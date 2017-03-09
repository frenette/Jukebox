package model;

import java.util.Observable;
import java.util.Observer;

public class Jukebox implements Observer {

    SongQueue queue;
    CardReader reader;
    SongCollection songs;
    StudentCollection students;
    SongSelector selector;
    Student currentStudent;

    public Jukebox() {
	queue = new SongQueue();
	reader = new CardReader();
	songs = new SongCollection();
	students = new StudentCollection();
	selector = new SongSelector();
    }

    public void play(Song song) {
	if (currentStudent.canPlay(song)) {
	    queue.addSong(song);
	} else {
	    return;
	}
    }

    @Override
    public void update(Observable o, Object arg) {
	if (arg instanceof Student) {
	    currentStudent = (Student) arg;
	    selector.unlock();
	} else {
	    play((Song) arg);
	}

    }

}
