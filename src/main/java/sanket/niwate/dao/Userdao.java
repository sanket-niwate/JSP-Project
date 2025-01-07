package sanket.niwate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sanket.niwate.model.User;

public class Userdao {
	private Connection con;
	private String query;
	private PreparedStatement pre;
	private ResultSet rs;

	public Userdao(Connection con) {
		this.con = con;
	}
	
	public User userLogin (String email ,String password) {
		User user =null;
		try {
			query="select * from users where email=? and password=?";
					pre =con.prepareStatement(query);
			pre.setString(1, email);
			pre.setString(2, password);
			rs=pre.executeQuery();
			if (rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return user;
	}
	
}
