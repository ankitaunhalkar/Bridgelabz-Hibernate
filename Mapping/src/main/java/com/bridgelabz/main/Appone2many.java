package com.bridgelabz.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.bridgelabz.one2many.Actor;
import com.bridgelabz.one2many.Movie;
import com.bridgelabz.util.HibernateUtil;

public class Appone2many {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Actor actor1 = new Actor();
		actor1.setName("Deepika");
		actor1.setExperience(7);
		
		Actor actor2 = new Actor();
		actor2.setName("Ranveer");
		actor2.setExperience(5);
		
		Set<Actor> actorSet = new HashSet<Actor>();
		actorSet.add(actor1);
		actorSet.add(actor2);
		
		Movie movie = new Movie();
		movie.setName("Ram-leela");
		movie.setActors(actorSet);
		
		actor1.setMovie(movie);
		actor2.setMovie(movie);
		
		session.save(movie);
		session.getTransaction().commit();
		
		HibernateUtil.shutdown();
	}
}
