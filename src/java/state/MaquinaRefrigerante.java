
/** Contexto do padrão State: mantém o estado e encaminha as operações. */
public class MaquinaRefrigerante {
    private EstadoMaquina estado;

    public MaquinaRefrigerante() {
        this.estado = new SemMoeda();
    }

    void alterarEstado(EstadoMaquina novoEstado) {
        this.estado = novoEstado;
    }

    public String inserirMoeda() {
        return estado.inserirMoeda(this);
    }

    public String selecionarProduto() {
        return estado.selecionarProduto(this);
    }

    public String retirarProduto() {
        return estado.retirarProduto(this);
    }

    public String devolverMoeda() {
        return estado.devolverMoeda(this);
    }

    public String estadoAtual() {
        return estado.nome();
    }
}
