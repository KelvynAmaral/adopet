package br.com.adopet.service;

import br.com.adopet.client.ClientHttpConfiguration;
import br.com.adopet.domain.Pet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PetServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private PetService petService = new PetService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Pet pet = new Pet();

    @Test
    public void deveVerificarSeDispararRequisicaoGetSeraChamado() throws IOException, InterruptedException {
        pet.setId(0L);
        when(response.body()).thenReturn("[{"+pet.toString()+"}]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);
        String excepectedAbrigosCadastados = "Pets Cadastrados:";
        String expectedIdENome = "0 - Pet Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        petService.listarPetsDoAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualPetsDoAbrigo = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(excepectedAbrigosCadastados, actualPetsDoAbrigo);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }

}
