package ie.atu.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class MyDirectory extends JFrame implements ActionListener {

	static JLabel l;

	MyDirectory() {

	}

	public void actionPerformed(ActionEvent e) {
		// String filepath = "";
		String com = e.getActionCommand();

		if (com.equals("save")) {
			JFileChooser c = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int d = c.showSaveDialog(null);

			if (d == JFileChooser.APPROVE_OPTION) {
				l.setText(c.getSelectedFile().getAbsolutePath());
				// filepath = c.getSelectedFile().getAbsolutePath();
			} else {
				l.setText("Operation Cancelled");
			}
		}

		else {
			JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int d = j.showOpenDialog(null);

			if (d == JFileChooser.APPROVE_OPTION) {
				l.setText(j.getSelectedFile().getAbsolutePath());
				// filepath = j.getSelectedFile().getAbsolutePath();
			} else
				l.setText("operation cancelled");
		}
		// if select button is pressed, close JFrame and save current selected filepath.
		// return it.
		// return filepath;
	}

}
