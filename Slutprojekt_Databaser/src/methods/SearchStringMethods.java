package methods;

import java.util.Arrays;
import java.util.List;

public class SearchStringMethods {

	public static List<String> getFirstSearchArrayList(String searchString, List<String> firstSearchStrings) {

//		String str[] = searchString.trim().split("\\s+|,\\s*|\\.\\s*");
		String str[] = searchString.trim().split(" ");
		firstSearchStrings = Arrays.asList(str);

		for (String s : firstSearchStrings) {
			System.out.println(s);
		}

		return firstSearchStrings;

	}

	public static List<String> getSecondSearchArrayList(List<String> firstSearchStrings,
			List<String> secondSearchStrings) {

		int minLength = 3;

		for (String word : firstSearchStrings) {

			for (int i = 0; i < word.length(); i++) {

				for (int j = i + minLength; j <= word.length(); j++) {
					secondSearchStrings.add(word.substring(i, j));
					System.out.println(secondSearchStrings);
				}
			}

		}

		return null;

	}

}
