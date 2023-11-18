package Controller;

import Service.ContatoService;
import Service.FabricaConexao;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import model.ContatoClass;

public class ContatoController {

    public static void salvar(String[] dados) {

        EntityManager em = FabricaConexao.getConexao();
        ContatoService contatoService = new ContatoService(em);

        String codigo = dados[3];

        ContatoClass contato = new ContatoClass();
        contato.arrayTo(dados);

        if (codigo.equals("0")) {

            contatoService.inserir(contato);

        } else {
            contatoService.editar(contato);
        }
    }

    public static void deletar(String[] dados) {
        EntityManager em = FabricaConexao.getConexao();
        ContatoService contatoService = new ContatoService(em);

        ContatoClass contato = new ContatoClass();
        contato.arrayTo(dados);

        if (contato.getCodigo() == 0) {
            System.out.println("Codigo para exclusão não informado!");
        } else {
            contatoService.deletar(contato);

        }

    }

    public static String[] recuperar(int codigo) {

        EntityManager em = FabricaConexao.getConexao();
        ContatoService contatoService = new ContatoService(em);

        ContatoClass objContato = contatoService.buscaPorCodigo(codigo);

        return objContato.toArray();

    }

    public static String[][] recuperarTodos() {
        EntityManager em = FabricaConexao.getConexao();
        ContatoService contatoService = new ContatoService(em);

        ArrayList<ContatoClass> listaContatos = contatoService.listar();

        String[][] data = new String[listaContatos.size()][];

        for (int i = 0; i < listaContatos.size(); i++) {
            ContatoClass contato = listaContatos.get(i);
            data[i] = new String[]{
                contato.getNome(),
                contato.getTipoContato(),
                String.valueOf(contato.getIsFavorito()), // Converte o valor booleano para string
                String.valueOf(contato.getCodigo())
            };
        }

        return data;

    }

}
