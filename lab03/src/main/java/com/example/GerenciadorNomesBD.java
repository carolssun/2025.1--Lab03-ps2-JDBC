//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesBD implements GerenciadorNomes {
    private static final String URL = "jdbc:postgresql://db.bedgzwuehkovsemomtdf.supabase.co:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "LAB03_progracaoII";

    public GerenciadorNomesBD() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS nomes (id SERIAL PRIMARY KEY, nome VARCHAR(" + MAX_CARACTERES_NOMES + "))";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM nomes";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() > MAX_CARACTERES_NOMES) {
            System.out.println("Erro: Nome excede o limite de " + MAX_CARACTERES_NOMES + " caracteres.");
            return;
        }
        String sql = "INSERT INTO nomes (nome) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

