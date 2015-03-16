package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

@WebServlet("/day.do")
public class TheDayServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1988년 3월 9일의 요일은?
		DateTime dt = new DateTime(1988, 3, 9, 12, 0, 0, 0);
		String dowStr = dt.dayOfWeek().getAsText();
		request.setAttribute("theDay", dowStr);
		System.out.println(dowStr);
		
		RequestDispatcher view = request.getRequestDispatcher("day.jsp");
		view.forward(request, response);
	}
}
