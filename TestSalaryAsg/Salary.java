package ece325_assignment4;

public class Salary {
	
	/**
	 * Returns the amount of pay a band member will get (in dollars). This amount is computed by adding the bonus (if any)
	 * to the base salary and then deducting the amount spent on snacks. So, if a band member earned 100 dollars, spent 50 on snacks,
	 * and earned a bonus of 10 (%), their pay will be 60 dollars. 
	 * 
	 * Note: The current implementation of this method is extremely buggy and can easily be abused by anyone.
	 * 
	 * @param salary The base salary earned by this band member during this salary period (in dollars).
	 * @param snacksAmount The total amount spent by this band member on snacks during this salary period (in dollars).
	 * @param bonus The bonus percentage that the band member earned this salary period (in percentage).   
	 * @return the amount of pay a band member will get (in dollars)
	 */
	public static Double pay(Double salary, Double snacksAmount, Integer bonus) {
		try {
			// find value of bonus as a percent
			Double bonus_percent = Double.valueOf(bonus)/100;
			// find value of earnings before snacksAmount is deducted
			Double earnings = (bonus_percent + 1)*salary;
			
			// check for illegal inputs (values that are out of their specified range)
			if (salary <= 0 || salary > 1000) {
				throw new IllegalArgumentException("Value for salary must be in range (0, 1000].");
			} else if (bonus < 0 || bonus > 10) {
				throw new IllegalArgumentException("Value for bonus must be in range [0, 10].");
			} else if (snacksAmount < 0 || snacksAmount > earnings) {
				throw new IllegalArgumentException("Value for snacksAmount must be in range [0, salary + bonus earnings].");
			}
			
			// if no illegal inputs, return total pay (= earnings - snacksAmount)
			else {
				return (earnings - snacksAmount);
			}
		}
		// if any input is null, catch exception
		catch (NullPointerException e) {
			throw new NullPointerException("Value cannot be null.");
		}
	}
	
	
}
