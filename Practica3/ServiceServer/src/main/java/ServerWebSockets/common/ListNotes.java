package main.java.ServerWebSockets.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class ListNotes {
	public final static String DEFAULT_FILE_NAME = "note_book.json";

	
	public ListNotes(){}
	// Iterates though all people in the AddressBook and prints info about them.
	

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
	public NoteBook listaNotas()  {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		

		// Read the existing address book.
		NoteBook noteBook=null;
		try {
			noteBook = gson.fromJson(new FileReader(
					filename), NoteBook.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noteBook;
	}
	public NoteBook listaNotasFilter(String option, String campo) {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;

		// Read the existing address book.
		NoteBook noteBook=null;
		NoteBook resultado=new NoteBook();
		try {
			noteBook = gson.fromJson(new FileReader(
					filename), NoteBook.class);
		
		for (Note note : noteBook.getListNotes()) {
			if(option.equals("Task") && note.getTask().equals(campo)){
				resultado.addNote(note);
				System.out.println("Nota añadida");
			}
			else if(option.equals("Project") && note.getProject().equals(campo)){
				resultado.addNote(note);
			}
			else if(option.equals("Context") && note.getContext().equals(campo)){
				resultado.addNote(note);
			}
			
		}
		
		
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
}