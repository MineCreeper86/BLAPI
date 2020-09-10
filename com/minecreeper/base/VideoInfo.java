package com.minecreeper.base;

import com.google.gson.annotations.SerializedName;

public class VideoInfo {
	public int code;
	public String message;
	public Data data;
	public static class Data{
		public String bvid;
		public int aid;
		@SerializedName("videos")
		public int p_amount;
		@SerializedName("tid")
		public int zone_id;
		@SerializedName("tname")
		public String zone_name;
		public int copyright;
		@SerializedName("pic")
		public String cover_url;
		public String title;
		@SerializedName("pubdate")
		public long publish_time;
		@SerializedName("desc")
		public String description;
		public int duration;
		public DataRights rights;
		public DataOwner owner;
		public DataStat stat;
		public String dynamic;
		@SerializedName("cid")
		public int pageid;
	}
	public static class DataRights{
		@SerializedName("download")
		public int downloadable;
		public int movie;
		public int pay;
		@SerializedName("hd5")
		public int quality;
		public int no_repaint;
		public int auto_play;
		@SerializedName("is_cooperation")
		public int cooperation;
	}
	public static class DataOwner{
		@SerializedName("mid")
		public int id;
		public String name;
		@SerializedName("face")
		public String face_url;
	}
	public static class DataStat{
		public int view;
		public int danmaku;
		@SerializedName("reply")
		public int comment;
		@SerializedName("favorite")
		public int favourite;
		public int coin;
		public int share;
		@SerializedName("now_rank")
		public int rank;
		@SerializedName("his_rank")
		public int history_rank;
		public int like;
	}
}
