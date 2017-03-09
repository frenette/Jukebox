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
//	this.addSongJButton();
	// End testing
	this.setSize(400, 600);
	this.setVisible(true);
    }
    
}
