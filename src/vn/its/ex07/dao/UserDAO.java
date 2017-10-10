package vn.its.ex07.dao;

import vn.its.ex07.model.User;

public interface UserDAO {

	User login(String userEmail, String userPass);
}
