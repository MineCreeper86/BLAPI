package com.minecreeper;

import com.minecreeper.video.Video;

public class FT {
	public static void main(String[] args) {
        Video v = new Video(170001);
        System.out.println("av170001的aid是"+v.getAid()+"，bvid是"+v.getBvid()+"，属于"+v.getZoneName()+"分区，共有"+v.getPartAmount()+"个分P");
	}
}
