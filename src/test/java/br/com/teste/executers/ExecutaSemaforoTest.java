package br.com.teste.executers;

import br.com.teste.domain.Semaforo;
import br.com.teste.enums.StatusSemaforoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class ExecutaSemaforoTest {
    @Test
    void deveExecutarUmSemaforo_QuandoStatusEhInicial() {
        ExecutaSemaforo executaSemaforo = new ExecutaSemaforo(new Semaforo(StatusSemaforoEnum.AMARELO));

        Assertions.assertTrue(executaSemaforo.semaforoEmEstadoInicial());
    }

    @Test
    void naoDeveExecutarUmSemaforo_QuandoStatusNaoEhInicial() {
        ExecutaSemaforo executaSemaforo = new ExecutaSemaforo(new Semaforo(StatusSemaforoEnum.VERDE));

        Assertions.assertFalse(executaSemaforo.semaforoEmEstadoInicial());
    }

    @Test
    void deveMudarStatusSemaforo_QuandoAtingirTempo() throws InterruptedException {
        Semaforo semaforo = new Semaforo(StatusSemaforoEnum.AMARELO);
        ExecutaSemaforo executaSemaforo = new ExecutaSemaforo(semaforo);

        Thread thread = new Thread(executaSemaforo::inicia);
        thread.start();
        Thread.sleep(TimeUnit.SECONDS.toMillis(15));
        thread.interrupt();
        Assertions.assertEquals(StatusSemaforoEnum.VERMELHO, executaSemaforo.statusAtualSemaforo());
    }
}
