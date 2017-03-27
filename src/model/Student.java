/*
 * Holds a student
 */

package model;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import model.Song;

public class Student extends Observable implements Observer, Serializable {

    private static final long serialVersionUID = 1L;
    private String userID;
    private String password;
    private int playTime;
    private DailyPlayStats dailyPlayStats;

    public Student(String id, String pass) {
	this.userID = id;
	this.password = pass;
	this.playTime = 90000;
	this.dailyPlayStats = new DailyPlayStats();
	this.dailyPlayStats.addObserver(this);
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

    public DailyPlayStats getDailyPlayStats() {
	return this.dailyPlayStats;
    }

    // Returns number of songs played by student.
    public int getTodaysPlayCount() {
	return this.dailyPlayStats.getPlayCount();
    }

    // Returns if the student can play another song.
    public boolean hasRemaningPlays() {
	return this.dailyPlayStats.hasRemaningPlays();
    }

    public void resetDailyPlayCount() {
	System.out.println("I am in resetDailyPlayCount() for Student '" + this + "'.");
	this.dailyPlayStats.resetPlayCount();
    }

    // Checks if the song can be played by the student, as well as the song.
    public boolean canPlay(Song song) {
	// check if the song is shorter than the user's playTime
	if (song.getLength() < this.playTime) {
	    // check if the user has any remaining plays today
	    if (this.dailyPlayStats.hasRemaningPlays()) {
		// check if the song has any remaining plays today
		if (song.hasRemaningPlays()) {
		    return true;
		}
	    }
	}

	return false;
    }

    // Subtracts minutes from the student, and adds a song played.
    public void queuedSong(Song song) {
	this.playTime -= song.getLength();
	this.dailyPlayStats.incrementPlayCount();

	this.hasChanged();
	this.notifyObservers();
    }

    @Override
    public String toString() {
	return this.userID;
    }

    @Override
    public void update(Observable o, Object arg) {
	System.out.println("======================================");
	System.out.println("The student is being updated");
	System.out.println("Songs played: " + this.dailyPlayStats.getPlayCount());
	System.out.println("this.countObservers(): " + this.countObservers());
	System.out.println("o.getClass(): " + o.getClass());
	System.out.println("======================================");

	this.hasChanged();
	this.notifyObservers();
    }
}
