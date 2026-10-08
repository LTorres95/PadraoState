import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaquinaRefrigeranteTest {

    @Test
    void iniciaSemMoedaERecusaOperacoesQueExigemPagamento() {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        assertEquals("SemMoeda", maquina.estadoAtual());
        assertEquals("Insira uma moeda antes de selecionar.", maquina.selecionarProduto());
        assertEquals("Não há produto para retirar.", maquina.retirarProduto());
        assertEquals("Não há moeda para devolver.", maquina.devolverMoeda());
        assertEquals("SemMoeda", maquina.estadoAtual());
    }

    @Test
    void inserirMoedaLevaAoEstadoComMoedaEImpedeUmaSegundaMoeda() {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        assertEquals("Moeda inserida.", maquina.inserirMoeda());
        assertEquals("ComMoeda", maquina.estadoAtual());
        assertEquals("A máquina já tem uma moeda.", maquina.inserirMoeda());
        assertEquals("ComMoeda", maquina.estadoAtual());
    }

    @Test
    void estadoComMoedaPermiteSelecionarOuDevolverMoeda() {
        MaquinaRefrigerante compra = new MaquinaRefrigerante();
        compra.inserirMoeda();

        assertEquals("Selecione um produto antes de retirar.", compra.retirarProduto());
        assertEquals("Produto selecionado. Preparando entrega.", compra.selecionarProduto());
        assertEquals("Entregando", compra.estadoAtual());

        MaquinaRefrigerante reembolso = new MaquinaRefrigerante();
        reembolso.inserirMoeda();
        assertEquals("Moeda devolvida.", reembolso.devolverMoeda());
        assertEquals("SemMoeda", reembolso.estadoAtual());
    }

    @Test
    void estadoEntregandoRecusaNovasOperacoesAteEntregarProduto() {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();
        maquina.inserirMoeda();
        maquina.selecionarProduto();

        assertEquals("Aguarde a entrega antes de inserir outra moeda.", maquina.inserirMoeda());
        assertEquals("Aguarde: já existe uma seleção em andamento.", maquina.selecionarProduto());
        assertEquals("A moeda já foi usada na compra.", maquina.devolverMoeda());
        assertEquals("Entregando", maquina.estadoAtual());
        assertEquals("Produto entregue. Obrigado!", maquina.retirarProduto());
        assertEquals("SemMoeda", maquina.estadoAtual());
    }

    @Test
    void permiteRealizarDuasComprasEmSequencia() {
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();

        maquina.inserirMoeda();
        maquina.selecionarProduto();
        maquina.retirarProduto();
        assertEquals("SemMoeda", maquina.estadoAtual());

        maquina.inserirMoeda();
        maquina.selecionarProduto();
        maquina.retirarProduto();
        assertEquals("SemMoeda", maquina.estadoAtual());
    }
}
