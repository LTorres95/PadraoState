public interface EstadoMaquina {
    String inserirMoeda(MaquinaRefrigerante maquina);

    String selecionarProduto(MaquinaRefrigerante maquina);

    String retirarProduto(MaquinaRefrigerante maquina);

    String devolverMoeda(MaquinaRefrigerante maquina);

    String nome();
}
