package co.jp.netwisdom.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.HobbyDAO;
import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.form.U_Form;



public class U_DelAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		U_Form userForm = (U_Form)form;
		
		String username = userForm.getUsername();
		
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
		
		return mapping.findForward("U_Search"); 
	}
		
		
		/*public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException{
			this.doGet(request, response);
		}


		private void doGet(HttpServletRequest request, HttpServletResponse response) {
			// TODO Auto-generated method stub
			
		}*/
}