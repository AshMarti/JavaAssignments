package ece325_lab_assignment6;

public class CompareLargeStringConcatenation {
	/**
	 * Creates a String object, performs concatOperations operations on it and returns the resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the String.
	 * @return The resulting String.
	 */
	private static String concatString(int concatOperations) {
		String string = new String("");
		for (int i = 0; i < concatOperations; i++) {
			string += "test";
		}
		return string;
	}
	
	/**
	 * Creates a StringBuilder object, performs concatOperations operations on it, converts the StringBuilder to a String and returns the 
	 * resulting String.
	 * @param concatOperations The number of concatenation operations to perform on the StringBuilder.
	 * @return The resulting String.
	 */
	private static String concatStringBuilder(int concatOperations) {
		StringBuilder string = new StringBuilder("");
		for (int i = 0; i < concatOperations; i++) {
			string.append("test");
		}
		String result = string.toString();
		return result;
	}

	public static void main(String[] args) {
		MillisPerformanceMeasurement test = new MillisPerformanceMeasurement();
		
		int numberOfOperations[] = {10, 100, 1000, 10000, 100000};

		// test #1: concatString
		System.out.println("Large strings concat using concatString: \n");
		for (int numOfOperations : numberOfOperations) {
			test.start();
			String output = concatString(numOfOperations);
			test.end();
			System.out.println("For string operated on " + numOfOperations + 
					" times : " + test.toString());
		}
		
		System.out.println("\n\n");
		
		
		// test #2: concatStringBuilder 
		System.out.println("Large strings concat using concatStringBuilder: \n");
		for (int numOfOperations : numberOfOperations) {
			test.start();
			String output = concatStringBuilder(numOfOperations);
			test.end();
			System.out.println("For string operated on " + numOfOperations + 
					" times : " + test.toString());
			}
		}		
	}

