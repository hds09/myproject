package edu.nju.MyJourney.helperModel;

import java.util.List;

import edu.nju.MyJourney.model.Journey;

public class SimilarJourney {
	private Journey theJ;
	private List<Journey> sims;
	public Journey getTheJ() {
		return theJ;
	}
	public void setTheJ(Journey theJ) {
		this.theJ = theJ;
	}
	public List<Journey> getSims() {
		return sims;
	}
	public void setSims(List<Journey> sims) {
		this.sims = sims;
	}
}
