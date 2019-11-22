/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Aviao;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class DaoAviao {
   public static boolean inserir(Aviao objeto) {
        String sql = "INSERT INTO aviao (vol, mol, cod, capa, datacons) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setDouble(1, objeto.getVol());
            ps.setString(2, objeto.getMol());
            ps.setInt(3, objeto.getCod());
            ps.setInt(4, objeto.getCapa());
            ps.setDate(5, Date.valueOf(objeto.getDatacons()));
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Aviao objeto = new Aviao();
        objeto.setVol(15.2);
        objeto.setCod(123);
        objeto.setMol("LauanyTour");
        objeto.setCapa(15);
        objeto.setDatacons(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy"))); 

        
        
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
      public static boolean alterar(Aviao objeto) {
        String sql = "UPDATE aviao SET vol = ?, cod = ?, mol = ?, capa = ?, datacons = ? WHERE cod=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setDouble(1, objeto.getVol());
            ps.setString(2, objeto.getMol());
            ps.setInt(3, objeto.getCapa());
            ps.setDate(4, Date.valueOf(objeto.getDatacons()));
            ps.setInt(5, objeto.getCod());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       public static boolean excluir(Aviao objeto) {
        String sql = "DELETE FROM produto WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCod());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
       
public static List<Aviao> consultar() {
        List<Aviao> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT vol, cod, mol, capa, datacons FROM aviao";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aviao objeto = new Aviao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCod(rs.getInt("Cod"));
                objeto.setMol(rs.getString("Mol"));
                objeto.setCapa(rs.getInt("Capa"));
                objeto.setVol(rs.getDouble("Vol"));
                objeto.setDatacons(rs.getDate("Datacons").toLocalDate());
               
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
}
public static Aviao consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT cod, vol, capa, datacons, mol FROM aviao WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Aviao objeto = new Aviao();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCod(rs.getInt("Cod"));
                objeto.setMol(rs.getString("Mol"));
                objeto.setCapa(rs.getInt("Capa"));
                objeto.setVol(rs.getDouble("Vol"));
                objeto.setDatacons(rs.getDate("Datacons").toLocalDate());
                
                
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
