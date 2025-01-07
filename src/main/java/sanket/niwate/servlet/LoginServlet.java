package sanket.niwate.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sanket.niwate.connection.Dbcon;
import sanket.niwate.dao.Userdao;
import sanket.niwate.model.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String email =request.getParameter("login-email");
			String password =request.getParameter("login-password");
			
			//out.print(email+password);
			try {
				Userdao udao=new Userdao(Dbcon.getConnection());
				User user=udao.userLogin(email, password);
				
				if (user !=null) {
					//out.print("user Login");
					request.getSession().setAttribute("auth", user);
					response.sendRedirect("index.jsp");
					
				} else {
                     out.print("user login failed");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		}
		}

