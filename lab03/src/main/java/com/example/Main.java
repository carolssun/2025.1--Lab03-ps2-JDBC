//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

package com.example;
public class Main {
    public static void main(String[] args) {
      GerenciadorNomes gNomes = new GerenciadorNomesMem();
      Ihm ihm = new Ihm(gNomes);
      ihm.dialogar();
 } }