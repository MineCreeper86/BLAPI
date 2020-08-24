package com.minecreeper.exceptions;

public class VideoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public VideoNotFoundException(String url){
        super("未通过"+url+"接口找到目标视频，可能是稿件已删除或未发布");
    }
}
