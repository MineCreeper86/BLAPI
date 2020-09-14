package com.minecreeper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.minecreeper.exceptions.RequestBlockedException;

public class NetConnection {
	private static long lastrequest = 0;
	private static long expirebfe = 0;
	private static ArrayList<ConnectDetails> details = new ArrayList<ConnectDetails>();
    public static String get(String address, String referer) throws Exception {
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
    	con.setRequestProperty("cookie", cookie);
    	con.setRequestProperty("referer", referer);
    	con.setRequestProperty("user_agent", Configs.ua);
    	detail.property = con.getRequestProperties();
    	con.connect();
    	detail.sendtimestamp = System.currentTimeMillis();
    	int code = con.getResponseCode();
    	detail.receivetimestamp = System.currentTimeMillis();
    	detail.status = code;
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) sb.append(line);
        br.close();
        result = sb.toString();
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
        details.add(detail);
        clearLog();
        if(code==412) throw new RequestBlockedException(address);
		return result;
    }
    public static ConnectDetails[] getConnectDetails(){
    	return details.toArray(new ConnectDetails[details.size()]);
    }
    public static void saveConnectDetails(String path) throws IOException{
    	File file = new File(path);
    	if(file.isDirectory()) file = new File(file.getPath()+"\\"+new SimpleDateFormat("yyyyMMdd HHmmssSSS").format(new Date(System.currentTimeMillis()))+".log");
    	createParentPath(file);
    	BufferedWriter writer = new BufferedWriter(new FileWriter(file.getPath()));
    	for(ConnectDetails c : getConnectDetails()) {
    		writer.write(c.toString());
    		writer.newLine();
    	}
    	writer.flush();
    	writer.close();
    }
    private static void createParentPath(File file) {
	    File parentFile = file.getParentFile();
	    if (null != parentFile && !parentFile.exists()) {
	        parentFile.mkdirs(); // 创建文件夹
	        createParentPath(parentFile); // 递归创建父级目录
	    }
	}
    private static void clearLog() {
    	int size = details.size();
    	if(Configs.logmaximum != -1 && Configs.logmaximum < size) {
    		ConnectDetails[] cd = details.toArray(new ConnectDetails[size]);
    		ConnectDetails[] tar = new ConnectDetails[Configs.logmaximum];
    		int a = size - Configs.logmaximum;
    		for(int i = 0;i < Configs.logmaximum;i++) tar[i] = cd[i+a];
    		details = (ArrayList<ConnectDetails>) Arrays.asList(tar);
    	}
    }
}
