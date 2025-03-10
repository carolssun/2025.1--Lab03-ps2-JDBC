//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

package com.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executar = true;

        while (executar) {
            System.out.println("Escolha o tipo de armazenamento:");
            System.out.println("(1) Memória");
            System.out.println("(2) Banco de Dados");
            System.out.println("(3) Sair");
            System.out.print("Opção: ");
            String escolha = scanner.nextLine();

            GerenciadorNomes gNomes = null;

            switch (escolha) {
                case "1":
                    gNomes = new GerenciadorNomesMem();
                    break;
                case "2":
                    gNomes = new GerenciadorNomesBD();
                    break;
                case "3":
                    System.out.println("Saindo do programa...");
                    executar = false;
                    continue;  // Volta ao início do loop sem executar `Ihm`
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    continue;
            }

            Ihm ihm = new Ihm(gNomes);
            ihm.dialogar();
        }
        scanner.close();
    }
}
