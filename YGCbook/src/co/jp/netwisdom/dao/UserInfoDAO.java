package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserInfoAndHobby;
import co.jp.netwisdom.mapping.UserInfoAndHobbyMapping;
import co.jp.netwisdom.mapping.UserInfoMapping;

public class UserInfoDAO {
	
	
	private JdbcTemplate template = new JdbcTemplate();
	
	

	public boolean save(UserInfo userinfo) {
		//默認失敗 row = 0
		int row = 0;
		
		//定義sql文
		String sql = "insert into userinfo (username,password,sex,major,intro,delFlg) values (?,?,?,?,?,?)";
		
		//輸入5個值給values
		Object[] values = new Object[]{
			userinfo.getUsername(), 
			userinfo.getPassword(),
			userinfo.getSex(),
			userinfo.getMajor(),
			userinfo.getIntro(),
			"0"
			};
		
		
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	
	
	
	//抽出
	/*public List<UserInfo> findUserInfo(String username , String sex , String major ) {
		
		System.out.println("###");
		System.out.println(username);
		System.out.println(sex);
		System.out.println(major);
		
		
		String sql = "select * from userinfo where " ;
		
		
		if(!"".equals(username)){
			sql= sql + "username = '" + username + "' and" ;	
		}else{
			sql= sql + "username = '" + username ;
		}
		
		//sex
		sql= sql + " sex = '" + sex + "'" ;	
		
		//major
		if(!"".equals(major)){
			sql= sql + " and major = '" + major + "'" ;	
		}
		
		List<UserInfo> list = new Vector<UserInfo>();
		try {
			list = template.selete(sql, new UserInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}*/
	
public List<UserInfoAndHobby> findUserInfoAndHobby(String username , String sex , String major ) {
		
		
		String sql = "select userinfo.username,password,sex,major,intro,hobby from userinfo LEFT JOIN hobby ON userinfo.username = hobby.username where 1=1  " ;
		
		
		if(!"".equals(username)){
			sql= sql + " and userinfo.username = '" + username + "' " ;	
		}
		//sex
		if(sex!=null){
			sql= sql + " and userinfo.sex = '" + sex + "' " ;	
		}
		//major
		if(!"".equals(major)){
			sql= sql + " and major = '" + major + "' " ;	
		}
		
		sql = sql + " and userinfo.delFlg='0' and hobby.delFlg='0' ";
		
		List<UserInfoAndHobby> list2 = new ArrayList<UserInfoAndHobby>();
		try {
			list2 = template.selete(sql, new UserInfoAndHobbyMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list2;
	}	


	public List<UserInfoAndHobby> findUserInfoAndHobby(String username) {
	
	
		String sql = "select userinfo.username,password,sex,major,userinfo.intro,hobby.hobby from userinfo LEFT JOIN hobby ON userinfo.username = hobby.username where 1=1 " ;
		
			sql= sql + " and userinfo.username = '" + username + "' " ;	
			sql= sql + " and userinfo.delFlg='0' and hobby.delFlg='0' ";

		List<UserInfoAndHobby> list2 = new ArrayList<UserInfoAndHobby>();
		try {
			list2 = template.selete(sql, new UserInfoAndHobbyMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list2;
	}	
	
	
	
	public List<UserInfo> checkName(String username) {
		
		
		String sql = "select * from userinfo where userinfo.delFlg='0' and userinfo.username = '" + username + "'";
		
		
		List<UserInfo> list2 = new ArrayList<UserInfo>();
		try {
			list2 = template.selete(sql, new UserInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list2;
	}	
	
	
	
	
	
	/**
	 * 論理削除
	 * @param userinfo
	 * @return
	 */
	public boolean delUserInfo(String username){
		//默認失敗 row = 0
		int row = 0;
		
		String sql = "update userinfo set delFlg='1' where userinfo.username=? ";
		
		Object[] values = new Object[]{
				username
			};
		
		
		try {
			row = template.updata(sql, values);
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (row == 1);
	}
	


}