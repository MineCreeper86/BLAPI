package com.minecreeper;

import com.minecreeper.video.Video;

public class Demo {
	public static void main(String[] args) {
        Video v = null;
		try {
			v = new Video(170001);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("av170001（"+v.getTitle()+"）的aid是"+v.getAid()+"，bvid是"+v.getBvid()+"，属于"+v.getZoneName()+"分区，共有"+v.getPartAmount()+"个分P，发布时间："+v.getPublishTime().toString()+"，时长总计"+v.getParsedDuration());
        System.out.println("视频简介是这样写的："+v.getDescription());
        System.out.println("v.isOriginal() = "+v.isOriginal());
	}
}
