package edu.nju.MyJourney.dao;

import java.util.List;

import edu.nju.MyJourney.model.Attraction;
import edu.nju.MyJourney.model.Hotel;

public interface AttractionDao {
		public void insertAttraction(Attraction hotel);
		public Attraction getAttractionByName(String name);
		public void updateAttraction(Attraction hotel);
		public List<Attraction> getAllAttraction();
}
