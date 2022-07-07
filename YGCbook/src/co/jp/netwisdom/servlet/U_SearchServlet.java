package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.dto.UserInfoAndHobbyDto;
import co.jp.netwisdom.entity.UserInfoAndHobby;
import sun.security.krb5.KdcComm;



public class U_SearchServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String sex = req.getParameter("sex");
		String major = req.getParameter("major");
		
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfoAndHobby> list = dao.findUserInfoAndHobby(username, sex, major);
		
		//創建一個存放UserInfoAndHobbyDto的List
		List<UserInfoAndHobbyDto> dtos = new ArrayList<>();
		
		//創建存放name的容器List
		List<String> nameList = new ArrayList<>();
		
		for(UserInfoAndHobby one : list){
			
			//判斷nameList有沒有當前循環的名字
			//若沒有
			if(!nameList.contains(one.getUsername())){
				//則把當前循環的名字放入nameList
				nameList.add(one.getUsername());
				//通過構造方法創建dto
				UserInfoAndHobbyDto dto = new UserInfoAndHobbyDto(
						one.getUsername(),
						one.getSex(),
						one.getMajor(),
						one.getIntro()	
						);
				
				List<String> hobbyList = new ArrayList<>();
				
				//把當前循環的hobby放入hobbyList中
				hobbyList.add(one.getHobby());
				//給dto的hobbyList屬性設置, 存有當前循環的hobbyList
				dto.setHobbyList(hobbyList);
				dtos.add(dto);
				
			//若有包含
			}else{
				//則循環dtos, 找到與當前名字相符的dto
				for(UserInfoAndHobbyDto dto : dtos){
					//外層循環的名字==dto的名字
					if (dto.getUsername().equals(one.getUsername())) {
						//往當前dto的hobbyList放入當前循環的hobby
						dto.getHobbyList().add(one.getHobby());
						
					}
					
				}

			}
			
		}
		
		//把查詢出來的list放入請求中
		req.setAttribute("dtos", dtos);
		
		req.getRequestDispatcher("U_Search.jsp").forward(req, resp);
		
	}

	

}