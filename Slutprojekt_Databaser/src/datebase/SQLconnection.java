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

		// First search - full sentence search
		List<String> fullSentenceSearch = new ArrayList<String>();
		fullSentenceSearch.add(searchString);
		List<BaseBean> fullSearchResults = null;

		// Set PreparedStatement
		stmt = generatePreparedStatement(fullSentenceSearch);

		try {
			resultSet = stmt.executeQuery();

			// Add first search beans to list
			fullSearchResults = addToBaseBean(resultSet);
			conn.endRequest();

		} catch (

		SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		// Second search - partial word search
		List<String> partialSearch = SearchStringMethods.getpartialSearchArrayLiStrings(searchString);
		List<BaseBean> partialSearchResults = null;

		// Set PreparedStatement
		stmt = generatePreparedStatement(partialSearch);

		try {
			resultSet = stmt.executeQuery();

			// Add second search beans to list
			partialSearchResults = addToBaseBean(resultSet);

			resultSet.close();
			conn.endRequest();
			conn.close();

		} catch (

		SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		// Add fullSearchResult to searchResult
		if (fullSearchResults != null) {

			searchResults.addAll(fullSearchResults);
		}

		// Check for duplicates and add non duplicates from partialSearchResults to
		// searchResult
		if (partialSearchResults != null) {

			for (BaseBean partialBaseBean : partialSearchResults) {

				if (!searchResults.contains(partialBaseBean)) {
					searchResults.add(partialBaseBean);

				}
			}
		}

		return searchResults;
	}

	// Method to generate a PreparedStatement with query and setString for each
	// search-"word"
	public static PreparedStatement generatePreparedStatement(List<String> searchStrings) {

		ArrayList<String> tablesArrayList = QueryMethods.getTablesArrayList();
		String requestQuery = "";

		for (int i = 0; i < tablesArrayList.size(); i++) {
			requestQuery += QueryMethods.addSelectTable(tablesArrayList.get(i));

			for (int j = 0; j < searchStrings.size(); j++) {
				requestQuery += QueryMethods.addMatchColumnsAgainst() + "(?)";

				if (j < searchStrings.size() - 1) {
					requestQuery += " OR ";
				}
			}

			if (i < tablesArrayList.size() - 1) {
				requestQuery += " UNION ";
			}
		}

		try {
			stmt = conn.prepareStatement(requestQuery);

			for (int i = 0; i < searchStrings.size(); i++) {

				for (int j = 0; j < tablesArrayList.size(); j++) {

					stmt.setString(j * searchStrings.size() + i + 1, searchStrings.get(i));

				}
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		System.out.println(stmt);
		return stmt;

	}

	// Add query result to BaseBean and return results with all the BaseBeans
	public static List<BaseBean> addToBaseBean(ResultSet resultSet) {
		List<BaseBean> results = new ArrayList<BaseBean>();

		try {
			while (resultSet.next()) {

				BaseBean baseBean = new BaseBean();

				// Add info to bean
				baseBean.setName(resultSet.getString("name"));
				baseBean.setDescription(resultSet.getString("description"));
				baseBean.setNotes1(resultSet.getString("notes_1"));
				baseBean.setNotes2(resultSet.getString("notes_2"));
				baseBean.setNotes3(resultSet.getString("notes_3"));
				baseBean.setNotes4(resultSet.getString("notes_4"));
				baseBean.setNotes5(resultSet.getString("notes_5"));
				baseBean.setNotes6(resultSet.getString("notes_6"));
				baseBean.setNotes7(resultSet.getString("notes_7"));
				baseBean.setNotes8(resultSet.getString("notes_8"));
				baseBean.setNotes9(resultSet.getString("notes_9"));
				baseBean.setNotes10(resultSet.getString("notes_10"));
				baseBean.setNotes11(resultSet.getString("notes_11"));
				baseBean.setNotes12(resultSet.getString("notes_12"));
				baseBean.setNotes12(resultSet.getString("notes_13"));
				baseBean.setNum1(Integer.toString(resultSet.getInt("num_1")));

				if (resultSet.getBigDecimal("num_2") != null) {
					baseBean.setNum2(resultSet.getBigDecimal("num_2").toString());
				}
				results.add(baseBean);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return results;

	}

}
