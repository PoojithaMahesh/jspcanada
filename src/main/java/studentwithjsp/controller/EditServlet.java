package studentwithjsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithjsp.dao.StudentDao;
import studentwithjsp.dto.Student;
@WebServlet("/edit")
public class EditServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Student student=new Student();
	student.setAddress(req.getParameter("address"));
	student.setEmail(req.getParameter("email"));
	student.setFees(Double.parseDouble(getServletContext().getInitParameter("fees")));
	student.setId(Integer.parseInt(req.getParameter("id")));
	student.setName(req.getParameter("name"));
	student.setPassword(req.getParameter("password"));
	student.setPhone(Long.parseLong(req.getParameter("phone")));
	
	
	StudentDao dao=new StudentDao();
	dao.updateStudent(student);
	
	
	Cookie[] cookies=req.getCookies();
	String studentwhologgedinandchangedthedetails=null;
	
	for(Cookie cookie:cookies) {
//		cookie==    studentwhoistryingtochangethedetails= poojitha
//		            studentwhoiistryingtodelete=abcc
		if(cookie.getName().equals("studentwhoistryingtochangethedetails")) {
			studentwhologgedinandchangedthedetails=cookie.getValue();
			break;
		}
	}
	String namewhosedetailsischanged=null;
	for(Cookie cookie:cookies) {
		if(cookie.getName().equals("nameofthestudentwhosedetailsisgoingtochange")) {
			namewhosedetailsischanged=cookie.getValue();
			break;
		}
	}
	req.setAttribute("name1", namewhosedetailsischanged);
	req.setAttribute("name", studentwhologgedinandchangedthedetails);
	req.setAttribute("list", dao.getAllStudents());
	RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
	
	dispatcher.forward(req, resp);
	
	
	
	
	
	
	
	
	
	
}
}
