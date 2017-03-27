/*
 * Class to hold 1 song and all its information.
 */

package model;

import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Observable;
import java.util.Observer;

public class Song extends Observable implements Observer, Serializable {

    private static final long serialVersionUID = 7743433347329977915L;
    private String artist;
    private String title;
    // TODO : when i serialize and deserialize I need to convert the path string
    // back to a path
    private transient Path fileName;
    private String pathString;
    private int songLength;
    private DailyPlayStats dailyPlayStats;

    public Song(String artist, String title, String fileName, int songLength) {
	this.artist = artist;
	this.title = title;
	this.fileName = Paths.get("/songfiles/" + fileName);
	this.pathString = this.fileName.toString();
	this.songLength = songLength;
	this.dailyPlayStats = new DailyPlayStats();
	this.dailyPlayStats.addObserver(this);
    }

    public String getArtist() {
	return this.artist;
    }

    public String getTitle() {
	return this.title;
    }

    public Path getPath() {
	return this.fileName;
    }

    public String getPathString() {
	return this.pathString;
    }

    public int getLength() {
	return this.songLength;
    }

    public String getSongID() {
	return this.title;
    }

    public boolean hasRemaningPlays() {
	return this.dailyPlayStats.hasRemaningPlays();
    }

    public void resetDailyPlayCount() {
	// System.out.println("I am in resetDailyPlayCount() for Song '" + this
	// + "'.");

	this.dailyPlayStats.resetPlayCount();
    }

    public void queuedSong() {
	this.dailyPlayStats.incrementPlayCount();
    }

    @Override
    public String toString() {
	return this.title;
    }

    @Override
    public void update(Observable o, Object arg) {
	// System.out.println("======================================");
	// System.out.println("The song is being updated");
	// System.out.println("Times played: " +
	// this.dailyPlayStats.getPlayCount());
	// System.out.println("this.countObservers(): " +
	// this.countObservers());
	// System.out.println("o.getClass(): " + o.getClass());
	// System.out.println("======================================");

	this.hasChanged();
	this.notifyObservers();
    }
}
