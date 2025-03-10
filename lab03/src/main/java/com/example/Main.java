//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

// package com.example;
// public class Main {
//     public static void main(String[] args) {
//       GerenciadorNomes gNomes = new GerenciadorNomesMem();
//       Ihm ihm = new Ihm(gNomes);
//       ihm.dialogar();
//  } }

package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a implementação:");
        System.out.println("1 - Em Memória");
        System.out.println("2 - Banco de Dados");
        int escolha = scanner.nextInt();

        GerenciadorNomes gNomes;
        
        if (escolha == 1) {
            gNomes = new GerenciadorNomesMem();
        } else {
            gNomes = new GerenciadorNomesBD();
        }

        Ihm ihm = new Ihm(gNomes);
        ihm.dialogar();

        scanner.close();
    }
}