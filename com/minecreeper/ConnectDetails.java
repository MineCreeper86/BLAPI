package com.minecreeper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ConnectDetails {
	long createtimestamp = 0;
	long sendtimestamp = 0;
    String url = "未收集到信息";
    Map<String, List<String>> property = null;
	long receivetimestamp = 0;
	int status = -1;
	String text = "无文本";
	Map<String, List<String>> field = null;
	long end;
    public ConnectDetails() {
    	this.createtimestamp = System.currentTimeMillis();
    }
    public String toString() {
    	String result = "--网络连接日志（创建于"+new SimpleDateFormat("yyyy年MM月dd日 - HH:mm:ss.SSS").format(new Date(createtimestamp))+"）--\r\n详细报文：\r\n-请求信息-\r\n";
    	result = result+"请求创建于："+createtimestamp+"\r\n";
    	result = result+"请求目标："+url+"\r\n请求头详细信息：\r\n";
    	for(String str:property.keySet()) {
    		String[] cs = property.get(str).toArray(new String[property.get(str).size()]);
    		String cs1 = "";
    		for(String cs2:cs) {
    			cs1 = cs1+cs2+";";
    		}
    		result = result+"字段"+str+"的值 => "+cs1+"\r\n";
    	}
    	result = result+"请求发送于："+sendtimestamp+"\r\n-响应信息-\r\n";
    	result = result+"响应接收于："+receivetimestamp+"\r\n";
    	result = result+"状态码："+status+"\r\n";
    	result = result+"响应内容：\r\n"+text+"\r\n响应头详细信息：\r\n";
    	for(String str:field.keySet()) {
    		String[] cs = field.get(str).toArray(new String[field.get(str).size()]);
    		String cs1 = "";
    		for(String cs2:cs) {
    			cs1 = cs1+cs2+";";
    		}
    		if(str != null) result = result+"字段"+str+"的值 => "+cs1+"\r\n";
    	}
    	result = result+"请求完成于："+end+"，总用时："+(end-createtimestamp)+"ms\r\n";
    	return result;
    }
}
