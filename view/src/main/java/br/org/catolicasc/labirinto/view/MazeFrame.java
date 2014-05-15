package br.org.catolicasc.labirinto.view;

import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.org.catolicasc.labirinto.view.elemento.Cenario;

public class MazeFrame {

	private static MazeFrame mazeFrame;
	private JFrame mainFrame;

	private MazeFrame() {
		mainFrame = new JFrame("Maze");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.show();
//		mainFrame.setSize(100, 200);
//		// mainFrame.pack();
//		mainFrame.show();
	}

	public static MazeFrame instnceOf() {
		if (mazeFrame == null) {
			mazeFrame = new MazeFrame();
		}
		return mazeFrame;
	}

	public void createFrame(Cenario[][] cenarios) throws IOException {
		// PAREDE('#'), POSICAO_INICIAL('S'), SAIDA('E'), REMEDIO('C'),
		// VENENO('T'), CORREDOR('.'), COBAIA('M'), MUTACAO('R');
		GridLayout grid = new GridLayout(cenarios.length,cenarios[0].length);
		JPanel panel = new JPanel(grid);
		for (int i = 0; i < cenarios.length; i++) {
			for (int j = 0; j < cenarios[i].length; j++) {

				String pathImage = null;
				switch (cenarios[i][j].getElemento().getCaracter()) {
				case '#':
					pathImage = "stone.png";
					break;
				case 'C':
					pathImage = "chesse.png";
					break;
				case 'T':
					pathImage = "trap.png";
					break;
				case 'R':
				case 'M':
					pathImage = "mouse.png";
					break;

				default:
					pathImage = "empty.png";
					break;
				}
				BufferedImage img = ImageIO.read(new File(Thread.currentThread().getContextClassLoader().getResource(pathImage).getFile()));
				
				ImageIcon icon = new ImageIcon(resize(img, 40, 40));
				panel.add(new JLabel(icon));
				
			}
		}
		
		mainFrame.setContentPane(panel);
		mainFrame.pack();
		mainFrame.repaint();
		
	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}

}
