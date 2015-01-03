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


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/delete" })

public class DeleteServlet extends HttpServlet {

	static String addNote;
	static String listNote;
	static String status;
	static String response;
	static String optionDeleteNote,campoDeleteNote;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String todasNotas="";
		String option=request.getParameter("menu");
		if(option!=null){
			System.out.println(option);
			String campo=request.getParameter("campo");
			String boton=request.getParameter("submit");
			System.out.println("Boton: "+boton);
			
			if(boton!=null){
				if(boton.equals("Borrar todo")){ optionDeleteNote="todo"; campoDeleteNote="nada";}
				else{ optionDeleteNote=option; campoDeleteNote=campo;}
				ClientManager client=ClientManager.createClient();
				try {
					client.connectToServer(DeleteNote.class, new URI("ws://localhost:8025/notes/message"));
				} catch (DeploymentException | URISyntaxException e) {
					e.printStackTrace();
				}

			
			}
			RequestDispatcher dispatch = request.getRequestDispatcher("listNotes.jsp");
			request.setAttribute("listNotes", todasNotas);
			dispatch.forward(request, resp);
		}
		
		
			
		
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

