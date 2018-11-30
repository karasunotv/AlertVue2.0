package com.example.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TvAndMovie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int showId;
	
	@Column
	private String showTitle;
	
	@Column
	private String showImage;
	
	@Column
	private String showYoutube;
	
	@Column
	private String showSummary;
	
	@Column
	private String station;
	
	@Column
	private Timestamp showAirTime;
	
	public TvAndMovie() {}

	public TvAndMovie(int showId, String showTitle, String showImage, String showYoutube, String showSummary, String station,
			Timestamp showAirTime) {
		super();
		this.showId = showId;
		this.showTitle = showTitle;
		this.showImage = showImage;
		this.showYoutube = showYoutube;
		this.showSummary = showSummary;
		this.station = station;
		this.showAirTime = showAirTime;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getShowImage() {
		return showImage;
	}

	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}

	public String getShowYoutube() {
		return showYoutube;
	}

	public void setShowYoutube(String showYoutube) {
		this.showYoutube = showYoutube;
	}

	public String getShowSummary() {
		return showSummary;
	}

	public void setShowSummary(String showSummary) {
		this.showSummary = showSummary;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public Timestamp getShowAirTime() {
		return showAirTime;
	}

	public void setShowAirTime(Timestamp showAirTime) {
		this.showAirTime = showAirTime;
	}

	@Override
	public String toString() {
		return "TvAndMovie [showId=" + showId + ", showTitle=" + showTitle + ", showImage=" + showImage
				+ ", showYoutube=" + showYoutube + ", showSummary=" + showSummary + ", station=" + station
				+ ", showAirTime=" + showAirTime + "]";
	}

	
}
