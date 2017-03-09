package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.Jukebox;
import model.Song;
import model.SongQueue;
import model.Student;

import view.SongJButton;

public class SongJButtonActionListener implements ActionListener {
    /*
     * We need a reference to jukebox to make sure that there is a current user
     * logged on
     */
    private Jukebox jukebox;
    
    public SongJButtonActionListener(Jukebox jukebox) {
	super();
	this.jukebox = jukebox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	testing(e);
    }

    // Testing
    private void testing(ActionEvent e) {
	SongJButton source = (SongJButton) e.getSource();
	Song song = source.getSong();
	SongQueue songQueue = jukebox.getSongQueue();
	// see if the jukebox has a user signed in
	Student currentStudent = jukebox.getCurrentStudent();

	// check if there is a student
	if (currentStudent != null) {
	    System.out.println("userID: " + currentStudent.getUserID());
	    System.out.println("songTitle: " + ((SongJButton) e.getSource()).getSong().toString());
	    System.out.println("canPlay: " + currentStudent.canPlay(song));

	    // check if the currentStudent can play the song
	    if (currentStudent.canPlay(song)) {
		/*
		 * Add the song to the queue which will also update the
		 * student's information about having played the song
		 */
		songQueue.addSong(song, currentStudent);
	    } else {
		/*
		 * The song is unable to be played, may be because the user has
		 * already played 3 songs, the user does not have enough time to
		 * play the song, or the song has already been played 3 times
		 */
	    }
	} else {
	    // open a dialog box saying you need to log in first
	    System.out.println("currentStudent == null");
	}

    }
    // End testing

}