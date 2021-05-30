package methods;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchStringMethods {

	public static List<String> getpartialSearchArrayLiStrings(String searchString) {

		// Input words with 3 or more letters added to ArrayList
		List<String> searchWords = new ArrayList<String>();
		String words[] = searchString.trim().split(" ");

		for (String word : words) {
			if (word.length() >= 3) {
				searchWords.add(word);
			}
		}

		// Split up words in parts
		Set<String> parts = new HashSet<String>();

		int minLength = 3;

		for (String word : searchWords) {

			for (int i = 0; i < word.length(); i++) {

				for (int j = i + minLength; j <= word.length(); j++) {
					parts.add(word.substring(i, j));

				}
			}

		}

		System.out.println(parts);

		//
		List<String> searchParts = new ArrayList<String>();
		searchParts.addAll(parts);

		return searchParts;

	}

}
