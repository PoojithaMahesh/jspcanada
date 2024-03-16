package studentwithjsp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	StudentDao dao=new StudentDao();
	List<Student> students=dao.getAllStudents();
	
	boolean value=false;
	String dbPassword=null;
	
	
	for(Student student:students) {
		if(email.equals(student.getEmail())) {
			value=true;
			dbPassword=student.getPassword();
			break;
		}
	}
	
	if(value) {
//		email is present
		if(password.equals(dbPassword)) {
//			login success
			RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
			dispatcher.forward(req, resp);
			
		}else {
//			password is not valid
			req.setAttribute("message", "INVALID PASSWORD");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}else {
		req.setAttribute("message", "INVALID EMAIL");
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.include(req, resp);
	}
	
	
	
	
	
	
	
	
	
}
}
