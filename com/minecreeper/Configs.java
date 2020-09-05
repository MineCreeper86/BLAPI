package com.minecreeper;

public class Configs {
	/**
     * 接口请求使用的会话ID
     * <br>将被作为请求器Cookie中的SESSDATA发送。
     */
    public static String sessdata = "";
    /**
     * 接口请求速度的限制器
     * <br>限制请求器在上一请求发起后<code>delay</code>毫秒内不再发起。
     * <br>在延迟期间将堵塞线程。
     */
    public static int delay = 50;
}
