import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TelaEdicao extends JPanel {

    private List<Personagem> personagens = new ArrayList<>();
    private GerenciadorPersonagens gerenciador;
    private JTextField box;
    private JPanel listaPersonagens;
    private JComboBox<String> escolha;

    public TelaEdicao(GerenciadorPersonagens gerenciador ){

        this.gerenciador = gerenciador;
        //this.personagens = gerenciador.listarTodos();
        montarFiltro();
        montarTela();
    }

    private void montarFiltro() {
        JPanel topPanel = new JPanel();
        JLabel descricao = new JLabel("Nome");
        box = new JTextField(10);
        JButton botao = new JButton("Filtrar");


        botao.addActionListener(e -> montarTela());
        escolha = new JComboBox<>(new String[]{"Nome", "Classe"});
        topPanel.add(descricao);
        topPanel.add(box);
        topPanel.add(botao);
        topPanel.add(escolha);
        add(topPanel, BorderLayout.NORTH);

        listaPersonagens = new JPanel(new GridLayout(0, 1, 8, 8));
        add(listaPersonagens, BorderLayout.CENTER);
    }

    public void montarTela() {

        listaPersonagens.removeAll();

        personagens = gerenciador.listarTodos();
        String textoFiltro = box.getText().trim().toLowerCase();
        String opcao = (String) escolha.getSelectedItem();

        //botao = new JButton("Filtrar");

        personagens.stream()
                .filter(p -> filtrar(p, textoFiltro, opcao))
                .map(p -> new JLabel(p.toString()))
                .forEach(listaPersonagens::add);

               setLayout(new GridLayout(0, 1, 8, 8));


        listaPersonagens.revalidate();
        listaPersonagens.repaint();
    }


    private boolean filtrar(Personagem personagem, String texto, String opcao) {


        switch (opcao) {

            case "Nome":
                return filtrarPorNome(personagem, texto);


            case "Classe":
                return filtraPorTipo(personagem, texto);



            default:
                return true;
        }
    }


    private boolean filtrarPorNome(Personagem p, String texto) {
        if (p.getNome().toLowerCase().contains(texto)){

            return true;

        }
        else{
            return false;
        }
    }

    private boolean filtraPorTipo(Personagem p, String texto) {
        if (p.getTipo().toLowerCase().contains(texto)){

            return true;

        }
        else{
            return false;
        }
    }




}
