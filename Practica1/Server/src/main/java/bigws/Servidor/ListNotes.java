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
	static String Print(NoteBook noteBook) {
		String resultado="";
		int numNotas=1;
		for (Note note : noteBook.getListNotes()) {
			String listaNotas="";
			listaNotas=listaNotas+"<b>NOTA "+numNotas+"</b><br>";
			listaNotas=listaNotas +"Task: "+note.getTask()+"<br>";
			listaNotas=listaNotas +"Context: "+note.getContext()+"<br>";
			listaNotas=listaNotas +"Project: "+ note.getProject()+"<br>";
			listaNotas=listaNotas +"Prioridad: "+note.getPriority()+"<br>";
			listaNotas=listaNotas+"<br>";
			numNotas++;
			resultado+="<fieldset><FONT face=Comic Sans MS,arial,verdana size=4 color=blue>"+listaNotas+"</FONT></fieldset>";
		}
		return resultado;
	}

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
	public String listaNotas()  {
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

		return Print(noteBook);
	}
	public String listaNotasFilter(String option, String campo) {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		String resultado="";

		// Read the existing address book.
		NoteBook noteBook=null;
		try {
			noteBook = gson.fromJson(new FileReader(
					filename), NoteBook.class);
		
		int numNotas=1;
		for (Note note : noteBook.getListNotes()) {
			if(option.equals("Task") && note.getTask().equals(campo)){
				String listaNotas="";
				listaNotas=listaNotas+"<b>NOTA "+numNotas+"</b><br>";
				listaNotas=listaNotas +"Task: "+note.getTask()+"<br>";
				listaNotas=listaNotas +"Context: "+note.getContext()+"<br>";
				listaNotas=listaNotas +"Project: "+ note.getProject()+"<br>";
				listaNotas=listaNotas +"Prioridad: "+note.getPriority()+"<br>";
				listaNotas=listaNotas+"<br>";
				numNotas++;
				resultado+="<fieldset><FONT face=Comic Sans MS,arial,verdana size=4 color=blue>"+listaNotas+"</FONT></fieldset>";
			}
			else if(option.equals("Project") && note.getProject().equals(campo)){
				String listaNotas="";
				listaNotas=listaNotas+"<b>NOTA "+numNotas+"</b><br>";
				listaNotas=listaNotas +"Task: "+note.getTask()+"<br>";
				listaNotas=listaNotas +"Context: "+note.getContext()+"<br>";
				listaNotas=listaNotas +"Project: "+ note.getProject()+"<br>";
				listaNotas=listaNotas +"Prioridad: "+note.getPriority()+"<br>";
				listaNotas=listaNotas+"<br>";
				numNotas++;
				resultado+="<fieldset><FONT face=Comic Sans MS,arial,verdana size=4 color=blue>"+listaNotas+"</FONT></fieldset>";
			}
			else if(option.equals("Context") && note.getContext().equals(campo)){
				String listaNotas="";
				listaNotas=listaNotas+"<b>NOTA "+numNotas+"</b><br>";
				listaNotas=listaNotas +"Task: "+note.getTask()+"<br>";
				listaNotas=listaNotas +"Context: "+note.getContext()+"<br>";
				listaNotas=listaNotas +"Project: "+ note.getProject()+"<br>";
				listaNotas=listaNotas +"Prioridad: "+note.getPriority()+"<br>";
				listaNotas=listaNotas+"<br>";
				numNotas++;
				resultado+="<fieldset><FONT face=Comic Sans MS,arial,verdana size=4 color=blue>"+listaNotas+"</FONT></fieldset>";;
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
	
	// Main function: Reads the entire address book from a file and prints all
		// the information inside.
		public static void main(String[] args) throws Exception {
			Gson gson = new Gson();
			String filename = DEFAULT_FILE_NAME;
			if (args.length > 0) {
				filename = args[0];
			}

			// Read the existing address book.
			NoteBook notesBook = gson.fromJson(new FileReader(filename),
					NoteBook.class);

			Print(notesBook);
		}
}