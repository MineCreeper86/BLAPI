package com.minecreeper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.minecreeper.exceptions.RequestBlockedException;

public class NetConnection {
	private static long lastrequest = 0;
	private static long expirebfe = 0;
	private static ArrayList<ConnectDetails> details = new ArrayList<ConnectDetails>();
    public static String get(String address) throws Exception {
    	ConnectDetails detail = new ConnectDetails();
    	if(System.currentTimeMillis()<lastrequest+Configs.delay) Thread.sleep(lastrequest+Configs.delay-System.currentTimeMillis());
    	detail.url = address;
    	String result = "";
    	URL url = new URL(address);
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("GET");
    	String cookie = "";
    	if(!Configs.sessdata.contentEquals("")) cookie = cookie + "SESSDATA="+Configs.sessdata+";";
    	if(!Configs.bfe.contentEquals("") && !(expirebfe < System.currentTimeMillis())) cookie = cookie + "bfe_id="+Configs.bfe;
    	con.setRequestProperty("Cookie", cookie);
    	con.setRequestProperty("user_agent", Configs.ua);
    	detail.property = con.getRequestProperties();
    	con.connect();
    	detail.sendtimestamp = System.currentTimeMillis();
    	int code = con.getResponseCode();
    	detail.receivetimestamp = System.currentTimeMillis();
    	detail.status = code;
        if (code == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) sb.append(line);
            br.close();
            result = sb.toString();
        }else if(code == 412) throw new RequestBlockedException(address);
        String returns = con.getHeaderField("set-cookie");
        if(returns != null) {
        	expirebfe = System.currentTimeMillis()+600000;
        	int startpos = returns.indexOf("bfe_id=")+7;
        	int endpos = returns.substring(startpos).indexOf(";")+startpos;
        	if(endpos-startpos == -1) endpos = returns.length();
        	Configs.bfe = returns.substring(startpos, endpos);
        }
        detail.text = result;
        detail.field = con.getHeaderFields();
        con.disconnect();
        lastrequest = System.currentTimeMillis();
        detail.end = lastrequest;
		return result;
    }
    public static ConnectDetails[] getConnectDetails(){
    	return details.toArray(new ConnectDetails[details.size()]);
    }
}
