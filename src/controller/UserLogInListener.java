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
     * Class : logIn
     */
    private class logIn implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println("logIn");

	    System.out.println(userLogInComponent.getUserIDFieldValue());
	    System.out.println(userLogInComponent.getPasswordFieldValue());

	    String studentID = userLogInComponent.getUserIDFieldValue();
	    Student student = jukebox.getStudentCollection().getStudent(studentID);

	    if (student != null) {
		// valid student userID
		String password = userLogInComponent.getPasswordFieldValue();

		if (student.correctPassowrd(password)) {
		    // valid password
		    jukebox.setCurrentStudent(student);
		    // The student is valid
		    System.out.println("Success : valid user.");
		    System.out.println("getCurrentStudent: " + jukebox.getCurrentStudent().toString());
		    jukebox.setCurrentStudent(student);
		    return;
		}

		// The password is invalid
		System.out.println("Error : invalid password.");
	    }

	    // The student is invalid
	    System.out.println("Error : invalid student.");

	    // clear the field
	    userLogInComponent.clearFields();

	}
    }

    /*
     * Class : signOut
     */
    private class signOut implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println("signOut");

	    // TODO
	    // System.out.println("getCurrentStudent: " +
	    // jukebox.getCurrentStudent().toString());
	    System.out.println("I am here 1");
	    if (jukebox.getCurrentStudent() != null) {
		System.out.println("I am here 2");
		System.out.println("Current studdent: " + jukebox.getCurrentStudent().toString());
		jukebox.setCurrentStudent(null);

		// clear the field
		userLogInComponent.clearFields();
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
