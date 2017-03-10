/*
 * Main GUI for jukebox program.
 */
package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Jukebox extends JFrame {
    
    private model.Jukebox jukebox;
    
    public Jukebox(model.Jukebox jukebox) {
	super();
	this.jukebox = jukebox;
	initilize();
    }
    
    //Adds view.
    private void initilize() {
	this.setLayout(new FlowLayout());
	/* 
	 * TODO
	 */
	this.add(new SongDisplayComponent(this.jukebox));
	System.out.println("SongDisplayComponent done");
	this.add(new UserLogInComponent(this.jukebox));
	System.out.println("UserLogInComponent done");
	this.setSize(1200, 200);
	this.setVisible(true);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
