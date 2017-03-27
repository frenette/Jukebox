/*
 * This holds the current queue of songs.
 */

package model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

import controller.SongPlayer;

public class SongQueue extends Observable implements Iterable<Song>, Iterator<Song>, Serializable {

    private static final long serialVersionUID = 1L;
    private Queue<Song> songs;
    private transient SongPlayer songPlayer;

    public SongQueue() {
	this.songs = new LinkedList<>();
	this.songPlayer = new SongPlayer(this);
	this.addObserver(this.songPlayer);
    }

    public void config() {

	this.songPlayer = new SongPlayer(this);
	this.addObserver(this.songPlayer);
	this.setChanged();
	this.notifyObservers();
    }

    public Queue<Song> getSongs() {
	return this.songs;
    }

    // Adds a song to the queue, then updates # of times played on the student
    // and the song.
    public void addSong(Song song, Student student) {
	this.songs.add(song);
	song.queuedSong();
	student.queuedSong(song);
	this.setChanged();
	// Testing
	// System.out.println("\t=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	// System.out.println("\taddSong()");
	// System.out.println("\thasChanged(): " + this.hasChanged());
	// System.out.println("\tcountObservers: " + this.countObservers());
	// System.out.println("\t=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	// End testing
	this.notifyObservers();
    }

    public Song getNextSong() {
	Song returnSong = this.songs.poll();
	this.setChanged();
	this.notifyObservers();

	return returnSong;
    }

    // Returns the list of songs as a string.
    public String listSongs() {
	String result = "";

	for (Song s : songs) {
	    result += s;
	}

	this.songs.forEach(System.out::println);
	return result;
    }

    @Override
    public Iterator<Song> iterator() {
	return this.songs.iterator();
    }

    @Override
    public boolean hasNext() {
	if (this.songs.size() > 0) {
	    return true;
	} else {
	    return false;
	}
    }

    @Override
    public Song next() {
	Song returnSong = this.songs.poll();
	this.setChanged();
	this.notifyObservers();
	return returnSong;
    }

    public int size() {
	return this.songs.size();
    }

    public Song getNextWithoutRemoving() {
	return this.songs.peek();
    }

    public void removeHead() {
	this.songs.poll();
	this.setChanged();
	this.notifyObservers();
    }
}
