/*
 * Holds all of the students.
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

public class StudentCollection implements Iterable<Student>, Serializable{

    /*
     * Start of singleton code
     */
    
    private static StudentCollection instance = null;
    
    public static synchronized StudentCollection getStudentCollection() {
	if (instance == null) {
	    instance = new StudentCollection();
	}
	
	return instance;
    }
    
    /*
     * End of singleton code
     */
    
    private static final long serialVersionUID = -5352286475152700333L;
    private Map<String, Student> students;
    
    public LocalDate currentDate;

    private StudentCollection() {
	this.students = new TreeMap<>();
	this.createTimer();
	this.currentDate = LocalDate.now();
    }

    // Adds a student to the collection.
    public void addStudent(Student student) {
	this.students.put(student.getUserID(), student);
    }

    public Student getStudent(String userID) {
	return students.get(userID);
    }
    
    public int size() {
	return this.students.size();
    }
    
    public Map<String, Student> getStudents() {
	return this.students;
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
    public Iterator<Student> iterator() {
	return this.students.values().iterator();
    }

    class MyTimerTask extends TimerTask {

	@Override
	public void run() {
	    // System.out.println("MyTimerTask has run");
	    // System.out.println("Inside of StudentCollection Timer");

	    // reset all of the students back to 0 plays
	    Collection<Student> studentsAsCollection = students.values();
	    for (Student s : studentsAsCollection) {
		s.resetDailyPlayCount();
	    }

	    // start the timer over again
	    createTimer();
	}
    }

    public void resetDates() {
	Collection<Student> studentsAsCollection = students.values();
	    for (Student s : studentsAsCollection) {
		s.resetDailyPlayCount();
	    }
    }
}
