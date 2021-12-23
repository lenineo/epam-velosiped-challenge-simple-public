package dev.abarmin.velosiped.task1;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String rowParams = exchange.getRequestURI().getQuery();
        if (rowParams.isEmpty()) {
            returnInputInvalid(exchange);
        }
        Map<String, Integer> paramsMap = queryParamsToMap(rowParams);
        Integer result = calculate(paramsMap.get("a"), paramsMap.get("b"));
        exchange.setAttribute("Content-Type", "text/html");
        exchange.sendResponseHeaders(200, result.toString().length());
        OutputStream os = exchange.getResponseBody();
        os.write(result.toString().getBytes());
        os.close();
    }

    private void returnInputInvalid(HttpExchange exchange) throws IOException {
        String invalidInput = "Invalid input";
        exchange.setAttribute("Content-Type", "text/html");
        exchange.sendResponseHeaders(500, invalidInput.length());
        OutputStream os = exchange.getResponseBody();
        os.write(invalidInput.getBytes());
        os.close();
    }

    public Map<String, Integer> queryParamsToMap(String query) {
        if (query == null) {
            return null;
        }
        Map<String, Integer> result = new HashMap<>();
        Arrays.stream(query.split("&")).map(param -> param.split("=")).forEach(entry -> {
            if (entry.length > 1) {
                result.put(entry[0], Integer.valueOf(entry[1]));
            } else {
                result.put(entry[0], 0);
            }
        });
        return result;
    }

    private boolean isParamsNumeric(Object o) {

        if ((o instanceof Integer)) return false;

        return true;
    }

    private Integer calculate(int a, int b) {
        return a + b;
    }

}
