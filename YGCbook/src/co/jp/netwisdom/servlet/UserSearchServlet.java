package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;

public class UserSearchServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");

		
		
		UserInfoDAO uDao = new UserInfoDAO(); 
		UserInfo userinfo = uDao.findById(username);
		System.out.println("okokok");
		
		 
		//HobbyDAO hDao = new HobbyDAO();
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*boolean rs1 =  uDao.save(userinfo);
		
		//Hobby
		
		String[] hobbyArr = request.getParameterValues("hobby");
		List<Hobby> hobbyList = new ArrayList<Hobby>();
		
		
		// 轉換數據
		for(String hobbyRs : hobbyArr){	
			Hobby hobbyOne = new Hobby(username,hobbyRs);
			hobbyList.add(hobbyOne);
		}
		
		HobbyDAO hDao = new HobbyDAO();
		boolean rs2 = hDao.insertHobby(hobbyList);
		
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
		/*if(rs1 && rs2){
			System.out.println("註冊成功!!!");
			request.getRequestDispatcher("userSuccess.jsp").forward(request, response);
		}else{
			System.out.println("註冊失敗!!!");
			request.getRequestDispatcher("userFail.jsp").forward(request, response);
			}
		*/
		
		//用戶愛好表更新 TODO
		//dao.save(new UserInfo(username,password,sex,major,intro));
		
		
		//request.setAttribute("admin", admin);
		//request.getRequestDispatcher("/background/sysAdmin/upSysAdminStates.jsp").forward(request, response);
	}

}