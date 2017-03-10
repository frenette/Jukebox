/*
 * Holds play information for users/songs, holds time info.
 */

package model;

import java.time.LocalDate;

public class PlayInformation {
    private LocalDate dateOfLastPlayed;
    private int playCount;
    private int maxPlayCount;

    public PlayInformation() {
	this.dateOfLastPlayed = LocalDate.now();
	this.playCount = 0;
	this.maxPlayCount = 3;
    }

    //Checks playcount of specific song/student.
    public boolean hasRemaningPlays() {
	if (isSameDay()) {
	    return this.playCount < this.maxPlayCount;
	} else {
	    return true;
	}
    }
    
    // returns number of songs played for song/student
    public int songsPlayed() {
	if (!isSameDay()) {
	    this.dateOfLastPlayed = LocalDate.now();
	    this.playCount = 0;
	}
	
	return this.playCount;
    }
    
    //returns time of next day for time information
    public void timeOfNextDay() {
	if (!isSameDay()) {
	 // it is a whole new day, new data and new count
	    this.dateOfLastPlayed = LocalDate.now();
	    this.playCount = 0;
	}
	
//	this.dateOfLastPlayed.
    }
    //Increments the playcount of student/song
    public void incrementPlayCount() {
	if (isSameDay()) {
	    playCount++;
	} else {
	    // it is a whole new day, new data and new count
	    this.dateOfLastPlayed = LocalDate.now();
	    this.playCount = 1;
	}
    }

    //Method to reset the play count if it is a new day.
    private boolean isSameDay() {
	LocalDate currentTime = LocalDate.now();

	if (currentTime.getDayOfMonth() == dateOfLastPlayed.getDayOfMonth()) {
	    // it is the same day of the month, but it must also be the same
	    // month, and same year
	    if (currentTime.getMonth() == dateOfLastPlayed.getMonth()) {
		// it is the same month, but it must also be the same year
		if (currentTime.getYear() == dateOfLastPlayed.getYear()) {
		    // it is still the same day
		    return true;
		}
	    }
	}

	return false;
    }
}
