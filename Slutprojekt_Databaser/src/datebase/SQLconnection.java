package datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.BaseBean;
import methods.SearchStringMethods;
import methods.QueryMethods;

public class SQLconnection {

	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet resultSet = null;

	public static boolean connectSQL() {

		try {

			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception ex) {
			System.out.println("Exception Driver " + ex.getMessage());
			return false;
		}

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_base", DatabaseLogin.getuName(),
					DatabaseLogin.getuPass());

			return true;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}

	public static ArrayList<BaseBean> stateSQL(String searchString, ArrayList<BaseBean> searchResults) {
		
		ArrayList<String> tablesArrayList = QueryMethods.getTablesArrayList();
		
		List<String> firstSearchStrings = new ArrayList<String>();
		firstSearchStrings = SearchStringMethods.getFirstSearchArrayList(searchString, firstSearchStrings);
		
//		List<String> secondSearchStrings = new ArrayList<String>();
//		secondSearchStrings = SearchStringMethods.getSecondSearchArrayList(firstSearchStrings, secondSearchStrings);
		
		String requestQuery = "";
		

		try {
			
			for (int i = 0; i < tablesArrayList.size(); i++) {
				requestQuery += QueryMethods.addSelectTable(tablesArrayList.get(i));
				
				for(int j = 0; j < firstSearchStrings.size(); j++) {
					requestQuery += QueryMethods.addColumnsLike() + "\"%" + firstSearchStrings.get(j) + "%\"";
				
					if (j < firstSearchStrings.size()-1) {
						requestQuery += " OR ";
					}
				}
				
				if(i < tablesArrayList.size()-1) {
					requestQuery += " UNION ";
				}
			}
			
			
			System.out.println(requestQuery);
			

			stmt = conn.prepareStatement(requestQuery);

			resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				
				// List of all notes and numbers
				List<String> collectedNotes = new ArrayList<String>();
				
				if (resultSet.getString("notes_1") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_2") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_3") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_4") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_5") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_6") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_7") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_8") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_9") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_10") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_11") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_12") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("notes_13") != null) {
					collectedNotes.add(resultSet.getString("notes_1"));
				}
				
				if (resultSet.getString("num_1") != null) {
					collectedNotes.add(Integer.toString(resultSet.getInt("num_1")));
				}
				
				if (resultSet.getString("num_2") != null) {
					collectedNotes.add(resultSet.getBigDecimal("num_2").toString());
				}
				
				
				// Add info to bean
				BaseBean baseBean = new BaseBean();
				
				baseBean.setSearchString(searchString);
				baseBean.setName(resultSet.getString("name"));
				baseBean.setDescription(resultSet.getString("description"));
				baseBean.setNotes(collectedNotes);
				

				searchResults.add(baseBean);
			}
			resultSet.close();
			conn.endRequest();
			conn.close();

			return searchResults;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return null;

	}

}
