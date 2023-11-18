package br.com.fagoc.jpa;

import Controller.ContatoController;
import Service.ContatoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import Service.FabricaConexao;
import model.ContatoClass;
import view.TelaPrincipal;

public class JPA {

    public static void main(String[] args) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("UP1");
        //System.out.println("FIM!");

        //Instancia a tela
        var Tela = new TelaPrincipal();

        //Define ela ao centro
        Tela.setLocationRelativeTo(null);

        //Define o titulo da janela
        Tela.setTitle("Agenda de Contatos");

        // Impedir o redimensionamento do JFrame
        Tela.setResizable(false);

        Tela.setVisible(true);

    }
}
