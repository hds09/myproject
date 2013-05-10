package edu.nju.MyJourney.helpflow;

import edu.nju.MyJourney.model.Attraction;

public class AttrRankCoef implements Comparable<AttrRankCoef>{
	private Attraction attr;
	private Double coef;
	public Attraction getAttr() {
		return attr;
	}
	public void setAttr(Attraction attr) {
		this.attr = attr;
	}
	public Double getCoef() {
		return coef;
	}
	public void setCoef(Double coef) {
		this.coef = coef;
	}
	@Override
	public int compareTo(AttrRankCoef o) {
		// TODO Auto-generated method stub
		if(this.coef>=o.getCoef()){
			return 1;
		}else
			return 0;
	}
}
