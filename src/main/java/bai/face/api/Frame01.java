package bai.face.api;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileView;

public class Frame01 {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageViews frame = new ImageViews();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ImageViews extends JFrame {
	private static final int DEFALT_WIDTH = 600;
	private static final int DEFALT_HEIGH = 500;
	private JLabel label;
	private JFileChooser chooser;

	public ImageViews() {
		setTitle("PGC");
		setSize(DEFALT_WIDTH, DEFALT_HEIGH);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu Menu = new JMenu("File");
		JMenu editMenu1 = new JMenu("Edit");
		JMenu editMenu2 = new JMenu("Help");
		menuBar.add(Menu);
		menuBar.add(editMenu1);
		menuBar.add(editMenu2);

		JMenuItem importItem = new JMenuItem("Import");
		Menu.add(importItem);
		importItem.addActionListener(new FileImportListener());

		JMenuItem openItem = new JMenuItem("OpenFile");
		Menu.add(openItem);

		JMenuItem exitItem = new JMenuItem("Exit");
		Menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		label = new JLabel();
		add(label);
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF &PGC &PAD files", "jpg", "gif", "pgc",
				"pad");
		chooser.setFileFilter(filter);
		chooser.setAccessory(new ImagePreviewer(chooser));
		chooser.setFileView(new FileIconView(filter, new ImageIcon()));

	}

	private class FileImportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			chooser.setCurrentDirectory(new File("."));
			int returnVal = chooser.showOpenDialog(ImageViews.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		}

	}
}

class FileIconView extends FileView {
	private FileNameExtensionFilter fliter;
	private Icon icon;

	public FileIconView(FileNameExtensionFilter filter, Icon anIcon) {
		fliter = filter;
		icon = anIcon;
	}

	public Icon getIcon(File f) {
		if (f.isDirectory() && fliter.accept(f)) {
			return icon;
		} else {
			return null;
		}
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}
}

class ImagePreviewer extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImagePreviewer(JFileChooser chooser) {
		setPreferredSize(new Dimension(100, 100));
		setBorder(BorderFactory.createEtchedBorder());

		chooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
					File f = (File) event.getNewValue();
					if (f == null) {
						setIcon(null);
						return;
					}
					ImageIcon icon = new ImageIcon(f.getPath());
					if (icon.getIconWidth() > getWidth()) {
						System.out.println("Ëõ·Åing...");
						icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_FAST));
						setIcon(icon);
					}
//					setIcon(icon);
				}
			}
		});
	}
}