package ece325_lab_assignment6;

public class CompareManySmallStringsConcatenation {
	/**
	 * Creates numberOfStrings String objects and performs operationsPerString concatenation
	 * operations on every string. Note that you can create one string first, then perform all
	 * the operations on that string, then create the second string, etc.
	 * @param numberOfStrings
	 * @param operationsPerString
	 */
	private static void concatString(int numberOfStrings, int concatOperationsPerString) {
		for (int i = 0; i < numberOfStrings; i++) {
			String string = new String("");
			for (int j = 0; j < concatOperationsPerString; j++) {
				string += "test";
			}
		}
	}

	/**
	 * Creates numberOfStrings StringBuilder objects and performs operationsPerString concatenation
	 * operations on every StringBuilder. Note that you can create one StringBuilder first, then 
	 * perform all the operations on that StringBuilder, then convert the StringBuilder to a String, 
	 * then create the second StringBuilder, etc.
	 * @param numberOfStrings
	 * @param operationsPerString
	 */
	private static void concatStringBuilder(int numberOfStrings, int concatOperationsPerString) {
		for (int i = 0; i < numberOfStrings; i++) {
			StringBuilder string = new StringBuilder();
			for (int j = 0; j < concatOperationsPerString; j++) {
				string.append("test");
			}
			String result = string.toString();
		}
	}

	public static void main(String[] args) {
		MillisPerformanceMeasurement test = new MillisPerformanceMeasurement();
		
		int numberOfStrings[] = {1000, 10000, 100000, 1000000, 10000000, 100000000};
		int numberOfOperations[] = {0, 1, 2, 3, 4};

		// test #1: concatString
		System.out.println("Small strings concat using concatString: \n");
		for (int numOfStrings : numberOfStrings) {
			for (int numOfOperations : numberOfOperations) {
				test.start();
				concatString(numOfStrings, numOfOperations);
				test.end();
				System.out.println("For " + numOfStrings + " strings operated on " + numOfOperations + 
						" times : " + test.toString());
			}
		}
		
		System.out.println("\n\n");
		
		// test #2: concatStringBuilder 
		System.out.println("Small strings concat using concatStringBuilder: \n");
		for (int numOfStrings : numberOfStrings) {
			for (int numOfOperations : numberOfOperations) {
				test.start();
				concatStringBuilder(numOfStrings, numOfOperations);
				test.end();
				System.out.println("For " + numOfStrings + " strings operated on " + numOfOperations + 
						" times : " + test.toString());
			}
		}
		
		
	}
}