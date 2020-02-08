package org.studyeasy.model;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.studyeasy.entity.User;

// MVC yapısana uymak için modelimiz oluşturuyoruz.
public class UsersModel {
	//DataSourceyi controllerdan olmalıyız MVC yapısına göre bu nedenle parametre olarak alıyoruz
	public List<User> listUsers(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<User> listUsers = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
			connect = dataSource.getConnection();
			
			// Step 2: Create a SQL statements string
			String query = "Select * from users";
			stmt = connect.createStatement();

			// Step 3: Execute SQL query
			rs = stmt.executeQuery(query);
         
			// Step 4: Process the result set
			while(rs.next()){
				listUsers.add(new User(rs.getInt("users_id"), rs.getString("usename"), rs.getString("email"))); //Listemize userları yüklüyoruz
				//getString ve getInt ile databaseden dönen verilerimizi tipine göre alıyoruz ResultSet metodlarından yararlanarak
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listUsers;
	}

}