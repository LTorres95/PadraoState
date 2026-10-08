public class SemMoeda implements EstadoMaquina {
    @Override
    public String inserirMoeda(MaquinaRefrigerante maquina) {
        maquina.alterarEstado(new ComMoeda());
        return "Moeda inserida.";
    }

    @Override
    public String selecionarProduto(MaquinaRefrigerante maquina) {
        return "Insira uma moeda antes de selecionar.";
    }

    @Override
    public String retirarProduto(MaquinaRefrigerante maquina) {
        return "Não há produto para retirar.";
    }

    @Override
    public String devolverMoeda(MaquinaRefrigerante maquina) {
        return "Não há moeda para devolver.";
    }

    @Override
    public String nome() {
        return "SemMoeda";
    }
}
