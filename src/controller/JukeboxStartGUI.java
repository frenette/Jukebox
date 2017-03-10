package controller;

public class JukeboxStartGUI {

    public static void main(String[] args) {
	/*
	 * Start up the GUI
	 */

	/*
	 * TODO : add the songs to the jukebox, and add the users
	 */
	model.Jukebox jukebox = new model.Jukebox();

	new view.Jukebox(jukebox);

    }

}
