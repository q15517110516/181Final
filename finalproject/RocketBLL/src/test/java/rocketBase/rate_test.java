package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@Test
	public void getRateTest(){
		double Rt = 0;
		try{
			Rt  = RateBLL.getRate(800);
			
		}catch (RateException e){
			e.printStackTrace();
		}
		System.out.println(Rt);
		assertTrue(Rt == 6);
	}
	
	@Test(expected = RateException.class)
	public void RateExceptionTest() throws RateException{
		assertTrue(RateBLL.getRate(100) !=0);
	}
	@Test
	public void getPaymentTest() {
		double PaymentTest = RateBLL.getPayment((0.04/12), 360, 300000, 0, true);
		System.out.println(PaymentTest);
		assertTrue(PaymentTest == -1432.25);
	}

}
