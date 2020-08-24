package com.minecreeper;

import com.minecreeper.video.Video;

public class Demo {
	public static void main(String[] args) throws Exception {
        demo1();
        demo2();
        //demo3();
	}

	@SuppressWarnings("unused")
	private static void demo3() throws Exception {
		Video v = new Video(1);
	}

	private static void demo2() throws Exception {
		Video v = new Video("BV1X4411R7G3");
		System.out.println(v.requirePaying()+", "+v.getParsedViewCount()+", "+v.getParsedDanmakuCount());
	}

	private static void demo1() throws Exception {
		Video hop = new Video(170001);
		System.out.println(hop.getBvid()+", "+hop.allowRepaint()+", "+hop.getOwnerName()+", "+hop.getParsedViewCount()+", "+hop.getParsedDanmakuCount()+", "+hop.getParsedCommentCount()+", "+hop.getParsedFavouriteCount()+", 全站历史最高排名"+hop.getHighestRank());
	}
}
