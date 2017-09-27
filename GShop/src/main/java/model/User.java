package model;



import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class User {
	
	@NotEmpty(message="ID를 입력해주세요.")
	private String user_id;
	private boolean user_idUnCheck;	
	@NotEmpty(message="Password을 입력해 주세요.")
	private String password;
	@NotEmpty(message="Password를 입력해 주세요.")
	private String password2;
	@NotEmpty(message="이름을 입력해 주세요.")
	private String user_name;
	@NotEmpty(message="닉네임을 입력해 주세요.")
	private String nickname;
	private boolean nicknameUnCheck;	
	private String email;	
	@Length(min=11,max=11,message="ex)01000001111")		
	private String phone;
	private String address;
	@Length(min=8,max=8,message="ex)20001010")
	private String birthday;	
	private int gender;
	private String picture_name;	
	private MultipartFile picture;
	private String introduce;	
	private int interest_genres;
	private int favorite_games;
	private int bought_games;
	private int cash_balance;
	private int status;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {		
		return password;
	}
	public void setPassword(String password) {
		this.password = password;		
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
		if(this.phone.length()==0){
			this.phone="           ";
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
		if(this.birthday.length()==0){
			this.birthday="        ";
		}
	}

	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getFavorite_games() {
		return favorite_games;
	}
	public void setFavorite_games(int favorite_games) {
		this.favorite_games = favorite_games;
	}
	public int getBought_games() {
		return bought_games;
	}
	public void setBought_games(int bought_games) {
		this.bought_games = bought_games;
	}
	public int getCash_balance() {
		return cash_balance;
	}
	public void setCash_balance(int cash_balance) {
		this.cash_balance = cash_balance;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPicture_name() {
		return picture_name;
	}
	public void setPicture_name(String picture_name) {
		this.picture_name = picture_name;
	}	
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getInterest_genres() {
		return interest_genres;
	}
	public void setInterest_genres(int interest_genres) {
		this.interest_genres = interest_genres;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;		
	}
	public boolean isUser_idUnCheck() {
		return user_idUnCheck;
	}
	public void setUser_idUnCheck(boolean user_idUnCheck) {
		this.user_idUnCheck = user_idUnCheck;
	}
	public boolean isNicknameUnCheck() {
		return nicknameUnCheck;
	}
	public void setNicknameUnCheck(boolean nicknameUnCheck) {
		this.nicknameUnCheck = nicknameUnCheck;
	}
	
}