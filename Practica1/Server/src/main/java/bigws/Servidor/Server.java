package bigws.Servidor;

import javax.xml.ws.Endpoint;

public class Server {
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8083/Servidor", new SoapWebService());
	}

}
