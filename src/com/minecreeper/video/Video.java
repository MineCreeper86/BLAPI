package com.minecreeper.video;

import com.google.gson.Gson;
import com.minecreeper.NetConnection;
import com.minecreeper.base.VideoInfo;

public class Video {
	private VideoInfo base = null;
	private String lnk = "";
	public Video(int aid) {
		this.lnk = "https://api.bilibili.com/x/web-interface/view?aid="+aid;
		this.construct();
	}
	public Video(String bvid) {
		this.lnk = "https://api.bilibili.com/x/web-interface/view?bvid="+bvid;
		this.construct();
	}
	private void construct() {
		Gson gson = new Gson();
		this.base = gson.fromJson(NetConnection.get(this.lnk), VideoInfo.class);
	}
	public void refresh() {
		this.construct();
	}
	public int getAid() {
		return this.base.data.aid;
	}
	public String getBvid() {
		return this.base.data.bvid;
	}
	public int getPartAmount() {
		return this.base.data.p_amount;
	}
	public boolean isSinglePart() {
		if(this.base.data.p_amount == 1) {
			return true;
		}
		return false;
	}
	public int getZoneID() {
		return this.base.data.zone_id;
	}
	public String getZoneName() {
		return this.base.data.zone_name;
	}
}
