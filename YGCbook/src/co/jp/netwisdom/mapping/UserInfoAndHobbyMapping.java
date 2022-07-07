package co.jp.netwisdom.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.key.dbManager.IResultSetMapping;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserInfoAndHobby;

public class UserInfoAndHobbyMapping implements IResultSetMapping{

	@Override
	public UserInfoAndHobby mapping(ResultSet rs) throws SQLException {
		int i = 1;
		UserInfoAndHobby userInfoAndHobby = new UserInfoAndHobby(
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++), 
				rs.getString(i++));
		
		return userInfoAndHobby;
	}
}
