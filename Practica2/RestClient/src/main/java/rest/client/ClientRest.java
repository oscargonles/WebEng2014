package main.java.rest.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import main.java.rest.note.*;

@WebServlet(urlPatterns = { "/hi" })

public class ClientRest extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		Client client = ClientBuilder.newClient();
		String option=request.getParameter("menu");
		try{
		String task = request.getParameter("task");
		String context = request.getParameter("context");
		String proyect = request.getParameter("proyect");
		String prio=request.getParameter("priority");
		
		if(prio!=null){
			int priority = Integer.parseInt(prio);
			Note note=new Note();
			note.setTask(task);
			note.setContext(context);
			note.setProject(proyect);
			note.setPriority(priority);
			Gson gson=new Gson();
			String note2=gson.toJson(note);
			Response response= null;
			response=client.target("http://localhost:8082/list")
			.request(MediaType.APPLICATION_JSON)
			.post(Entity.entity(note2, MediaType.APPLICATION_JSON));
			System.out.println(response);
		}
		
		}catch(NullPointerException e){}
		if(option!=null){
			System.out.println(option);
			String campo=request.getParameter("campo");
			String boton=request.getParameter("submit");
			System.out.println("Boton: "+boton);
			if(boton!=null){
				if(boton.equals("Borrar todo")){ System.out.println(ClientBuilder.newClient()
						.target("http://localhost:8082/list").request(MediaType.APPLICATION_JSON)
						.delete().readEntity(String.class));
				}
				else{
					System.out.println(ClientBuilder.newClient()
						.target("http://localhost:8082/list/note/{option}/{campo}")
						.resolveTemplate("option", option)
						.resolveTemplate("campo", campo).request(MediaType.APPLICATION_JSON)
						.delete().readEntity(String.class));
				}
			}
			else{
				boton=request.getParameter("submit2");
				campo=request.getParameter("campo");
				if(boton.equals("Aceptar Filter")) {
					Response response= client.target("http://localhost:8082/list/filterNote/{option}/{campo}")
						.resolveTemplate("option", option)
						.resolveTemplate("campo", campo).request(MediaType.APPLICATION_JSON)
						.get();
					NoteBook listaNotas=response.readEntity(NoteBook.class);
					String todasNotas=Print(listaNotas);;
					resp.setContentType("text/html");
					RequestDispatcher dispatch = request.getRequestDispatcher("listNotes.jsp");
					request.setAttribute("listNotes", todasNotas);
					dispatch.forward(request, resp);
				}
			}
		}
			
			Response response= client.target("http://localhost:8082/list")
					.request(MediaType.APPLICATION_JSON)
					.get();
			NoteBook listaNotas=response.readEntity(NoteBook.class);
			String todasNotas="";
			if(listaNotas!=null)
				todasNotas=Print(listaNotas);
			resp.setContentType("text/html");
			
		RequestDispatcher dispatch = request.getRequestDispatcher("listNotes.jsp");
		request.setAttribute("listNotes", todasNotas);
		dispatch.forward(request, resp);
		
	}

	
	
	public String Print(NoteBook noteBook) {
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


