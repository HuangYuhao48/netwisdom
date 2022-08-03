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

public class UserRegisterAction extends Action {

	
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
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
		String[] hobbyArr = userForm.getHobby();
		
		//用戶信息表更新
		
		UserInfo userinfo = new UserInfo(username,password,sex,major,intro);
		UserInfoDAO uDao = new UserInfoDAO(); 
		boolean rs1 =  uDao.save(userinfo);
		
		//Hobby
		
		
		List<Hobby> hobbyList = new ArrayList<Hobby>();
		
		
		// 轉換數據
		for(String hobbyRs : hobbyArr){	
			Hobby hobbyOne = new Hobby(username,hobbyRs);
			hobbyList.add(hobbyOne);
		}
		
		HobbyDAO hDao = new HobbyDAO();
		boolean rs2 = hDao.insertHobby(hobbyList);
		
		if(rs1 && rs2){
			return mapping.findForward("success");
		}else{
			return mapping.findForward("error");
			}	
	}
}