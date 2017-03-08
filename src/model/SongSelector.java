package model;

import java.util.Observable;

public class SongSelector extends Observable {

	public boolean locked = true;
	public SongCollection songs;
	
	public void unlock() {
		locked = false;
	}
	public void chooseSong() {
		setChanged();
		notifyObservers(getSongs());
	}
	public Song getSongs() {
		return new Song();
	}
}
