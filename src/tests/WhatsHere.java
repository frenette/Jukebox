package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Jukebox;
import model.Song;
import model.SongCollection;
import model.SongQueue;
import model.Student;
import model.StudentCollection;

public class WhatsHere {

  public static void main(String[] args) {
    System.out.println("This package should contain unit tests that get at least 90% code coverage in the model package");
  
  }
  Jukebox jukebox = new Jukebox();
  StudentCollection students = jukebox.getStudentCollection();
  SongQueue queue = jukebox.getSongQueue();
  Student student = students.getStudent("Chris");
  SongCollection songs = jukebox.getSongCollection();
  
  
  @Test
  //Jukebox
  public void test() {
	  jukebox = new Jukebox(student);
	  student.correctPassowrd("1");
	  jukebox.setCurrentStudent(student);
	  student = jukebox.getCurrentStudent();
	  assertEquals("Chris", student.toString());
	  
	  
  }
  @Test
  //Songs
  public void test2() {
	  Song s = new Song("Kevin MacLeod", "Danse Macabre", "DanseMacabreViolinHook.mp3", 34);
	  songs.getSong("Danse Macabre");
	  queue.addSong(s , student);
	  assertEquals(34, s.getLength());
	  s.getSongPath();
	  assertTrue(student.canPlay(s));
	  String songString = queue.listSongs();
	  assertFalse(songString.equals(null));
	  
  }
  
  @Test
  //Observers
  //Were gonna initilize the GUI since it calls many methods we want to make sure work.
  public void test3() {

		new view.Jukebox(jukebox);
  }
  
  
}