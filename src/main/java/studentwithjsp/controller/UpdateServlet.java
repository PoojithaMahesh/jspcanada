package studentwithjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	StudentDao dao=new StudentDao();
	Student student=dao.findStudentById(id);
	
	HttpSession httpSession=req.getSession();
	String name=(String) httpSession.getAttribute("studentwhologgedin");
	
	if(name!=null) {
//		that student is coming from Login page
		Cookie cookie=new Cookie("nameofthestudentwhosedetailsisgoingtochange", student.getName());
		resp.addCookie(cookie);
		req.setAttribute("student", student);
		RequestDispatcher dispatcher=req.getRequestDispatcher("edit.jsp");
		dispatcher.forward(req, resp);
	}else {
//		that name is null 
//		name=null he is not coming from the login page directly he is coming to this update page
		req.setAttribute("message", "Hey scammer i know you copied the url please Login");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
	
	
	
	
	
	
	
}
}
