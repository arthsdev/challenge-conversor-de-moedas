package br.com.conversordemoeda.principal;

import br.com.conversordemoeda.conversor.ConversorMoeda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ConversorMoeda conversor = new ConversorMoeda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha a conversão:");
            System.out.println("1 - Dólar para Real");
            System.out.println("2 - Real para Dólar");
            System.out.println("3 - Euro para Real");
            System.out.println("4 - Real para Euro");
            System.out.println("5 - Libra Esterlina para Real");
            System.out.println("6 - Real para Libra Esterlina");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            if (opcao == 0) {
                System.out.println("Saindo...");
                break;
            }

            System.out.print("Digite o valor a converter: ");
            double valor = scanner.nextDouble();

            try {
                double resultado = 0.0;

                switch (opcao) {
                    case 1:
                        resultado = conversor.converter(valor, "USD", "BRL");
                        System.out.printf("USD %.2f = BRL %.2f%n", valor, resultado);
                        break;
                    case 2:
                        resultado = conversor.converter(valor, "BRL", "USD");
                        System.out.printf("BRL %.2f = USD %.2f%n", valor, resultado);
                        break;
                    case 3:
                        resultado = conversor.converter(valor, "EUR", "BRL");
                        System.out.printf("EUR %.2f = BRL %.2f%n", valor, resultado);
                        break;
                    case 4:
                        resultado = conversor.converter(valor, "BRL", "EUR");
                        System.out.printf("BRL %.2f = EUR %.2f%n", valor, resultado);
                        break;
                    case 5:
                        resultado = conversor.converter(valor, "GBP", "BRL");
                        System.out.printf("GBP %.2f = BRL %.2f%n", valor, resultado);
                        break;
                    case 6:
                        resultado = conversor.converter(valor, "BRL", "GBP");
                        System.out.printf("BRL %.2f = GBP %.2f%n", valor, resultado);
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro na conversão: " + e.getMessage());
            }

            System.out.println();
        }

        scanner.close();
    }
}
