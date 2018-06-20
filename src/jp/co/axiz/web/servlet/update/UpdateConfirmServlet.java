package jp.co.axiz.web.servlet.update;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User_infoDao;
import entity.User_info2;
import util.DbUtil;

/**
 * Servlet implementation class UpdateConfirmServlet
 */
@WebServlet("/updateConfirmt")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfirmServlet() {
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
		// TODO Auto-generated method stub
//		doGet(request, response);

		request.setCharacterEncoding("UTF-8");


		// 入力情報を取得
		HttpSession session = request.getSession();
		String tel = (String) session.getAttribute("newtel");
		String name = (String) session.getAttribute("newname");
		String repass = (String) request.getParameter("rePass");
		User_info2 uinfo = (User_info2) session.getAttribute("update");
		String pass = (String) session.getAttribute("newpass");
		Integer id = uinfo.getUser_id();

		System.out.print(repass+pass);

		//更新して結果画面へ

		if(repass.equals(pass) ){
			try(Connection conn = DbUtil.getConnection()){
				User_infoDao userinfoDao = new User_infoDao(conn);
				userinfoDao.update(id,name,tel,pass);
				session.setAttribute("default_id", id);
				request.getRequestDispatcher("updateResult.jsp").forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません");
			request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);

	}

	}

}
