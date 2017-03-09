package model;

import java.util.LinkedList;
import java.util.Queue;

public class SongQueue {

    private Queue<Song> songs;

    public SongQueue() {
	songs = new LinkedList<>();
    }

    public void addSong(Song song) {
	this.songs.add(song);
    }
    
    public void addSong(Song song, Student student) {
	this.songs.add(song);
	student.queuedSong(song);
    }

    public Song getNextSong() {
	return this.songs.poll();
    }

    public void listSongs(Song song) {
	this.songs.forEach(System.out::println);
    }

}
