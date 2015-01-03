package service.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.websocket.DeploymentException;

import service.note.Note;
import service.note.NoteBook;

import org.glassfish.tyrus.client.ClientManager;

import com.google.gson.Gson;



@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/hi" })

public class GestionServlet extends HttpServlet {

	static String addNote;
	static String listNote;
	static String status;
	static String response;
	static String optionDeleteNote,campoDeleteNote;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String todasNotas="";
		try{
		String task = request.getParameter("task");
		String context = request.getParameter("context");
		String proyect = request.getParameter("proyect");
		String prio=request.getParameter("priority");
		
		if(prio!=null){
			Gson gson=new Gson();
			int priority = Integer.parseInt(prio);
			Note note=new Note();
			note.setTask(task);
			note.setContext(context);
			note.setProject(proyect);
			note.setPriority(priority);
			addNote=gson.toJson(note);
			ClientManager client=ClientManager.createClient();
			client.connectToServer(AddNote.class, new URI("ws://localhost:8025/notes/message"));
		}
		
		}catch(NullPointerException | DeploymentException | URISyntaxException e){ e.printStackTrace();}
		/*if(option!=null){
			System.out.println(option);
			String campo=request.getParameter("campo");
			String boton=request.getParameter("submit");
			System.out.println("Boton: "+boton);
			
			if(boton!=null){
				if(boton.equals("Borrar todo")){ optionDeleteNote="todo"; campoDeleteNote="";}
				else{ optionDeleteNote=option; campoDeleteNote=campo;}
				ClientManager client=ClientManager.createClient();
				try {
					client.connectToServer(DeleteNote.class, new URI("ws://localhost:8025/notes/message"));
				} catch (DeploymentException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				boton=request.getParameter("submit2");
				campo=request.getParameter("campo");
				
				if(boton.equals("Lista completa")){
					try {
						Gson gson=new Gson();
						ClientManager client=ClientManager.createClient();
						client.connectToServer(ListNotes.class, new URI("ws://localhost:8025/notes/message"));
						resp.setStatus(HttpServletResponse.SC_OK);
						NoteBook noteBook=gson.fromJson(listNote, NoteBook.class);
						
						if(noteBook!=null)
							todasNotas=Print(noteBook);
						System.out.println("Lista notas:"+todasNotas+noteBook);
						
					} catch (DeploymentException  | URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(boton.equals("Aceptar Filter")) {
					String todasNotas=hws.listaNotasFilter(option,campo);
					resp.setContentType("text/html");
					RequestDispatcher dispatch = request.getRequestDispatcher("listNotes.jsp");
					request.setAttribute("listNotes", todasNotas);
					dispatch.forward(request, resp);
				}
			}
			
		}*/
		RequestDispatcher dispatch = request.getRequestDispatcher("listNotes.jsp");
		request.setAttribute("listNotes", todasNotas);
		dispatch.forward(request, resp);
			
			
		
	}

	public static String Print(NoteBook noteBook) {
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
}

