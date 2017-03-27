/*
 * Main GUI for jukebox program.
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.SongCollection;
import model.SongQueue;
import model.StudentCollection;

@SuppressWarnings("serial")
public class Jukebox extends JFrame {

    private model.Jukebox jukebox;

    private SongQueueComponent songQueueComponent;

    public Jukebox(model.Jukebox jukebox) {
	super();
	this.jukebox = jukebox;
	// this.initilize();

	this.setSize(1200, 600);
	this.setLayout(new FlowLayout());
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	this.addWindowListener(new WindowListener() {

	    @Override
	    public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened(WindowEvent e)");

		int userOption = JOptionPane.showConfirmDialog(null,
			"Start with previous saved state?\nNo means beginning with default state.");

		if (userOption == JOptionPane.OK_OPTION) {
		    try {
			FileInputStream songQueueFileIn = new FileInputStream("/tmp/songQueue.ser");
			ObjectInputStream songQueueOut = new ObjectInputStream(songQueueFileIn);
			SongQueue songQueue = (SongQueue) songQueueOut.readObject();
			// TODO : deal with listeners later
			jukebox.setSongQueue(songQueue);
			songQueue.config();
			songQueueOut.close();
			songQueueFileIn.close();
			System.out.println("Deserialized data in /tmp/songQueue.ser");

			FileInputStream studentCollectionFileIn = new FileInputStream("/tmp/studentCollection.ser");
			ObjectInputStream studentCollectionOut = new ObjectInputStream(studentCollectionFileIn);
			StudentCollection studentCollection = (StudentCollection) studentCollectionOut.readObject();
			// TODO : deal with listeners later
			jukebox.setStudentCollection(studentCollection);
			studentCollectionOut.close();
			studentCollectionFileIn.close();
			System.out.println("Deserialized data in /tmp/studentCollection.ser");

			FileInputStream songCollectionFileIn = new FileInputStream("/tmp/songCollection.ser");
			ObjectInputStream songCollectionOut = new ObjectInputStream(songCollectionFileIn);
			SongCollection songCollection = (SongCollection) songCollectionOut.readObject();
			// TODO : deal with listeners later
			jukebox.setSongCollection(songCollection);
			songCollectionOut.close();
			songCollectionFileIn.close();
			System.out.println("Deserialized data in /tmp/songCollection.ser");
		    } catch (IOException i) {
			i.printStackTrace();
			return;
		    } catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		    } finally {
			initilize();
		    }
		} else if (userOption == JOptionPane.NO_OPTION) {
		    // we don't have to do anything
		    initilize();
		}
	    }

	    @Override
	    public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing(WindowEvent e)");

		int userOption = JOptionPane.showConfirmDialog(null, "Would you like to save the data?");

		if (userOption == JOptionPane.OK_OPTION) {
		    try {
			FileOutputStream songQueueFileOut = new FileOutputStream("/tmp/songQueue.ser");
			ObjectOutputStream songQueueOut = new ObjectOutputStream(songQueueFileOut);
			songQueueOut.writeObject(jukebox.getSongQueue());
			songQueueOut.close();
			songQueueFileOut.close();
			System.out.println("Serialized data is saved in /tmp/songQueue.ser");

			FileOutputStream studentCollectionFileOut = new FileOutputStream("/tmp/studentCollection.ser");
			ObjectOutputStream studentCollectionOut = new ObjectOutputStream(studentCollectionFileOut);
			studentCollectionOut.writeObject(jukebox.getStudentCollection());
			studentCollectionOut.close();
			studentCollectionFileOut.close();
			System.out.println("Serialized data is saved in /tmp/studentCollection.ser");

			FileOutputStream songCollectionFileOut = new FileOutputStream("/tmp/songCollection.ser");
			ObjectOutputStream songCollectionOut = new ObjectOutputStream(songCollectionFileOut);
			songCollectionOut.writeObject(jukebox.getSongCollection());
			songCollectionOut.close();
			songCollectionFileOut.close();
			System.out.println("Serialized data is saved in /tmp/songCollection.ser");
		    } catch (IOException i) {
			i.printStackTrace();
		    }
		} else if (userOption == JOptionPane.NO_OPTION) {
		    // we don't have to do anything
		}
	    }

	    @Override
	    public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowClosed(WindowEvent e)");
	    }

	    @Override
	    public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowIconified(WindowEvent e)");
	    }

	    @Override
	    public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeiconified(WindowEvent e)");
	    }

	    @Override
	    public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowActivated(WindowEvent e)");
	    }

	    @Override
	    public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("windowDeactivated(WindowEvent e)");
	    }
	});
	
	this.setVisible(true);
    }

    // Adds view.
    private void initilize() {
	this.add(new SongDisplayComponent(this.jukebox));
	System.out.println("SongDisplayComponent done");

	this.add(new UserLogInComponent(this.jukebox));
	System.out.println("UserLogInComponent done");

	// TODO
	this.songQueueComponent = new SongQueueComponent(this.jukebox);
	this.add(this.songQueueComponent);
	System.out.println("SongQueueComponent done");

	this.add(new SongCollectionJTableComponent(this.jukebox));
	System.out.println("SongCollectionJTableComponent done");
		
	this.songQueueComponent.updateUI();
	
    }
}
