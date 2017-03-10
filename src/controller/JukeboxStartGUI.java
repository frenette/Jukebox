package controller;

public class JukeboxStartGUI {

    public static void main(String[] args) {
	/*
	 * Start up the GUI
	 */
	
	model.Jukebox jukebox = new model.Jukebox();
	new view.Jukebox(jukebox);

    }

}
