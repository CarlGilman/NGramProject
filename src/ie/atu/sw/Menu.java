package ie.atu.sw;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
	private Scanner s;
	// keeps the menu running when activated
	private boolean keepRunning = true;

	public Menu() {
		// allows for input from the user
		s = new Scanner(System.in);

	}

// general UI for the n-Gram
	public void start() {
		while (keepRunning) {
			showOptions();
			// list of choices
			int choice = Integer.parseInt(s.next()); // blocks...

			System.out.println(choice);

			if (choice == 1) {
				System.out.println(
						"Please Select a file to use, once selected please do not close the file browser window"
								+ "\n");
				// Create a frame to select files
				JFrame f = new JFrame("File Selector");
				// set visibility of frame
				f.setVisible(true);
				// enable frame to close
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// set size of frame that appears
				f.setSize(600, 600);

				// button to select the file
				JButton button1 = new JButton("Open File Browser");
				JButton runButton = new JButton("Run with selected file");

				// object of the class
				MyDirectory d1 = new MyDirectory();

				// capture user input on the button
				button1.addActionListener(d1);

				SaveFileLocation listener_SaveFileLocation = new SaveFileLocation();

				runButton.addActionListener(listener_SaveFileLocation); // this -----------
				// panel to add the buttons too
				JPanel p = new JPanel();

				// adding button to the panel frame
				p.add(button1);
				p.add(runButton);

				MyDirectory.l = new JLabel("no file Selected");

				p.add(MyDirectory.l);
				f.add(p);

				f.show();
				// imports code from MyDirectory tab to work in the menu
				// MyDirectory.fileSelection();
				// selecting directory
				start();
				return;
				// building the ngram and printing out to a csv file from selected file
			} else if (choice == 2) {

				// set ngram size from input
				System.out.println("Please enter nGram Size between 1-4");
				int nGramSize = Integer.parseInt(s.next());

				System.out.println(
						"Running nGram program on: " + SaveFileLocation.fileLocation + ", NGram size: " + nGramSize);
				System.out.println("Please wait this may take some time if the file size is large");
				NGram.run(SaveFileLocation.fileLocation, nGramSize);

				// quit out from program
			} else if (choice == 3) {
				quit();
				// quit out from program
				System.out.println("[INFO] Shutting down.... Please wait....");
				keepRunning = false;
			} else {
				System.out.println("ERROR Invalid Input");
			}
		}

	}
	// code for the directory

	private void quit() {

	}

	// layout for menu (visual UI) with various options
	private void showOptions() {
		System.out.println("############################################");
		System.out.println("#                                          #");
		System.out.println("#          NGram V1.0 Main Menu            #");
		System.out.println("#                                          #");
		System.out.println("############################################");
		System.out.println("\n");
		System.out.println("(1) Select Text File Directory");
		System.out.println("(2) Select n-Gram Size and produce output file");
		System.out.println("(3) Quit");
		System.out.println("Please enter an option 1-3");

	}
}
