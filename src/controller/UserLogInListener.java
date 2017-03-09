package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Student;

public class UserLogInListener implements ActionListener {
    private ActionListener thisActionListener;
    // TODO
    private Student currentStudent;

    public UserLogInListener(ActionListenerType type, Student student) {
	this.currentStudent = student;

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

    private class logIn implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    System.out.println("logIn");
	}
    }

    private class signOut implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
	    // TODO Auto-generated method stub
	    System.out.println("signOut");
	}
    }
}
