/*
 * InitializeUsers holds required users.
 */
package model;

public class InitializeUsers {

    /*
     * Chris 1 Devon 22 River 333 Ryan 4444
     */

    private Jukebox jukebox;

    public InitializeUsers(Jukebox jukebox) {
	this.jukebox = jukebox;
    }

    public void initializeUsers() {
	String[] studentsInformation = { "Chris", "1", "Devon", "22", "River", "333", "Ryan", "4444" };

	for (int index = 0; index < studentsInformation.length; index++) {
	    this.jukebox.getStudentCollection()
		    .addStudent(new Student(studentsInformation[index++], studentsInformation[index]));
	}
    }
}
