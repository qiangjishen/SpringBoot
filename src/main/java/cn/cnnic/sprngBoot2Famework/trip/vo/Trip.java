package cn.cnnic.sprngBoot2Famework.trip.vo;

import java.sql.Timestamp;

public class Trip {

	private Long tripId;
	
	private String tripName;
	
	private Timestamp tripDate;
	
	private int tripLine;

	private String tripDestination;
	/**
	 * 行车路线
	 */
	private String carLine;
	

	/**
	 * 剩余座位数
	 */
	private String freeNum;
	
	private String carColor;
	
	private String ownerName;
	
	private int gender;
	
	private int likes;
	
	private int noLikes;
	
	private String carType;
	
	private Double price;
	
	/**
	 * 状态，是否已满
	 */
	private int status;
	
	private Timestamp createTime;

	public Long getTripId() {
		return tripId;
	}

	public void setTripId(Long tripId) {
		this.tripId = tripId;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public Timestamp getTripDate() {
		return tripDate;
	}

	public void setTripDate(Timestamp tripDate) {
		this.tripDate = tripDate;
	}

	

	public int getTripLine() {
		return tripLine;
	}

	public void setTripLine(int tripLine) {
		this.tripLine = tripLine;
	}

	public String getTripDestination() {
		return tripDestination;
	}

	public void setTripDestination(String tripDestination) {
		this.tripDestination = tripDestination;
	}

	public String getCarLine() {
		return carLine;
	}

	public void setCarLine(String carLine) {
		this.carLine = carLine;
	}

	public String getFreeNum() {
		return freeNum;
	}

	public void setFreeNum(String freeNum) {
		this.freeNum = freeNum;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getNoLikes() {
		return noLikes;
	}

	public void setNoLikes(int noLikes) {
		this.noLikes = noLikes;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	
	
	
}
