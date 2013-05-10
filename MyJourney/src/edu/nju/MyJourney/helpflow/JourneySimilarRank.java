package edu.nju.MyJourney.helpflow;

import edu.nju.MyJourney.model.Journey;

public class JourneySimilarRank implements Comparable<JourneySimilarRank>{
	private Journey journey;
	private double rank;
	@Override
	public int compareTo(JourneySimilarRank o) {
		// TODO Auto-generated method stub
		if(this.rank>=o.rank){
			return 1;
		}else
			return 0;
	}
	public double getRank() {
		return rank;
	}
	public void setRank(double rank) {
		this.rank = rank;
	}
	public Journey getJourney() {
		return journey;
	}
	public void setJourney(Journey journey) {
		this.journey = journey;
	}

}
