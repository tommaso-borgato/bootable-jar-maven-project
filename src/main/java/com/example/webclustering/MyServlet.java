package com.example.webclustering;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/clustering"})
public class MyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		long t;
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			t = System.currentTimeMillis();
			user = new User(t);
			request.getSession().setAttribute("user", user);
		}
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Web clustering demo</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Session id " + request.getSession().getId() + "</h1>");
			out.println("<h1>User Created " + user.getCreated() + "</h1>");
			out.println("<h1>Host Name " + System.getenv("HOSTNAME") + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}