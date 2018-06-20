package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import dao.AdminDao;
import entity.Admin;
import util.DbUtil;

public class LoginService {

	public List<Admin>find(){
		try(Connection con = DbUtil.getConnection()){
			AdminDao ld = new AdminDao(con);
			return ld.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public Admin authentication(String admin_id, String password) {
		try(Connection con = DbUtil.getConnection()){
			AdminDao logindao = new AdminDao (con);
			Admin log = logindao.findByIdAndPass(admin_id, password);

			return log;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
