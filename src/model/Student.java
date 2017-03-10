/*
 * Holds a student
 */

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

    //Verify password
    public boolean correctPassowrd(String passwordAtempt) {
	return this.password.equals(passwordAtempt);
    }

    //Checks if the song can be played by the student, as well as the song.
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
    
    //Returns number of songs played by student.
    public int songsPlayedToday() {
	return this.songsPlayed.songsPlayed();
    }
    
    //Returns if the student can play another song.
    public boolean hasRemaningPlays() {
	return this.songsPlayed.hasRemaningPlays();
    }

    //Subtracts minutes from the student, and adds a song played.
    public void queuedSong(Song song) {
	this.songsPlayed.incrementPlayCount();
	this.playTime -= song.getLength();
    }

    @Override
    public String toString() {
	return this.userID;
    }
}
