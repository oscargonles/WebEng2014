package main.java.rest.server;

import java.net.URI;

public class Note {

	/*public Note(int id, String task, String context, String project, int priority,URI href) {
		this.href=href;
		this.id=id;
		this.task = task;
		this.context = context;
		this.project = project;
		this.priority = priority;
	}*/
	
	private String task,context,project;
	
	private int priority, id;
	private URI href;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public URI getHref() {
		return href;
	}
	public void setHref(URI href) {
		this.href = href;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Note [task=" + task + ", context=" + context + ", project="
				+ project + ", priority=" + priority + "]";
	}
}
