package br.com.conversordemoeda.servico;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ServicoCambio {

    public double pegarCotacao(String moedaBase, String moedaDestino) throws Exception {
        String urlStr = "https://api.exchangerate-api.com/v4/latest/" + moedaBase;
        URL url = new URL(urlStr);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.setRequestMethod("GET");

        int responseCode = conexao.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("Erro na requisição HTTP: " + responseCode);
        }

        BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
        StringBuilder resposta = new StringBuilder();
        String linha;

        while ((linha = leitor.readLine()) != null) {
            resposta.append(linha);
        }
        leitor.close();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(resposta.toString(), JsonObject.class);

        JsonObject taxas = jsonObject.getAsJsonObject("rates");

        if (!taxas.has(moedaDestino)) {
            throw new RuntimeException("Moeda destino não encontrada: " + moedaDestino);
        }

        return taxas.get(moedaDestino).getAsDouble();
    }
}
