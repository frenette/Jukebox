package model;

import java.util.Observable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class SongQueue extends Observable implements Iterator<Song> {

    private Queue<Song> songs;

    public SongQueue() {
	songs = new LinkedList<>();
    }
    
    public void addSong(Song song, Student student) {
	this.songs.add(song);
	song.queuedSong();
	student.queuedSong(song);
	
	/*
	 * Update the status of the SongQueue
	 */
	this.setChanged();
	this.notifyObservers();
    }

    public Song getNextSong() {
	return this.songs.poll();
    }

    public void listSongs(Song song) {
	this.songs.forEach(System.out::println);
    }

    @Override
    public boolean hasNext() {
	if (this.songs.peek() != null) {
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public Song next() {
	return this.getNextSong();
    }

}
