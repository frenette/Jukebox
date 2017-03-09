package model;

import java.util.Observable;
import java.util.Observer;

public class Jukebox implements Observer {
    
    SongCollection songs;
    SongQueue queue;
    StudentCollection students;
    Student currentStudent;
    
    public Jukebox() {
	this.songs = new SongCollection();
	this.queue = new SongQueue();
	this.students = new StudentCollection();
    }
    
    /*
     * Used for dependency injection for testing
     */
    public Jukebox(Student injectedStudent) {
	this.currentStudent = injectedStudent;

	this.songs = new SongCollection();
	this.queue = new SongQueue();
	this.students = new StudentCollection();
    }
    
    public SongCollection getSongCollection() {
	return this.songs;
    }
    
    public void addToSongCollection(Song song) {
	this.songs.addSong(song);
    }
    
    public SongQueue getSongQueue() {
	return this.queue;
    }
        
    public Student getCurrentStudent() {
	return this.currentStudent;
    }
    
    public void setCurrentStudent(Student newStudent) {
	this.currentStudent = newStudent;
    }

    @Override
    public void update(Observable o, Object arg) {
	// TODO
//	if (arg instanceof Student) {
//	    currentStudent = (Student) arg;
//	    selector.unlock();
//	} else {
//	    play((Song) arg);
//	}
    }
}
