package br.com.prova;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class ExProva1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> historico = new Stack<>();
        carregarHistorico(historico, "C:\\Users\\12114376\\Downloads\\Prova\\Lista_URL.txt");

        while (true) {
            System.out.println("Opções:");
            System.out.println("1 - Excluir um link");
            System.out.println("2 - Consultar um link");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o link para excluir: ");
                    String linkParaExcluir = scanner.nextLine();
                    if (historico.remove(linkParaExcluir)) {
                        System.out.println("Link excluído com sucesso!");
                    } else {
                        System.out.println("Link não encontrado.");
                    }
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.print("Digite o link para consultar: ");
                    String linkParaConsultar = scanner.nextLine();
                    if (historico.contains(linkParaConsultar)) {
                        System.out.println("Link Encontrado");
                    } else {
                        System.out.println("Link Não Encontrado");
                    }
                    System.out.println(" ");
                    break;
                case 3:
                    salvarHistorico(historico, "C:\\Users\\12114376\\Downloads\\Prova\\Lista_URL.txt");
                    System.out.println("Programa encerrado.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println("Histórico de Links:");
            for (String link : historico) {
                System.out.println(link);

            }
        }
    }

    public static void carregarHistorico(Stack<String> historico, String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                historico.push(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o histórico: " + e.getMessage());
        }
    }

    public static void salvarHistorico(Stack<String> historico, String arquivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            for (String link : historico) {
                pw.println(link);
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar o histórico: " + e.getMessage());
        }
    }
}
