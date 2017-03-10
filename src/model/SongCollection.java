package model;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SongCollection {

    private Map<String, Song> songs;
    
    public SongCollection() {
	this.songs = new TreeMap<>();
    }
    
    public void addSong(Song song) {
	this.songs.put(song.getSongID(), song);
    }
    
    public Song getSong(String songID) {
	return this.songs.get(songID);
    }
    
    public Iterator<Song> getIterator() {
	return this.songs.values().iterator();
    }

}
