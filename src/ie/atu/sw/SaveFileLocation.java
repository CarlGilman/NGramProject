package ie.atu.sw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//saving file location from the file browser using an action listener

public class SaveFileLocation implements ActionListener {

	static String fileLocation;

	SaveFileLocation() {
	}

	public void actionPerformed(ActionEvent e) {
		fileLocation = MyDirectory.l.getText();

		System.out.println(fileLocation);
	}

}