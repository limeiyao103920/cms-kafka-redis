package com.lmy.entity;

import java.io.Serializable;

public class Car implements Serializable {

	private int id;
	private String vdate;
	private int tid;
	private String title;
	private String url;
	private String tname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVdate() {
		return vdate;
	}
	public void setVdate(String vdate) {
		this.vdate = vdate;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", vdate=" + vdate + ", tid=" + tid + ", title=" + title + ", url=" + url + ", tname="
				+ tname + "]";
	}
	public Car(int id, String vdate, int tid, String title, String url, String tname) {
		super();
		this.id = id;
		this.vdate = vdate;
		this.tid = tid;
		this.title = title;
		this.url = url;
		this.tname = tname;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
