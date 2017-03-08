package model;

import java.util.Map;
import java.util.TreeMap;

public class StudentCollection {

    private Map<String, Student> students;
    
    public StudentCollection() {
	this.students = new TreeMap<>();
    }
    
    public void addStudent(Student student) {
	this.students.put(student.getUserID(), student);
    }
    
    public Student getStudent(String userID) {
	return students.get(userID);
    }

}
