import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Relogio extends JFrame {

    SimpleDateFormat formatoHora;
    SimpleDateFormat formatoDia;
    SimpleDateFormat formatoData;
//teste
    JLabel marcaHora;
    JLabel marcaDia;
    JLabel marcaData;
    String hora;
    String dia;
    String data;

    Relogio() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Relógio digital");
        this.setLayout(new FlowLayout());
        this.setSize(350, 220);
        this.setResizable(false);

        formatoHora = new SimpleDateFormat("hh:mm:ss a", Locale.getDefault());
        formatoDia = new SimpleDateFormat("EEEE", new Locale("pt", "BR"));
        formatoData = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
        marcaHora = new JLabel();
        marcaHora.setFont(new Font("SANS_SERIF", Font.PLAIN, 59));
        marcaHora.setBackground(Color.BLACK);
        marcaHora.setForeground(Color.WHITE);
        marcaHora.setOpaque(true);
        marcaDia = new JLabel();
        marcaDia.setFont(new Font("Ink Free", Font.BOLD, 34));
        marcaData = new JLabel();
        marcaData.setFont(new Font("Ink Free", Font.BOLD, 30));

        this.add(marcaHora);
        this.add(marcaDia);
        this.add(marcaData);
        this.setVisible(true);

        iniciarRelogio();
    }

    public void iniciarRelogio() {
        while (true) {
            hora = formatoHora.format(Calendar.getInstance().getTime());
            marcaHora.setText(hora);

            dia = formatoDia.format(Calendar.getInstance().getTime());
            marcaDia.setText(dia);

            data = formatoData.format(Calendar.getInstance().getTime());
            marcaData.setText(data);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Relogio();
    }
}
