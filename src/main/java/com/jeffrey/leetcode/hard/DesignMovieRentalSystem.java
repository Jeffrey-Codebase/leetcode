package com.jeffrey.leetcode.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DesignMovieRentalSystem {
	/*
	 * Problem: 1912. Design Movie Rental System
	 * https://leetcode.com/problems/design-movie-rental-system/
	 *
	 * Time Complexity: 
	 *		Constructor: O(NlogN) , N = the length of the entries array
	 *		search, rent, drop, report: O(logN)
	 *
	 * Space Complexity: O(N)
	 *
	 */
	class MovieRentingSystem {
	    class Copy{
	        int mid;
	        int sid;
	        int price;
	        public Copy(int sid, int mid, int price){
	            this.mid=mid;
	            this.sid=sid;
	            this.price=price;
	        }
	        
	    }
	    Map<Integer,TreeSet<Copy>> m2c;
	    Map<String,Copy> sm2c;
	    TreeSet<Copy> rented;
	    Comparator<Copy> cc = 
	        (Copy c1, Copy c2)->{
	            if(c1.price!=c2.price) return c1.price-c2.price;
	            if(c1.sid != c2.sid) return c1.sid-c2.sid;
	            return c1.mid-c2.mid;
	        };
	    public MovieRentingSystem(int n, int[][] entries) {
	        
	        m2c = new HashMap<Integer,TreeSet<Copy>>();
	        sm2c = new HashMap<String,Copy>();
	        rented = new TreeSet<Copy>(cc);
	        for(int[] e :entries ){
	            Copy c = new Copy(e[0],e[1],e[2]);
	            String key = e[0]+","+e[1];
	            sm2c.put(key,c);
	            if(!m2c.containsKey(c.mid))
	                m2c.put(c.mid,new TreeSet<Copy>(cc));
	            m2c.get(c.mid).add(c);
	        }
	    }
	    
	    public List<Integer> search(int movie) {
	        List<Integer> result = new ArrayList<Integer>();
	        if(!m2c.containsKey(movie)) return result;
	        TreeSet<Copy> copies= m2c.get(movie);
	        for(Copy c : copies){
	            result.add(c.sid);
	            if(result.size()==5)
	                break;
	        }
	        return result;
	    }
	    
	    public void rent(int shop, int movie) {
	        String key = shop+","+movie;
	        Copy copy =  sm2c.get(key);
	        rented.add(copy);
	        m2c.get(movie).remove(copy);
	    }
	    
	    public void drop(int shop, int movie) {
	        String key = shop+","+movie;
	        Copy copy =  sm2c.get(key);
	        rented.remove(copy);
	        m2c.get(movie).add(copy);
	    }
	    
	    public List<List<Integer>> report() {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        for(Copy c : rented){
	            List<Integer> clist = new ArrayList<Integer>();
	            clist.add(c.sid);
	            clist.add(c.mid);
	            result.add(clist);
	            if(result.size()==5)
	                break;
	        }
	        return result;
	    }
	}
}
