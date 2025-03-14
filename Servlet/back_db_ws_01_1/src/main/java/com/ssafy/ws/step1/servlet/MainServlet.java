package com.ssafy.ws.step1.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.ssafy.ws.step1.dto.Car;

  //이 서블릿이 호출되기 위해서는 url 상에 http://server_ip:port/context_name/main 이 필요하다.
@WebServlet("/main")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
  /**
   * get 방식의 요청에 대해 응답하는 메서드이다.
   * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
   */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}
	
	
  /**
   * post 방식의 요청에 대해 응답하는 메서드이다.
   * front controller pattern을 적용하기 위해 내부적으로 process를 호출한다.
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      // post 요청 시 한글 파라미터의 처리를 위해 encoding을 처리한다.
      request.setCharacterEncoding("utf-8");
      process(request, response);
  }
	
  /**
   * request 객체에서 action 파라미터를 추출해서 실제 비지니스 로직 메서드(ex: doRegist) 
   * 호출해준다.
   */
	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "regist":
			doRegist(request, response);
			break;
		}
	}
	
  /**
   * 자동차 정보를 등록하기 위해 파라미터가 잘 전달되는지 확인하고 전달 결과를 화면에 출력한다.
   * 이를 위해 request 전달 받은 내용을 추출해서 Car 객체를 생성한 후 response 출력한다.
   * 특히 response 시 content의 형식에 주의한다.
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
	private void doRegist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request 객체에서 전달된 parameter를 추출한다.
		String VIN = request.getParameter("VIN");
		String modelName = request.getParameter("modelName");
		String color = request.getParameter("color");
		// 문자열로 전달된 mileage는 숫자로 변환
		int mileage = Integer.parseInt(request.getParameter("mileage"));
		
		// 전달받은 parameter를 이용해서 Car 객체를 생성한다. 
		Car car = new Car(VIN, modelName, color, mileage);
		
		// 화면에 출력할 데이터를 구성한다. 
		StringBuilder output = new StringBuilder();
		
		output.append("<html><body>").append("<h1>자동차 정보</h1>").append(car.toString()).append("</body></html>");
		
		// response 객체를 통해서 생성한 html코드를 출력한다.
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(output.toString());
		
	}
}
