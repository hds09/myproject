package edu.nju.MyJourney.helpflow;

import edu.nju.MyJourney.model.Hotel;
import edu.nju.MyJourney.model.Restaurant;

public class RestRankCoef implements Comparable<RestRankCoef>{
	private Restaurant rest;
	private Double coff;
	@Override
	public int compareTo(RestRankCoef o) {
		// TODO Auto-generated method stub
		if(this.coff>=o.getCoff()){
			return 1;
		}else{
			return 0;
		}
	}
	public Restaurant getRest() {
		return rest;
	}
	public void setRest(Restaurant rest) {
		this.rest = rest;
	}
	public Double getCoff() {
		return coff;
	}
	public void setCoff(Double coff) {
		this.coff = coff;
	}

}
