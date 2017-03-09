package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Student;
import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;
import songplayer.SongPlayer;
import view.SongJButton;

public class SongJButtonActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	testing(e);
    }

    // Testing
    private void testing(ActionEvent e) {
	SongJButton source = (SongJButton) e.getSource();
	model.Jukebox jukebox = source.getJukebox();
	// see if the jukebox has a user signed in
	Student currentStudent = jukebox.getCurrentStudent();

	if (currentStudent != null) {
	    //
	    System.out.println(((SongJButton) e.getSource()).getSong().toString());
	    EndOfSongListener waitForSongEnd = new WaitingForSongToEnd();
	    SongPlayer.playFile(waitForSongEnd,
		    "/Users/alexanderfrenette/Dropbox/csc 335/git/jukebox17-frenette-ejrosie/songfiles/SwingCheese.mp3");
	} else {
	    // open a dialog box saying you need to log in first
	    System.out.println("currentStudent == null");
	}

    }

    /**
     * This inner class allows us to have an callback function that receive a
     * songFinishedPlaying message whenever an audio file has been played.
     */
    private class WaitingForSongToEnd implements EndOfSongListener {

	public void songFinishedPlaying(EndOfSongEvent eosEvent) {
	    System.out.println("\nFinished " + eosEvent.fileName() + ", " + eosEvent.finishedDate() + ", "
		    + eosEvent.finishedTime());
	}
    }
    // End testing

}
