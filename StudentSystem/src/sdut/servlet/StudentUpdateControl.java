package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.GradeBin;
import sdut.bin.StudentBin;
import sdut.entity.Grade;
import sdut.entity.Student;

/**
 * Servlet implementation class StudentUpdateControl
 */
@WebServlet("/StudentUpdateControl")
public class StudentUpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateControl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pw=request.getParameter("password");
		String age=request.getParameter("age");
		String place=request.getParameter("place");
		String phone=request.getParameter("phone");
		String qq=request.getParameter("qq");
		String grade=request.getParameter("grade");
		Student s=new Student(
				new Integer(id),
				name,
				pw,
				new Integer(age),
				place,
				phone,
				qq,
				new Integer(grade)
				);
		StudentBin sb=new StudentBin();
		if(sb.update(s)){
			PrintWriter out= response.getWriter();
			out.write("<script>alert('success!');location.href='StudentSelect.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			request.setAttribute("grade", new ArrayList<Student>().add(s));
			request.setAttribute("message", "更新失败");
			response.sendRedirect("StudentUpdate.jsp");
		}
	}
}
