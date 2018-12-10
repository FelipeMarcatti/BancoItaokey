/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.MovimentoConta;

/**
 *
 * @author Lucas
 */
public class MovimentoContaDAO {
    private Connection conexao;

    public MovimentoContaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void adiciona(MovimentoConta mov) throws SQLException {

        String insere = ("insert into movimentoconta"
        + "(idconta, tipomovimento, descricao, valor, data)"
        +"values(?, ?, ?, ?, ?)");
        try (PreparedStatement pstmt = conexao.prepareStatement(insere)) {
            pstmt.setInt(2, mov.getIdMovimento());
            pstmt.setBoolean(3, mov.getTipoMovimento());
            pstmt.setString(4, mov.getDescricao());
            pstmt.setDouble(5, mov.getValor());
            pstmt.setDate(6, java.sql.Date.valueOf(mov.getData()));
            
// executa
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public  int validaId() throws SQLException
    {
        
        PreparedStatement stmt = conexao.prepareStatement("Select max(id) as id from movimentoconta");
        int aux=0;
        
        ResultSet a =stmt.executeQuery();
        if(a.next()){
            aux=a.getInt("idmovimento");
        }
        else{
            aux=0;
        }
        stmt.close();
        conexao.close();
        
        return aux;
    }
    public void deleta(int id) throws SQLException{
        
        try{
        PreparedStatement stmt = conexao.prepareStatement("delete from movimentoconta where idconta = ?");
        stmt.setInt(1, id);
        stmt.execute();
        stmt.close();
        conexao.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList buscar(int idconta) throws SQLException{

        ArrayList<MovimentoConta> mov = new ArrayList<>();
        String busca = ("Select * from movimentoconta where idconta = ?");
            try (PreparedStatement pstmt = conexao.prepareStatement(busca)) {
            pstmt.setInt(1, idconta);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                MovimentoConta m = new MovimentoConta();
                m.setDescricao(rs.getString("descricao"));
                m.setTipoMovimento(rs.getBoolean("tipomovimento"));
                m.setValor(rs.getDouble("valor"));
                m.setIdMovimento(rs.getInt("idMovimentacao"));
                String data = rs.getString("data");
                if(data!=null)
                {m.setData(LocalDate.parse(data));}
                mov.add(m);
            } 
            
        return mov;
        }
    }
}
