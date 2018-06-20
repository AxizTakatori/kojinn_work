
package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.User_infoDao;
import entity.Task;
import util.DbUtil;

public  class selectservice { //loginエンティティに対する操作を提供するServiceクラス

	public List<Task> find() {
		try (Connection con = DbUtil.getConnection()) {
			User_infoDao uid = new User_infoDao(con);
			return uid.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
	public List<Task> findid(Integer id) {
		try (Connection con = DbUtil.getConnection()) {
			User_infoDao uid = new User_infoDao(con);
			return uid.findbyid(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
//
//	public List<User_info2> findname(String user_name) {
//		try (Connection con = DbUtil.getConnection()) {
//			User_infoDao uid = new User_infoDao(con);
//			return uid.findbyname(user_name);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Collections.emptyList();
//	}
//	public List<User_info2> findtel(String telephone) {
//		try (Connection con = DbUtil.getConnection()) {
//			User_infoDao uid = new User_infoDao(con);
//			return uid.findbytel(telephone);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Collections.emptyList();
//	}
//	public List<User_info2> findnameAndtel(String user_name,String telephone) {
//		try (Connection con = DbUtil.getConnection()) {
//			User_infoDao uid = new User_infoDao(con);
//			return uid.findbynameAndtel(user_name,telephone);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Collections.emptyList();
//	}
//	public List<User_info2> findidAndname(Integer user_id,String user_name) {
//		try (Connection con = DbUtil.getConnection()) {
//			User_infoDao uid = new User_infoDao(con);
//			return uid.findbyidAndname(user_id,user_name);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Collections.emptyList();
//	}
//	public List<User_info2> findidAndtelephone(Integer user_id,String telephone ) {
//		try (Connection con = DbUtil.getConnection()) {
//			User_infoDao uid = new User_infoDao(con);
//			return uid.findbyidAndtelephone(user_id,telephone);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Collections.emptyList();
//
//	}
//	public List<User_info2> findidAndnameAndtelephone(Integer user_id ,String user_name,String telephone ) {
//		try (Connection con = DbUtil.getConnection()) {
//			User_infoDao uid = new User_infoDao(con);
//			return uid.findbyidAndnameAndtelephone(user_id,user_name,telephone);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return Collections.emptyList();
//	}
//
//	public void delete(Integer u_id) {
//		try(Connection con = DbUtil.getConnection()){
//			User_infoDao userinfo = new User_infoDao(con);
//			userinfo.delete(u_id);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}
//
//	public void update(Integer user_id,String user_name, String telephone, String password) {
//		try(Connection con = DbUtil.getConnection()){
//			User_infoDao userinfo = new User_infoDao(con);
//			userinfo.update(user_id, user_name, telephone, password);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//	}

}