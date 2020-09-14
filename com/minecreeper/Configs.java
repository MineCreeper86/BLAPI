package com.minecreeper;

public class Configs {
	/**
     * 接口请求使用的会话ID
     * <br>将被作为请求器Cookie中的SESSDATA发送。
     */
    public static String sessdata = "";
    /**
     * 接口请求使用浏览器伪造参数
     * <br>将被作为请求器Cookie中的bfe_id发送。
     */
    public static String bfe = "";
    /**
     * 接口请求使用浏UA参数
     * <br>将被作为请求器user_agent发送。
     */
    public static String ua = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.122 Safari/537.36";
    /**
     * 接口请求速度的限制器
     * <br>限制请求器在上一响应接收后<code>delay</code>毫秒内不再发起。
     * <br>在延迟期间将堵塞线程。
     */
    public static int delay = 50;
    /**
     * 网络连接日志的条数上限
     * <br>在请求器日志数量大于<code>logmaximum</code>时自动清除倒数第<code>logmaximum</code>+<code>1</code>条日志
     * <br>当值为<code>-1</code>不清除日志
     * <br>当值为<code>0</code>不保留日志
     * @see
     * com.minecreeper.NetConnection.getConnectDetails()
     */
    public static int logmaximum = -1;
}
