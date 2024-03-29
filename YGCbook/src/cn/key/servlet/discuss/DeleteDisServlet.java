package cn.key.servlet.discuss;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.key.dao.BookDiscussDAO;

public class DeleteDisServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("disId"));
		BookDiscussDAO dao = new BookDiscussDAO();
		String path = "/Error.jsp";
		String returnPath = "/ShowDiscussServlet";
		if (dao.delete(id)) {
			path = "/Success.jsp";
		}
		request.setAttribute("title","����ɾ��");
		request.setAttribute("returnPath",returnPath);
		request.getRequestDispatcher("/background"+ path).forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
