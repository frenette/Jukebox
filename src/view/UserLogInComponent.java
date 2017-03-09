package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ActionListenerType;
import controller.UserLogInListener;

public class UserLogInComponent extends JPanel {
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

    public UserLogInComponent() {
	this.userdIDLabel = new JLabel("Account Name");
	this.passwordLabel = new JLabel("Password");
	this.statusLabel = new JLabel("Status:");
	this.userStatusLabel = new JLabel("Login First");

	this.userdIDField = new JTextField();
	this.passwordField = new JPasswordField();

	this.signOutButton = new JButton("Sign Out");
	this.loginButton = new JButton("Login");
	
	// add the listeners
	this.signOutButton.addActionListener(new UserLogInListener(ActionListenerType.SIGNOUT, null));
	this.loginButton.addActionListener(new UserLogInListener(ActionListenerType.LOGIN, null));
	
	// set the the view layout
	int rowCount = 4;
	int columnCount = 2;
	this.setLayout(new GridLayout(rowCount, columnCount));

	// add the components
	this.add(this.userdIDLabel);
	this.add(this.userdIDField);
	this.add(this.passwordLabel);
	this.add(this.passwordField);
	this.add(this.statusLabel);
	this.add(this.userStatusLabel);
	this.add(this.signOutButton);
	this.add(this.loginButton);
    }
}
