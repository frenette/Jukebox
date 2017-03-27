/*
 * Holds play information for users/songs, holds time info.
 */

package model;

import java.io.Serializable;
import java.util.Observable;

public class DailyPlayStats extends Observable implements Serializable {

    private static final long serialVersionUID = -5746533644493976882L;
    private int playCount;
    private int maxPlayCount;

    public DailyPlayStats() {
	this.playCount = 0;
	this.maxPlayCount = 3;
    }

    // returns number of songs played for song/student
    public int getPlayCount() {
	return this.playCount;
    }

    // Checks playCount of specific song/student.
    public boolean hasRemaningPlays() {
	return this.playCount < this.maxPlayCount;
    }

    // Increments the playCount of student/song
    public void incrementPlayCount() {
	this.playCount++;

	this.setChanged();
	this.notifyObservers();
    }

    public void resetPlayCount() {
	this.playCount = 0;

	this.setChanged();
	this.notifyObservers();
    }
}
