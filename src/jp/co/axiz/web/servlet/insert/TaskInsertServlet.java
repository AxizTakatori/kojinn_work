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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/taskinsert")
public class TaskInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskInsertServlet() {
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

		//リクエスト、レスポンス時の文字化け防止
		request.setCharacterEncoding("UTF-8");
		response.setContentType("index.jsp; charset=UTF-8");
		HttpSession session = request.getSession();

		//フォームから入力された値を取得
				String title = request.getParameter("title");
				String task = request.getParameter("task");
				String limitdate = request.getParameter("limitdate");
				String name = request.getParameter("name");
				String status = request.getParameter("status");

				if((title==null || task==null || limitdate==null || name==null || status==null)||("".equals(title))||("".equals(task))||("".equals(limitdate))||("".equals(name))||("".equals(status))) {
					request.setAttribute("msg", "項目が未入力です。");
					request.getRequestDispatcher("detail.jsp").forward(request, response);
					return;

				}else {
					//合っていない場合『ログイン失敗』を表示
					session.setAttribute("newtitle", title);
					session.setAttribute("newtask", task);
					session.setAttribute("newlimitdate", limitdate);
					session.setAttribute("newname", name);
					session.setAttribute("newstatus", status);

					//Daoの登録メソッド呼び出し
					Connection con=DbUtil.getConnection();
					User_infoDao uid =new User_infoDao(con);
					uid.register(title,task,limitdate,name,status);

					request.getRequestDispatcher("taskinsertResult.jsp").forward(request, response);
				}

	}

}
