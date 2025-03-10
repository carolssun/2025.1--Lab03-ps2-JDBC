//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

package com.example;
import java.util.List;
 public interface GerenciadorNomes {
   int MAX_CARACTERES_NOMES = 20;
   List<String> obterNomes();
   void adicionarNome(String nome);
}
 