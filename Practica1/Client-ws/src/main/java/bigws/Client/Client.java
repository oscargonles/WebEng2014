package bigws.Client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import bigws.servidor.*;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/hi" })

public class Client extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		SoapWebServiceService hwss = new SoapWebServiceService();
		SoapWebService hws = hwss.getSoapWebServicePort();
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
			hws.addNote(note);
		}
		
		}catch(NullPointerException e){}
		if(option!=null){
			System.out.println(option);
			String campo=request.getParameter("campo");
			String boton=request.getParameter("submit");
			System.out.println("Boton: "+boton);
			if(boton!=null){
				if(boton.equals("Borrar todo")) option="todo";
				hws.deleteNote(option, campo);
			}
			else{
				boton=request.getParameter("submit2");
				campo=request.getParameter("campo");
				if(boton.equals("Lista completa")) hws.showAll();
				else if(boton.equals("Aceptar Filter")) {
					NoteBook noteBookFilter=hws.listaNotasFilter(option,campo);
					String todasNotas=PrintFilter(noteBookFilter,option,campo);
					resp.setContentType("text/html");
					RequestDispatcher dispatch = request.getRequestDispatcher("listNotes.jsp");
					request.setAttribute("listNotes", todasNotas);
					dispatch.forward(request, resp);
				}
			}
		}
			NoteBook listNotes=hws.listaNotas();
			String todasNotas=Print(listNotes);
			resp.setContentType("text/html");
			RequestDispatcher dispatch = request.getRequestDispatcher("listNotes.jsp");
			request.setAttribute("listNotes", todasNotas);
			dispatch.forward(request, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
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
	
	public String PrintFilter(NoteBook noteBook, String option,String campo){
		String resultado="";
		int numNotas=1;
		for (Note note : noteBook.getListNotes()) {
			switch(option){
				case "Task":
					if(note.getTask().equals(campo)){
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
					break;
				case "Project":
					if(note.getProject().equals(campo)){
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
					break;
					
				case "Context":
					if(note.getContext().equals(campo)){
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
					break;
			}
			
			
			
		}
		return resultado;
	}
}

