package ece325_lab_assignment6;

public class MillisPerformanceMeasurement implements PerformanceMeasurement {
	long timeStart;
	long timeEnd;
	boolean isStarted;
	boolean isEnded;
	/**
	 * First resets the performance measurement, and then starts it.
	 */
	public void start() {
	reset();
	isStarted = true;
	timeStart = getResult();
	}
	
	/**
	 * Ends the performance measurement.
	 */
	public void end() {
		if (isStarted && !isEnded) {
			timeEnd = getResult();
			isEnded = true;
		} else {
			System.out.println("Error in usage of end().");
		}
	}
	
	/**
	 * Resets the performance measurement. Make sure that the start and end are set to 0.
	 */
	public void reset() {
		isStarted = false;
		isEnded = false;
	}
	
	/**
	 * Returns the result of the measurement.
	 * @return the result of the measurement.
	 */
	public long getResult() {
		return System.currentTimeMillis();
	}
	
	public String toString() {
		return ("System took " + (timeEnd - timeStart) + "ms to complete task.");
	}

}
