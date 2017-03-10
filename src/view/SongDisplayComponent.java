/*
 * Displays a list of all songs avaiable for the user to play.
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JPanel;

import model.Song;
import model.SongCollection;

/*
 * Description : In iteration 1 we will be displaying the songs as simple buttons
 */

@SuppressWarnings("serial")
public class SongDisplayComponent extends JPanel {
    
    private model.Jukebox jukebox;
    
    public SongDisplayComponent(model.Jukebox jukebox) {
	super();
	System.out.println("SongDisplayComponent constructor start");
	this.jukebox = jukebox;
//	this.setLayout(new FlowLayout());
	this.initilizeButtons();
	
	System.out.println("SongDisplayComponent constructor done");
    }
    
    //Initializes a button for each song.
    private void initilizeButtons() {
	// get the songs from the jukebox
	SongCollection songCollection = this.jukebox.getSongCollection();
	
	System.out.println("initilizeButtons start");
	
	Iterator<Song> songIterator = songCollection.getIterator();
	
	while (songIterator.hasNext()) {
	    System.out.println("initilizeButtons loop");
	    this.add(new SongJButton(this.jukebox, songIterator.next()));
	}
    }
}
