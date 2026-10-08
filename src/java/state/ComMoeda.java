public class ComMoeda implements EstadoMaquina {
    @Override
    public String inserirMoeda(MaquinaRefrigerante maquina) {
        return "A máquina já tem uma moeda.";
    }

    @Override
    public String selecionarProduto(MaquinaRefrigerante maquina) {
        maquina.alterarEstado(new Entregando());
        return "Produto selecionado. Preparando entrega.";
    }

    @Override
    public String retirarProduto(MaquinaRefrigerante maquina) {
        return "Selecione um produto antes de retirar.";
    }

    @Override
    public String devolverMoeda(MaquinaRefrigerante maquina) {
        maquina.alterarEstado(new SemMoeda());
        return "Moeda devolvida.";
    }

    @Override
    public String nome() {
        return "ComMoeda";
    }
}
