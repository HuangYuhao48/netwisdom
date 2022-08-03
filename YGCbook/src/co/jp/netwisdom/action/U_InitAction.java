package co.jp.netwisdom.action;

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
import co.jp.netwisdom.entity.UserInfoAndHobby;
import co.jp.netwisdom.form.U_Form;



public class U_InitAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		U_Form userForm = (U_Form)form;
		String username = userForm.getUsername();
		
		UserInfoDAO dao = new UserInfoDAO();
		List<UserInfoAndHobby> list = dao.findUserInfoAndHobby(username);
		
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
		request.setAttribute("dto", dtos.get(0));
		
		return mapping.findForward("userReg"); 
	}
}