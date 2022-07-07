package co.jp.netwisdom.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.transport.DefaultIORToSocketInfoImpl;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.dto.UserInfoAndHobbyDto;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserInfoAndHobby;
/*
public class UserSearchServlet extends HttpServlet {

/*	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//取得參數 -a
		String username = request.getParameter("username");
		String sex = request.getParameter("sex");
		String major = request.getParameter("major");

		
		
		UserInfoDAO uDao = new UserInfoDAO(); 
		List<UserInfoAndHobby> list = uDao.findUserInfoAndHobby(username, sex, major);
		
		//List<UserInfoDto> userInfoDtos = new ArrayList<UserInfoDto>();
		
		//Map<String, String> userNameMap = new HashMap<String, String>();
		//標示dto是否被創建 
		List<String> userNames = new ArrayList<String>();
		
		List<UserInfoAndHobbyDto> dtos = new ArrayList<UserInfoAndHobbyDto>();
		
		

		System.out.println("用戶信息:");
		//置入參數 -a 
		//UserInfo userinfo = uDao.findUserInfo(username , sex , major );
		for(UserInfoAndHobby userinfoandhobby : list){
			
			
			//用戶名不存在時 ,證明大的dto未創建
			if(!userNames.contains(userinfoandhobby.getUsername())){
				
				
				UserInfoAndHobbyDto dto = new UserInfoAndHobbyDto(userinfoandhobby.getUsername() , userinfoandhobby.getPassword() , 
						userinfoandhobby.getSex() , userinfoandhobby.getMajor() , userinfoandhobby.getIntro());
				
				//將創建的大的dto加到畫面展示list裡
				dtos.add(dto);
				//將用戶名加到用戶名list裡 
				userNames.add(userinfoandhobby.getUsername());
				
				//將愛好加入子dto中
				dto.getHobbyList().add(new HobbyDto(userinfoandhobby.getHobby()));
			}else{
				
				//取得以往添加過的大dto
				for(UserInfoAndHobbyDto temp : dtos){
					if(temp.getUsername().equals(userinfoandhobby.getUsername())){
						//將愛好加入子dto中
						temp.getHobbyList().add(new HobbyDto(userinfoandhobby.getHobby()));
					}
					
				}
				
			}

		}
	
		for(UserInfoAndHobbyDto result : dtos){
			
			System.out.println("----------分隔線----------");
			System.out.println("姓名:" + result.getUsername());
		 	System.out.println("密碼:" + result.getPassword());
			System.out.println("性別:" + result.getSex());
			System.out.println("專業:" + result.getMajor());
			System.out.println("簡介:" + result.getIntro());
			
			System.out.println("愛好:");
			StringBuffer sb = new StringBuffer("");
			for(HobbyDto hobbyDto : result.getHobbyList()){
			//System.out.print(hobbyDto.getHobby() + ",");
			sb.append(hobbyDto.getHobby() + ",");
			}
			if(",".equals(sb.toString().substring(sb.toString().length()-1))){
				System.out.print(sb.toString().substring(0,sb.toString().length()-1));
			}else{
			System.out.print(sb.toString());
			}
			
			System.out.println("");
		}
		
		 
		//HobbyDAO hDao = new HobbyDAO();
		
		
		
		if(true){
			//不會把request中參數全部清除掉進行跳轉
			request.getRequestDispatcher("/userRegSuccess.jsp").forward(request, response);
			//會把request中參數全部清除掉進行跳轉
			response.sendRedirect("/userRegSuccess.jsp");
			
		}else{
			request.getRequestDispatcher("/userRegErr.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
		
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
		//request.getRequestDispatcher("/background/sysAdmin/upSysAdminStates.jsp").forward(request, response);*/
	

