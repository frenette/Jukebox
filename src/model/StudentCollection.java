package model;

import java.util.ArrayList;

public class StudentCollection {

	ArrayList<Student> students = new ArrayList<Student>();
	
	public Student getStudent(int id) {
		for(Student s: students) {
			if (s.cardID == id) {
				return s;
			}
		}
		return null;
	}
}
