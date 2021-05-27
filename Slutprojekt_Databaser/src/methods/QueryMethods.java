package methods;

import java.util.ArrayList;

public class QueryMethods {

	public static ArrayList<String> getTablesArrayList() {

		ArrayList<String> tablesArrayList = new ArrayList<String>();
		tablesArrayList.add("`bearbase`");
		tablesArrayList.add("`ikea_names`");
		tablesArrayList.add("`masterscplist`");

		return tablesArrayList;
	}

	public static String addSelectTable(String table) {
		return "SELECT `name`, `description`, `notes_1`, `notes_2`, `notes_3`, `notes_4`, `notes_5`, `notes_6`, `notes_7`, `notes_8`, `notes_9`, `notes_10`, `notes_11`, `notes_12`, `notes_13`, `num_1`, `num_2` FROM "
				+ table + " WHERE ";
	}

	public static String addColumnsLike() {
		return "CONCAT_WS(`name`, `description`, `notes_1`, `notes_2`, `notes_3`, `notes_4`, `notes_5`, `notes_6`, `notes_7`, `notes_8`, `notes_9`, `notes_10`, `notes_11`, `notes_12`, `notes_13`, `num_1`, `num_2`) LIKE ";
	}

}
