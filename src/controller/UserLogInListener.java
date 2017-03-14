/*
 * Listens for the user log in, and verifys each user.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Jukebox;
import model.Student;
import model.StudentCollection;
import view.UserLogInComponent;

public class UserLogInListener implements ActionListener {
    private ActionListener thisActionListener;
    private Jukebox jukebox;
    private UserLogInComponent userLogInComponent;

    public UserLogInListener(ActionListenerType type, Jukebox jukebox) {
	this.jukebox = jukebox;

	if (type == ActionListenerType.LOGIN) {
	    this.thisActionListener = new logIn();
	} else if (type == ActionListenerType.SIGNOUT) {
	    this.thisActionListener = new signOut();
	}
    }

    public UserLogInListener(ActionListenerType type, Jukebox jukebox, UserLogInComponent userLogInComponent) {
	this.jukebox = jukebox;
	this.userLogInComponent = userLogInComponent;

	if (type == ActionListenerType.LOGIN) {
	    this.thisActionListener = new logIn();
	} else if (type == ActionListenerType.SIGNOUT) {
	    this.thisActionListener = new signOut();
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	this.thisActionListener.actionPerformed(e);
    }

    /*
     * Class : logIn Verifys username and password
     */
    private class logIn implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println("logIn");

	    /*
	     * NOTE : we assume that a user can't login if there is already a
	     * current student
	     */

	    if (jukebox.getCurrentStudent() == null) {
		String newStudentID = userLogInComponent.getUserIDFieldValue();
		Student newStudent = jukebox.getStudentCollection().getStudent(newStudentID);

		System.out.println(userLogInComponent.getUserIDFieldValue());
		System.out.println(userLogInComponent.getPasswordFieldValue());

		if (newStudent != null) {
		    // valid student userID
		    String password = userLogInComponent.getPasswordFieldValue();

		    if (newStudent.correctPassowrd(password)) {
			// valid password
			jukebox.setCurrentStudent(newStudent);
			// The student is valid
			System.out.println("Success : valid user.");
			System.out.println("getCurrentStudent: " + jukebox.getCurrentStudent().toString());

			// set the newStudent to be the jukebox's currentStudent
			jukebox.setCurrentStudent(newStudent);

			// add the userLogInComponent as a listener of the
			// newStudent which will be the currentUser
			// TODO
			jukebox.getCurrentStudent().getPlayInformation().addObserver(userLogInComponent);
			System.out.println("newStudent.countObservers(): " + newStudent.countObservers());

			// have the userLogInComponent update the status label
			userLogInComponent.updateStatusLabel();

			return;

		    }

		    // The password is invalid
		    System.out.println("Error : invalid password.");
		}

		// The student is invalid
		System.out.println("Error : invalid student.");
		// clear the field
		userLogInComponent.clearFields();
	    } else {
		/*
		 * NOTE : there is already a user logged in
		 */

		System.out.println("ERROR: there is already a user logged in.");
	    }
	}
    }

    /*
     * Class : signOut Controls the user signing out.
     */
    private class signOut implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println("signOut");

	    // TODO
	    // System.out.println("getCurrentStudent: " +
	    // jukebox.getCurrentStudent().toString());
	    System.out.println("I am here 1");

	    Student currentStudent = jukebox.getCurrentStudent();

	    if (currentStudent != null) {
		System.out.println("I am here 2");
		System.out.println("Current studdent: " + jukebox.getCurrentStudent().toString());

		// remove the observers for the currentStudent
		jukebox.getCurrentStudent().getPlayInformation().deleteObserver(userLogInComponent);
		jukebox.setCurrentStudent(null);

		// clear the field
		userLogInComponent.clearFields();

		// have the userLogInComponent update the status label
		userLogInComponent.updateStatusLabel();
	    } else {
		/*
		 * TODO : we have the ability to give an alert because the user
		 * is trying to log out when there is nothing to log out
		 */
		System.out.println("I am here 3");
	    }
	}
    }
}
