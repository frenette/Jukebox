/*
 * SongCollection stores each song.
 */

package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class SongCollection implements Iterable<Song>, Serializable{
    
    /*
     * Start of singleton code
     */
    
    private static SongCollection instance = null;
    
    public static synchronized SongCollection getSongCollection() {
	if (instance == null) {
	    instance = new SongCollection();
	}
	
	return instance;
    }
    
    /*
     * End of singleton code
     */
    
    private static final long serialVersionUID = -2102470815939806538L;
    private Map<String, Song> songs;
    
    public LocalDate currentDate;

    private SongCollection() {
	this.songs = new TreeMap<>();
	this.createTimer();
	this.currentDate = LocalDate.now();
    }

    // Adds a song to the collection
    public void addSong(Song song) {
	this.songs.put(song.getSongID(), song);
    }

    public Song getSong(String songID) {
	return this.songs.get(songID);
    }
    
    public int size() {
	return this.songs.size();
    }
    
    public Map<String, Song> getSongs() {
	return this.songs;
    }

    public void createTimer() {
	System.out.println("LOCAL DATE: " + LocalDate.now());

	try {
	    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    LocalDate currentDate = LocalDate.now();
	    Date date = dateFormatter.parse(currentDate + " 24:00:00");
	    Timer timer = new Timer();
	    timer.schedule(new MyTimerTask(), date);
	} catch (ParseException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public Iterator<Song> iterator() {
	return this.songs.values().iterator();
    }

    class MyTimerTask extends TimerTask {

	@Override
	public void run() {
	    System.out.println("MyTimerTask has run");
	    System.out.println("Inside of SongCollection Timer");

	    // reset all of the songs back to 0 plays
	    Collection<Song> songAsCollection = songs.values();
	    for (Song s : songAsCollection) {
		s.resetDailyPlayCount();
	    }

	    // start the timer over again
	    createTimer();
	}
    }

    public void resetDates() {
	Collection<Song> songAsCollection = songs.values();
	    for (Song s : songAsCollection) {
		s.resetDailyPlayCount();
	    }	
    }
}
