package br.com.adopet.service;

import br.com.adopet.client.ClientHttpConfiguration;
import br.com.adopet.domain.Abrigo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.http.HttpResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AbrigoServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private AbrigoService abrigoService = new AbrigoService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);
    private Abrigo abrigo = new Abrigo("Abrigo Teste", "999999999", "kelvyn.candido@gmail.com");

    @Test
    public void deveVerificarSeDispararRequisicaoGetSeraChamado() throws IOException, InterruptedException {
        abrigo.setId(0L);
        when(response.body()).thenReturn("[{"+abrigo.toString()+"}]");
        when(client.dispararRequisicaoGet(anyString())).thenReturn(response);
        String excepectedAbrigosCadastados = "Abrigos cadastrados:";
        String expectedIdENome = "0 - Abrigo Teste";

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        abrigoService.listarAbrigo();

        String[] lines = baos.toString().split(System.lineSeparator());
        String actualAbrigosCadastados = lines[0];
        String actualIdENome = lines[1];

        Assertions.assertEquals(excepectedAbrigosCadastados, actualAbrigosCadastados);
        Assertions.assertEquals(expectedIdENome, actualIdENome);
    }

}
