package bigws.Servidor;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


public class ListNotes {
	public final static String DEFAULT_FILE_NAME = "note_book.json";

	
	public ListNotes(){}
	// Iterates though all people in the AddressBook and prints info about them.
	

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
	
}