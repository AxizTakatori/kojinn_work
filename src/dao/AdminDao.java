package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Admin;



public class AdminDao {
	private Connection con;
	private static final String SQL_SELECT_ADMIN_ID_AND_PASSWORD ="SELECT user_id, user_name, password FROM usertable WHERE user_id = ? AND password = ?";
	private static final String SQL_SELECT_ALL = "SELECT admin_id, admin_name, password";
	private static final String SQL_INSERT_INTO_USER_INFO_AND_USER = "INSERT INTO admin (admin_name , password) VALUES(?,?)";

//	private static final String SQL_SELECT_USER_ID_AND_USER_NAME_AND_TELEPHNE_AND_PASSWORD  ="SELECT user_id, user_name,telephone, password FROM user_info WHERE user_id = ? AND user_name = ?\" AND telephone = ?\" AND password = ?";
//	private static final String SQL_SELECT_ALL1 = "SELECT user_id, user_name,telephone , password";

	public AdminDao(Connection con){
		this.con=con;
	}

	public Admin findByIdAndPass(String user_id, String password) {
		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ADMIN_ID_AND_PASSWORD)){
			stmt.setString(1, user_id);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				return new Admin(rs.getString("user_id"),rs.getString("user_name"),rs.getString("password"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Admin> findAll(){
		List<Admin> list = new ArrayList<Admin>();

		try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)){
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Admin lg = new Admin(rs.getString("admin_id"),rs.getString("admin_name"),rs.getString("password"));
				list.add(lg);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}


	//Daoの登録メソッド
	public void register(String newname,String newpass) {
		// TODO 自動生成されたメソッド・スタブ
		try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT_INTO_USER_INFO_AND_USER)){
			stmt.setString(1, newname);
			stmt.setString(2, newpass);

			stmt.executeUpdate();


		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			throw new RuntimeException(e);
		}

	}


	}

