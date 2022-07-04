package co.jp.netwisdom.dto;
/**
 * 
 * @author ikugo
 *
 */
public class HobbyDto {

	//愛好
	private String hobby;
	
	
	

	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {  
		this.hobby = hobby;
	}
	public HobbyDto(String hobby) {
		super();
		this.hobby = hobby;
	}
	public HobbyDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
