import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class TelaEstatisticas extends JPanel {

    private GerenciadorPersonagens gerenciador;

    private JLabel[] quantidadesLabels;
    private JLabel[] somatoriosLabels;
    private JLabel[] mediasLabels;
    private JLabel[] especializacoesLabels;

    public TelaEstatisticas(GerenciadorPersonagens gerenciador) {
        this.gerenciador = gerenciador;
        montarTela();
        atualizar();
    }

    private void montarTela() {
        setLayout(new GridLayout(0, 1, 12, 12));
        setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        quantidadesLabels = adicionarBloco("Quantidades", 3);
        somatoriosLabels = adicionarBloco("Somatorios", 2);
        mediasLabels = adicionarBloco("Medias", 3);
        especializacoesLabels = adicionarBloco("Estatisticas por especializacao", 4);
    }

    private JLabel[] adicionarBloco(String titulo, int quantidadeLabels) {
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBorder(BorderFactory.createEtchedBorder());

        JLabel tituloLabel = new JLabel(titulo, SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel painelDados = new JPanel(new GridLayout(0, 1, 4, 4));

        JLabel[] labels = new JLabel[quantidadeLabels];

        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel("", SwingConstants.CENTER);
            labels[i].setFont(new Font("Arial", Font.PLAIN, 14));
            painelDados.add(labels[i]);
        }

        painelPrincipal.add(tituloLabel, BorderLayout.NORTH);
        painelPrincipal.add(painelDados, BorderLayout.CENTER);

        add(painelPrincipal);

        return labels;
    }

    public void atualizar() {
        atualizarQuantidades();
        atualizarSomatorios();
        atualizarMedias();
        atualizarEspecializacoes();
    }

    private void atualizarQuantidades() {
        quantidadesLabels[0].setText("Total de personagens: " + gerenciador.totalPersonagens());
        quantidadesLabels[1].setText("Total de guerreiros: " + gerenciador.totalGuerreiros());
        quantidadesLabels[2].setText("Total de magos: " + gerenciador.totalMagos());
    }

    private void atualizarSomatorios() {
        somatoriosLabels[0].setText("Soma das vidas: " + gerenciador.somaVidas());
        somatoriosLabels[1].setText("Soma da mana dos magos: " + gerenciador.totalManaMagos());
    }

    private void atualizarMedias() {
        mediasLabels[0].setText("Media de nivel: " + String.format("%.2f", gerenciador.mediaNivel()));
        mediasLabels[1].setText("Media de ataque: " + String.format("%.2f", gerenciador.mediaAtaque()));
        mediasLabels[2].setText("Media de defesa dos guerreiros: "
                + String.format("%.2f", gerenciador.mediaDefesaGuerreiros()));
    }

    private void atualizarEspecializacoes() {
        especializacoesLabels[0].setText("Guerreiros cadastrados: " + gerenciador.totalGuerreiros());
        especializacoesLabels[1].setText("Magos cadastrados: " + gerenciador.totalMagos());
        especializacoesLabels[2].setText("Mana total dos magos: " + gerenciador.totalManaMagos());
        especializacoesLabels[3].setText("Defesa media dos guerreiros: "
                + String.format("%.2f", gerenciador.mediaDefesaGuerreiros()));
    }

}