package service.client;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class ListNotes {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected ... " + session.getId());
		try {
			System.out.println("listar: "+ListServlet.optionListNote+","+ListServlet.campoListNote);
			session.getBasicRemote().sendText("listar: "+ListServlet.optionListNote+","+ListServlet.campoListNote);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		String op = message.split(": ")[0];
		logger.info("Received ...." + message);
		switch (op) {
		case "listar":
			ListServlet.listNote = message.split(": ")[1];
			break;
		}
		ListServlet.latch.countDown();
		return message;
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		logger.info(String.format("Session %s close because of %s",
				session.getId(), closeReason));
		ListServlet.latch.countDown();
	}
}
