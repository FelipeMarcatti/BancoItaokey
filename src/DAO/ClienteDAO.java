/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;

/**
 *
 * @author Alunos
 */
public class ClienteDAO {
    private final Connection conexao;

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Cliente cliente) {
        try {
            String insercao = "INSERT INTO Cliente (nome, cpf, datanascimento, senha) VALUES (?, ?, ?, ?);";
            try (PreparedStatement pstmt = conexao.prepareStatement(insercao)) {
                pstmt.setString(1, cliente.getNome());
                pstmt.setString(2, cliente.getCpf());
                pstmt.setDate(3, java.sql.Date.valueOf(cliente.getDataNasc()));           
                pstmt.setString(4, cliente.getSenha()); 
                
                
                int resultado = pstmt.executeUpdate();
                if (resultado == 1) {
                    System.out.println("\nInserção bem sucedida.");
                } else {
                    System.out.println("A inserção não foi feita corretamente.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    public void alterar(Cliente cliente) {
        try {

            String alteracao = "UPDATE cliente WHERE idcliente = ? SET nome = ?, cpf = ?, dataNascimento = ?, senha = ?;";
            try (PreparedStatement pstmt = conexao.prepareStatement(alteracao)) {
                pstmt.setInt(1, cliente.getIdCliente());
                pstmt.setString(2, cliente.getNome());
                pstmt.setString(3, cliente.getCpf());
                pstmt.setDate(4, java.sql.Date.valueOf(cliente.getDataNasc()));    
                pstmt.setString(5, cliente.getSenha());
                int alteracoes = pstmt.executeUpdate();
                if (alteracoes == 1) {
                    System.out.println("\nAlteracao do cliente realizada com sucesso.");
                } else {
                    System.out.println("Alteracao nao realizada.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }
    
    public void remover(int id) {
        try {
            String remocao = "DELETE FROM cliente WHERE idcliente = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(remocao)) {
                pstmt.setInt(1, id);
                int remocoes = pstmt.executeUpdate();
                if (remocoes == 1) {
                    System.out.println("Remoção realizada com sucesso.");
                } else {
                    System.out.println("Não foi possível realizar a remoção.");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }
    
     public Cliente mostrar(int id) {
        Cliente cliente = null;
        try {
            String selecao = "SELECT * FROM cliente WHERE id = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
                pstmt.setLong(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        cliente = new Cliente();
                        cliente.setNome(rs.getString(1));
                        cliente.setCpf(rs.getString(2));
                        cliente.setDataNasc(rs.getDate(3).toLocalDate());     
                        cliente.setSenha(rs.getString(4));   
                        cliente.setIdCliente(rs.getInt(5));

                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return cliente;
    }
    
    
    public List<Cliente> mostrarTodos() {
        Cliente cliente;
        List<Cliente> c = new ArrayList<Cliente>();
        try {
            String selecao = "SELECT * FROM cliente";
            try (Statement stmt = conexao.createStatement()) {
                try (ResultSet rs = stmt.executeQuery(selecao)) {
                    while (rs.next()) {
                        cliente = new Cliente();
                        cliente.setNome(rs.getString(1));
                        cliente.setCpf(rs.getString(2));
                        cliente.setDataNasc(rs.getDate(3).toLocalDate());   
                        cliente.setSenha(rs.getString(4)); 
                        cliente.setIdCliente(rs.getInt(5));
                        c.add(cliente);
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return c;
    }

    

   

    
    public boolean checkLogin(String cpf, String senha) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = this.conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ? and senha = ?");
            stmt.setString(1, cpf);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //this.conexao.closeConnection(this.conexao, stmt, rs);
        }

        return check;

    }
    public boolean checkCpf(String cpf) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = this.conexao.prepareStatement("SELECT * FROM cliente WHERE cpf = ?");
            stmt.setString(1, cpf);
            

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //this.conexao.closeConnection(this.conexao, stmt, rs);
        }

        return check;

    }
  /*  public boolean checkRg(String rg) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = this.conexao.prepareStatement("SELECT * FROM cliente WHERE rg = ?");
            stmt.setString(1, rg);
            

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //this.conexao.closeConnection(this.conexao, stmt, rs);
        }

        return check;

    }*/
    public Cliente procurar(String cpf) {
        Cliente cliente = null;
        try {
            String selecao = "SELECT * FROM cliente WHERE cpf = ?";
            try (PreparedStatement pstmt = conexao.prepareStatement(selecao)) {
                pstmt.setString(1, cpf);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        cliente = new Cliente();
                        cliente.setNome(rs.getString(1));
                        cliente.setCpf(rs.getString(2));
                        cliente.setDataNasc(rs.getDate(3).toLocalDate());                        
                        cliente.setSenha(rs.getString(4));
                        cliente.setIdCliente(rs.getInt(5));

                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erro no acesso ao banco de dados.");
            while (ex != null) {
                System.out.println("SQL State: " + ex.getSQLState());
                System.out.println("Mensagem: " + ex.getMessage());
                System.out.println("Error Code: " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
        return cliente;
    }
    
}
