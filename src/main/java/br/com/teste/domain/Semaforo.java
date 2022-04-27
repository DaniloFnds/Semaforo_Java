package br.com.teste.domain;

import br.com.teste.enums.StatusSemaforoEnum;

public final class Semaforo {
    private final StatusSemaforoEnum statusSemaforo;

    public Semaforo(StatusSemaforoEnum statusSemaforo) {
        this.statusSemaforo = statusSemaforo;
    }

    public StatusSemaforoEnum statusAtualSemaforo() {
        return this.statusSemaforo;
    }

    public boolean isEstadoInicial() {
        return StatusSemaforoEnum.AMARELO.equals(this.statusSemaforo);
    }

    public Semaforo proximoStatusSemaforo() {
         return new Semaforo(this.statusSemaforo.proximo());
    }

    public long tempoExecucao() {
        return this.statusSemaforo.getTempoExecucao();
    }
}
