package co.jp.netwisdom.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.entity.Hobby;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.form.U_Form;



public class U_UpdateAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//強轉父類
		U_Form userForm = (U_Form)form;
		//Name
		String username = userForm.getUsername();
		//pwd
		String password = userForm.getPassword();
		//sex
		String sex = userForm.getSex();
		//major
		String major = userForm.getMajor();
		//intro
		String intro = userForm.getIntro();
		//hobby
		String[] hobbyArray = userForm.getHobby();
		
		List hobbyList = new ArrayList<>();
		
		for(int i=0 ; i<hobbyArray.length; i++){
			Hobby hobbyObject = new Hobby();
			hobbyObject.setUsername(username);
			hobbyObject.setHobby(hobbyArray[i]);
			hobbyList.add(hobbyObject);
		}
		HobbyDAO hobbyDAO = new HobbyDAO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		
		boolean updateUserInfoFlag = true;
		
		//用戶信息表論理消除
		updateUserInfoFlag = userInfoDAO.delUserInfo(username);
		//用戶信息表登錄
		updateUserInfoFlag = userInfoDAO.save(new UserInfo(username,password,sex,major,intro));
		
		if(updateUserInfoFlag){
			System.out.println("用戶信息表更新成功");
		}else{
			System.out.println("用戶信息表更新失敗");
		}
		//用戶愛好表更新Flag
		boolean updateHobbyFlag = true;
		//用戶信息表論理消除
		updateHobbyFlag = hobbyDAO.delHobby(username);
		//用戶信息表登錄
		updateHobbyFlag = hobbyDAO.insertHobby(hobbyList);
		
		if(updateHobbyFlag){
			System.out.println("用戶愛好表更新成功");
		}else{
			System.out.println("用戶愛好表更新失敗");
		}
		
		return mapping.findForward("update"); 
	}
		
		
		/*public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException{
			this.doGet(request, response);
		}


		private void doGet(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}*/
	
	
}