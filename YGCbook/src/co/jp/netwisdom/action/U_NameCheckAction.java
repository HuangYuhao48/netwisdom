package co.jp.netwisdom.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import co.jp.netwisdom.dao.UserInfoDAO;
import co.jp.netwisdom.dto.UserInfoAndHobbyDto;
import co.jp.netwisdom.entity.UserInfo;
import co.jp.netwisdom.entity.UserInfoAndHobby;
import co.jp.netwisdom.form.U_Form;



public class U_NameCheckAction extends Action{

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		U_Form userForm = (U_Form)form;
		String username = userForm.getUsername();
		
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfo> list = dao.checkName(username);
		
		System.out.println(list.size());
		PrintWriter pWriter = response.getWriter();
		
		
		if(list.size()>=1){
			pWriter.print("1");
			
		}else {
			pWriter.print("0");
		}
		
		
		
		return null;
	}	
}