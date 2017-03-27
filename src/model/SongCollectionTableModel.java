package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class SongCollectionTableModel implements TableModel {
    
    	private Jukebox jukebox;
    
    	public SongCollectionTableModel(Jukebox jukebox) {
    	    this.jukebox = jukebox;
    	}
    	
	@Override
	public int getRowCount() {
	    return  this.jukebox.getSongCollection().size();
	}

	@Override
	public int getColumnCount() {
	    return 3;
	}

	@Override
	public String getColumnName(int columnIndex) {
	    if (columnIndex == 0) {
		return "Song Title";
	    } else if (columnIndex == 1) {
		return "Artist Name";
	    } else {
		return "Song Length";
	    }
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    if (columnIndex < 2) {
		return String.class;
	    } else {
		return Integer.class;
	    }
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
	    return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    Object[] keyArray = this.jukebox.getSongCollection().getSongs().keySet().toArray();
	    Song song =  this.jukebox.getSongCollection().getSong(keyArray[rowIndex].toString());

	    if (columnIndex == 0) {
		return song.getSongID();
	    } else if (columnIndex == 1) {
		return song.getArtist();
	    } else {
		return song.getLength();
	    }
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	    // TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	    // TODO Auto-generated method stub

	}

}
