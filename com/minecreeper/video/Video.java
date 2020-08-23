package com.minecreeper.video;

import java.util.Date;

import com.google.gson.Gson;
import com.minecreeper.NetConnection;
import com.minecreeper.base.VideoInfo;
import com.minecreeper.exceptions.RequestBlockedException;

public class Video {
	private VideoInfo base = null;
	private String lnk = "";
	public Video(int aid) throws Exception {
		this.lnk = "https://api.bilibili.com/x/web-interface/view?aid="+aid;
		this.construct();
	}
	public Video(String bvid) throws Exception {
		this.lnk = "https://api.bilibili.com/x/web-interface/view?bvid="+bvid;
		this.construct();
	}
	private void construct() throws Exception {
		Gson gson = new Gson();
		this.base = gson.fromJson(NetConnection.get(this.lnk), VideoInfo.class);
		if(this.base.code==-412) {
			throw new RequestBlockedException(this.lnk);
		}
	}
	public void refresh() throws Exception {
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
	public boolean isOriginal() {
		if(this.base.data.copyright==1) {
			return true;
		}
		return false;
	}
	public String getCoverUrl() {
		return this.base.data.cover_url;
	}
	public String getTitle() {
		return this.base.data.title;
	}
	public Date getPublishTime() {
		return new Date(this.base.data.publish_time*1000);
	}
	public String getDescription() {
		return this.base.data.description;
	}
	public int getDuration() {
		return this.base.data.duration;
	}
	public String getParsedDuration() {
		int dur = this.getDuration();
		return dur/60 + ":" + dur%60;
	}
}
