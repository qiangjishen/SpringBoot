package cn.cnnic.sprngBoot2Famework.trip.vo;

import java.sql.Timestamp;

public class TripAll {

	private Long id;

	private String ownerName;

	private Long ownerId;

	private Timestamp tripTime;

	private String destination;
	
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * 行车路线
	 */
	private String carLine;

	/**
	 * 剩余座位数
	 */
	private int freeNum;

	private Double price;

	/**
	 * 状态，是否已满
	 */
	private int status;

	private String carColor;
	/**
	 * 车型
	 */
	private String carType;

	private String icon;

	/**
	 * 有多少个赞
	 */
	private Integer likes = 0;

	/**
	 * 负面赞
	 */
	private Integer noLikes = 0;

	/**
	 * 座位数
	 */
	private String seatsNum;

	/**
	 * 运营类型：私家、出租、货运
	 */
	private String operateType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Timestamp getTripTime() {
		return tripTime;
	}

	public void setTripTime(Timestamp tripTime) {
		this.tripTime = tripTime;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCarLine() {
		return carLine;
	}

	public void setCarLine(String carLine) {
		this.carLine = carLine;
	}

	public int getFreeNum() {
		return freeNum;
	}

	public void setFreeNum(int freeNum) {
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

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Integer getNoLikes() {
		return noLikes;
	}

	public void setNoLikes(Integer noLikes) {
		this.noLikes = noLikes;
	}

	public String getSeatsNum() {
		return seatsNum;
	}

	public void setSeatsNum(String seatsNum) {
		this.seatsNum = seatsNum;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}
	
	
	
	
	
	
	
	
	
	

}
