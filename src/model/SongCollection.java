/*
 * SongCollection stores each song.
 */

package model;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SongCollection {

    private Map<String, Song> songs;
    
    public SongCollection() {
	this.songs = new TreeMap<>();
    }
    
    //Adds a song to the colleciton
    public void addSong(Song song) {
	this.songs.put(song.getSongID(), song);
    }
    
    public Song getSong(String songID) {
	return this.songs.get(songID);
    }
    
    //The songs are stored as an iterator so that it is easier to get them for the buttons.
    public Iterator<Song> getIterator() {
	return this.songs.values().iterator();
    }

}
