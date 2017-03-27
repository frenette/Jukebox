/*
 * Starts the Jukeboxe, and puts model.jukebox into view.jukebox.
 */

package controller;

public class JukeboxStartGUI {

    /*
     * Start up the GUI
     */
    public static void main(String[] args) {
	model.Jukebox jukebox = new model.Jukebox();
	new view.Jukebox(jukebox);

    }

}
