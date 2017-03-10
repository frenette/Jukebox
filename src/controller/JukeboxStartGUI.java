/*
 * Starts the Jukeboxes, and puts model.jukebox into view.jukebox.
 */
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
