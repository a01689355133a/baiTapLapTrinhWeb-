package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.register;

import java.io.IOException;

import DAO.DAOregister;

/**
 * Servlet implementation class controllerRegister
 */
@WebServlet("/register")
public class controllerRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String  password = request.getParameter("password");
		String  repassword = request.getParameter("repassword");
		request.setAttribute("username", username);
		request.setAttribute("fullname", fullname);
		request.setAttribute("email", email);
		request.setAttribute("sdt", sdt);
		String baoloi = "";
		DAOregister dr = new DAOregister();
		String url = "";
		if(dr.kiemTraTenDangNhap(username)) {
			baoloi += " Tên đăng nhập đã tồn tại! </br>";
		}
		if(!password.equals(repassword)) {
			baoloi += " mật khẩu không khớp! </br>";
		}
		request.setAttribute("baoloi", baoloi);
		
		if(baoloi.length() > 0) {
			url = "/dangKi.jsp";
		}else {
			register reg = new register(username, fullname, email, sdt, password);
			dr.insert(reg);
			url = "/registerSuccess.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
