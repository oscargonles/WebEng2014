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
public class DeleteNote {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected ... " + session.getId());
		try {
			System.out.println("Borrando: "+DeleteServlet.optionDeleteNote+","+DeleteServlet.campoDeleteNote);
			session.getBasicRemote().sendText("delete: " + DeleteServlet.optionDeleteNote+","+DeleteServlet.campoDeleteNote);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		String op = message.split(": ")[0];
		logger.info("Received ...." + message);
		switch (op) {
		case "delete":
			DeleteServlet.status = "OK";
			break;
		default:
			DeleteServlet.status = "500: Internal Server Error";
			break;
		}
		DeleteServlet.response = message.split(": ")[1];
		return message;
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		logger.info(String.format("Session %s close because of %s",
				session.getId(), closeReason));
	}
}
