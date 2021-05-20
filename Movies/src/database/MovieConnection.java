package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.MovieBean;

public class MovieConnection {
	
	static Connection conn = null; 
	static PreparedStatement stmt = null;
	static ResultSet rs = null; 
	
	public static boolean connectSQL() {
		
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception ex) {
            System.out.println("Exception Driver " + ex.getMessage());
            return false;
        }
		
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_base", MovieLogin.getUserName(), MovieLogin.getUserPass());
			return true;
			
		}catch(SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
		}
		
	}
	
	
	public static ArrayList<MovieBean> getActorsInMovie(String name, ArrayList<MovieBean> beans) {

		
		try {
			String requestQuery = "SELECT `actors` FROM `movie` WHERE `name` LIKE ?";
		
			stmt = conn.prepareStatement(requestQuery);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
	
			while (rs.next()) {
				MovieBean movieBean = new MovieBean();
				movieBean.setActors(rs.getString("actors"));
				beans.add(movieBean);
			}
			
			rs.close();
			conn.endRequest();
	
			return beans;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		
		return null;
	}
	
	
	
	public static ArrayList<MovieBean> getMovieNameWithAward(String award, ArrayList<MovieBean> beans) {

		try {
			String requestQuery = "SELECT `name` FROM `movie` WHERE `awards` LIKE ?";
		
			stmt = conn.prepareStatement(requestQuery);
			stmt.setString(1, "%" + award + "%");
			rs = stmt.executeQuery();
		
			while (rs.next()) {
				MovieBean movieBean = new MovieBean();
				movieBean.setName(rs.getString("name"));
				beans.add(movieBean);
			}
			
			rs.close();
			conn.endRequest();
			
			return beans;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		return null;
	}
	
	
	public static ArrayList<MovieBean> getMovieNameWithActor(String actor, ArrayList<MovieBean> beans) {

		try {
			String requestQuery = "SELECT `name` FROM `movie` WHERE `actors` LIKE ?";
		
			stmt = conn.prepareStatement(requestQuery);
			stmt.setString(1, "%" + actor + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				MovieBean movieBean = new MovieBean();
				movieBean.setName(rs.getString("name"));
				beans.add(movieBean);
			}
			
			rs.close();
			conn.endRequest();

			return beans;

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		
		return null;
	}
	
	
	public static ArrayList<MovieBean> getAwardsWithActor(String actor, ArrayList<MovieBean> beans) {

		try {
			String requestQuery = "SELECT `name`, `awards` FROM `movie` WHERE `actors` LIKE ?";
		
			stmt = conn.prepareStatement(requestQuery);
			stmt.setString(1, "%" + actor + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				MovieBean movieBean = new MovieBean();
				movieBean.setName(rs.getString("name"));
				movieBean.setAwards(rs.getString("awards"));
				beans.add(movieBean);
			}
			
			rs.close();
			conn.endRequest();
			conn.close();

			return beans;

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		
		return null;
	}
	
	
	
	
	
	
}
