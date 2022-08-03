package co.jp.netwisdom.form;

import org.apache.struts.action.ActionForm;

import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.UserInfo;

public class U_Form extends ActionForm {

	//Name
	private String username;
	//pwd
	private String password;
	//sex
	private String sex;
	//major
	private String major;
	//intro
	private String intro;
	
	private String[] hobby;
	
	//for del user
	private String[] check;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String[] getCheck() {
		return check;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}

	public U_Form(String username, String password, String sex, String major, String intro, String[] hobby,
			String[] check) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.major = major;
		this.intro = intro;
		this.hobby = hobby;
		this.check = check;
	}

	public U_Form() {
		super();
		// TODO Auto-generated constructor stub
	}





}
