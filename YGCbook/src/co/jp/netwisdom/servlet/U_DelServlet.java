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



public class U_DelServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		
		HobbyDAO hobbyDAO = new HobbyDAO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		
		boolean updateUserInfoFlag = true;
		
		//用戶信息表論理消除
		updateUserInfoFlag = userInfoDAO.delUserInfo(username);
		//用戶信息表登錄
		
		
		if(updateUserInfoFlag){
			System.out.println("用戶信息表刪除成功");
		}else{
			System.out.println("用戶信息表刪除失敗");
		}
		//用戶愛好表更新Flag
		boolean updateHobbyFlag = true;
		//用戶信息表論理消除
		updateHobbyFlag = hobbyDAO.delHobby(username); 
		
		if(updateHobbyFlag){
			System.out.println("用戶愛好表刪除成功");
		}else{
			System.out.println("用戶愛好表刪除失敗");
		}
		
		req.getRequestDispatcher("U_Search.jsp").forward(req, resp);
	}
		
		
		public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException{
			this.doGet(request, response);
		}
		
		
	
		
		
		
		
		
		
		/*?UserInfoDAO dao = new UserInfoDAO();
		List<UserInfoAndHobby> list = dao.findUserInfoAndHobby(username);
		
		//創建一個存放UserInfoAndHobbyDto的List
		List<UserInfoAndHobbyDto> dtos  = new ArrayList<>();
		
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
						one.getPassword(),
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
		req.setAttribute("dto", dtos.get(0));
		
		req.getRequestDispatcher("userReg.jsp").forward(req, resp);
		
	

		UserInfo userinfo = new UserInfo(username,password,sex,major,intro);
		UserInfoDAO uDao = new UserInfoDAO(); 
		boolean rs1 =  uDao.delUserInfo(userinfo);
		
		//Hobby
		
		String[] hobbyArr = req.getParameterValues("hobby");
		List<Hobby> hobbyList = new ArrayList<Hobby>();
		
		
		// 轉換數據
		for(String hobbyRs : hobbyArr){	
			Hobby hobbyOne = new Hobby(username,hobbyRs);
			hobbyList.add(hobbyOne);
		}
		
		HobbyDAO hDao = new HobbyDAO();
		boolean rs2 = hDao.insertHobby(hobbyList);
		
		
		if(rs1){
			System.out.println("更新成功!!!");
			req.getRequestDispatcher("userUpdateSuccess.jsp").forward(req, resp);
		}else{
			System.out.println("更新失敗!!!");
			req.getRequestDispatcher("userUpdateFail.jsp").forward(req, resp);
			}
		
	
	}*/
}