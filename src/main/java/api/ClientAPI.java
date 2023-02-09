package api;

import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ClientAPI {
    static WebClient webClient = WebClient.create("http://localhost:8080");
    public static void main(String[] args) {

        Mono<Product> createdProduct = findById(1);


    }

    public static Mono<Product> findById(Integer id)
    {
        return webClient.get()
                .uri("/product/" + id)
                .retrieve()
                /*.onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
                        clientResponse -> Mono.empty())*/
                .bodyToMono(Product.class);
    }
}
