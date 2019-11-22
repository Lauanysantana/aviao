/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoAviao;
import javax.swing.JOptionPane;
import modelo.Aviao;
import tela.manutencao.Manutencaoaviao;
import tela.manutencao.Manutencaoaviao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorAviao {

   public static void inserir(Manutencaoaviao man){
       Aviao objeto = new Aviao();
        objeto.setVol(Double.parseDouble(man.jtfVol.getText()));
        objeto.setMol(man.jtfMol.getText());
        objeto.setCod(Integer.parseInt(man.jtfCod.getText()));
        objeto.setCapa(Integer.parseInt(man.jtfCapa.getText()));
        objeto.setDatacons(LocalDate.parse(man.jtfDatcons.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        
        boolean resultado = DaoAviao.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

   public static void alterar(Manutencaoaviao man){
        Aviao objeto = new Aviao();
        //definir todos os atributos
        objeto.setVol(Double.parseDouble(man.jtfVol.getText()));
        objeto.setMol(man.jtfMol.getText());
        objeto.setCod(Integer.parseInt(man.jtfCod.getText()));
        objeto.setCapa(Integer.parseInt(man.jtfCapa.getText()));
        objeto.setDatacons(LocalDate.parse(man.jtfDatcons.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        boolean resultado = DaoAviao.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(Manutencaoaviao man){
        Aviao objeto = new Aviao();
        objeto.setCod(Integer.parseInt(man.jtfCod.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoAviao.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Vol");
        modelo.addColumn("Cod");
        modelo.addColumn("Mol");
        modelo.addColumn("Capa");
        modelo.addColumn("Datacons");
        List<Aviao> resultados = DaoAviao.consultar();
        for (Aviao objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCod());
            linha.add(objeto.getMol());
            linha.add(objeto.getCapa());
            linha.add(objeto.getVol());
            linha.add(objeto.getDatacons().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    public static void atualizaCampos(Manutencaoaviao man, int pk){ 
        Aviao objeto = DaoAviao.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfMol.setText(objeto.getMol().toString());
        man.jtfCapa.setText(objeto.getCapa().toString());;
        man.jtfVol.setText(objeto.getVol().toString());
        man.jtfCod.setText(objeto.getCod().toString());
        man.jtfDatcons.setText(objeto.getDatacons().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        man.jtfCod.setEnabled(false); //desabilitando o campo código
        man.BtnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
    }
    
    
    

