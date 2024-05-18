package ru.vsu.putinpa.simplecode.service;

import org.springframework.stereotype.Service;
import ru.vsu.putinpa.simplecode.model.TaskRun;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class JobeInABoxService {
    public void runs(TaskRun runSpec) {
        try (var client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://jobe/jobe/index.php/restapi/runs"))
                    .timeout(Duration.ofSeconds(10))
                    .header("Content-Type", "application/json; charset-utf-8")
                    .POST(HttpRequest.BodyPublishers.ofString("""
                            {
                                "run_spec": {
                                    "language_id": "java",
                                    "sourcecode": "public class Main {\\n public static void main(String ...args) {System.out.println(5 / 0);}\\n}\\n"
                                }
                            }""")).build();
            var responseFuture = client.sendAsync(
                    request, HttpResponse.BodyHandlers.ofString());
            var response = responseFuture.thenApply(HttpResponse::body).thenAccept(System.out::println);
        }
    }
}
