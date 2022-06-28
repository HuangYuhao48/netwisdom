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

public class UserRegsterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Name
		String username = request.getParameter("username");
		//pwd
		String password = request.getParameter("password");
		//sex
		String sex = request.getParameter("sex");;
		//major
		String major = request.getParameter("major");
		//intro
		String intro = request.getParameter("intro");
		//hobby TODO
		//String hobby = request.getParameter("hobby");
		//String[] hobbyArray = {"0","1","2"};
		//String[] hobby2 = new String[]{"1","2","3"};
		//String[] hobby3 = new String[3];
		username = "xxd";		
		String[] hobbyArray = {"0","1","2"};
		
		Hobby hobby1 = new Hobby();
		hobby1.setUsername(username);
		hobby1.setHobby(hobbyArray[0]);
		
		Hobby hobby2 = new Hobby();
		hobby2.setUsername(username);
		hobby2.setHobby(hobbyArray[1]);
		
		Hobby hobby3 = new Hobby();
		hobby3.setUsername(username);
		hobby3.setHobby(hobbyArray[2]);
		
		//#001用法
		/*List<Hobby> hobbyList = new ArrayList<Hobby>();
		hobbyList.add(hobby1);
		hobbyList.add(hobby2);
		hobbyList.add(hobby3); */
		
		//#002用法
		List hobbyList = new ArrayList();
		hobbyList.add(hobby1);
		hobbyList.add(hobby2);
		hobbyList.add(hobby3);
		
		
		UserInfoDAO uDao = new UserInfoDAO(); 
		
		//HobbyDAO hDao = new HobbyDAO(); 
		//dao.save(hobbyList);
		
		//用戶信息表更新
		boolean result =  uDao.save(new UserInfo(username,password,sex,major,intro));
		
		if(result){
			System.out.println("用戶信息載入成功!!!");
		}else{
			System.out.println("用戶信息載入失敗!!!");
			}
		
		
		
		//用戶愛好表更新 TODO
		//dao.save(new UserInfo(username,password,sex,major,intro));
		
		
		//request.setAttribute("admin", admin);
		request.getRequestDispatcher("/background/sysAdmin/upSysAdminStates.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}