package view;

import java.awt.Color;

import javax.swing.JFrame;

import controller.SongJButtonActionListener;
import model.Song;
import model.Student;

@SuppressWarnings("serial")
public class Jukebox extends JFrame {
    public Jukebox() {
	super();
	initilize();
    }
    
    private void initilize() {
	this.add(new UserLogInComponent());
	// Testing
	this.addSongJButton();
	// End testing
	this.setSize(400, 600);
	this.setVisible(true);
    }
    
    // Testing
    private void addSongJButton() {
	System.out.println("Adding song button");
	Song testSong = new Song("Song artist", "Song title", "Song fileName", 10);
	Student testStudent = new Student("Example user", "Example password");
	SongJButton button = new SongJButton(new model.Jukebox(testStudent), testSong);
	button.setSize(50, 50);
	button.setBackground(Color.BLUE);
	button.addActionListener(new SongJButtonActionListener());
	this.add(button);
    }
}
