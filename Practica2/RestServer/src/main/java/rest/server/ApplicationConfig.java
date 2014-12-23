package main.java.rest.server;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {

	/**
     * Default constructor
     */
    public ApplicationConfig() {
    	this(new NoteBook());
    }


    /**
     * Main constructor
     * @param taskList a provided ToDo list
     */
    public ApplicationConfig(final NoteBook noteBook) {
    	register(RestService.class);
    	register(MOXyJsonProvider.class);
    	register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(noteBook).to(NoteBook.class);
			}});
	}	
}
