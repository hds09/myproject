package edu.nju.MyJourney.helpflow;

import edu.nju.MyJourney.model.Hotel;

public class HotelRankCoef implements Comparable<HotelRankCoef>{
	private Hotel hotel;
	private double coff;
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Double getCoff() {
		return coff;
	}
	public void setCoff(Double coff) {
		this.coff = coff;
	}
	@Override
	public int compareTo(HotelRankCoef hr) {
		// TODO Auto-generated method stub
		if(this.coff>hr.getCoff()){
			return 1;
		}else if(this.coff<hr.getCoff()){
			return -1;
		}else{
			return 0;
		}
	}
}
