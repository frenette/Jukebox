package model;

import java.util.Observable;
import java.util.Observer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import controller.SongPlayer;

public class SongQueue extends Observable implements Iterator<Song> {

    private Queue<Song> songs;
    private SongPlayer songPlayer;

    public SongQueue() {
	this.songs = new LinkedList<>();
	this.songPlayer = new SongPlayer(this);
	this.addObserver(this.songPlayer);
    }

    /*
     * NOTE : testing uses only
     */
    public void initializeObserver() {
	this.addObserver(new Observer() {

	    @Override
	    public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("I WAS UPDATED");
		System.out.println("I WAS UPDATED");
		System.out.println("I WAS UPDATED");
		System.out.println("I WAS UPDATED");
		System.out.println("I WAS UPDATED");
		System.out.println("I WAS UPDATED");
		System.out.println("I WAS UPDATED");
		System.out.println("I WAS UPDATED");
	    }

	});
    }

    public void addSong(Song song, Student student) {
	this.songs.add(song);
	song.queuedSong();
	student.queuedSong(song);

	/*
	 * Update the status of the SongQueue
	 */
	this.setChanged();
	// Testing
	System.out.println("\t=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	System.out.println("\taddSong()");
	System.out.println("\thasChanged(): " + this.hasChanged());
	// TODO : ERROR should be 1, shows 0
	System.out.println("\tcountObservers: " + this.countObservers());
	System.out.println("\t=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	// End testing
	this.notifyObservers();
    }

    public Song getNextSong() {
	return this.songs.poll();
    }

    public void listSongs() {
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
