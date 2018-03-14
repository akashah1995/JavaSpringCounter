package com.codingdojo.counter.controllers;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Generate
 */
@WebServlet("/Generate")
public class Generate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Generate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("got here");
		HttpSession session = request.getSession();
		Random generator = new Random();
		if (session.getAttribute("Count") != null) {
			int count = (int) session.getAttribute("Count");
			count++;
			session.setAttribute("Count", count);
			String strout = "";
			for (int i = 0; i< 10; i++) {
				int r = generator.nextInt(2);
				if (r == 1) {
					int number = generator.nextInt(9);
					String stringnumber = Integer.toString(number);
					strout = strout.concat(stringnumber);
				}
				
				if (r == 0) {
					char letter = (char) (generator.nextInt(26) + 'a');
					String stringletter = Character.toString(letter);
					strout = strout.concat(stringletter);
				}
				
			}
			session.setAttribute("Word", strout);
			Date date = new Date();
			session.setAttribute("Date", date);
			System.out.println(date);
		}
		else {
			session.setAttribute("Count", 0);
			session.setAttribute("Word", "");
			session.setAttribute("Date", "");
			System.out.println("empty stuff");
		}
		request.getRequestDispatcher("/Counter").forward(request,response);
	}

}
