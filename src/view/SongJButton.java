/*
 * Contains song information for each button.
 */
package view;

import javax.swing.JButton;

import controller.SongJButtonActionListener;
import model.Jukebox;
import model.Song;

@SuppressWarnings("serial")
public class SongJButton extends JButton {
    
    private model.Jukebox jukebox;
    private Song song;

    public SongJButton(model.Jukebox jukebox, Song song) {
	super();
	this.jukebox = jukebox;
	this.song = song;
	// Initialize the button text
	this.setText(this.song.toString());
	this.addActionListener();
    }

    //Gets song tied to button.
    public Song getSong() {
	return this.song;
    }
    
    private void addActionListener() {
	this.addActionListener(new SongJButtonActionListener(this.jukebox));
    }

}
