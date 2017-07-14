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

import sdut.bin.GradeBin;
import sdut.entity.Grade;

/**
 * Servlet implementation class GradeSelectControl
 */
@WebServlet("/GradeSelectControl")
public class GradeSelectControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeSelectControl() {
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
		GradeBin gb=new GradeBin();
		List<Grade>list=gb.search(new Integer(id));
		if(!list.isEmpty()){
			PrintWriter out= response.getWriter();
			out.write("<script>alert('success！');location.href='StudentSelect.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			request.setAttribute("message", "更新失败");
			response.sendRedirect("GradeUpdate.jsp");
		}
	}
	
}
