package bigws.Servidor;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
	
	private List<Note> listNotes = new ArrayList<Note>();

	public NoteBook(){}
	
	public NoteBook(List<Note> listNotes) {
		this.listNotes = listNotes;
	}

	public List<Note> getListNotes() {
		return listNotes;
	}

	public void setListNotes(List<Note> listNotes) {
		this.listNotes = listNotes;
	}
	
	public void deleteNote(Note note){
		listNotes.remove(note);
	}
	
	public void addNote(Note note) {
		listNotes.add(note);
	}
	public Note getNote() {
		return listNotes.get(0);
	}

	public void deleteListNote(List<Note> listDelete) {
		for (int i=0;i<listDelete.size();i++){
			listNotes.remove(listDelete.get(i));
			
		}
		
	}

	public void deleteAll() {
		listNotes = new ArrayList<Note>();
		
	}
}
