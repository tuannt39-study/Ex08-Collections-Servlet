package vn.its.ex07.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.its.ex07.dao.UserDAOImp;
import vn.its.ex07.model.User;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String LOGIN = "/admin/login.jsp";
	private static String INDEX = "/index.jsp";

	private User user;
	private UserDAOImp userDAOImp;

	public UserController() {
		super();
		user = new User();
		userDAOImp = new UserDAOImp();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forward = "";
		String action = request.getParameter("action");
		try {
			if (action.equalsIgnoreCase("login")) {
				forward = LOGIN;
			} else if (action.equalsIgnoreCase("logout")) {
				HttpSession session = request.getSession();
				session.invalidate();
				String error = "Dang Xuat";
				request.setAttribute("error", error);
				forward = LOGIN;
			} else {
				forward = INDEX;
			}
		} catch (Exception ex) {
			forward = INDEX;
			Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String forward = "";
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String error = "";
		switch (action) {
		case "login":
			String userEmail = request.getParameter("userEmail");
			String userPass = request.getParameter("userPass");
			if (userEmail == null || userEmail == "") {
				error = "Ban phai nhap Email <br />";
			}
			;
			if (userPass == null || userPass == "") {
				error += "Ban phai nhap Pass";
			}
			;
			if (error == "") {
				user = userDAOImp.login(userEmail, userPass);
				if (user != null) {
					session.setAttribute("user", user);
					Cookie cookie = new Cookie("userEmail", userEmail);
					cookie.setMaxAge(60*15);
					response.addCookie(cookie);
					forward = INDEX;
				} else {
					error = "Nhap Sai";
					request.setAttribute("error", error);
					forward = LOGIN;
				}
			} else {
				request.setAttribute("error", error);
				forward = LOGIN;
			}
			break;
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}
}
