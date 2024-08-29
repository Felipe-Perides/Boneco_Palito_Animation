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
		
		JLabel balaoFala = new JLabel("Olá, meu nome é Lucas Grulho!");
		balaoFala.setPreferredSize(new Dimension(50,80));
		balaoFala.setFont(new Font("Arial",Font.PLAIN, 18));
		contentPane.add(balaoFala, BorderLayout.NORTH);
		
		// Config Painel Sul + Botão de avançar
		JPanel panelSul = new JPanel();
		panelSul.setLayout(null);
		panelSul.setPreferredSize(new Dimension(650, 60));
		
		JButton skip = new JButton("AVANÇAR");
		skip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		skip.setFont(new Font("Arial",Font.BOLD, 12));
		skip.setSize(115,39);
		skip.setLocation(508, 11);
		
		panelSul.add(skip);
		contentPane.add(panelSul,BorderLayout.SOUTH);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawOval(287, 50, 75, 75); //Cabeça
		
		g.drawOval(305, 70, 10, 10);// Olho 1
		g.drawOval(335, 70, 10, 10);// Olho 2
		
		//g.drawArc(310, 90, 30, 20, 0, -180);// Boca FECHADA
		g.drawOval(310, 100, 30, 10);// Boca ABERTA
		
		g.drawLine(325, 125, 325, 375); //Corpo
		
		g.drawLine(325, 180, 255, 220); //Braço 1
		g.drawLine(325, 180, 395, 220); //Braço 2
		
		g.drawLine(325, 375, 275, 462); //Perna 1
		g.drawLine(325, 375, 375, 462); //Perna 2
	}
}
