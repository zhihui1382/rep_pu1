package bai.face.api;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;

import java.awt.Image;
import java.awt.BorderLayout; 

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Frame02 {

	public static void main(String[] args) {
		JFrame frm = new JFrame("测试");
		JPanel pan01 = new JPanel();
		JPanel pan02 = new JPanel();
		//icon.getImage().getScaledInstance(
		ImageIcon ico = new ImageIcon("E:/img/a.jpg");
		int w =ico.getIconWidth();
		int h = ico.getIconHeight(); 
		ImageIcon img = new ImageIcon( ico.getImage().getScaledInstance(w/2,h/2, Image.SCALE_DEFAULT) );
		JLabel lbl = new JLabel( img );
		pan01.add(lbl);
		
		/**选择对话框**********************************************************/
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.JPG  *.PDF  *.BMP ", "jpg", "pdf", "bmp");
		chooser.setFileFilter(filter);
		
		JButton btnChooser = new JButton("请选择照片");
		ActionListener bcListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int returnVal =chooser.showOpenDialog( frm );
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String name = chooser.getSelectedFile().getPath();
//					JOptionPane.showMessageDialog(null,name);
					ImageIcon ico = new ImageIcon(name);
					int w =ico.getIconWidth();
					int h = ico.getIconHeight(); 
					ImageIcon img = new ImageIcon( ico.getImage().getScaledInstance(w/2,h/2, Image.SCALE_DEFAULT) );
					lbl.setIcon(img);
				}
			}
			
		};
		btnChooser.addActionListener(bcListener);
		pan02.add(btnChooser);
		
		
		frm.add(pan01,BorderLayout.CENTER); //SOUTH南
		frm.add(pan02,BorderLayout.SOUTH);
		frm.setSize(500, 350);
		frm.setLocation(350,50);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setVisible(true);
	}

}
