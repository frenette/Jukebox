package view;

import javax.swing.JFrame;

public class Jukebox extends JFrame {
    public Jukebox() {
	super();
	initilize();
    }
    
    private void initilize() {
	this.add(new UserLogInComponent());
	this.setSize(400, 600);
	this.setVisible(true);
    }
}
