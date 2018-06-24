package UserDataAnalysis;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

	@SerializedName("guid")
	@Expose
	private String guid;
	@SerializedName("isActive")
	@Expose
	private Boolean isActive;
	@SerializedName("balance")
	@Expose
	private String balance;
	@SerializedName("age")
	@Expose
	private Integer age;
	@SerializedName("eyeColor")
	@Expose
	private String eyeColor;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("email")
	@Expose
	private String email;
	@SerializedName("phone")
	@Expose
	private String phone;
	@SerializedName("address")
	@Expose
	private String address;
	@SerializedName("registered")
	@Expose
	private String registered;
	@SerializedName("friends")
	@Expose
	private List<FriendModel> friends = null;
	@SerializedName("greeting")
	@Expose
	private String greeting;
	@SerializedName("favoriteFruit")
	@Expose
	private String favoriteFruit;

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEyeColor() {
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) {
		this.eyeColor = eyeColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public List<FriendModel> getFriends() {
		return friends;
	}

	public void setFriends(List<FriendModel> friends) {
		this.friends = friends;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getFavoriteFruit() {
		return favoriteFruit;
	}

	public void setFavoriteFruit(String favoriteFruit) {
		this.favoriteFruit = favoriteFruit;
	}

}