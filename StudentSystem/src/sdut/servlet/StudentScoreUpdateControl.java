package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.ScoreBin;
import sdut.bin.StudentBin;
import sdut.entity.Score;
import sdut.entity.Student;

/**
 * Servlet implementation class StudentScoreUpdateControl
 */
@WebServlet("/StudentScoreUpdateControl")
public class StudentScoreUpdateControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreUpdateControl() {
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
		String score=request.getParameter("score");
		String course=request.getParameter("course");
		String time=request.getParameter("time");
		String studentid=request.getParameter("studentid");
		Score s=new Score(
				new Integer(id),
				Double.parseDouble(score),
				course,
				time,
				new Integer(studentid)
				);
		ScoreBin sb=new ScoreBin();
		if(sb.update(s)){
			PrintWriter out= response.getWriter();
			out.write("<script>alert('success!');location.href='StudentScoreSelect.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			request.setAttribute("message", "更新失败");
			response.sendRedirect("StudentUpdate.jsp");
		}
	}
}
