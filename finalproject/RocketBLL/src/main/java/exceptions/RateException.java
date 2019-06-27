package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	
	RateDomainModel rate;

	public RateException(RateDomainModel R){
		this.rate = R;
	}
	public RateDomainModel getrate(){
		return this.rate;
	}
}