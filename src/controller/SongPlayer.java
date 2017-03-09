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
    private songplayer.SongPlayer songPlayer;

    public SongPlayer(SongQueue songQueue) {
	this.songPlaying = false;
	this.songQueue = songQueue;
	this.songPlayer = new songplayer.SongPlayer();
    }

    private void initilize() {
	// attach the observable objects

    }

    // TODO
    @Override
    public void update(Observable o, Object arg) {
	// if the msg comes form the songQueue check if there is already a song
	// playing
	if (o.getClass().equals(SongQueue.class)) {

	} else {
	    // msg came from the songPlayer, the song is over
	    this.songPlaying = false;

	    /*
	     * Check to see if there are more songs in the songQueue, if so play
	     * them.
	     */
	    if (songQueue.hasNext()) {
		// play the song
		Song nextSong = songQueue.next();
		// TODO give it a waiter function
		songPlayer.playFile(null, nextSong.getSongPath().toString());
	    }
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
	    
	    // we need to alert the 
	}
    }

}
