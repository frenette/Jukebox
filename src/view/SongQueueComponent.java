package view;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Song;
import model.SongQueueListModel;

public class SongQueueComponent extends JPanel {

    private static final long serialVersionUID = 1L;

    private model.Jukebox jukebox;

    public SongQueueComponent(model.Jukebox jukebox) {
	this.jukebox = jukebox;
	SongQueueListModel songQueueListModel = new SongQueueListModel(this.jukebox.getSongQueue());
	this.jukebox.getSongQueue().addObserver(songQueueListModel);
	JList<Song> mySongQueueList = new JList<>(songQueueListModel);
	JScrollPane mySongQueueListScroller = new JScrollPane(mySongQueueList);
	this.add(mySongQueueListScroller);
    }
}
