package com.model;
import com.interfaceModel.ActionModel;

public class Member extends GeneralModel {
	private String tableName = "member_tb";
	private Integer userID;
	private String userName;
	private String password;
	private String fullName;
	private String birthDate;
	private float height;
	private float weight;
	private String bloodType;
	private String hobby;
	private String phone;
	private String email;
	private String detailEdu;
	private String detailFav;
	private String detailLsk;
	private String picturePath;
	private int admin;
	private int careerID;

	public String getTableName(){
		return tableName;
	}
	public void setAction(ActionModel action){
		this.action = action;
	}
	public ActionModel getAction(){
		return this.action;
	}
	public Member() {
		this.tableName = "member_tb";
		this.userID = null;
	}
	public void setUserID(int userID){
		this.userID = userID;
	}
	public int getUserID() {
		return this.userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getHeight() {
		return height;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getWeight() {
		return this.weight;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getHobby() {
		return this.hobby;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setDetailEdu(String detailEdu) {
		this.detailEdu = detailEdu;
	}

	public String getDetailEdu() {
		return this.detailEdu;
	}

	public void setDetailFav(String detailFav) {
		this.detailFav = detailFav;
	}

	public String getDetailFav() {
		return this.detailFav;
	}

	public void setDetailLsk(String detailLsk) {
		this.detailLsk = detailLsk;
	}

	public String getDetailLsk() {
		return this.detailLsk;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public String getPicturePath() {
		return this.picturePath;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getAdmin() {
		return this.admin;
	}

	public void setCareerID(int careerID) {
		this.careerID = careerID;
	}
	
	public int getCareerID(){
		return this.careerID;
	}
}
