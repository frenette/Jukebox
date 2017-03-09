package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Jukebox;
import model.Student;
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
	    // TODO Auto-generated method stub
	    System.out.println("logIn");

	    /*
	     * TODO : get the user field's username, get the password field's
	     * password.
	     */
	    
	    System.out.println(userLogInComponent.getUserIDFieldValue());
	    System.out.println(userLogInComponent.passwordFieldValue());

	    // Attempting login student
	    // String studentID = TODO
	    // // get the student trying to log in
	    // Student student =
	    // jukebox.getSongCollection().getStudent(studentID);
	    //
	    // if (student != null) {
	    // // valid student userID
	    // String password = TODO;
	    // if (student.correctPassowrd(password)) {
	    // this.jukebox.setCurrentUser(student)
	    // return;
	    // }
	    // }
	    //
	    // // The student was not a valid student
	    // TODO : create error dialog

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
//	    if (jukebox.getCurrentStudent() != null) {
//		jukebox.setCurrentStudent(null);
//	    } else {
//		/*
//		 * TODO : we have the ability to give an alert because the user
//		 * is trying to log out when there is nothing to log out
//		 */
//	    }
	}
    }
}
