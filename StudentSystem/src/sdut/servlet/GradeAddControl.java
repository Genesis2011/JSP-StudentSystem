package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.GradeBin;
import sdut.entity.Grade;

/**
 * Servlet implementation class GradeControl
 */
@WebServlet("/GradeAddControl")
public class GradeAddControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeAddControl() {
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
		Grade g=new Grade();
		g.setId(new Integer(id));
		g.setName(name);
		GradeBin gb=new GradeBin();
		PrintWriter out= response.getWriter();
		if(gb.add(g)){
			out.write("<script>alert('success!');location.href='GradeSelect.jsp';</script>");
			out.flush();
			out.close();
		}else{
			out.write("<script>alert('fail!');location.href='GradeAdd.jsp';</script>");
			out.flush();
			out.close();
		}
	}

}
