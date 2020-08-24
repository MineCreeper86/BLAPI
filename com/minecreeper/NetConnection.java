package com.minecreeper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.minecreeper.exceptions.RequestBlockedException;

public class NetConnection {
    public static String get(String address) throws Exception {
    	String result = "";
    	URL url = new URL(address);
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("GET");
    	con.setRequestProperty("Cookie", "SESSDATA="+Configs.sessdata);
    	con.connect();
        if (con.getResponseCode() == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            result = sb.toString();
        }else if(con.getResponseCode() == 412) throw new RequestBlockedException(address);
        con.disconnect();
		return result;
    }
}
