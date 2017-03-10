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
	this.currentStudent = null;

	// Initialize users
	InitializeUsers initUsrs = new InitializeUsers(this);
	initUsrs.initializeUsers();
	System.out.println("Initialized users");

	// Initialize songs
	InitializeSongs initSongs = new InitializeSongs(this);
	initSongs.initializeSongs();
	System.out.println("Initialized songs");
    }

    /*
     * Used for dependency injection for testing
     */
    public Jukebox(Student injectedStudent) {
	this.songs = new SongCollection();
	this.queue = new SongQueue();
	this.students = new StudentCollection();
	this.currentStudent = injectedStudent;

	// Initialize users
	InitializeUsers initUsrs = new InitializeUsers(this);
	initUsrs.initializeUsers();
	System.out.println("Initialized users");

	// Initialize songs
	InitializeSongs initSongs = new InitializeSongs(this);
	initSongs.initializeSongs();
	System.out.println("Initialized songs");
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

    public StudentCollection getStudentCollection() {
	return this.students;
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
	// if (arg instanceof Student) {
	// currentStudent = (Student) arg;
	// selector.unlock();
	// } else {
	// play((Song) arg);
	// }
    }
}
