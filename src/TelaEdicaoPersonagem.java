import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;

public class TelaEdicaoPersonagem extends JDialog {

    private GerenciadorPersonagens gerenciador;
    private Personagem personagem;

    private JTextField nomeCampo;
    private JSpinner nivelCampo;

    private JComboBox<Armas> armaCombo;
    private JSpinner forcaCampo;
    private JSpinner defesaCampo;

    private JComboBox<ElementoMagico> elementoCombo;
    private JSpinner manaCampo;
    private JSpinner poderMagicoCampo;

    public TelaEdicaoPersonagem(Window janelaPrincipal, GerenciadorPersonagens gerenciador, Personagem personagem) {
        super(janelaPrincipal, "Editar personagem", Dialog.ModalityType.APPLICATION_MODAL);

        this.gerenciador = gerenciador;
        this.personagem = personagem;

        montarTela();

        pack();
        setMinimumSize(new Dimension(450, 320));
        setLocationRelativeTo(janelaPrincipal);
    }

    private void montarTela() {
        JPanel painel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int linha = 0;

        adicionarCampo(painel, gbc, linha, "Classe", new JLabel(personagem.getTipo()));
        linha++;

        nomeCampo = new JTextField(personagem.getNome(), 24);
        adicionarCampo(painel, gbc, linha, "Nome", nomeCampo);
        linha++;

        nivelCampo = new JSpinner(new SpinnerNumberModel(personagem.getNivel(), 1, 100, 1));
        adicionarCampo(painel, gbc, linha, "Nivel", nivelCampo);
        linha++;

        JLabel avisoLabel = new JLabel("Vida e ataque sao atualizados automaticamente pelo nivel.");
        adicionarCampo(painel, gbc, linha, "Aviso", avisoLabel);
        linha++;

        if (personagem instanceof Guerreiro) {
            Guerreiro guerreiro = (Guerreiro) personagem;

            armaCombo = new JComboBox<>(Armas.values());
            armaCombo.setSelectedItem(guerreiro.getTipoArma());

            forcaCampo = new JSpinner(new SpinnerNumberModel(guerreiro.getForca(), 0, 999, 1));
            defesaCampo = new JSpinner(new SpinnerNumberModel(guerreiro.getDefesa(), 0, 999, 1));

            adicionarCampo(painel, gbc, linha, "Arma", armaCombo);
            linha++;

            adicionarCampo(painel, gbc, linha, "Forca", forcaCampo);
            linha++;

            adicionarCampo(painel, gbc, linha, "Defesa", defesaCampo);
            linha++;
        }

        if (personagem instanceof Mago) {
            Mago mago = (Mago) personagem;

            elementoCombo = new JComboBox<>(ElementoMagico.values());
            elementoCombo.setSelectedItem(mago.getElemento());

            manaCampo = new JSpinner(new SpinnerNumberModel(mago.getMana(), 0, 999, 1));
            poderMagicoCampo = new JSpinner(new SpinnerNumberModel(mago.getPoderMagico(), 0, 999, 1));

            adicionarCampo(painel, gbc, linha, "Elemento", elementoCombo);
            linha++;

            adicionarCampo(painel, gbc, linha, "Mana", manaCampo);
            linha++;

            adicionarCampo(painel, gbc, linha, "Poder magico", poderMagicoCampo);
            linha++;
        }

        JPanel painelBotoes = new JPanel();

        JButton salvarBotao = new JButton("Salvar");
        JButton cancelarBotao = new JButton("Cancelar");

        salvarBotao.addActionListener(e -> salvar());
        cancelarBotao.addActionListener(e -> dispose());

        painelBotoes.add(salvarBotao);
        painelBotoes.add(cancelarBotao);

        gbc.gridx = 0;
        gbc.gridy = linha;
        gbc.gridwidth = 2;

        painel.add(painelBotoes, gbc);

        add(painel, BorderLayout.CENTER);
    }

    private void adicionarCampo(JPanel painel, GridBagConstraints gbc, int linha, String texto, Component campo) {
        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = linha;
        painel.add(new JLabel(texto), gbc);

        gbc.gridx = 1;
        painel.add(campo, gbc);
    }

    private void salvar() {
        String nome = nomeCampo.getText().trim();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o nome do personagem.");
            return;
        }

        if (!nome.equalsIgnoreCase(personagem.getNome()) && gerenciador.nomeJaExiste(nome)) {
            JOptionPane.showMessageDialog(this, "Ja existe um personagem cadastrado com esse nome.");
            return;
        }

        personagem.setNome(nome);
        personagem.setNivel((int) nivelCampo.getValue());

        if (personagem instanceof Guerreiro) {
            Guerreiro guerreiro = (Guerreiro) personagem;

            guerreiro.setTipoArma((Armas) armaCombo.getSelectedItem());
            guerreiro.setForca((int) forcaCampo.getValue());
            guerreiro.setDefesa((int) defesaCampo.getValue());
        }

        if (personagem instanceof Mago) {
            Mago mago = (Mago) personagem;

            mago.setElemento((ElementoMagico) elementoCombo.getSelectedItem());
            mago.setMana((int) manaCampo.getValue());
            mago.setPoderMagico((int) poderMagicoCampo.getValue());
        }

        JOptionPane.showMessageDialog(this, "Personagem editado com sucesso.");
        dispose();
    }

}