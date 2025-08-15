package com.exemplo.conversor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class main {

    // 6 opções fixas de conversão (taxas de exemplo). Ajuste se desejar.
    enum Opcao {
        BRL_PARA_USD("BRL → USD", new BigDecimal("0.18")),
        USD_PARA_BRL("USD → BRL", new BigDecimal("5.55")),
        BRL_PARA_EUR("BRL → EUR", new BigDecimal("0.16")),
        EUR_PARA_BRL("EUR → BRL", new BigDecimal("6.20")),
        BRL_PARA_ARS("BRL → ARS", new BigDecimal("54.00")),
        ARS_PARA_BRL("ARS → BRL", new BigDecimal("0.0185"));

        private final String rotulo;
        private final BigDecimal taxa; // multiplicador

        Opcao(String rotulo, BigDecimal taxa) {
            this.rotulo = rotulo;
            this.taxa = taxa;
        }

        public BigDecimal converter(BigDecimal valor) {
            return valor.multiply(taxa);
        }

        public String rotulo() {
            return rotulo;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("===============================");
        System.out.println(" Conversor de Moedas (6 opções) ");
        System.out.println("===============================\n");

        while (true) {
            mostrarMenu();
            int escolha = lerOpcao(sc);
            if (escolha == 0) {
                System.out.println("Saindo... Até logo!");
                break;
            }

            Opcao opcao = Opcao.values()[escolha - 1];
            System.out.println("\nSelecionado: " + opcao.rotulo());
            System.out.print("Digite o valor a converter: ");
            BigDecimal valor = lerValor(sc);

            BigDecimal convertido = opcao.converter(valor).setScale(2, RoundingMode.HALF_UP);
            System.out.println("Resultado: " + opcao.rotulo() + "  " + fmt(valor) + " => " + fmt(convertido) + "\n");
        }
    }

    private static void mostrarMenu() {
        System.out.println("Escolha uma opção:");
        for (int i = 0; i < Opcao.values().length; i++) {
            System.out.printf("%d) %s%n", i + 1, Opcao.values()[i].rotulo());
        }
        System.out.println("0) Sair");
        System.out.print("> ");
    }

    private static int lerOpcao(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= 0 && valor <= Opcao.values().length) {
                    return valor;
                }
            } catch (NumberFormatException ignored) { }
            System.out.print("Opção inválida. Tente novamente: ");
        }
    }

    private static BigDecimal lerValor(Scanner sc) {
        while (true) {
            String entrada = sc.nextLine().trim().replace(",", "."); // aceita vírgula
            try {
                BigDecimal valor = new BigDecimal(entrada);
                if (valor.compareTo(BigDecimal.ZERO) >= 0) {
                    return valor;
                }
            } catch (NumberFormatException ignored) { }
            System.out.print("Valor inválido. Digite novamente: ");
        }
    }

    private static String fmt(BigDecimal v) {
        return v.setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}