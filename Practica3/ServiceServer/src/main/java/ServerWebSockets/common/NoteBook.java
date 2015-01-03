package main.java.ServerWebSockets.common;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
	
	public List<Note> listNotes = new ArrayList<Note>();

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

	public boolean deleteFilterNote(String option, String campo){
			boolean borrado=false;
			switch(option){
				case "Task":
					for(int i=0;i<listNotes.size();i++){
						if(listNotes.get(i).getTask().equals(campo))
							deleteNote(listNotes.get(i));
					}
				break;
				
				case "Context":
					for(int i=0;i<listNotes.size();i++){
						if(listNotes.get(i).getContext().equals(campo))
							deleteNote(listNotes.get(i));
					}
				break;
				
				case "Project":
					for(int i=0;i<listNotes.size();i++){
						if(listNotes.get(i).getProject().equals(campo))
							deleteNote(listNotes.get(i));
					}
				break;
			}
			return true;
	}
	
	public NoteBook FilterNote(String option, String campo){
		NoteBook listaNotasFilter=new NoteBook();
		switch(option){
			case "Task":
				for(int i=0;i<listNotes.size();i++){
					if(listNotes.get(i).getTask().equals(campo))
						listaNotasFilter.addNote(listNotes.get(i));
				}
			break;
			
			case "Context":
				for(int i=0;i<listNotes.size();i++){
					if(listNotes.get(i).getContext().equals(campo))
						listaNotasFilter.addNote(listNotes.get(i));
				}
			break;
			
			case "Project":
				for(int i=0;i<listNotes.size();i++){
					if(listNotes.get(i).getProject().equals(campo))
						listaNotasFilter.addNote(listNotes.get(i));
				}
			break;
		}
		return listaNotasFilter;
}
	
	public void deleteAll() {
		listNotes = new ArrayList<Note>();
		
	}
}
