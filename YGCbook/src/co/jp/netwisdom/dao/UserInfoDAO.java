package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import cn.key.dbManager.JdbcTemplate;
import cn.key.entity.BookType;
import cn.key.mapping.BookTypeMapping;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.mapping.UserInfoMapping;

public class UserInfoDAO {
	
	
	private JdbcTemplate template = new JdbcTemplate();
	
	
	public boolean save(UserInfo userinfo) {
		//默認失敗 row = 0
		int row = 0;
		
		//定義sql文
		String sql = "insert into userinfo (username,password,sex,major,intro) values (?,?,?,?,?)";
		
		//輸入5個值給values
		Object[] values = new Object[]{
			userinfo.getUsername(), 
			userinfo.getPassword(),
			userinfo.getSex(),
			userinfo.getMajor(),
			userinfo.getIntro()
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
	
	
	public UserInfo findById(String username) {
		String sql = "select * from userinfo where username= " + username;
		List<UserInfo> list = new Vector<UserInfo>();
		try {
			list = template.selete(sql, new UserInfoMapping());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list.get(0);
	}
	
	
}