package model;

import java.util.LinkedList;
import java.util.Queue;

public class SongQueue {

	public Queue<Song> songs = new LinkedList<Song>();
	
	public void add(Song song) {
		songs.add(song);
	}
	public void play(Song song) {
		for(Song s: songs) {
			System.out.println(s);
		}
	}

}
