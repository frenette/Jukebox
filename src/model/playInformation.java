package model;

import java.time.LocalDate;

public class playInformation {
    private LocalDate dateOfLastPlayed;
    private int timesPlayed;
    private int maxTimesPlayed;

    public playInformation() {
	this.dateOfLastPlayed = LocalDate.now();
	this.timesPlayed = 0;
	this.maxTimesPlayed = 3;
    }

    public boolean hasRemaningPlays() {
	if (isSameDay()) {
	    return this.timesPlayed < this.maxTimesPlayed;
	} else {
	    return true;
	}
    }
    
    public void incrementPlayCount() {
	if (isSameDay()) {
	    timesPlayed++;
	} else {
	    // it is a whole new day, new data and new count
	    this.dateOfLastPlayed = LocalDate.now();
	    this.timesPlayed = 1;
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
