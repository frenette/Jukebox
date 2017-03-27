package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Song;
import model.SongCollectionTableModel;
import model.SongQueue;
import model.Student;

public class SongCollectionJTableComponent extends JPanel implements TableModelListener {

    /*
     * TODO : when I add a song to the "songs" map it wont update the JTable
     * unless I manually change the table. THe model needs to know that the
     * stuff has changed.
     */

    private static final long serialVersionUID = 1L;
    private model.Jukebox jukebox;
    private JTable table;
    // Need a TableModel to set as the model for a JTabel
    private TableModel model = null;

    // TODO
    JButton playSongJButton;

    public SongCollectionJTableComponent(model.Jukebox jukebox) {
	super();

	this.jukebox = jukebox;
	this.model = new SongCollectionTableModel(this.jukebox);

	// this.setLayout(new BorderLayout());

	this.initilizeJTable();

	// Add the button TODO add button listener
	this.playSongJButton = new JButton("Add song to queue");
	this.playSongJButton.addActionListener(new ActionListener() {

	    @Override
	    public void actionPerformed(ActionEvent e) {
		Student currentStudent = jukebox.getCurrentStudent();
		int row = table.convertRowIndexToModel(table.getSelectedRow());
		
		// check if there is a student, and if the selected column is
		// valid
		if (currentStudent != null && row != -1) {

		    // get the song
		    String songID = (String) model.getValueAt(row, 0);
		    Song song = jukebox.getSongCollection().getSong(songID);

		    // check if the currentStudent can play the song
		    if (currentStudent.canPlay(song)) {
			/*
			 * Add the song to the queue which will also update the
			 * student's information about having played the song
			 */
			System.out.println("songQueue.addSong(song, currentStudent);");
			SongQueue songQueue = jukebox.getSongQueue();
			songQueue.addSong(song, currentStudent);
			songQueue.listSongs();
		    } else {
			/*
			 * The song is unable to be played, may be because the
			 * user has already played 3 songs, the user does not
			 * have enough time to play the song, or the song has
			 * already been played 3 times
			 */
			if (currentStudent.hasRemaningPlays()) {
			    // the user has no more plays
			    JOptionPane.showMessageDialog(null,
				    song.toString() + " has reached the max number of plays for the day.");
			} else {
			    // the song has no more plays
			    JOptionPane.showMessageDialog(null,
				    "You have reached the max number of plays for the day.");
			}
		    }

		    // System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=\n");
		} else {
		    if (currentStudent == null) {
			// open a dialog box saying you need to log in first
			System.out.println("currentStudent == null");
			JOptionPane.showMessageDialog(null, "You must log in before playing a song.");
		    } else {
			// there was not a song selected
			JOptionPane.showMessageDialog(null, "You must select a song before addding it to the queue.");
		    }
		}

	    }

	});
	this.add(this.playSongJButton);

	// TODO TESTING
	this.setBackground(Color.BLUE);
    }

    private void initilizeJTable() {
	table = new JTable(model);
	JScrollPane scrollPane = new JScrollPane(table);
	this.add(scrollPane);
	RowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
	table.setRowSorter(sorter);
    }

    @Override
    public void tableChanged(TableModelEvent e) {
	// TODO Auto-generated method stub

    }
}
