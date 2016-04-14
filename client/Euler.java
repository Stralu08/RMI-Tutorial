package client;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import compute.Task;

public class Euler implements Task<BigDecimal>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int digits;
	
	public Euler(int digits){
		this.digits = digits;
	}
	
	@Override
	public BigDecimal execute() {
		return computeE(digits);
	}
	
	public static BigDecimal computeE(int digits){
		MathContext mc = new MathContext(100, RoundingMode.HALF_UP);
	    BigDecimal result = BigDecimal.ZERO;
	    for (int i = 0; i <= digits; i++) {
	      BigDecimal factorial = factorial(new BigDecimal(i));
	      BigDecimal res = BigDecimal.ONE.divide(factorial, mc);
	      result = result.add(res);
	    }
	    return result;
	}
	
	private static BigDecimal factorial(BigDecimal n) {
		if (n.equals(BigDecimal.ZERO))
		     return BigDecimal.ONE;
		 else
		     return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
		 }

	

}
