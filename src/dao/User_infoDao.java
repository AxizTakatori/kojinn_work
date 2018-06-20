package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Task;
import entity.User_info;
import entity.User_info2;



public class User_infoDao {
	private Connection con;

	private static final String SQL_SELECT_USER_ID_AND_USER_NAME_AND_TELEPHNE_AND_PASSWORD  ="SELECT user_id, user_name,telephone, password FROM user_info WHERE user_id = ? AND user_name = ?\" AND telephone = ?\" AND password = ?";

//	private static final String SQL_INSERT_INTO_USER_INFO_AND_USER = "INSERT INTO user_info (user_name,telephone , password) VALUES(?,?,?)";
	private static final String SQL__SELECT_USER_ID = "SELECT user_id FROM user_info ";

	private static final String SQL_SELECT_ID = "SELECT * FROM user_info WHERE user_id = ?  ";
	private static final String SQL_SELECT_NAME = "SELECT * FROM user_info WHERE user_name = ?  ";
	private static final String SQL_SELECT_TEL = "SELECT * FROM user_info WHERE telephone = ?  ";
	private static final String SQL_SELECT_NAME_TEL = "SELECT * FROM user_info WHERE user_name = ? AND telephone = ?  ";
	private static final String SQL_SELECT_ID_NAME = "SELECT * FROM user_info WHERE user_id = ? AND user_name = ?";
	private static final String SQL_SELECT_ID_TEL = "SELECT * FROM user_info WHERE user_id = ? AND telephone = ?";
	private static final String SQL_SELECT_ID_NAME_TEL = "SELECT * FROM user_info WHERE user_id = ? AND user_name = ? AND telephone = ?";

	private static final String SQL_DELETE="DELETE FROM user_info WHERE user_id = ?";
	private static final String SQL_UPDATE="UPDATE user_info SET user_name=?, telephone=?, password=? WHERE user_id=?";

	private static final String SQL_INSERT_INTO_USERTABLE_AND_USER = "INSERT INTO usertable (user_id,user_name, password) VALUES(?,?,?)";
	private static final String SQL_INSERT_INTO_TASK = "INSERT INTO task (title,task,limitdate,name,status) VALUES(?,?,?,?,?)";
//	private static final String SQL_SELECT_TASK_ALL = "SELECT user_id, user_name,telephone , password FROM user_info";
	private static final String SQL_SELECT_ALL = "SELECT id,title,task,limitdate,name,status FROM task";
	private static final String SQL_SELECT_TASK_ID = "SELECT * FROM task WHERE id = ?  ";



	public User_infoDao(Connection con){
		this.con=con;
	}



	public User_info findByIdAndPass(String user_id,String user_name, String telephone ,String password) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_USER_ID_AND_USER_NAME_AND_TELEPHNE_AND_PASSWORD)){
			stmt.setString(1, user_id);
			stmt.setString(2, user_name);
			stmt.setString(3, telephone);
			stmt.setString(4, password);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new User_info(rs.getString("user_id"),rs.getString("user_name"),rs.getString("telepone"),rs.getString("password"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



	//Daoの登録メソッド
	public void register(String newid,String newname, String newpass) {
		// TODO 自動生成されたメソッド・スタブ
		try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT_INTO_USERTABLE_AND_USER)){
			stmt.setString(1, newid);
			stmt.setString(2, newname);
			stmt.setString(3, newpass);

			stmt.executeUpdate();


		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			throw new RuntimeException(e);
		}

	}


	//MAXIDを探すメソッド
	public int findmaxid() {
		PreparedStatement stmt=null;
		int max_id;
		try {
			String sql = "SELECT MAX(user_id) AS max FROM user_info";

			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				max_id = rs.getInt("max");
			} else {
				max_id=101;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//ここまででbuy_numに最大値+1が入っている。
		return max_id;
	}

	//user_infoテーブルからidを持ってくるよ
	public User_info findById(String user_id) {
		try (PreparedStatement stmt = con.prepareStatement(SQL__SELECT_USER_ID)){
			stmt.setString(1, user_id);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new User_info(rs.getString("user_id"),rs.getString("user_name"),rs.getString("telepone"),rs.getString("password"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



	//select
	public List<User_info2> findAll1() {
		List<User_info2> list = new ArrayList<User_info2>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}


	public List<User_info2> findbyId(Integer user_id) {
		List<User_info2> list = new ArrayList<User_info2>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID)) {
			stmt.setInt(1, user_id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	public List<User_info2> findbyname(String user_name) {
		List<User_info2> list = new ArrayList<User_info2>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_NAME)) {
			stmt.setString(1, user_name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	public List<User_info2> findbytel(String telephone) {
		List<User_info2> list = new ArrayList<User_info2>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_TEL)) {
			stmt.setString(1, telephone);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	public List<User_info2> findbynameAndtel(String user_name,String telephone) {
		List<User_info2> list = new ArrayList<User_info2>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_NAME_TEL)) {
			stmt.setString(1,user_name );
			stmt.setString(2, telephone);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	public List<User_info2>findbyidAndname(Integer user_id,String user_name) {
		List<User_info2> list = new ArrayList<User_info2>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID_NAME)) {
			stmt.setInt(1,user_id );
			stmt.setString(2, user_name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	public List<User_info2>findbyidAndtelephone(Integer user_id,String telephone) {
		List<User_info2> list = new ArrayList<User_info2>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID_TEL)) {
			stmt.setInt(1,user_id );
			stmt.setString(2, telephone);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;

	}
	public List<User_info2>findbyidAndnameAndtelephone(Integer user_id ,String user_name,String telephone ) {
		List<User_info2> list = new ArrayList<User_info2>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID_NAME_TEL)) {
			stmt.setInt(1,user_id );
			stmt.setString(2, user_name);
			stmt.setString(3, telephone);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User_info2 userinfo = new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	//更新　入力されたIDを探すよー
	public User_info2 findID(Integer id) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ID)) {
			stmt.setInt(1,id );
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return new User_info2(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	//削除
	public void delete(Integer id) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_DELETE)){
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//更新
	public void update(Integer user_id, String user_name, String telephone, String password) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_UPDATE)){
			stmt.setString(1, user_name);
			stmt.setString(2, telephone);
			stmt.setString(3, password);
			stmt.setInt(4, user_id);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



	public void register(String title, String task, String limitdate, String name, String status) {
		// TODO 自動生成されたメソッド・スタブ
		try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT_INTO_TASK)){
			stmt.setString(1, title);
			stmt.setString(2, task);
			stmt.setString(3, limitdate);
			stmt.setString(4, name);
			stmt.setString(5, status);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

//	public List<Task> findtaskAll(){
//		List<Task> list = new ArrayList<Task>();
//
//		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_TASK_ALL)){
//			ResultSet rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				Task lg = new Task(rs.getInt("id"),rs.getString("title"),rs.getString("task"),rs.getString("limitdate"),rs.getString("name"),rs.getString("status"));
//				list.add(lg);
//			}
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//		return list;
//	}
	public List<Task> findAll(){
		List<Task> list = new ArrayList<Task>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)){
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Task lg = new Task(rs.getInt("id"),rs.getString("title"),rs.getString("task"),rs.getString("limitdate"),rs.getString("name"),rs.getString("status"));
				list.add(lg);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}


	public List<Task> findbyid(Integer id) {
		List<Task> list = new ArrayList<Task>();


		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_TASK_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Task userinfo = new Task(rs.getInt("id"),rs.getString("title"),rs.getString("task"),rs.getString("limitdate"),rs.getString("name"),rs.getString("status"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}


	}








