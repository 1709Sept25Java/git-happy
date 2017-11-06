package com.revature.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.*;


public class Driver {

	public static void main(String[] args) {
		
		//init();
	
	}

	
	public static void init() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		Venue v1 = new Venue("Cask", "167 East 33rd Street, New York, NY", 2123004924);
		Deal d1 = new Deal("Beer", "Founder's All Day IPA and Modelo Especial cans", 5, 1600, 2000, v1, "published");
		Deal d2 = new Deal("Beer", "Cask Pilsner and Cask Belgian Wheat Ale on tap", 6, 1600, 2000, v1, "published");
		Deal d3 = new Deal("Wine", "Rioja, Pinot Grigio, Rose, Sparkling Rose, Champagne", 7, 1600, 2000, v1, "published");
		Deal d4 = new Deal("Cocktails", "Blood Orange Jalapeño Margarita, Capital Hill, Red/White Sangria", 8, 1600, 2000, v1, "published");
		Venue v2 = new Venue("Bazar", "31 W 26th Street, New York, NY", 2125108155);
		Deal d5 = new Deal("Beer", "Founder's All Day IPA and Modelo Especial cans", 5, 1130, 1900, v2, "published");
		Deal d6 = new Deal("Wine", "Pinot Grigio, Malbac, Grenache, Pinot Gris", 7, 1130, 1900, v2, "published");
		Deal d7 = new Deal("Cocktails", "Select Specialty Cocktails", 9, 1130, 1900, v2, "published");
		Venue v3 = new Venue("The Maze", "32 W 32nd Street, New York, NY", 2125108155);
		Deal d8 = new Deal("Beer", "Bottles and drafts", 5, 1730, 2000, v3, "published");
		Deal d9 = new Deal("Wine", "All Wine", 9, 1730, 2000, v3, "published");
		Deal d10 = new Deal("Cocktails", "Half Priced Cocktails", 9, 1730, 2000, v3, "published");
		Venue v4 = new Venue("The Cellar","900 Broadway, New York, NY",2124663340);
		Deal d11 = new Deal("Beer", "Entire Selection of Beer", 7, 1500, 1900, v4, "published");
		Deal d12 = new Deal("Wine", "Dry Riesling, Rose, Cabernet Sauvignon", 8, 1500, 1900, v4, "published");
		Deal d13 = new Deal("Cocktails", "Entire Selection of Specialty Cocktails", 10, 1500, 1900, v4, "published");
		Venue v5 = new Venue("District Social","252 W 37th Street, New York, NY",2129949599);
		Deal d14 = new Deal("Beer", "$4-5 Draft Pints", 4, 1600, 1900, v5, "published");
		Deal d15 = new Deal("Wine", "House Red, White, & Prosecco", 7, 1600, 1900, v5, "published");
		Deal d16 = new Deal("Cocktails", "Well Drinks", 6, 1600, 1900, v5, "published");
		Deal d17 = new Deal("Cocktails", "Cucumber Gimlet & El Diablo", 6, 1600, 1900, v5, "published");
		Venue v6 = new Venue("Calle Dao", "38 W 39th Street, New York, NY",2122219002);
		Deal d18 = new Deal("Beer", "Draft and bottles", 6, 1100, 1900, v6, "published");
		Deal d19 = new Deal("Cocktails", "Well drinks and select cocktails", 8, 1100, 1900, v6, "published");
		Venue v7 = new Venue("5th & Mad", "7 E 36th Street, New York, NY",2127252353);
		Deal d20 = new Deal("Beer", "All beers", 6, 1130, 1700, v7, "published");
		Deal d21 = new Deal("Wine", "All wine", 6, 1130, 1700, v7, "published");
		Deal d22 = new Deal("Cocktails", "All well drinks", 6, 1130, 1700, v7, "published");
		
		s.save(v1);
		s.save(v2);
		s.save(v3);
		s.save(v4);
		s.save(v5);
		s.save(v6);
		s.save(v7);
		
		s.save(d1);
		s.save(d2);
		s.save(d3);
		s.save(d4);
		s.save(d5);
		s.save(d6);
		s.save(d7);
		s.save(d8);
		s.save(d9);
		s.save(d10);
		s.save(d11);
		s.save(d12);
		s.save(d13);
		s.save(d14);
		s.save(d15);
		s.save(d16);
		s.save(d17);
		s.save(d18);
		s.save(d19);
		s.save(d20);
		s.save(d21);
		s.save(d22);
		tx.commit();
		s.close();
	}
}

//public static List<> getVenues(Session s){
//	
//}

