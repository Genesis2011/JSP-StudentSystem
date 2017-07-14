package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.ScoreBin;

/**
 * Servlet implementation class ScoreDeleteControl
 */
@WebServlet("/StudentScoreDeleteControl")
public class StudentScoreDeleteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreDeleteControl() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String id=request.getParameter("id");
		System.out.println(123);
		if(id!=null){
			ScoreBin scb=new ScoreBin();
			if(scb.delete(new Integer(id))){
				PrintWriter out= response.getWriter();
				out.write("<script>alert('success!');location.href='StudentScoreSelect.jsp';</script>");
				out.flush();
				out.close();
			}
			else{
				request.setAttribute("message", "删除失败");
				response.sendRedirect("StudentScoreUpdate.jsp");
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
