package project.web;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.PrintWriter;

public class IndexHttpHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange exchange) throws IOException {

		String s = "<a href='/registration'>Registration</a><br><a href='/login'>Log In</a>";

		exchange.sendResponseHeaders(200, s.length());

		PrintWriter printWriter = new PrintWriter(exchange.getResponseBody());
		printWriter.print(s);
		printWriter.flush();

	}

}
