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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//リクエスト、レスポンス時の文字化け防止
		request.setCharacterEncoding("UTF-8");
		response.setContentType("index.jsp; charset=UTF-8");
		HttpSession session = request.getSession();


		//フォームから入力された値を取得
		String user_id = request.getParameter("id");

		try {Integer.parseInt(user_id);
		}catch(Exception e){
			request.setAttribute("msg", "無効なIDです。");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return ;
		}

		//何も入力されていないときは『ログインできませんでした』を表示
		if((user_id==null)||("".equals(user_id))) {
			request.setAttribute("msg", "必須項目を入力してください。");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		//DBからuser_idを取得
		Connection con=DbUtil.getConnection();
		User_infoDao uid =new User_infoDao(con);
	 	User_info2 uinfo =uid.findID(Integer.parseInt(user_id));
	 	if(uinfo == null) {
			request.setAttribute("msg", "入力されたデータは存在しません。");
			request.getRequestDispatcher("update.jsp").forward(request, response);
	 	}else {
	 		//セッションにいれるよ
			session.setAttribute("update", uinfo);
			request.getRequestDispatcher("updateInput.jsp").forward(request, response);
	 	}
	}
}


