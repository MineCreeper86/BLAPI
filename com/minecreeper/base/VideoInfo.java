package com.minecreeper.base;

import com.google.gson.annotations.SerializedName;

public class VideoInfo {
	@SerializedName("code")
	public int code;
	@SerializedName("message")
	public String message;
	@SerializedName("data")
	public Data data;
	public static class Data{
		@SerializedName("bvid")
		public String bvid;
		@SerializedName("aid")
		public int aid;
		@SerializedName("videos")
		public int p_amount;
		@SerializedName("tid")
		public int zone_id;
		@SerializedName("tname")
		public String zone_name;
		@SerializedName("copyright")
		public int copyright;
		@SerializedName("pic")
		public String cover_url;
		@SerializedName("title")
		public String title;
		@SerializedName("pubdate")
		public long publish_time;
		@SerializedName("desc")
		public String description;
		@SerializedName("duration")
		public int duration;
		@SerializedName("rights")
		public DataRights rights;
		@SerializedName("owner")
		public DataOwner owner;
		@SerializedName("stat")
		public DataStat stat;
	}
	public static class DataRights{
		@SerializedName("download")
		public int downloadable;
		@SerializedName("movie")
		public int movie;
		@SerializedName("pay")
		public int pay;
		@SerializedName("hd5")
		public int quality;
		@SerializedName("no_repaint")
		public int no_repaint;
		@SerializedName("autoplay")
		public int auto_play;
		@SerializedName("is_cooperation")
		public int cooperation;
	}
	public static class DataOwner{
		@SerializedName("mid")
		public int id;
		@SerializedName("name")
		public String name;
		@SerializedName("face")
		public String face_url;
	}
	public static class DataStat{
		@SerializedName("view")
		public int view;
	}
}
