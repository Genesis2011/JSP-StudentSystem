package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.StudentBin;
import sdut.entity.Student;

/**
 * Servlet implementation class StudenSelectControl
 */
@WebServlet("/RegisterControl")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControl() {
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
		request.setCharacterEncoding("UTF-8");
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
		if(sb.register(s)){
			PrintWriter out= response.getWriter();
			out.write("<script>alert('Register Success');location.href='login.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			request.setAttribute("message", "Register Failed");
			response.sendRedirect("register.jsp");
		}
	}
}
