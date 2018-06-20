package jp.co.axiz.web.servlet.insert;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.User_infoDao;
import util.DbUtil;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet("/insertConfirm")
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertConfirmServlet() {
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
		response.setContentType("index.jsp; charset=UTF-8");
		HttpSession session = request.getSession();

		//フォームから入力された値を取得
		String repass = request.getParameter("rePass");
		String newid =(String) session.getAttribute("newid");
		String newpass =(String) session.getAttribute("newpass");
		String newname =(String) session.getAttribute("newname");


		if(newpass.equals(repass)) {
			//Daoの登録メソッド呼び出し
			Connection con=DbUtil.getConnection();
			User_infoDao uid =new User_infoDao(con);
			uid.register(newid,newname,newpass);

			//MAXIDを探すメソッド呼び出し
			session.setAttribute("defoid",uid.findmaxid() );

			request.getRequestDispatcher("insertResult.jsp").forward(request, response);

		}else {
			//合っていない場合『前画面で入力したパスワードと一致しません』を表示
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません。");
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);

		}

	}

}
