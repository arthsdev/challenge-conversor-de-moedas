package br.com.conversordemoeda.conversor;

import br.com.conversordemoeda.servico.ServicoCambio;

public class ConversorMoeda {

    private ServicoCambio servicoCambio;

    public ConversorMoeda() {
        this.servicoCambio = new ServicoCambio();
    }

    public double converter(double valor, String moedaBase, String moedaDestino) throws Exception {
        double cotacao = servicoCambio.pegarCotacao(moedaBase, moedaDestino);
        return valor * cotacao;
    }
}
