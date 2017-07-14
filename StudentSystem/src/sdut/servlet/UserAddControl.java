package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.StudentBin;
import sdut.bin.UserBin;
import sdut.entity.Student;
import sdut.entity.User;

/**
 * Servlet implementation class UserAddControl
 */
@WebServlet("/UserAddControl")
public class UserAddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAddControl() {
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
		String password=request.getParameter("password");
		String age=request.getParameter("age");		
		String phone=request.getParameter("phone");		
		User u=new User(
				new Integer(id),
				name,
				password,
				new Integer(age),				
				phone
				);
		UserBin ub=new UserBin();
		PrintWriter out= response.getWriter();
		if(ub.add(u)){
			out.write("<script>alert('success!');location.href='UserSelect.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			out.write("<script>alert('fail!');location.href='UserAdd.jsp';</script>");
			out.flush();
			out.close();
		}
	}
}
