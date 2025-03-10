package com.ssafy.ws.step2.servlet;

import java.io.IOException;

import com.ssafy.ws.step2.dto.Movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.

@WebServlet("/main")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String action = request.getParameter("action");
		switch(action) {
		case "regist":
			doRegist(request, response);
			break;
		}
	}
	
	
	private void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String title = request.getParameter("title");
		String director = request.getParameter("director");
		String genre = request.getParameter("genre");
		int runningTime = Integer.parseInt(request.getParameter("runningTime"));
		
		Movie movie = new Movie(title, director, genre, runningTime);
		
		StringBuilder output = new StringBuilder();
		
		output.append("<html><body>").append("<h1>영화 정보</h1>").append(movie.toString()).append("</body></html>");
		
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(output.toString());
	}
	
	
}
