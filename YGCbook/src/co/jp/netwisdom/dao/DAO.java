package co.jp.netwisdom.dao;

import java.sql.SQLException;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.UserInfo;

public class DAO {
	
	
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
	
	
}