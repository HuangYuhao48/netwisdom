package co.jp.netwisdom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.netwisdom.entity.UserInfo;

public class UserInfoMapping implements IResultSetMapping{

	@Override
	public UserInfo mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserInfo userinfo = new UserInfo(
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++));
		return userinfo;
	}
}
