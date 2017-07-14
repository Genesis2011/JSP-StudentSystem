package sdut.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class StudentScoreUpdateConnection
 */
@WebServlet("/StudentScoreUpdateConnection")
public class StudentScoreUpdateConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentScoreUpdateConnection() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF8");
		String id=request.getParameter("id");
		if(id!=null){
			ScoreBin sb=new ScoreBin();
			List<Score> list=sb.search(new Integer(id));
			request.setAttribute("list", list);
			request.getRequestDispatcher("StudentScoreUpdate.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
