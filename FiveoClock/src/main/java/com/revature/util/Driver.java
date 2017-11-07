package com.revature.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.dao.DealDao;
import com.revature.dao.DealDaoImpl;
import com.revature.domain.*;

public class Driver {

	public static void main(String[] args) throws JsonProcessingException{

		 init();
		 DealDaoImpl dd = new DealDaoImpl();
		 dd.getDealsJSON();
	}

	public static void init() {

		Session s = HibernateUtil.getSession();

		Transaction tx = s.beginTransaction();

		Venue v1 = new Venue("Cask", "167 East 33rd Street, New York, NY", "2123004924");

		Deal d1 = new Deal("Beer", "Founder's All Day IPA and Modelo Especial cans", 5, 1600, 2000, v1, "published");

		Deal d2 = new Deal("Beer", "Cask Pilsner and Cask Belgian Wheat Ale on tap", 6, 1600, 2000, v1, "published");

		Deal d3 = new Deal("Wine", "Rioja, Pinot Grigio, Rose, Sparkling Rose, Champagne", 7, 1600, 2000, v1,
				"published");

		Deal d4 = new Deal("Cocktails", "Blood Orange Jalapeño Margarita, Capital Hill, Red/White Sangria", 8, 1600,
				2000, v1, "published");

		Venue v2 = new Venue("Bazar", "31 W 26th Street, New York, NY", "2125108155");

		Deal d5 = new Deal("Beer", "Founder's All Day IPA and Modelo Especial cans", 5, 1130, 1900, v2, "published");

		Deal d6 = new Deal("Wine", "Pinot Grigio, Malbac, Grenache, Pinot Gris", 7, 1130, 1900, v2, "published");

		Deal d7 = new Deal("Cocktails", "Select Specialty Cocktails", 9, 1130, 1900, v2, "published");

		Venue v3 = new Venue("The Maze", "32 W 32nd Street, New York, NY", "2125108155");

		Deal d8 = new Deal("Beer", "Bottles and drafts", 5, 1730, 2000, v3, "published");

		Deal d9 = new Deal("Wine", "All Wine", 9, 1730, 2000, v3, "published");

		Deal d10 = new Deal("Cocktails", "Half Priced Cocktails", 9, 1730, 2000, v3, "published");

		Venue v4 = new Venue("The Cellar", "900 Broadway, New York, NY", "2124663340");

		Deal d11 = new Deal("Beer", "Entire Selection of Beer", 7, 1500, 1900, v4, "published");

		Deal d12 = new Deal("Wine", "Dry Riesling, Rose, Cabernet Sauvignon", 8, 1500, 1900, v4, "published");

		Deal d13 = new Deal("Cocktails", "Entire Selection of Specialty Cocktails", 10, 1500, 1900, v4, "published");

		Venue v5 = new Venue("District Social", "252 W 37th Street, New York, NY", "2129949599");

		Deal d14 = new Deal("Beer", "$4-5 Draft Pints", 4, 1600, 1900, v5, "published");

		Deal d15 = new Deal("Wine", "House Red, White, & Prosecco", 7, 1600, 1900, v5, "published");

		Deal d16 = new Deal("Cocktails", "Well Drinks", 6, 1600, 1900, v5, "published");

		Deal d17 = new Deal("Cocktails", "Cucumber Gimlet & El Diablo", 6, 1600, 1900, v5, "published");

		Venue v6 = new Venue("Calle Dao", "38 W 39th Street, New York, NY", "2122219002");

		Deal d18 = new Deal("Beer", "Draft and bottles", 6, 1100, 1900, v6, "published");

		Deal d19 = new Deal("Cocktails", "Well drinks and select Cocktails", 8, 1100, 1900, v6, "published");

		Venue v7 = new Venue("5th & Mad", "7 E 36th Street, New York, NY", "2127252353");

		Deal d20 = new Deal("Beer", "All beers", 6, 1130, 1700, v7, "published");

		Deal d21 = new Deal("Wine", "All wine", 6, 1130, 1700, v7, "published");

		Deal d22 = new Deal("Cocktails", "All well drinks", 6, 1130, 1700, v7, "published");

		Venue v8 = new Venue("Alameda", "195 Franklin St Brooklyn, NY 11222", "3472277296");
		Deal d23 = new Deal("Beer", "Draft Beer", 7, 1800, 1900, v8, "published");
		Deal d24 = new Deal("Cocktails", "Cocktails", 10, 1800, 1900, v8, "published");
		Deal d25 = new Deal("Wine", "Wine", 9, 1800, 1900, v8, "published");

		Venue v9 = new Venue("Allswell", "124 Bedford Ave Brooklyn, NY 11211", "3477992743");
		Deal d26 = new Deal("Beer", "Beer", 7, 1600, 1900, v9, "published");
		Deal d27 = new Deal("Cocktails", "Cocktails", 13, 1600, 1900, v9, "published");
		Deal d28 = new Deal("Beer", "Can", 4, 1600, 1900, v9, "published");
		Deal d29 = new Deal("Beer", "Bottle", 4, 1600, 1900, v9, "published");
		Deal d30 = new Deal("Cider", "Cider", 10, 1600, 1900, v9, "ublished");

		Venue v10 = new Venue("Bar Matchless", "557 Manhattan Ave Brooklyn, NY 11222", "7183835333");
		Deal d31 = new Deal("Beer", "PBR", 3, 1500, 2000, v10, "published");
		Deal d32 = new Deal("Beer", "BOGO Tuesday", 6, 1500, 2000, v10, "published");
		Deal d33 = new Deal("Wells", "Well drinks", 4, 1500, 2000, v10, "published");

		Venue v11 = new Venue("Black Swan", "1048 Bedford Ave New York, NY 11205", "7187834744");
		Deal d34 = new Deal("Wells", "shots of wells", 3, 1100, 2000, v11, "published");
		Deal d35 = new Deal("Wine", "wine", 4, 1100, 2000, v11, "published");
		Deal d36 = new Deal("Whiskey", "Jameson", 4, 1100, 2000, v11, "published");
		Deal d37 = new Deal("Cocktails", "margaritas", 5, 1100, 2000, v11, "published");

		Venue v12 = new Venue("Donna", "27 Broadway Brooklyn, NY 11211", "6465686622");
		Deal d38 = new Deal("Beer", "Draft Beer", 5, 1700, 2000, v12, "published");
		Deal d39 = new Deal("Cocktails", "Frozen Cocktails", 9, 1700, 2000, v12, "published");

		Venue v13 = new Venue("Drop Off Service", "211 Ave A New York, NY 10009", "2122602914");
		Deal d40 = new Deal("Beer", "Craft Beer", 3, 1500, 2000, v13, "published");
		Deal d41 = new Deal("Wells", "Well Drinks", 5, 1500, 2000, v13, "published");

		Venue v14 = new Venue("Jeremy's Ale House", "228 Front St New York NY 10038", "2129643537");
		Deal d42 = new Deal("Beer", "Bucket of Budweiser", 5, 1600, 1800, v14, "published");
		Deal d43 = new Deal("Beer", "Bucket of Bud Light", 7, 1600, 1800, v14, "published");
		Deal d44 = new Deal("Beer", "Bucket of Coors", 4, 1600, 1800, v14, "published");
		Deal d45 = new Deal("Beer", "$Bucket of Coors Light", 4, 1600, 1800, v14, "published");
		Deal d46 = new Deal("Wells", "half price well drinks", 5, 1600, 1800, v14, "published");

		Venue v15 = new Venue("Niagara", "112 Avenue A New York, NY 10009", "2124209517");
		Deal d47 = new Deal("Beer", "Draft Beer", 4, 1400, 2000, v15, "published");
		Deal d48 = new Deal("Wine", "Wine", 4, 1400, 2000, v15, "published");
		Deal d49 = new Deal("Liquor", "Well Liquor", 5, 1400, 2000, v15, "published");
		Deal d50 = new Deal("Cocktails", "Frozen Drinks", 5, 1400, 2000, v15, "published");

		Venue v16 = new Venue("Réunion", "357 W 44th St New York, NY 10036", "2125823200");
		Deal d51 = new Deal("Beer", "Beer", 3, 1730, 2000, v16, "published");
		Deal d52 = new Deal("Cocktails", "Cocktails", 6, 1730, 2000, v16, "published");

		Venue v17 = new Venue("Hourglass Tavern & BettiBar", "373 W 46th St New York, NY 10036", "2122652060");
		Deal d53 = new Deal("Cocktails", "Cocktails", 5, 1700, 2200, v17, "published");

		Venue v18 = new Venue("McGee's Pub", "240 W 55th St New York, NY 10019", "2129573536");
		Deal d54 = new Deal("Wine", "Wine", 4, 1100, 2100, v18, "published");
		Deal d55 = new Deal("Beer", "Beer", 4, 1100, 2100, v18, "published");
		Deal d56 = new Deal("Wells", "Well Drinks", 4, 1100, 2100, v18, "published");

		Venue v19 = new Venue("The Upsider", "1004 2nd Ave New York, NY 10022", "6467264760");
		Deal d57 = new Deal("Wine", "Wine", 7, 1600, 1900, v19, "published");
		Deal d58 = new Deal("Cocktails", "Cocktails", 9, 1600, 1900, v19, "published");

		Venue v20 = new Venue("The Wayland", "700 E 9th St New York, NY 10009", "2127777022");
		Deal d59 = new Deal("Beer", "Beer", 5, 1600, 1900, v20, "published");
		Deal d60 = new Deal("Cocktails", "Cocktails", 7, 1600, 1900, v20, "published");

		Venue v21 = new Venue("Ivy", "944 8th Ave New York, NY 10019", "2124599444");
		Deal d61 = new Deal("Beer", "Beer", 5, 1600, 1900, v21, "published");
		Deal d62 = new Deal("Wine", "Wine", 6, 1600, 1900, v21, "published");
		Deal d63 = new Deal("Cocktai", "Cocktails", 7, 1600, 1900, v21, "published");

		Venue v22 = new Venue("Draught 55", "245 E 55th St New York, NY 10022", "2123004096");
		Deal d64 = new Deal("Beer", "Beer", 5, 1600, 2000, v22, "published");
		Deal d65 = new Deal("Wine", "Wine", 5, 1600, 2000, v22, "published");
		Deal d66 = new Deal("Wells", "Well Drinks", 5, 1600, 2000, v22, "published");

		Venue v23 = new Venue("Union Pool", "484 Union Ave Brooklyn, NY 11211", "7186090484");
		Deal d67 = new Deal("Wells", "Well Drinks", 4, 1700, 2100, v23, "published");
		Deal d68 = new Deal("Whiskey", "Jameson shot", 5, 1700, 2100, v23, "published");
		Deal d69 = new Deal("Beer", "PBR", 5, 1700, 2100, v23, "published");
		Deal d70 = new Deal("Beer", "Beer", 5, 1700, 2100, v23, "published");

		Venue v24 = new Venue("The Stag's Head", "252 E 51st St New York, NY 10022", "2128882453");
		Deal d71 = new Deal("Beer", "Craft Beer", 5, 1100, 1900, v24, "published");
		Deal d72 = new Deal("Beer", "Draft Beer", 5, 1100, 1900, v24, "published");
		Deal d73 = new Deal("Wells", "Well Drinks", 5, 1100, 1900, v24, "published");
		Deal d74 = new Deal("Wine", "House Wine", 6, 1100, 1900, v24, "published");

		Venue v25 = new Venue("The Mermaid Inn", " 570 Amsterdam Ave New York, NY 10024", "2127997400");
		Deal d75 = new Deal("Beer", "Beer", 5, 1700, 1900, v25, "published");
		Deal d76 = new Deal("Wine", "Wine", 7, 1700, 1900, v25, "published");
		Deal d77 = new Deal("Cocktails", "Cocktails", 8, 1700, 1900, v25, "published");

		Venue v26 = new Venue("Porchlight", "271 11th Ave New York, NY 10001", "2129816188");
		Deal d78 = new Deal("Beer", "Flask of Punch", 5, 1600, 1900, v26, "published");
		Deal d79 = new Deal("Cocktails", "Cocktails", 10, 1600, 1900, v26, "published");
		Deal d80 = new Deal("Beer", "Fence Post(16oz cans of beer)", 7, 400, 700, v26, "published");

		Venue v27 = new Venue("Freud NYC", "506 LaGuardia Pl New York, NY 10012", "2127770327");
		Deal d81 = new Deal("Cocktails", "Cocktails", 9, 1600, 1900, v27, "published");
		Deal d82 = new Deal("Wine", "Wine", 8, 1600, 1900, v27, "published");
		Deal d83 = new Deal("Beer", "Beer", 6, 1600, 1900, v27, "published");

		s.save(v1);

		s.save(v2);

		s.save(v3);

		s.save(v4);

		s.save(v5);

		s.save(v6);

		s.save(v7);

		s.save(v8);
		s.save(v9);
		s.save(v10);
		s.save(v11);
		s.save(v12);
		s.save(v13);
		s.save(v14);
		s.save(v15);
		s.save(v16);
		s.save(v17);
		s.save(v18);
		s.save(v19);
		s.save(v20);
		s.save(v21);
		s.save(v22);
		s.save(v23);
		s.save(v24);
		s.save(v25);
		s.save(v26);
		s.save(v27);

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

		s.save(d23);
		s.save(d24);
		s.save(d25);
		s.save(d26);
		s.save(d27);
		s.save(d28);
		s.save(d29);
		s.save(d30);
		s.save(d31);
		s.save(d32);
		s.save(d33);
		s.save(d34);
		s.save(d35);
		s.save(d36);
		s.save(d37);
		s.save(d38);
		s.save(d39);
		s.save(d40);
		s.save(d41);
		s.save(d42);
		s.save(d43);
		s.save(d44);
		s.save(d45);
		s.save(d46);
		s.save(d47);
		s.save(d48);
		s.save(d49);
		s.save(d50);
		s.save(d51);
		s.save(d52);
		s.save(d53);
		s.save(d54);
		s.save(d55);
		s.save(d56);
		s.save(d57);
		s.save(d58);
		s.save(d59);
		s.save(d60);
		s.save(d61);
		s.save(d62);
		s.save(d63);
		s.save(d64);
		s.save(d65);
		s.save(d66);
		s.save(d67);
		s.save(d68);
		s.save(d69);
		s.save(d70);
		s.save(d71);
		s.save(d72);
		s.save(d73);
		s.save(d74);
		s.save(d75);
		s.save(d76);
		s.save(d77);
		s.save(d78);
		s.save(d79);
		s.save(d80);
		s.save(d81);
		s.save(d82);
		s.save(d83);

		tx.commit();

		s.close();

	}

	static void byPrice() {
		Session s = HibernateUtil.getSession();
		List<Deal> orderByPrice = s.createCriteria(Deal.class).addOrder(Order.asc("price")).list();
		for (Deal d : orderByPrice) {
			System.out.print(d);
		}
	}

	static void dealByType(String type) {
		Session s = HibernateUtil.getSession();
		List<Deal> dealByType = s.createCriteria(Deal.class).add(Restrictions.like("type", type))
				.addOrder(Order.asc("price")).list();
		for (Deal d : dealByType) {
			System.out.print(d);
		}
	}

	static void specificDealForVenue(String type) {
		Session s = HibernateUtil.getSession();
		Query query = s
				.createQuery("from Venues v where v.venueId =" + "(select venueID from Deals where type = :type)");
		query.setParameter("type", type);
		List specificDeals = query.list();
		for (Object d : specificDeals) {
			System.out.print((Deal) d);
		}
	}

}