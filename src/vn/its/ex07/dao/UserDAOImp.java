package vn.its.ex07.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.its.ex07.connect.DatabaseConnect;
import vn.its.ex07.model.User;

public class UserDAOImp implements UserDAO {

	private Connection conn;

	public UserDAOImp() {
		super();
		this.conn = DatabaseConnect.getConnection();
	}

	@Override
	public User login(String userEmail, String userPass) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String login = "SELECT USERID, EMAIL, PASS, FIRSTNAME, LASTNAME FROM ITSOL.USERS WHERE EMAIL = '" + userEmail
					+ "' AND PASS = '" + userPass + "'";
			pstm = conn.prepareStatement(login);
			rs = pstm.executeQuery();
			if (rs.next()) {
				int userID = rs.getInt("USERID");
				userEmail = rs.getString("EMAIL");
				userPass = rs.getString("PASS");
				String userLastName = rs.getString("LASTNAME");
				String userFirstName = rs.getString("FIRSTNAME");
				User user = new User();
				user.setUserID(userID);
				user.setUserEmail(userEmail);
				user.setUserPass(userPass);
				user.setUserFirstName(userFirstName);
				user.setUserLastName(userLastName);
				return user;
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return null;
	}
}
