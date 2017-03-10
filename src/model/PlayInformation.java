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

    public boolean hasRemaningPlays() {
	if (isSameDay()) {
	    return this.playCount < this.maxPlayCount;
	} else {
	    return true;
	}
    }
    
    public int songsPlayed() {
	if (!isSameDay()) {
	    this.dateOfLastPlayed = LocalDate.now();
	    this.playCount = 0;
	}
	
	return this.playCount;
    }
    
    public void timeOfNextDay() {
	if (!isSameDay()) {
	 // it is a whole new day, new data and new count
	    this.dateOfLastPlayed = LocalDate.now();
	    this.playCount = 0;
	}
	
//	this.dateOfLastPlayed.
    }

    public void incrementPlayCount() {
	if (isSameDay()) {
	    playCount++;
	} else {
	    // it is a whole new day, new data and new count
	    this.dateOfLastPlayed = LocalDate.now();
	    this.playCount = 1;
	}
    }

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
