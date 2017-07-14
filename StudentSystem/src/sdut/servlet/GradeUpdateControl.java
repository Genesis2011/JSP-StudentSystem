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
import sdut.entity.Grade;

/**
 * Servlet implementation class GradeUpdateControl
 */
@WebServlet("/GradeUpdateControl")
public class GradeUpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeUpdateControl() {
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
		System.out.println(id);
		System.out.println(name);
		Grade g=new Grade();
		g.setId(new Integer(id));
		g.setName(name);
		GradeBin gb=new GradeBin();
		if(gb.update(g)){
			PrintWriter out= response.getWriter();
			out.write("<script>alert('success！');location.href='GradeSelect.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			request.setAttribute("grade", new ArrayList<Grade>().add(g));
			request.setAttribute("message", "更新失败");
			response.sendRedirect("GradeUpdate.jsp");
		}
	}
}
