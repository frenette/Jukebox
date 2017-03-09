package view;

import javax.swing.JButton;

import model.Song;

@SuppressWarnings("serial")
public class SongJButton extends JButton {

    /*
     * We need to keep track of the state of the jukebox because the action
     * listener needs to know if there is a user that is signed in to know to
     * add the song to the queue or not
     */
    private model.Jukebox jukebox;
    private Song song;

    public SongJButton(model.Jukebox jukebox, Song song) {
	super();
	this.jukebox = jukebox;
	this.song = song;
	// Initialize the button text
	this.setText(this.song.toString());
    }
    
    public model.Jukebox getJukebox() {
	return this.jukebox;
    }

    public Song getSong() {
	return this.song;
    }

}
