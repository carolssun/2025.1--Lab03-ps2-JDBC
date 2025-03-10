//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

package com.example;
import java.util.*;
public class GerenciadorNomesMem implements GerenciadorNomes {
  private List<String> nomes = new ArrayList<String>();
  @Override
  public List<String> obterNomes() {
    return nomes;
  }
  @Override
  public void adicionarNome(String nome) {
    nomes.add(nome);
  }
}