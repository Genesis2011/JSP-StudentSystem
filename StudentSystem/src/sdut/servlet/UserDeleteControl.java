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

@WebServlet("/UserDeleteControl")
public class UserDeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteControl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String id=request.getParameter("id");
		if(id!=null){
			UserBin ub=new UserBin();
			if(ub.delete(new Integer(id))){
				PrintWriter out= response.getWriter();
				out.write("<script>alert('success!');location.href='UserSelect.jsp';</script>");
				out.flush();
				out.close();
			}
			else{
				request.setAttribute("message", "删除失败");
				response.sendRedirect("StudentUpdate.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
