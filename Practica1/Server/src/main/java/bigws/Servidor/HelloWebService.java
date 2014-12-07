package bigws.Servidor;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class HelloWebService {
	
	
	@WebMethod()
	public void addNote(Note note){
		GestionNote gestionNote=new GestionNote();
		gestionNote.addNotes(note);
		
	}
	@WebMethod()
	public String listaNotas()  {
		ListNotes list=new ListNotes();
		return list.listaNotas();
	}
	@WebMethod()
	public void deleteNote(String tipo,String campo) {
		GestionNote gestionNote=new GestionNote();
		gestionNote.deleteNote(tipo,campo);
	}
	@WebMethod()
	public String listaNotasFilter(String option, String campo){
		ListNotes list=new ListNotes();
		return list.listaNotasFilter(option, campo);
	}
	@WebMethod()
	public void showAll(){}
}
