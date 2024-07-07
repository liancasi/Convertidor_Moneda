import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ConsultaMoneda {
    private static final String API_KEY = "0999466bcf73c712b599fc81";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/USD";
    private List<Moneda> historial = new ArrayList<>();
    private List<String> monedasDisponibles;

    public ConsultaMoneda() {
        monedasDisponibles = obtenerListaMonedas();
    }

    public Moneda convertirMoneda(double valor, String monedaOrigen, String monedaDestino) {
        double tasaCambio = obtenerTasaCambio(monedaOrigen, monedaDestino);
        double valorConvertido = valor * tasaCambio;
        Moneda resultado = new Moneda(valor, monedaOrigen, valorConvertido, monedaDestino);
        historial.add(resultado);
        return resultado;
    }

    private double obtenerTasaCambio(String monedaOrigen, String monedaDestino) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            double tasaOrigen = conversionRates.get(monedaOrigen).getAsDouble();
            double tasaDestino = conversionRates.get(monedaDestino).getAsDouble();

            return tasaDestino / tasaOrigen;
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0;
        }
    }

    public List<Moneda> obtenerHistorial() {
        return new ArrayList<>(historial);
    }

    public List<String> obtenerMonedasDisponibles() {
        return new ArrayList<>(monedasDisponibles);
    }

    private List<String> obtenerListaMonedas() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            return new ArrayList<>(conversionRates.keySet());
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de monedas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
