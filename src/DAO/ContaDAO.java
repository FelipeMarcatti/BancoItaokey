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
import java.time.LocalDate;
import model.Conta;

/**
 *
 * @author Lucas
 */
public class ContaDAO {
    private final Connection conexao;

    public ContaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adiciona(Conta conta) {
        String insere = ("insert into conta" +"( idcliente, saldo)" + "values(?, ?)");
        //int a = Buscaconta();
        try (PreparedStatement pstmt = conexao.prepareStatement(insere)) {
            pstmt.setInt(1, conta.getIdCliente());
            pstmt.setDouble(2, conta.getSaldo());
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleta(int id) throws SQLException {
        //MovimentoContaDAO movDAO = new MovimentoContaDAO();
        //int a = BuscaId(id);
        //mov.deleta(a);
        String deleta = ("delete from conta where idcliente = ?");
        try (PreparedStatement pstmt = conexao.prepareStatement(deleta)) {        
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    public int BuscaId(int idcliente) throws SQLException {
        int a;
        try {
            PreparedStatement stmt = con.prepareStatement("Select idconta from conta where idcliente = ?");
            stmt.setInt(1, idcliente);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                a = rs.getInt("idconta");   
            }
            else
            {
                a=0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    public int Buscaconta(){
        Connection con = new ConnectionFactory().getConnection();
        int a;
        try {
            PreparedStatement stmt = con.prepareStatement("Select max(idconta) as id from conta");
            ResultSet rs = stmt.executeQuery();
            rs.next();
            a = rs.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    public Conta BuscaTudo(int idcliente){
        Conta c = new Conta();
        try {
            PreparedStatement stmt = con.prepareStatement("Select * from conta where idcliente = ?");
            stmt.setInt(1, idcliente);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            c.setIdconta(rs.getInt("idconta"));
            c.setSaldo(rs.getBigDecimal("saldo"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }
    public int sacar(int idconta ,int idcliente, BigDecimal valor) throws SQLException{
        Conta c = new Conta();
        MovimentoContaDAO m1 = new MovimentoContaDAO();
        int valida=-1;
        BigDecimal b;
        c=BuscaTudo(idcliente);
        b=c.getSaldo().subtract(valor);
        if(b.compareTo(BigDecimal.ZERO)>=0)
        {
            try{
                PreparedStatement stmt = con.prepareStatement("Update conta set saldo = ? where idcliente = ?");
                stmt.setBigDecimal(1, b);
                stmt.setInt(2, idcliente);
                stmt.execute();
                stmt.close();
                valida = 1;
            }catch(SQLException e)
            {
                throw new RuntimeException(e);
            }
        }
        return valida;
    }
    public int depositar(int idconta, int idcliente, BigDecimal valor) throws SQLException{
        Conta c = new Conta();
         MovimentoContaDAO m1 = new MovimentoContaDAO();
        c=BuscaTudo(idcliente);
        BigDecimal b = c.getSaldo().add(valor);
        try{
                PreparedStatement stmt = con.prepareStatement("Update conta set saldo = ? where idcliente = ?");
                stmt.setBigDecimal(1, b);
                stmt.setInt(2, idcliente);
                stmt.execute();
                stmt.close();
            }catch(SQLException e)
            {
                throw new RuntimeException(e);
            }
                MovimentoConta m = new MovimentoConta(idconta, true," ", b, LocalDate.now()); 
                m1.adiciona(m);
        return 1;
    }*/
}
