package co.jp.netwisdom.entity;
/**
 * 
 * @author ikugo
 *
 */
public class Hobby {
	//用戶名
	private String username;
	//愛好
	private String hobby;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {  
		this.hobby = hobby;
	}
	public Hobby(String username, String hobby) {
		super();
		this.username = username;
		this.hobby = hobby;
	}
	public Hobby() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
