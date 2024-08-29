import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// 3 metodos = consomeAPI/BuscaCEP/ReceHorario

public class BuscaEndere {
    public static class ConsomeApi {
        public String responseHttp(String url) throws IOException, InterruptedException {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        public String retornaEnd(int cep) throws IOException, InterruptedException {
            return this.responseHttp("https://viacep.com.br/ws/" + cep + "/json/");
        }
        public String retornaHorario() throws IOException, InterruptedException {
            return this.responseHttp("https://worldtimeapi.org/api/timezone/America/Sao_Paulo");
        }
    }
}