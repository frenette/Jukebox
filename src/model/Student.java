/*
 * Holds a student
 */

package model;

import java.util.Observable;
import java.util.Observer;

import model.Song;

public class Student extends Observable implements Observer {
    private String userID;
    private String password;
    private int playTime;
    private PlayInformation songsPlayed;

    public PlayInformation getPlayInformation() {
	return this.songsPlayed;
    }

    public Student(String id, String pass) {
	this.userID = id;
	this.password = pass;
	this.playTime = 90000;
	this.songsPlayed = new PlayInformation();

	// let songsPlayed know we are observing it
	this.songsPlayed.addObserver(this);
	System.out.println("countObservers for this.songsPlayed: " + this.songsPlayed.countObservers());
    }

    public String getUserID() {
	return this.userID;
    }

    // Verify password
    public boolean correctPassowrd(String passwordAtempt) {
	return this.password.equals(passwordAtempt);
    }

    public int getPlayTime() {
	return this.playTime;
    }

    // Checks if the song can be played by the student, as well as the song.
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

    // Returns number of songs played by student.
    public int songsPlayedToday() {
	return this.songsPlayed.songsPlayed();
    }

    // Returns if the student can play another song.
    public boolean hasRemaningPlays() {
	return this.songsPlayed.hasRemaningPlays();
    }

    // Subtracts minutes from the student, and adds a song played.
    public void queuedSong(Song song) {
	this.playTime -= song.getLength();
	// NOTE : increment count needs to be second because it calls notify the observers
	this.songsPlayed.incrementPlayCount();

	System.out.println("this.playTime: " + this.playTime);
	
	//
	
	this.hasChanged();
	this.notifyObservers();
    }

    @Override
    public String toString() {
	return this.userID;
    }

    @Override
    public void update(Observable o, Object arg) {
	System.out.println("The student is saying it has changed");
	System.out.println("Songs played: " + this.songsPlayed.songsPlayed());
	System.out.println("this.countObservers(): " + this.countObservers());
	System.out.println(o.getClass());

	this.hasChanged();
	this.notifyObservers(o);
    }
}
