import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaListagem extends JPanel {

    private List<Personagem> personagens = new ArrayList<>();
    private List<Personagem> personagensExibidos = new ArrayList<>();

    private GerenciadorPersonagens gerenciador;
    private JTextField box;
    private JComboBox<String> escolha;
    private JComboBox<String> ordemCombo;

    private DefaultListModel<String> modeloLista;
    private JList<String> listaPersonagens;

    public TelaListagem(GerenciadorPersonagens gerenciador) {
        this.gerenciador = gerenciador;
        setLayout(new BorderLayout());
        montarFiltro();
        montarLista();
        montarTela();
    }

    private void montarFiltro() {
        JPanel topPanel = new JPanel();

        JLabel descricao = new JLabel("Filtro");
        box = new JTextField(12);

        JButton botaoFiltrar = new JButton("Filtrar");
        JButton botaoLimpar = new JButton("Limpar filtro");
        JButton editarBotao = new JButton("Editar selecionado");
        JButton removerBotao = new JButton("Remover selecionados");

        escolha = new JComboBox<>(new String[]{"Nome", "Classe"});
        ordemCombo = new JComboBox<>(new String[]{"Cadastro", "A-Z", "Z-A"});

        botaoFiltrar.addActionListener(e -> montarTela());
        botaoLimpar.addActionListener(e -> limparFiltro());
        editarBotao.addActionListener(e -> editarSelecionado());
        removerBotao.addActionListener(e -> removerSelecionados());
        ordemCombo.addActionListener(e -> montarTela());

        topPanel.add(descricao);
        topPanel.add(box);
        topPanel.add(escolha);

        topPanel.add(new JLabel("Ordem"));
        topPanel.add(ordemCombo);

        topPanel.add(botaoFiltrar);
        topPanel.add(botaoLimpar);
        topPanel.add(editarBotao);
        topPanel.add(removerBotao);

        add(topPanel, BorderLayout.NORTH);
    }

    private void montarLista() {
        modeloLista = new DefaultListModel<>();

        listaPersonagens = new JList<>(modeloLista);
        listaPersonagens.setFont(new Font("Arial", Font.PLAIN, 14));
        listaPersonagens.setFixedCellHeight(28);
        listaPersonagens.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane = new JScrollPane(listaPersonagens);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Personagens cadastrados"));

        add(scrollPane, BorderLayout.CENTER);
    }

    public void montarTela() {
        modeloLista.clear();
        personagensExibidos.clear();

        personagens = gerenciador.listarTodos();

        ordenarPersonagens();

        String textoFiltro = box.getText().trim().toLowerCase();
        String opcao = (String) escolha.getSelectedItem();

        for (Personagem personagem : personagens) {
            if (filtrar(personagem, textoFiltro, opcao)) {
                personagensExibidos.add(personagem);
                modeloLista.addElement(formatarPersonagem(personagem));
            }
        }

        if (modeloLista.isEmpty()) {
            modeloLista.addElement("Nenhum personagem encontrado.");
        }
    }

    private void ordenarPersonagens() {
        String ordem = (String) ordemCombo.getSelectedItem();

        if ("A-Z".equals(ordem)) {
            personagens.sort((p1, p2) -> p1.getNome().compareToIgnoreCase(p2.getNome()));
        }

        if ("Z-A".equals(ordem)) {
            personagens.sort((p1, p2) -> p2.getNome().compareToIgnoreCase(p1.getNome()));
        }
    }

    private String formatarPersonagem(Personagem personagem) {
        String texto = personagem.getNome();
        texto += " | Classe: " + personagem.getTipo();
        texto += " | Nivel: " + personagem.getNivel();
        texto += " | Vida: " + personagem.getVida();
        texto += " | Ataque: " + personagem.getAtaque();

        if (personagem instanceof Guerreiro) {
            Guerreiro guerreiro = (Guerreiro) personagem;

            texto += " | Arma: " + guerreiro.getTipoArma();
            texto += " | Forca: " + guerreiro.getForca();
            texto += " | Defesa: " + guerreiro.getDefesa();
        }

        if (personagem instanceof Mago) {
            Mago mago = (Mago) personagem;

            texto += " | Elemento: " + mago.getElemento();
            texto += " | Mana: " + mago.getMana();
            texto += " | Poder magico: " + mago.getPoderMagico();
        }

        return texto;
    }

    private boolean filtrar(Personagem personagem, String texto, String opcao) {
        if (texto.isEmpty()) {
            return true;
        }

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
        if (p.getNome().toLowerCase().contains(texto)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean filtrarPorTipo(Personagem p, String texto) {
        if (p.getTipo().toLowerCase().contains(texto)) {
            return true;
        } else {
            return false;
        }
    }

    private void limparFiltro() {
        box.setText("");
        montarTela();
    }

    private void editarSelecionado() {
        int[] indicesSelecionados = listaPersonagens.getSelectedIndices();

        if (indicesSelecionados.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione um personagem para editar.");
            return;
        }

        if (indicesSelecionados.length > 1) {
            JOptionPane.showMessageDialog(this, "Selecione apenas um personagem para editar.");
            return;
        }

        int indice = indicesSelecionados[0];

        if (indice < 0 || indice >= personagensExibidos.size()) {
            JOptionPane.showMessageDialog(this, "Nenhum personagem valido selecionado.");
            return;
        }

        Personagem personagem = personagensExibidos.get(indice);

        Window janelaPrincipal = SwingUtilities.getWindowAncestor(this);

        TelaEdicaoPersonagem telaEdicao = new TelaEdicaoPersonagem(janelaPrincipal, gerenciador, personagem);
        telaEdicao.setVisible(true);

        montarTela();
    }

    private void removerSelecionados() {
        int[] indicesSelecionados = listaPersonagens.getSelectedIndices();

        if (indicesSelecionados.length == 0) {
            JOptionPane.showMessageDialog(this, "Selecione pelo menos um personagem.");
            return;
        }

        if (personagensExibidos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum personagem valido selecionado.");
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

        for (int i = indicesSelecionados.length - 1; i >= 0; i--) {
            int indice = indicesSelecionados[i];

            if (indice >= 0 && indice < personagensExibidos.size()) {
                Personagem personagem = personagensExibidos.get(indice);
                gerenciador.removerPorNome(personagem.getNome());
            }
        }

        montarTela();

        JOptionPane.showMessageDialog(this, "Personagem(ns) removido(s) com sucesso.");
    }

}