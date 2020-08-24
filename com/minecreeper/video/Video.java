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
		if(this.base.code==-412) throw new RequestBlockedException(this.lnk);
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
	public boolean isMutiplePart() {
		if(this.base.data.p_amount == 1) return false;
		return true;
	}
	public int getZoneID() {
		return this.base.data.zone_id;
	}
	public String getZoneName() {
		return this.base.data.zone_name;
	}
	public boolean isOriginal() {
		if(this.base.data.copyright==1) return true;
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
	public boolean isDownloadable() {
		if(this.base.data.rights.downloadable==1) return true;
		return false;
	}
	public boolean isMovie() {
		if(this.base.data.rights.movie==1) return true;
		return false;
	}
	public boolean requirePaying() {
		if(this.base.data.rights.pay==1) return true;
		return false;
	}
	public boolean isHD() {
		if(this.base.data.rights.quality==1) return true;
		return false;
	}
	public boolean allowRepaint() {
		if(this.base.data.rights.no_repaint==0) return true;
		return false;
	}
	public boolean isAutoPlay() {
		if(this.base.data.rights.auto_play==1) return true;
		return false;
	}
	public boolean isCooperation() {
		if(this.base.data.rights.cooperation==1) return true;
		return false;
	}
	public int getOwnerID() {
		return this.base.data.owner.id;
	}
	public String getOwnerName() {
		return this.base.data.owner.name;
	}
	public String getOwnerFaceUrl() {
		return this.base.data.owner.face_url;
	}
	public int getViewCount() {
		return this.base.data.stat.view;
	}
	public String getParsedViewCount() {
		int count = this.getViewCount();
		if(count>=10000) return (float)((count+500)/1000)/10+"万次播放";
		else return count+"次播放";
	}
}
