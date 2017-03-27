/*
 * Plays the songs, and controls the sounds.
 */

package controller;

import java.util.Observable;
import java.util.Observer;

import model.Song;
import model.SongQueue;
import songplayer.EndOfSongEvent;
import songplayer.EndOfSongListener;

public class SongPlayer implements Observer {
    private Boolean songPlaying;
    private SongQueue songQueue;

    public SongPlayer(SongQueue songQueue) {
	this.songPlaying = false;
	this.songQueue = songQueue;
    }

    @Override
    public void update(Observable o, Object arg) {
	// // Testing
	// System.out.println("\t\t=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	// System.out.println("\t\tSongPlayer has been updated");
	// System.out.println("\t\t=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
	// // End testing

	this.playSong();
    }

    // Plays the song if there is one.
    private void playSong() {
	if (this.songPlaying == false) {
	    if (this.songQueue.hasNext()) {
		this.songPlaying = true;
		Song nextSong = this.songQueue.getNextWithoutRemoving();
		songplayer.SongPlayer.playFile(new WaitingForSongToEnd(),
			(System.getProperty("user.dir") + nextSong.getPathString()));
	    }
	}
    }

    /**
     * This inner class allows us to have an callback function that receive a
     * songFinishedPlaying message whenever an audio file has been played.
     */
    private class WaitingForSongToEnd implements EndOfSongListener {

	public void songFinishedPlaying(EndOfSongEvent eosEvent) {
	    songPlaying = false;
	    songQueue.removeHead();
	    playSong();
	    System.out.println("\nFinished " + eosEvent.fileName() + ", " + eosEvent.finishedDate() + ", "
		    + eosEvent.finishedTime());
	}
    }

}
