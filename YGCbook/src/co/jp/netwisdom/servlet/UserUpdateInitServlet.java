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

public class UserUpdateInitServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Name
		String username = request.getParameter("username");
		System.out.println(username);
		
		UserInfoDAO uDao = new UserInfoDAO(); 
		List<UserInfoAndHobby> list = uDao.findUserInfoAndHobby(username);
		
		List<UserInfoAndHobbyDto> dtos = new ArrayList<>();
	
		List<String> nameList = new ArrayList<>();
		
		for(UserInfoAndHobby one:list){
			
			if(!nameList.contains(one.getUsername())){
				nameList.add(one.getUsername());
				
				UserInfoAndHobbyDto dto = new UserInfoAndHobbyDto(
						one.getUsername(),
						one.getPassword(),
						one.getSex(),
						one.getMajor(),
						one.getIntro()
						);
				
				List<String> hobbyList = new ArrayList<>();
				
				hobbyList.add(one.getHobby());
				dto.setHobbyList(hobbyList);
				dtos.add(dto);
				
			}else{
				
				for(UserInfoAndHobbyDto dto : dtos){
					
					if(dto.getUsername().equals(one.getUsername())){
						dto.getHobbyList().add(one.getHobby());
					}
					
				}
				
			}
			
		}
		
		request.setAttribute("dto", dtos.get(0));
		request.getRequestDispatcher("userReg.jsp").forward(request, response);
		
		/*if(rs1){
			System.out.println("用戶信息載入成功!!!");
		}else{
			System.out.println("用戶信息載入失敗!!!");
			}
		if(rs2){
			System.out.println("愛好載入成功!!!");
		}else{
			System.out.println("愛好載入失敗!!!");
			}*/
		//if(rs1 && rs2){
		//	System.out.println("註冊成功!!!");
		//	request.getRequestDispatcher("userSuccess.jsp").forward(request, response);
		//}else{
		//	System.out.println("註冊失敗!!!");
		//	request.getRequestDispatcher("userFail.jsp").forward(request, response);
		//	}
		
		
		//用戶愛好表更新 TODO
		//dao.save(new UserInfo(username,password,sex,major,intro));
		
		
		//request.setAttribute("admin", admin);
		//request.getRequestDispatcher("/background/sysAdmin/upSysAdminStates.jsp").forward(request, response);
	}

}