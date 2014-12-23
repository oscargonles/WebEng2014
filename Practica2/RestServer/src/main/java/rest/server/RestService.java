package main.java.rest.server;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;




@Path("/list")
public class RestService {
	
	@Inject
	NoteBook gestionNotas;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public NoteBook getListNotes() {
		return gestionNotas;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addNote(@Context UriInfo info, Note note) {
		System.out.println("dentro");
		gestionNotas.addNote(note);
		note.setHref(info.getAbsolutePathBuilder().path("/note/{id}").build(note.getID()));
		
		return Response.created(note.getHref()).entity(note).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteNoteList() {
		gestionNotas.deleteAll();
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/note/{option}/{campo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteNote(@PathParam("option") String option, @PathParam("campo") String campo) {
		System.out.println("Delete: "+option+ " con valor: "+campo );
		gestionNotas.deleteFilterNote(option, campo);
		return Response.noContent().build();
	}
	
	
	@GET
	@Path("/filterNote/{option}/{campo}")
	@Produces(MediaType.APPLICATION_JSON)
	public NoteBook filterNote(@PathParam("option") String option, @PathParam("campo") String campo) {
		return  gestionNotas.FilterNote(option, campo);
	}
	

}