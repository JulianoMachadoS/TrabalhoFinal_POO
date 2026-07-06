import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TelaListagem extends JPanel {

    private List<Personagem> personagens = new ArrayList<>();
    private List<JCheckBox> caixasSelecao = new ArrayList<>();

    private GerenciadorPersonagens gerenciador;
    private JTextField box;
    private JPanel listaPersonagens;
    private JComboBox<String> escolha;

    public TelaListagem(GerenciadorPersonagens gerenciador ){

        this.gerenciador = gerenciador;
        setLayout(new BorderLayout());
        montarFiltro();
        montarTela();
    }

    private void montarFiltro() {
        JPanel topPanel = new JPanel();

        JLabel descricao = new JLabel("Filtro");
        box = new JTextField(10);

        JButton botao = new JButton("Filtrar");
        JButton removerBotao = new JButton("Remover selecionados");

        escolha = new JComboBox<>(new String[]{"Nome", "Classe"});

        botao.addActionListener(e -> montarTela());
        removerBotao.addActionListener(e -> removerSelecionados());

        topPanel.add(descricao);
        topPanel.add(box);
        topPanel.add(botao);
        topPanel.add(escolha);
        topPanel.add(removerBotao);

        add(topPanel, BorderLayout.NORTH);

        listaPersonagens = new JPanel(new GridLayout(0, 1, 8, 8));
        add(listaPersonagens, BorderLayout.CENTER);
    }

    public void montarTela() {

        listaPersonagens.removeAll();
        caixasSelecao.clear();

        personagens = gerenciador.listarTodos();
        String textoFiltro = box.getText().trim().toLowerCase();
        String opcao = (String) escolha.getSelectedItem();

        for (Personagem personagem : personagens) {
            if (filtrar(personagem, textoFiltro, opcao)) {
                JCheckBox checkBox = new JCheckBox(personagem.toString() + personagem.getDadosEspecificos());

                checkBox.putClientProperty("personagem", personagem);

                caixasSelecao.add(checkBox);
                listaPersonagens.add(checkBox);
            }
        }

        listaPersonagens.revalidate();
        listaPersonagens.repaint();
    }


    private boolean filtrar(Personagem personagem, String texto, String opcao) {


        switch (opcao) {

            case "Nome":
                return filtrarPorNome(personagem, texto);


            case "Classe":
                return filtrarPorTipo(personagem, texto);

            default:
                return true;
        }
    }


    private boolean filtrarPorNome(Personagem p, String texto) {
        if (p.getNome().toLowerCase().contains(texto)){

            return true;
        } else {
            return false;
        }
    }

    private boolean filtrarPorTipo(Personagem p, String texto) {
        if (p.getTipo().toLowerCase().contains(texto)){
            return true;
        } else {
            return false;
        }
    }

    private List<Personagem> getPersonagensSelecionados() {
        List<Personagem> selecionados = new ArrayList<>();

        for (JCheckBox checkBox : caixasSelecao) {
            if (checkBox.isSelected()) {
                Personagem personagem = (Personagem) checkBox.getClientProperty("personagem");
                selecionados.add(personagem);
            }
        }

        return selecionados;
    }

    private void removerSelecionados() {
        List<Personagem> selecionados = getPersonagensSelecionados();

        if (selecionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos um personagem.");
            return;
        }

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja remover os personagens selecionados?",
                "Confirmar remocao",
                JOptionPane.YES_NO_OPTION
        );

        if (resposta != JOptionPane.YES_OPTION) {
            return;
        }

        for (Personagem personagem : selecionados) {
            gerenciador.removerPorNome(personagem.getNome());
        }

        montarTela();

        JOptionPane.showMessageDialog(this, "Personagem(ns) removido(s) com sucesso.");
    }

}