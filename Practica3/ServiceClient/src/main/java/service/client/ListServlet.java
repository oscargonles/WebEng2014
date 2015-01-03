package service.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

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
@WebServlet(urlPatterns = { "/listar" })

public class ListServlet extends HttpServlet {

	static String listNote;
	static String response;
	static String optionListNote,campoListNote;
	static CountDownLatch latch;
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		String todasNotas="";
		String option=request.getParameter("menu");
		latch=new CountDownLatch(1);
		
		if(option!=null){
			System.out.println(option);
			String boton=request.getParameter("submit");
			System.out.println("Boton: "+boton);
			String campo=request.getParameter("campo");
			if(boton==null){
				boton=request.getParameter("submit2");
				if(boton.equals("Lista completa")){
					try {
						optionListNote="todo";
						campoListNote="nada";
						Gson gson=new Gson();
						ClientManager client=ClientManager.createClient();
						client.connectToServer(ListNotes.class, new URI("ws://localhost:8025/notes/message"));
						latch.await();
						NoteBook noteBook=gson.fromJson(listNote, NoteBook.class);
						
						if(noteBook!=null)
							todasNotas=Print(noteBook);
						
					} catch (DeploymentException  | URISyntaxException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(boton.equals("Aceptar Filter")) {
					optionListNote=option;
					campoListNote=campo;
					ClientManager client=ClientManager.createClient();
					try {
						Gson gson=new Gson();
						client.connectToServer(ListNotes.class, new URI("ws://localhost:8025/notes/message"));
						latch.await();
						NoteBook noteBook=gson.fromJson(listNote, NoteBook.class);
						if(noteBook!=null)
							todasNotas=Print(noteBook);
					} catch (DeploymentException | URISyntaxException | InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
			
		resp.setContentType("text/html");
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

