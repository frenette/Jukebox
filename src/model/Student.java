package model;

import model.Song;

public class Student {
    private String userID;
    private String password;
    private int playTime;
    private PlayInformation songsPlayed;

    public Student(String id, String pass) {
	this.userID = id;
	this.password = pass;
	this.playTime = 90000;
	this.songsPlayed = new PlayInformation();
    }
    
    public String getUserID() {
	return this.userID;
    }
    
    public boolean correctPassowrd(String passwordAtempt) {
	return this.password.equals(passwordAtempt);
    }
    
    public boolean canPlay(Song song) {
	// check if the song is shorter than the user's playTime
	if (song.getLength() < this.playTime) {
	    // check if the user has any remaining plays today
	    if (this.songsPlayed.hasRemaningPlays()) {
		// check if the song has any remaining plays today
		if (song.hasRemaningPlays()) {
		    return true;
		}
	    }
	}

	return false;
    }
    
    public void queuedSong(Song song) {
	this.songsPlayed.incrementPlayCount();
	this.playTime -= song.getLength();
    }
    
    @Override
    public String toString() {
	return this.userID;
    }

}
