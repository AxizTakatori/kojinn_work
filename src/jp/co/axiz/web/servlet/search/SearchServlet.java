package jp.co.axiz.web.servlet.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Task;
import service.selectservice;


/**
 * 検索機能。タスク一覧を取得し、一覧結果へフォワードする。
 */
@WebServlet(urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		selectservice selectservice=new selectservice();
		List<Task> select = selectservice.find();
		request.setAttribute("userList", select);

		request.getRequestDispatcher("search.jsp").forward(request, response);
	}
}