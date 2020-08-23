package com.minecreeper.exceptions;

public class RequestBlockedException extends Exception{
	private static final long serialVersionUID = 1L;
	public RequestBlockedException(String url){
        super("在请求"+url+"时返回了412（同一接口访问频率过高），将于若干分钟后恢复访问。");
    }
}
