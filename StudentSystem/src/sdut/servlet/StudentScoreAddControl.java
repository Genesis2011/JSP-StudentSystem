package sdut.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sdut.bin.ScoreBin;
import sdut.bin.StudentBin;
import sdut.entity.Score;
import sdut.entity.Student;
@WebServlet("/StudentScoreAddControl")
public class StudentScoreAddControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreAddControl() {
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
//		String id=request.getParameter("id");
		String score=request.getParameter("score");
		String course=request.getParameter("course");
		String time=request.getParameter("time");
		String studentid=request.getParameter("studentid");
		
	    Score s=new Score(
				null,
				new Double(score),
				course,
				time,
				new Integer(studentid)				
				);
		ScoreBin scorebin=new ScoreBin();
		boolean i=scorebin.add(s);
		System.out.println(i);
		PrintWriter out= response.getWriter();
		if(i){
			out.write("<script>alert('success!');location.href='StudentScoreSelect.jsp';</script>");
			out.flush();
			out.close();
		}
		else{
			out.write("<script>alert('fail!');location.href='StudentScoreAdd.jsp';</script>");
			out.flush();
			out.close();
		}
	}
}
