package main.java.ServerWebSockets.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class GestionNote {
	
	public final static String DEFAULT_FILE_NAME = "note_book.json";

	
	public GestionNote(){
		
		File fichero=new File(DEFAULT_FILE_NAME);
		try {
			if(!fichero.exists())
			fichero.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// This function fills in a Person message based on user input.
	static Note PromptForAddress(BufferedReader stdin, PrintStream stdout)
			throws IOException {
		Note note = new Note();

		stdout.print("Enter task Note: ");
		note.setTask(stdin.readLine());

		stdout.print("Enter context: ");
		note.setContext(stdin.readLine());

		stdout.print("Enter project: ");
		note.setProject(stdin.readLine());

		stdout.print("Enter priority: ");
		note.setPriority(Integer.parseInt(stdin.readLine()));

		return note;
	}
	
	public void deleteNote(String tipo,String campo) {
		try{
		String filename = DEFAULT_FILE_NAME;

		NoteBook noteBook = new NoteBook();
		FileReader fil=new FileReader(filename);
		Gson gson = new Gson();
		noteBook = gson.fromJson(fil, NoteBook.class);
		List<Note> listDelete=new ArrayList<Note>();
		if(!tipo.equals("todo")){	
			for (Note note : noteBook.getListNotes()) {
				if(tipo.equals("Task") && note.getTask().equals(campo)){
					listDelete.add(note);
				}
				else if(tipo.equals("Project") && note.getProject().equals(campo)){
					listDelete.add(note);
				}
				else if(tipo.equals("Context") && note.getContext().equals(campo)){
					listDelete.add(note);
				}
			}
			noteBook.deleteListNote(listDelete);
		}
		else if(tipo.equals("todo")) noteBook.deleteAll();
		
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(noteBook));
		output.close();
		fil.close();
		}catch(IOException e){}
	}
	public void addNotes(Note note) {
		String filename = DEFAULT_FILE_NAME;
		try{
		NoteBook noteBook=null;
		Gson gson = new Gson();

		// Read the existing address book.
		try {
			noteBook = gson.fromJson(new FileReader(filename), NoteBook.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}
		if(noteBook==null) noteBook=new NoteBook();
		noteBook.addNote(note);
		// Write the new address book back to disk.
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(noteBook));
		output.close();
		} catch(IOException e){}
	}

	// Main function: Reads the entire address book from a file,
	// adds one person based on user input, then writes it back out to the same
	// file.
	public static void main(String[] args) throws Exception {
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename=args[0];
		}

		NoteBook noteBook = new NoteBook();
		Gson gson = new Gson();

		// Read the existing address book.
		try {
			noteBook = gson.fromJson(new FileReader(filename), NoteBook.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}
		Note nota=PromptForAddress(new BufferedReader(
				new InputStreamReader(System.in)), System.out);
		//System.out.println(nota.toString());
		// Add an address.
		noteBook.addNote(nota);
		// Write the new address book back to disk.
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(noteBook));
		output.close();
	}
	public void showAll() {
		
		
	}
}
