package jp.co.axiz.web.servlet.update;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User_info2;

/**
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet("/updateInput")
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInputServlet() {
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

		// ログインID、パスワードを取得
		String newname = request.getParameter("newName");
		String newtel = request.getParameter("newTel");
		String newpass = request.getParameter("newPass");

		System.out.println(newpass);

		HttpSession session=request.getSession();
		User_info2 Uinfo =(User_info2) session.getAttribute("update");

		// 入力値のチェック
		if (newname.equals(Uinfo.getUser_name()) && newtel.equals(Uinfo.getTelephone()) && newpass.equals(Uinfo.getPassword())) {//変更されているかのﾁｪｯｸ
			request.setAttribute("msg", "１項目以上変更してください");
			// 次画面指定
//			System.out.print("aaaaa");
			request.getRequestDispatcher("updateInput.jsp").forward(request, response);
		}else if(("".equals(newname)||"".equals(newtel)||"".equals(newpass))){
			request.setAttribute("msg", "１項目以上変更してください");
//			System.out.print("xxx");
			request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
			}else {//nameとtelを格納
				session.setAttribute("newname", newname);
				session.setAttribute("newtel", newtel);
				session.setAttribute("newpass", newpass);
				session.setAttribute("id", Uinfo.getUser_id());

				if(newpass.equals(Uinfo.getPassword())){

					request.setAttribute("defopass", newpass);

				}else {

					request.setAttribute("defopass", "");

				}
//			System.out.print("ccc");
			request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
		}
	}


	}


