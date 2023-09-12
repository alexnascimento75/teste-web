// Nome do Pacote
package apiTest;

// Bibliotecas
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

// Classe
public  class testeUser {
// Atributos
// Funções e Métodos
// Funções de Apoio
    public static String lerArquivoJson(String arquivoJson) throws IOException {
       return new String(Files.readAllBytes(Paths.get(arquivoJson)));

    }

@Test
    public void testarIncluirUser() throws IOException {
// Carregar os Dados do Json
    String jsonBody = lerArquivoJson("src/test/resources/json/user1.json");
    String userId = "1372633669";

// Realizar o Ieste
    given()                                                        // Dado que
            .contentType("application/json")           // o tipo do conteúdo
            .log().all()                                        // mostre tudo
            .body(jsonBody)                             // corpo da requisição
            .when()                                                  // Quando
            .post("https://petstore.swagger.io/v2/user")  // Endpoint/ Onde
            .then()                                                   // Então
            .log().all()                             // mostre tudo no retorno
            .statusCode(200)                    // Comunicação - ida e volta
            .body("code", is(200))                   // Tag Code é 200
            .body("type", is("unknown"))         // Tag type é unknowm
            .body("message", is(userId))
    ;

    }
}