//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

package com.example;
import java.util.*;
import java.sql.*;

public class GerenciadorNomesBD implements GerenciadorNomes {

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        
        try {
            String pwd = "LAB03_programacaoII";
            String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres?user=postgres.iyaptczegscjtjaaevoj&password=" + pwd;

            Connection conn = DriverManager.getConnection(url);
            String query = "SELECT nome FROM nomes";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() > MAX_CARACTERES_NOMES) {
            throw new IllegalArgumentException("O nome não pode ter mais de " + MAX_CARACTERES_NOMES + " caracteres.");
        }

        try {
            String pwd = "LAB03_programacaoII";
            String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres?user=postgres.iyaptczegscjtjaaevoj&password=" + pwd;

            Connection conn = DriverManager.getConnection(url);
            String query = "INSERT INTO nomes (nome) VALUES (?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nome);
            pstmt.executeUpdate();

            System.out.println("Nome adicionado com sucesso!");

            pstmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
