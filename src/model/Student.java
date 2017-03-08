package model;

import model.Song;

public class Student {
	public String name;
	public int cardID;
	private String password;
	public double minutes;
	public int dailySongs;
	
	public Student(String n, int id) {
		name = n;
		cardID = id;
		minutes = 1500;
		dailySongs = 2;
	}
	
	public boolean canPlay(Song song) {
		if(song.time < minutes) {
			playSong(song.time);
			return true;
		}
		return false;
	}
	
	public void playSong(double time) {
		minutes -= time;
	}
	
	public boolean correctPassowrd(String passwordAtempt) {
	    return this.password.equals(passwordAtempt);
	}
}
