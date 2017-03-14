/*
 * Holds log-in field and information for users.
 */
package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ActionListenerType;
import controller.UserLogInListener;
import model.Student;

@SuppressWarnings("serial")
public class UserLogInComponent extends JPanel implements Observer {

    private model.Jukebox jukebox = new model.Jukebox();

    private JLabel userdIDLabel;
    private JLabel passwordLabel;
    private JLabel statusLabel;
    /*
     * "userStatusLabel" changes depending on if the user is logged in or not
     * User is not logged in : "Login First" User is logged in : <number of
     * songs selected today> selected, <time until the next day
     * hours:minutes:seconds>
     */

    private JLabel userStatusLabel;

    private JTextField userdIDField;
    private JPasswordField passwordField;

    private JButton signOutButton;
    private JButton loginButton;

    public UserLogInComponent(model.Jukebox jukebox) {
	this.jukebox = jukebox;

	this.userdIDLabel = new JLabel("Account Name");
	this.passwordLabel = new JLabel("Password");
	this.statusLabel = new JLabel("Status:");
	this.userStatusLabel = new JLabel("Login First");

	this.userdIDField = new JTextField();
	this.passwordField = new JPasswordField();

	this.signOutButton = new JButton("Sign Out");
	this.loginButton = new JButton("Login");

	// add the listeners
	this.signOutButton.addActionListener(new UserLogInListener(ActionListenerType.SIGNOUT, jukebox, this));
	this.loginButton.addActionListener(new UserLogInListener(ActionListenerType.LOGIN, jukebox, this));

	// set the the view layout
	int rowCount = 4;
	int columnCount = 2;
	this.setLayout(new GridLayout(rowCount, columnCount));

	// add the components
	this.add(this.userdIDLabel);
	this.add(this.userdIDField);
	this.add(this.passwordLabel);
	this.add(this.passwordField);
	this.add(this.signOutButton);
	this.add(this.loginButton);
	this.add(this.statusLabel);
	this.add(this.userStatusLabel);
    }

    // Gets the username from the username field.
    public String getUserIDFieldValue() {
	return this.userdIDField.getText();
    }

    // Gets password from password field.
    public String getPasswordFieldValue() {
	return String.valueOf(this.passwordField.getPassword());
    }

    // Clear fields on wrong entry.
    public void clearFields() {
	this.userdIDField.setText(null);
	this.passwordField.setText(null);
    }

    public void updateStatusLabel() {
	// <number of songs selected today> selected, <time until the next day
	// hours:minutes:seconds>

	Student currentStudent = this.jukebox.getCurrentStudent();
	System.out.println(currentStudent);
	System.out.println(currentStudent);
	System.out.println(currentStudent);
	System.out.println(currentStudent);

	if (currentStudent != null) {
	    int songsPlayed = this.jukebox.getCurrentStudent().songsPlayedToday();
	    System.out.println("this.jukebox.getCurrentStudent().songsPlayedToday(): " + songsPlayed);
	    int secondsRemaining = currentStudent.getPlayTime();
	    int hours = secondsRemaining / 3600;
	    int minutes = (secondsRemaining % 3600) / 60;
	    int seconds = secondsRemaining % 60;
	    String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
	    
	    this.userStatusLabel.setText(songsPlayed + " selected, " + timeString);
	} else {
	    this.userStatusLabel.setText("Login First");
	}	
    }

    @Override
    public void update(Observable o, Object arg) {
	System.out.println("The UserLogInComponent is saying it has changed");
	System.out.println(o.getClass());
	this.updateStatusLabel();
    }
}
