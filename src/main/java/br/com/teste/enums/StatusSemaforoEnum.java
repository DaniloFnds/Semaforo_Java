package br.com.teste.enums;

public enum StatusSemaforoEnum {
    AMARELO(0, 10),
    VERMELHO(1, 40),
    VERDE(2, 60);

    final int ordemSemaforo;
    final long tempoExecucacao;

    StatusSemaforoEnum(int ordemSemaforo, long tempoExecucacao) {
        this.ordemSemaforo = ordemSemaforo;
        this.tempoExecucacao = tempoExecucacao;
    }

    public StatusSemaforoEnum proximo() {
        return getStatusSemaforoPelaOrdem(this.ordemSemaforo+1);
    }

    private StatusSemaforoEnum getStatusSemaforoPelaOrdem(int ordemSemaforo) {
        int ultimaOrdem = StatusSemaforoEnum.values().length; //MOSTRAR A QUIESTAO DE NAO TESTAR TODOS OS CENARIOS, FALTANDO O -1 aqui,
        // PQ O LENGTH RETORNA O TAMANHO( 3 ) E SE PASSAR VERDE PARA
        // INICIAR VAI DAR ERRO
        if(ordemSemaforo > ultimaOrdem) {
            ordemSemaforo--;
        }
        return StatusSemaforoEnum.values()[ordemSemaforo];
    }

    public long getTempoExecucao() {
        return tempoExecucacao;
    }
}
