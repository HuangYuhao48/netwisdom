package co.jp.netwisdom.dao;

import java.sql.SQLException;
import java.util.List;

import cn.key.dbManager.JdbcTemplate;
import co.jp.netwisdom.entity.Hobby;

public class HobbyDAO {
	
	
	private JdbcTemplate template = new JdbcTemplate();
	
	//#001用法
	/*public boolean save(List<Hobby > list) {
		
		for(Hobby hobby : list){
			
			
		}
	}*/
	
	//#002用法
	public boolean insertHobby(List<Hobby> list) {
		
		int row = 0;
		
		String sql = "insert into hobby (username,hobby) values (?,?)";
		
		for(Hobby hobby : list){
			
			
			Object[] values = {
					hobby.getUsername(),
					hobby.getHobby()
					};
			//執行sql文
			try {
				row = template.updata(sql, values);
				
				if(row !=1){
					break;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return (row == 1);
	}
	
	/**
	 * 論理削除
	 * @param userinfo
	 * @return
	 */
	public boolean delHobby(String username) {
	
		
		String sql = "update hobby set delFlg='1' where hobby.username=? ";
		
		Object[] values = new Object[]{
				username
			};
		
		
		try {
			template.updata(sql, values);
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
		

