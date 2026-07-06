import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class TelaEstatisticas extends JPanel {

    private GerenciadorPersonagens gerenciador;

    private JLabel totalPersonagensLabel;
    private JLabel totalGuerreirosLabel;
    private JLabel totalMagosLabel;
    private JLabel somaVidasLabel;
    private JLabel mediaNivelLabel;
    private JLabel mediaAtaqueLabel;
    private JLabel totalManaMagosLabel;
    private JLabel mediaDefesaGuerreirosLabel;

    public TelaEstatisticas(GerenciadorPersonagens gerenciador) {
        this.gerenciador = gerenciador;
        montarTela();
        atualizar();
    }

    private void montarTela() {
        setLayout(new GridLayout(0, 1, 8, 8));

        totalPersonagensLabel = adicionarLinha();
        totalGuerreirosLabel = adicionarLinha();
        totalMagosLabel = adicionarLinha();
        somaVidasLabel = adicionarLinha();
        mediaNivelLabel = adicionarLinha();
        mediaAtaqueLabel = adicionarLinha();
        totalManaMagosLabel = adicionarLinha();
        mediaDefesaGuerreirosLabel = adicionarLinha();
    }

    private JLabel adicionarLinha() {
        JLabel label = new JLabel();
        add(label);
        return label;
    }

    public void atualizar() {
        totalPersonagensLabel.setText("Total de personagens: " + gerenciador.totalPersonagens());
        totalGuerreirosLabel.setText("Total de guerreiros: " + gerenciador.totalGuerreiros());
        totalMagosLabel.setText("Total de magos: " + gerenciador.totalMagos());

        somaVidasLabel.setText("Soma das vidas: " + gerenciador.somaVidas());
        mediaNivelLabel.setText("Media de nivel: " + String.format("%.2f", gerenciador.mediaNivel()));
        mediaAtaqueLabel.setText("Media de ataque: " + String.format("%.2f", gerenciador.mediaAtaque()));

        totalManaMagosLabel.setText("Soma da mana dos magos: " + gerenciador.totalManaMagos());
        mediaDefesaGuerreirosLabel.setText("Media de defesa dos guerreiros: "
                + String.format("%.2f", gerenciador.mediaDefesaGuerreiros()));
    }

}