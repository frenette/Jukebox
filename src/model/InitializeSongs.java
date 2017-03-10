/*
 * Initialize songs is the holder for the required songs.
 */

package model;

public class InitializeSongs {

    /*
     * Kevin MacLeod Danse Macabre DanseMacabreViolinHook.mp3 34 FreePlay Music
     * Determined Tumbao DeterminedTumbao.mp3 20 Sun Microsystems Flute
     * flute.aif 6 Kevin MacLeod Loping Sting LopingSting.mp3 5 Unknown Space
     * Music spacemusic.au 6 FreePlay Music Swing Cheese SwingCheese.mp3 15
     * Microsoft Tada tada.wav 2 Kevin MacLeod The Curtain Rises
     * TheCurtainRises.mp3 28 Pierre Langer Untameable Fire UntameableFire.mp3
     * 282
     */

    private Jukebox jukebox;

    public InitializeSongs(Jukebox jukebox) {
	this.jukebox = jukebox;
	initializeSongs();
    }
    
    //Cleaner initialization method.
    public void initializeSongs() {
	String[] songInformation = { "Kevin MacLeod", "Danse Macabre", "DanseMacabreViolinHook.mp3", "34",
		"FreePlay Music", "Determined Tumbao", "DeterminedTumbao.mp3", "20", "Sun Microsystems", "Flute",
		"flute.aif", "6", "Kevin MacLeod", "Loping Sting", "LopingSting.mp3", "5", "Unknown", "Space Music",
		"spacemusic.au", "6", "FreePlay Music", "Swing Cheese", "SwingCheese.mp3", "15", "Microsoft", "Tada",
		"tada.wav", "2", "Kevin MacLeod", "The Curtain Rises", "TheCurtainRises.mp3", "28", "Pierre Langer",
		"Untameable Fire", "UntameableFire.mp3", "282" };

	for (int index = 0; index < songInformation.length; index++) {
	    this.jukebox.getSongCollection().addSong(new Song(songInformation[index++], songInformation[index++],
		    songInformation[index++], Integer.parseInt(songInformation[index])));
	}
    }
}
