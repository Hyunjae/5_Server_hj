package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

@WebServlet("/scope") // 무조건 절대경로 방식으로 요청 주소 작성
public class ScopeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/scope.jsp");
		
		// 1. page -> JSP에서만 사용 가능
//		PageContext 추상클래스를 이용함
		
		// 2. request
		req.setAttribute("message", "request scope에 저장된 메세지 입니다.");
		
		// 3. session
		// 1) HttpSession 객체 얻어오기
		// 브라우저는 사용자가 사용, 사용자의 정보는 request에 담겨있기 때문에
		// request를 통해서 session을 얻어온다
		HttpSession session = req.getSession();
		
		// 2) session scope로 값 세팅하기
		// * page, request, session, application은 모두 사용법이 동일
		session.setAttribute("sessionValue", "999");
		
		// 4. application
		// 1) ServletContext 객체 얻어오기
		ServletContext application = req.getServletContext();
		
		// 2) application 범위로 값 세팅
		application.setAttribute("appValue", "애플리케이션 범위 값");
		
		
		// 내장 객체 우선 순위 확인
		
		// page -> JSP 작성
		// request
		req.setAttribute("str", "request scope");
		session.setAttribute("str", "session scope");
		application.setAttribute("str", "application scope");
		
		
		
		dispatcher.forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
