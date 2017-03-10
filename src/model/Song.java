package model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Song {

    private String artist;
    private String title;
    private Path fileName;
    private int songLength;
    private PlayInformation timesPlayed;
    
    public Song(String artist, String title, String fileName, int songLength) {
	this.artist = artist;
	this.title = title;
	this.fileName = Paths.get("/songfiles/" + fileName);
	this.songLength = songLength;
	this.timesPlayed = new PlayInformation();
    }
    
    public String getSongID() {
	return this.title;
    }
    
    public Path getSongPath() {
	return this.fileName;
    }

    public boolean hasRemaningPlays() {
	return timesPlayed.hasRemaningPlays();
    }

    public int getLength() {
	return this.songLength;
    }
    
    public void queuedSong() {
	this.timesPlayed.incrementPlayCount();
    }
    
    @Override
    public String toString() {
	return this.title;
    }

}
