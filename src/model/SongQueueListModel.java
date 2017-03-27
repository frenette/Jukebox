package model;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;

public class SongQueueListModel extends AbstractListModel<Song> implements Observer {

    private static final long serialVersionUID = -7521407062983424137L;
    private SongQueue songQueue;

    public SongQueueListModel(SongQueue songQueue) {
	super();
	this.songQueue = songQueue;
    }

    @Override
    public int getSize() {
	return this.songQueue.size();
    }

    @Override
    public Song getElementAt(int index) {
	return (Song) ((List) this.songQueue.getSongs()).get(index);
    }

    @Override
    public void update(Observable o, Object arg) {
	this.fireContentsChanged(this, 0, this.getSize());

    }
}
