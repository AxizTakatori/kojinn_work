package jp.co.axiz.web.servlet.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Task;
import entity.User_info2;
import service.selectservice;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet("/select")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();


		// 入力値を取得
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String telephone = request.getParameter("telephone");

		// 入力値のチェック
		if(user_id.equals("")&&user_name.equals("")&&telephone.equals("")||(user_id==null&&user_name==null&&telephone==null)){
			// メッセージ設定
			selectservice selectservice=new selectservice();
			List<Task> select = selectservice.find();
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);


		}else if(!("".equals(user_id))&&"".equals(user_name)&&"".equals(telephone)) {
			Integer id =Integer.parseInt(user_id);
			selectservice selectservice=new selectservice();
			List<User_info2> select = selectservice.findid(id);
			if(select.size() !=0) {
				request.setAttribute("select", select);
			}else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした。");

				session.setAttribute("defoid", "");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);


		}else if("".equals(user_id)&&!("".equals(user_name))&&"".equals(telephone)) {
			//Integer id =Integer.parseInt(user_id);
			selectservice selectservice=new selectservice();
			List<User_info2> select = selectservice.findname(user_name);
			if(select.size() !=0) {
				request.setAttribute("select", select);
			}else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした。");

				session.setAttribute("defoid", "");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

		}else if("".equals(user_id)&&"".equals(user_name)&&!("".equals(telephone))) {
			//Integer id =Integer.parseInt(user_id);
			selectservice selectservice=new selectservice();
			List<User_info2> select = selectservice.findtel(telephone);
			if(select.size() !=0) {
				request.setAttribute("select", select);
			}else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした。");

				session.setAttribute("defoid", "");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

		}else if("".equals(user_id)&&!("".equals(user_name))&&!("".equals(telephone))) {
			//Integer id =Integer.parseInt(user_id);
			selectservice selectservice=new selectservice();
			List<User_info2> select = selectservice.findnameAndtel(user_name,telephone);
			if(select.size() !=0) {
				request.setAttribute("select", select);
			}else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした。");

				session.setAttribute("defoid", "");


				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

		}else if(!("".equals(user_id))&&!("".equals(user_name))&&"".equals(telephone)){
			Integer id =Integer.parseInt(user_id);
			selectservice selectservice=new selectservice();
			List<User_info2> select = selectservice.findidAndname(id,user_name);
			if(select.size() !=0) {
				request.setAttribute("select", select);
			}else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした。");

				session.setAttribute("defoid", "");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

		}else if(!("".equals(user_id))&&"".equals(user_name)&&!("".equals(telephone))){
			Integer id =Integer.parseInt(user_id);
			selectservice selectservice=new selectservice();
			List<User_info2> select = selectservice.findidAndtelephone(id,telephone);
			if(select.size() !=0) {
				request.setAttribute("select", select);
			}else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした。");

				session.setAttribute("defoid", "");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);

		}else if(!("".equals(user_id))&&!("".equals(user_name))&&!("".equals(telephone))){
			Integer id =Integer.parseInt(user_id);
			selectservice selectservice=new selectservice();
			List<User_info2> select = selectservice.findidAndnameAndtelephone(id,user_name,telephone);
			if(select.size() !=0) {
				request.setAttribute("select", select);
			}else {
				// メッセージ設定
				request.setAttribute("msg", "入力されたデータはありませんでした。");

				session.setAttribute("defoid", "");

				// 次画面指定
				request.getRequestDispatcher("select.jsp").forward(request, response);
				return;
			}
			request.setAttribute("userList", select);

			// 次画面指定
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
System.out.print(select);
		}
	}
}









