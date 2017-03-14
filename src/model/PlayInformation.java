/*
 * Holds play information for users/songs, holds time info.
 */

package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class PlayInformation extends Observable {
    private LocalDate dateOfLastPlayed;
    private int playCount;
    private int maxPlayCount;

    public PlayInformation() {
	this.dateOfLastPlayed = LocalDate.now();
	this.playCount = 0;
	this.maxPlayCount = 3;

	// TODO
	this.testing();
    }

    // Checks playcount of specific song/student.
    public boolean hasRemaningPlays() {
//	if (isSameDay()) {
//	    return this.playCount < this.maxPlayCount;
//	} else {
//	    return true;
//	}
	
	return this.playCount < this.maxPlayCount;
    }

    // returns number of songs played for song/student
    public int songsPlayed() {
//	if (!isSameDay()) {
//	    this.dateOfLastPlayed = LocalDate.now();
//	    this.playCount = 0;
//	}

	return this.playCount;
    }

    // Increments the playcount of student/song
    public void incrementPlayCount() {
//	if (isSameDay()) {
//	    playCount++;
//	} else {
//	    // it is a whole new day, new data and new count
//	    this.dateOfLastPlayed = LocalDate.now();
//	    this.playCount = 1;
//	}
	
	playCount++;
	
//	System.out.println("incrementPlayCount: " + this.playCount);
//	System.out.println("countObservers for PlayInformation: " + this.countObservers());
	this.setChanged();
	this.notifyObservers();
    }

    // Method to reset the play count if it is a new day.
//    private boolean isSameDay() {
//	LocalDate currentTime = LocalDate.now();
//
//	if (currentTime.getDayOfMonth() == dateOfLastPlayed.getDayOfMonth()) {
//	    // it is the same day of the month, but it must also be the same
//	    // month, and same year
//	    if (currentTime.getMonth() == dateOfLastPlayed.getMonth()) {
//		// it is the same month, but it must also be the same year
//		if (currentTime.getYear() == dateOfLastPlayed.getYear()) {
//		    // it is still the same day
//		    return true;
//		}
//	    }
//	}
//
//	return false;
//    }

    /*
     * TESTING : SHOULD SEND MSG AS SOON AS MIDNIGHT HITS
     */
    public void testing() {

	/*
	 * LocalTime midnight = LocalTime.MIDNIGHT; LocalDate today =
	 * LocalDate.now(ZoneId.of("Europe/Berlin")); LocalDateTime
	 * todayMidnight = LocalDateTime.of(today, midnight); LocalDateTime
	 * tomorrowMidnight = todayMidnight.plusDays(1);
	 */

	DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	LocalDate currentDate = LocalDate.now();
	Date date = null;
	try {
	    date = dateFormatter.parse(currentDate + " 23:59:59");
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Timer timer = new Timer();
	// LocalTime midnight = LocalTime.MIDNIGHT;
	// LocalDate today = LocalDate.now();
	// LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
	// Date todayMidnightDate =
	// Date.from(todayMidnight.atZone(ZoneId.systemDefault()).toInstant());
	//
	// Date in = new Date();
	// LocalDateTime ldt = LocalDateTime.of(today, midnight);
	// Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());

	timer.schedule(new MyTimerTask(), date);
	// System.out.println(todayMidnightDate);
	// System.out.println(Date.from(Instant.now()).getClass());


	// timer.schedule(new MyTimerTask(), Date.from(Instant.now()),

	// System.out.println("0000000000000000000000000000000");
	// LocalDateTime time = LocalDateTime.now();
	// System.out.println(time);
	// System.out.println("0000000000000000000000000000000");

    }

    private class MyTimerTask extends TimerTask {

	@Override
	public void run() {

	    // TODO Auto-generated method stub
	    System.out.println("MyTimerTask has run");

	    dateOfLastPlayed = LocalDate.now();
	    playCount = 0;

	    setChanged();
	    notifyObservers();

	    // Timer timer = new Timer();
	    // LocalTime midnight = LocalTime.MIDNIGHT;
	    // LocalDate today = LocalDate.now();
	    // LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
	    // Date todayMidnightDate =
	    // Date.from(todayMidnight.atZone(ZoneId.systemDefault()).toInstant());
	    // // Date.from(todayMidnight.toInstant(ZoneId.systemDefault())).;
	    //
	    // Date in = new Date();
	    // LocalDateTime ldt = LocalDateTime.of(today, midnight);
	    // Date out =
	    // Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
	    //
	    // // timer.schedule(new MyTimerTask(), todayMidnightDate,
	    // // TimeUnit.DAYS.toMillis(1));
	    // timer.schedule(new MyTimerTask(), todayMidnightDate);

	}

    }
}
