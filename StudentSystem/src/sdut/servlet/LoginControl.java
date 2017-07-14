package sdut.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.UserBin;
import sdut.entity.User;
import sdut.bin.StudentBin;
import sdut.entity.Student;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
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
		request.setCharacterEncoding("utf-8");
	    String name=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		request.getSession(true);
		request.getSession().setMaxInactiveInterval(1200);
		
		if("student".equals(request.getParameter("type"))){
			StudentBin sb=new StudentBin();
			Student s=new Student();
			s.setName(name);
			s.setPassword(pwd);
			if(sb.login(s)){
				request.getSession().setAttribute("who", s);
				//设置session里的用户类型,用于控制访问权限
				request.getSession().setAttribute("type", "student");
				//跳转到学生管理界面
				response.sendRedirect("StudentScoreSelect.jsp");
			}
			else{
				response.sendRedirect("login.jsp");
			}
		}else if("user".equals(request.getParameter("type"))){
			UserBin ub=new UserBin();
			User user=new User();
			user.setName(name);
			user.setPassword(pwd);
			if(ub.login(user)){
				request.getSession().setAttribute("who", user);
				//设置session里的用户类型,用于控制访问权限
				request.getSession().setAttribute("type", "user");
				//跳转到管理员管理界面
				response.sendRedirect("StudentSelect.jsp");
			}
			else{
				response.sendRedirect("login.jsp");
			}
		}
		else{
			/* out.println("fail"); */
			response.sendRedirect("login.jsp");
			//跳转 重定向
		}
	}

}
