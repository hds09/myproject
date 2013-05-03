package edu.nju.MyJourney.action;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
public static void main(String args[]){
	String startdate="2013-04-17";
	DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");       
	try {
		Date date = (Date) fmt.parse(startdate);
		System.out.println(date.toLocaleString());
		Date tomo = new   Date((date.getTime()/1000+86400*1)*1000);
		System.out.println(tomo.toLocaleString());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
