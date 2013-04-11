
package edu.nju.MyJourney.model;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;




@SuppressWarnings("deprecation")
public class test {
	  public static void main(String[] args) {
		     
	    	new SchemaExport(new AnnotationConfiguration().configure()).create(false, true);
	    }
}
