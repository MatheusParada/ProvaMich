package br.com.prova;
import java.util.Scanner;

public class ExProva2 {
    public static void main(String[] args) {
        int N = 2;
        int[][] estante = new int[N][N];
        String[] produto = {"vazio", "xampu", "condicionador", "hidratante", "tintura", "demaquilante"};
        int[] contador = new int[6];
        int i, j;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Considere os seguintes produtos e seus códigos: ");
        System.out.println("1: xampu;");
        System.out.println("2: condicionador;");
        System.out.println("3: hidratante;");
        System.out.println("4: tintura;");
        System.out.println("5: demaquilante;");
        System.out.println("0: vazio");
        System.out.printf("Adicione %d produtos na estante informando seu código\n", N * N);

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                System.out.print("Forneça código: ");
                int codigo = scanner.nextInt();
                if (codigo > 5 || codigo < 0) {
                    System.out.println("ATENÇÃO: Código de produto inválido");
                    j--;
                } else {
                    estante[i][j] = codigo;
                }
            }
        }

        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                contador[estante[i][j]]++;
            }
        }

        for (i = 1; i <= 5; i++) {
            System.out.printf("Produto %s possui %d caixas na estante.\n", produto[i], contador[i]);
        }
    }
}
