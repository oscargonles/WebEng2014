package main.java.ServerWebSockets.server;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.server.ServerEndpoint;

import main.java.ServerWebSockets.common.GestionNote;
import main.java.ServerWebSockets.common.ListNotes;
import main.java.ServerWebSockets.common.Note;
import main.java.ServerWebSockets.common.NoteBook;

import com.google.gson.Gson;




@ServerEndpoint(value = "/message")
public class WebSocketsService {

	private GestionNote gestionNote=new GestionNote();
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected ... " + session.getId());
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		String op = message.split(": ")[0];
		Gson gson = new Gson();
		boolean status = false;
		String response = op + ": ";
		//System.out.println("Mensaje: "+message);
		switch (op) {
		case "quit":
			try {
				session.close(new CloseReason(CloseCodes.NORMAL_CLOSURE,
						"Service ended"));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			break;
		case "add":
			try{
				Note note = gson.fromJson(message.split(": ")[1], Note.class);
				status = addToDo(note);
				if (status) response += "Task added succesfully";
				else response += "Error adding the task";
			} catch (Exception e){
				response += op + "Error during the operation";
			}
			break;
		case "delete":
			try{
				message=message.split(": ")[1];
				String tipo = gson.fromJson(message.split(",")[0], String.class);
				String campo = gson.fromJson(message.split(",")[1], String.class);
				System.out.println("Borrar: "+tipo+","+campo);
			    deleteNote(tipo,campo);
			    
			} catch (Exception e){
				response += "Error during the operation";
			}
			break;
		case "listar":
			try{
				message=message.split(": ")[1];
				String tipo = gson.fromJson(message.split(",")[0], String.class);
				String campo = gson.fromJson(message.split(",")[1], String.class);
				if(tipo.equals("todo")) response +=listarNotas();
				else response+=listarNotas(tipo,campo);
				
			} catch (Exception e){
				response += "Error during the operation";
			}
			break;
		}
		session.getAsyncRemote().sendText(response);
		return response;
	}
	
	private String listarNotas(String tipo, String campo) {
		System.out.println("listar: "+tipo+","+campo);
		ListNotes list=new ListNotes();
		Gson gson=new Gson();
		return gson.toJson(list.listaNotasFilter(tipo,campo)); 
	}

	private void deleteNote(String tipo,String campo) {
		System.out.println("Borrar: "+tipo+","+campo);
		gestionNote.deleteNote(tipo, campo);
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		logger.info(String.format("Session %s closed because of %s",
				session.getId(), closeReason));
	}
	
	@OnError
	public void onError(Session session, Throwable t){
		logger.info(String.format("Session %s closed because an error",
				session.getId()));
	}
	
	private String listarNotas(){
		ListNotes list=new ListNotes();
		Gson gson=new Gson();
		return gson.toJson(list.listaNotas());
	}
	
	
	private boolean addToDo(Note note){
		try{
			gestionNote.addNotes(note);
			return true;
		} catch (Exception e){
			logger.log(Level.SEVERE, e.toString(), e);
			return false;
		}
	}
	
	/*
	private ToDoList getTasks(){
		ToDoList todos = null;
		Gson gson = new Gson();
		try {
			todos = gson.fromJson(new FileReader(DEFAULT_FILE_NAME), 
					ToDoList.class);
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, e.toString(), e);
		}
		return todos;
	}
	
	private boolean setTasks(ToDoList todos){
		FileWriter output;
		Gson gson = new Gson();
		try {
			output = new FileWriter(DEFAULT_FILE_NAME);
			output.write(gson.toJson(todos));
			output.close();
			return true;
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.toString(), e);
		}
		return false;
	}
	
	
	
	private boolean deleteToDo(ToDo t){
		boolean find = false;
		try{
			ToDoList todos = getTasks();
			find = todos.deleteToDo(t);
			setTasks(todos);
			return find;
		} catch (Exception e){
			logger.log(Level.SEVERE, e.toString(), e);
			return find;
		}
	}
	
	private String listToDos(){
		try{
			ToDoList todos = getTasks();
			Gson gson = new Gson();
			return gson.toJson(todos);
		}catch (Exception e){
			logger.log(Level.SEVERE, e.toString(), e);
			return "";
		}
	}*/
}