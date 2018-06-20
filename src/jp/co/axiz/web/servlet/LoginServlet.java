package jp.co.axiz.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import entity.Task;
import service.LoginService;
import service.selectservice;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		//リクエスト、レスポンス時の文字化け防止
		request.setCharacterEncoding("UTF-8");
		response.setContentType("index.jsp; charset=UTF-8");
		HttpSession session = request.getSession();

		//フォームから入力された値を取得
		String user_id = request.getParameter("id");
		String password = request.getParameter("pass");

		//何も入力されていないときは『ログインできませんでした』を表示
		if((user_id==null || password==null)||("".equals(user_id))||("".equals(password))) {
			request.setAttribute("msg", "ログインできませんでした。");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		//DBからid、passを取得　nullじゃない時は判定用のインスタンスに入れる
		LoginService loginService = new LoginService();
		Admin login = loginService.authentication(user_id, password);
		boolean isSuccess =(login != null);

		//入力されたものがDB内のadmin_id、passwordと合っているか判定
		if(isSuccess) {

			//合っていた場合はそのadminのidをセッションスコープに保存
			session.setAttribute("loginname", login.getAdmin_name());

			selectservice selectservice=new selectservice();
			List<Task> select = selectservice.find();
			request.setAttribute("userList", select);

			request.getRequestDispatcher("search.jsp").forward(request, response);

			//Daoの登録メソッド呼び出し
//			Connection con=DbUtil.getConnection();
//			User_infoDao uid =new User_infoDao(con);
//			uid.register(title,task,limitdate,name,status);




		}else {
			//合っていない場合『ログイン失敗』を表示
			request.setAttribute("msg", "ログイン失敗。");
			//次画面指定
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}