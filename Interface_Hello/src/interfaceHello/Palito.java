package interfaceHello;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Palito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected DesenhoPanel desenho;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Palito frame = new Palito();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Palito() {
		initComponents();
		
	}
	
	public void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		JPanel panelNorte = new JPanel();
        panelNorte.setPreferredSize(new Dimension(650, 80));
        panelNorte.setLayout(null);
        JLabel balaoFala = new JLabel("Olá, meu nome é Lucas Grulho!");
        balaoFala.setFont(new Font("Arial", Font.PLAIN, 18));
        panelNorte.add(balaoFala);
        contentPane.add(panelNorte, BorderLayout.NORTH);
		
		// Config Painel Sul + Botão de avançar
		JPanel panelSul = new JPanel();
		panelSul.setLayout(null);
		panelSul.setPreferredSize(new Dimension(650, 60));
		
		JButton skip = new JButton("AVANÇAR");
		skip.addActionListener(e -> {
			try {
				limparTela();
				Thread.sleep(1000);
				redesenharTela();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		skip.setFont(new Font("Arial",Font.BOLD, 12));
		skip.setSize(115,39);
		skip.setLocation(508, 11);
		
		panelSul.add(skip);
		contentPane.add(panelSul,BorderLayout.SOUTH);
		
		//Classe desenho
		desenho = new DesenhoPanel();
		contentPane.add(desenho, BorderLayout.CENTER);
	}
	
	public void limparTela() {
		contentPane.removeAll();
		contentPane.revalidate();
		contentPane.repaint();
	}
	public void redesenharTela() {
		desenho = new DesenhoPanel();
		contentPane.add(desenho, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();
	}
	class DesenhoPanel extends JPanel{
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(650,500);
		}
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int centroX = getWidth() / 2;
            int centroY = getHeight() / 2;

            g.drawOval(centroX - 37, centroY - 225, 75, 75); // Cabeça
            g.drawOval(centroX - 20, centroY - 205, 10, 10); // Olho 1
            g.drawOval(centroX + 10, centroY - 205, 10, 10); // Olho 2
            g.drawOval(centroX - 15, centroY - 175, 30, 10); // Boca ABERTA
            g.drawLine(centroX, centroY - 150, centroX, centroY + 100); // Corpo
            g.drawLine(centroX, centroY - 95, centroX - 70, centroY - 55); // Braço 1
            g.drawLine(centroX, centroY - 95, centroX + 70, centroY - 55); // Braço 2
            g.drawLine(centroX, centroY + 100, centroX - 50, centroY + 187); // Perna 1
            g.drawLine(centroX, centroY + 100, centroX + 50, centroY + 187); // Perna 2
        }
	}
}