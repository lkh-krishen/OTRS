package net.otrs.noticemanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.otrs.noticemanagement.model.Notice;

/**
 * 
==============================================================================================================================================
==============================================================================================================================================

                             THIS DAO CLASS PROVIDES CRUD DATABASE OPERATIONS FOR THE TABLE NOTICE IN THE DATABASE

==============================================================================================================================================
==============================================================================================================================================
*
**/

// DAO stands for database access object. It is a design pattern that handles all database operations.

public class NoticeDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinetrainreservationsystem?useSSL=false"; //MySQL JDBC link and name of database
	private String jdbcUsername = "root";
	private String jdbcPassword = "password";
	
	// a static variable is only allocated to the memory once: when the class loads.
	// Once a final variable has been assigned, it always contains the same value.
	
	private static final String INSERT_NOTICES_SQL = "INSERT INTO notices" + "(priority, title, description, email) VALUES" + "(?, ?, ?, ?);";
	private static final String SELECT_NOTICE_BY_ID = "select id, priority, title, description, email from notices where id = ?";
	private static final String SELECT_ALL_NOTICES = "select * from notices";
	private static final String DELETE_NOTICES_SQL = "delete from notices where id = ?;";
	private static final String UPDATE_NOTICES_SQL = "update notices set priority = ?, title = ?, description = ?, email = ? where id = ?;";

	public NoticeDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertNotice(Notice notice) throws SQLException {
		System.out.println(INSERT_NOTICES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NOTICES_SQL)) {
			preparedStatement.setInt(1, notice.getPriority());
			preparedStatement.setString(2, notice.getTitle());
			preparedStatement.setString(3, notice.getDescription());
			preparedStatement.setString(4, notice.getEmail());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Notice selectNotice(int id) {
		Notice notice = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NOTICE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int priority = rs.getInt("priority");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String email = rs.getString("email");
				notice = new Notice(id, priority, title, description, email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return notice;
	}

	public List<Notice> selectAllNotices() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Notice> notices = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NOTICES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				int priority = rs.getInt("priority");
				String title = rs.getString("title");
				String description = rs.getString("description");
				String email = rs.getString("email");
				notices.add(new Notice(id, priority, title, description, email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return notices;
	}

	public boolean deleteNotice(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_NOTICES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateNotice(Notice notice) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_NOTICES_SQL);) {
			statement.setInt(1, notice.getPriority());
			statement.setString(2, notice.getTitle());
			statement.setString(3, notice.getDescription());
			statement.setString(4, notice.getEmail());
			statement.setInt(5, notice.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err); //System.err writes to a file.           // The printStackTrace() method in Java is a tool used to handle exceptions and errors. It is a
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());    // method of Java's throwable class which prints the throwable along with other details like
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode()); // he line number and class name where the exception occurred
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause(); // The getCause() method of Throwable class is the inbuilt method used to return the cause of this 
					                  // throwable or null if cause can’t be determined for the Exception occurred.
				}
			}
		}
	}

}
