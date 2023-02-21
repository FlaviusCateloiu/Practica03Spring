package api;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ClientAPI {
    static WebClient webClient = WebClient.create("http://localhost:8080");
    public static void main(String[] args) {

        Mono<Product> createdProduct = findById(101);
        createdProduct.subscribe(System.out::println);
    }

    public static Mono<Product> findById(int id)
    {
        return webClient.get()
                .uri("/product/{id}", id)
                .retrieve()
                .bodyToMono(Product.class);
    }
}
