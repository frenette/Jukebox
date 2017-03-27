/*
 * Coordinator class, combines all the other classes. 
 * Last thing: we just can't bring ourselves to comment what a getter or setter does.
 */

package model;

public class Jukebox {
    
    private SongCollection songs;
    private SongQueue queue;
    private StudentCollection students;
    private Student currentStudent;

    public Jukebox() {
	this.songs = SongCollection.getSongCollection();
	this.queue = new SongQueue();
	this.students =  StudentCollection.getStudentCollection();
	this.currentStudent = null;

	// Initialize users
	new InitializeUsers(this);
	System.out.println("Initialized users");

	// Initialize songs
	new InitializeSongs(this);
	System.out.println("Initialized songs");
    }

    /*
     * Used for dependency injection for testing
     */
    public Jukebox(Student injectedStudent) {
	this.songs = SongCollection.getSongCollection();
	this.queue = new SongQueue();
	this.students =  StudentCollection.getStudentCollection();
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

    // adds a song to song collections
    public void addToSongCollection(Song song) {
	this.songs.addSong(song);
    }

    public SongQueue getSongQueue() {
	return this.queue;
    }

    public StudentCollection getStudentCollection() {
	return this.students;
    }
    
    public void setSongCollection(SongCollection songs) {
	this.songs = songs;
    }

    public void setSongQueue(SongQueue queue) {
	this.queue = queue;
    }

    public void setStudentCollection(StudentCollection students) {
	this.students = students;
    }

    public Student getCurrentStudent() {
	return this.currentStudent;
    }

    public void setCurrentStudent(Student newStudent) {
	this.currentStudent = newStudent;
    }
}
