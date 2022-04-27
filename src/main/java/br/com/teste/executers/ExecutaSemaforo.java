package br.com.teste.executers;

import br.com.teste.domain.Semaforo;
import br.com.teste.enums.StatusSemaforoEnum;

import java.util.concurrent.TimeUnit;

public class ExecutaSemaforo {
    private Semaforo semaforo;

    public ExecutaSemaforo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    public boolean semaforoEmEstadoInicial() {
        return this.semaforo.isEstadoInicial();
    }

    public void inicia() {
        boolean statusExecucao = true;
        while (statusExecucao) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(this.semaforo.tempoExecucao()));
                this.semaforo = this.semaforo.proximoStatusSemaforo();
            } catch (InterruptedException e) {
                statusExecucao = false;
            }
        }
    }

    public StatusSemaforoEnum statusAtualSemaforo() {
        return this.semaforo.statusAtualSemaforo();
    }
}
