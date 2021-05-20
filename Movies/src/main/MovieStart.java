package main;


import java.util.ArrayList;

import bean.MovieBean;
import database.MovieConnection;

public class MovieStart {

	public static void main(String[] args) {
		
		if(MovieConnection.connectSQL()) {
			
			// Print actors in the movie Seven
			String movieName = "Seven";
			ArrayList<MovieBean> movieBeans = new ArrayList<MovieBean>();
			MovieConnection.getActorsInMovie(movieName, movieBeans);
			
			System.out.println("Actors in the movie Seven is;");
			for (int i = 0; i < movieBeans.size(); i++) {
				System.out.println(movieBeans.get(i).getActors());
			}
			
			
			// Print names of movies that has won an Oscar for Best Picture
			String award = "Oscar (Best Picture)";
			ArrayList<MovieBean> oscarBeans = new ArrayList<MovieBean>();
			MovieConnection.getMovieNameWithAward(award, oscarBeans);
			
			System.out.println("");
			System.out.println("Movies that has won an Oscar for Best Picture is;");	
			for (int i = 0; i < oscarBeans.size(); i++) {
				System.out.println(oscarBeans.get(i).getName() + " ");
			}
			
			
			// Print names of movies with the actor Brad Pitt
			String actor = "Brad Pitt";
			ArrayList<MovieBean> actorBeans = new ArrayList<MovieBean>();
			MovieConnection.getMovieNameWithActor(actor, actorBeans);
						
			System.out.println("");
			System.out.println("The names of movies with the actor Brad Pitt is;");	
			for (int i = 0; i < actorBeans.size(); i++) {
				System.out.println(actorBeans.get(i).getName() + " ");
			}
			
			
			// Print the awards that movies with the actor Brad Pitt has won
			actor = "Brad Pitt";
			ArrayList<MovieBean> awardBeans = new ArrayList<MovieBean>();
			MovieConnection.getAwardsWithActor(actor, awardBeans);
									
			System.out.println("");
			System.out.println("Movies with the actor Brad Pitt has won the following awards;");	
			for (int i = 0; i < awardBeans.size(); i++) {
				System.out.println(awardBeans.get(i).getName() + " - " + awardBeans.get(i).getAwards());
			}

		}

	}

}
