package view;

import java.awt.Color;

import javax.swing.JPanel;

import controller.SongJButtonActionListener;
import model.Song;
import model.Student;

/*
 * Description : In iteration 1 we will be displaying the songs as simple buttons
 */

public class SongDisplayComponent extends JPanel {
    
    private model.Jukebox jukebox;
    
    public SongDisplayComponent(model.Jukebox jukebox) {
	super();
	this.jukebox = jukebox;
    }
    
//    private void initilizeButtons() {
//	// get the songs from the jukebox
//	jukebox.get
//    }
//    
//    private 
//    
//    // Testing
//    private void addSongJButton() {
//	System.out.println("Adding song button");
//	Song testSong = new Song("Song artist", "Song title", "Song fileName", 10);
//	Student testStudent = new Student("Example user", "Example password");
//	SongJButton button = new SongJButton(new model.Jukebox(testStudent), testSong);
//	button.setSize(50, 50);
//	button.setBackground(Color.BLUE);
//	button.addActionListener(new SongJButtonActionListener());
//	this.add(button);
//    }
}
