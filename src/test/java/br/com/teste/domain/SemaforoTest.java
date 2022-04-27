package br.com.teste.domain;

import br.com.teste.domain.Semaforo;
import br.com.teste.enums.StatusSemaforoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SemaforoTest {

    @Test
    void deve_iniciar_com_status_parametrizavel() {

        Semaforo semaforo = new Semaforo(StatusSemaforoEnum.AMARELO);

        Assertions.assertEquals(StatusSemaforoEnum.AMARELO, semaforo.statusAtualSemaforo());
    }

    @Test
    void deveTrocarStatusSemaforoParaVermelho_QuandoSolicitado() {
        Semaforo semaforo = new Semaforo(StatusSemaforoEnum.AMARELO);

        semaforo = semaforo.proximoStatusSemaforo();

        Assertions.assertEquals(StatusSemaforoEnum.VERMELHO, semaforo.statusAtualSemaforo());
    }

    @Test
    void deveTrocarStatusSemaforoParaVerde_QuandoSolicitadoDuasVezes() {
        Semaforo semaforo = new Semaforo(StatusSemaforoEnum.AMARELO);

        semaforo = semaforo.proximoStatusSemaforo();
        semaforo = semaforo.proximoStatusSemaforo();

        Assertions.assertEquals(StatusSemaforoEnum.VERDE, semaforo.statusAtualSemaforo());
    }
}
