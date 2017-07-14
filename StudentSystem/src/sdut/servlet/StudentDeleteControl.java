package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.StudentBin;
import sdut.entity.Student;

/**
 * Servlet implementation class StudentDeleteControl
 */
@WebServlet("/StudentDeleteControl")
public class StudentDeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteControl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String id=request.getParameter("id");
		if(id!=null){
			StudentBin sb=new StudentBin();
			if(sb.delete(new Integer(id))){
				PrintWriter out= response.getWriter();
				out.write("<script>alert('success!');location.href='StudentSelect.jsp';</script>");
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
