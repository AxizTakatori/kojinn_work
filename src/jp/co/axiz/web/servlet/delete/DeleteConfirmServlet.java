package jp.co.axiz.web.servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User_info2;
import service.selectservice;

/**
 * Servlet implementation class DeleteConfirmServlet
 */
@WebServlet("/deleteConfirm")
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteConfirmServlet() {
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

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// idから取得
		HttpSession session= request.getSession();
		User_info2 ui=(User_info2)session.getAttribute("info");
		Integer deleteId=ui.getUser_id();

		//削除して結果画面へ
		selectservice userInfo=new selectservice();
		userInfo.delete(deleteId);
		session.removeAttribute("newId");//removeAttribute...セッションオブジェクトの削除
		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);

		session.setAttribute("defoid", "");
	}

}


