package project.web;

import project.model.Operation;
import project.service.OperationService;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class OperationHttpHandler implements HttpHandler {

	private final OperationService operationService = new OperationService();

	@Override
	public void handle(HttpExchange exchange) throws IOException {

		String query = exchange.getRequestURI().getQuery(); //localhost:8080/calculate?num1=2&num2=2&type=sum
		String[] parameters = query.split("&");
		Map<String, String> map=new HashMap<>();

        for (String parameter : parameters) {

            String[] p = parameter.split("=");
            String key = p[0];
            String value = p[1];
            map.put(key, value);

        }

		double num1 = Double.parseDouble(map.get("num1"));
		double num2 = Double.parseDouble(map.get("num2"));
		String type = map.get("type");

		Operation operation = new Operation(num1, num2, type);
		Operation calculate = operationService.calculate(operation);
		double result = calculate.getResult();
		String s="Result = " + result;

		exchange.sendResponseHeaders(200, s.length());

		PrintWriter printWriter = new PrintWriter(exchange.getResponseBody());
		printWriter.print(s);
		printWriter.flush();

	}

}
