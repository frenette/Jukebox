package model;

import java.util.Observable;

public class CardReader extends Observable {

	static StudentCollection students;
	
	public void updater(Student s) {
			setChanged();
			notifyObservers(s);
	}
}
