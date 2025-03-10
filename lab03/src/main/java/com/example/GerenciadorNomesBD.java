//Carolina sun Ramos Nantes de Castilho - 10386494
//Millie Talala Zogheib - 10443653

package com.example;
import java.util.*;
import java.sql.*;

public class GerenciadorNomesBD implements GerenciadorNomes {
    try {
        String pwd = "LAB03_programacaoII";
        String url = "jdbc:postgresql://aws-0-sa-east-1.pooler.supabase.com:5432/postgres?user=postgres.iyaptczegscjtjaaevoj&password=" + pwd;
  
        Connection conn = DriverManager.getConnection(url);

        Scanner entrada = new Scanner(System.in);
        System.out.print("Informe o numero da conta: ");
        int nroConta = Integer.parseInt(entrada.nextLine());

        String query = "select * from contas where nro_conta = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, nroConta);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            System.out.print(rs.getInt("nro_conta"));
            System.out.print(" - ");
            System.out.println(rs.getDouble("saldo"));
        }

    } catch(Exception ex) {
        ex.printStackTrace();
    }
      
}
