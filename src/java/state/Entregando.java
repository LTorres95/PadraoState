public class Entregando implements EstadoMaquina {
    @Override
    public String inserirMoeda(MaquinaRefrigerante maquina) {
        return "Aguarde a entrega antes de inserir outra moeda.";
    }

    @Override
    public String selecionarProduto(MaquinaRefrigerante maquina) {
        return "Aguarde: já existe uma seleção em andamento.";
    }

    @Override
    public String retirarProduto(MaquinaRefrigerante maquina) {
        maquina.alterarEstado(new SemMoeda());
        return "Produto entregue. Obrigado!";
    }

    @Override
    public String devolverMoeda(MaquinaRefrigerante maquina) {
        return "A moeda já foi usada na compra.";
    }

    @Override
    public String nome() {
        return "Entregando";
    }
}
