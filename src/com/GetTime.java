package com;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetTime {
    public static String get() {
        // Создаем HTTP-клиент
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // Создаем HTTP-запрос
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://timeapi.io/api/TimeZone/zone?timeZone=Europe/Moscow"))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();

        try {
            // Отправляем запрос и получаем ответ
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Проверяем статус ответа
            if (response.statusCode() == 200) {
                // Парсим JSON-ответ
                ObjectMapper mapper = new ObjectMapper();
                JsonNode jsonNode = mapper.readTree(response.body());
                //Ответ сервера: {"timeZone":"Europe/Moscow","currentLocalTime":"2026-04-26T01:02:07.0325851","currentUtcOffset":{"seconds":10800,"milliseconds":10800000,"ticks":108000000000,"nanoseconds":10800000000000},"standardUtcOffset":{"seconds":10800,"milliseconds":10800000,"ticks":108000000000,"nanoseconds":10800000000000},"hasDayLightSaving":false,"isDayLightSavingActive":false,"dstInterval":null}
                // Извлекаем строку с текущим временем
                return jsonNode.get("currentLocalTime").asText();
                // Выводим результат
                //System.out.println("Текущее время: " + datetimeStr);
            } else {
                System.out.println("Ошибка запроса. Код статуса: " + response.statusCode());
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
