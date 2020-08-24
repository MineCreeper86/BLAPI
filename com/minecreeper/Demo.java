package com.minecreeper;

import com.minecreeper.video.Video;

public class Demo {
	public static void main(String[] args) throws Exception {
        demo1();//av号与bv号的转换与是否允许转载
        demo2();//检查该视频是否需要大会员
	}

	private static void demo2() throws Exception {
		Video v = new Video("BV1X4411R7G3");
		System.out.println(v.requirePaying()+", "+v.getParsedViewCount());
	}

	private static void demo1() throws Exception {
		Video hop = new Video(170001);
		System.out.println(hop.getBvid()+", "+hop.allowRepaint()+", "+hop.getOwnerName());
	}
}
