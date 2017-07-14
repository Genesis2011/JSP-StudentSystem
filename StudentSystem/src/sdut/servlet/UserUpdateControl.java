package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class UserUpdateControl
 */
@WebServlet("/UserUpdateControl")
public class UserUpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pw=request.getParameter("password");
		String age=request.getParameter("age");
		String phone=request.getParameter("phone");
		User u=new User(
				new Integer(id),
				name,
				pw,
				new Integer(age),
				phone
				);
		UserBin ub=new UserBin();
		if(ub.update(u)){
			PrintWriter out= response.getWriter();
			out.write("<script>alert('success!');location.href='UserSelect.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			request.setAttribute("grade", new ArrayList<User>().add(u));
			request.setAttribute("message", "更新失败");
			response.sendRedirect("StudentUpdate.jsp");
		}
	}
}
