package ie.atu.sw;
//is it possible to do same output to a file with word and definition?
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class OutputHandler {
	private String outputFileName;

	OutputHandler(String nameOfFile) {
		outputFileName = nameOfFile;
		createFile();

	}

	// creating a file to output
	public void createFile() {
		try {
			File createdFile = new File(outputFileName);
			if (createdFile.createNewFile()) {
				System.out.println("File created: " + createdFile.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	// writing out the list of ngrams to the file
	public void writeOut(ArrayList<NGram> nGrams) {
		try {
			FileWriter myWriter = new FileWriter(outputFileName);
			myWriter.write("\"Value\",\"Frequency\"\n");

			for (int i = 0; i < NGram.nGrams.size(); i++) {
				myWriter.write(
						"\"" + NGram.nGrams.get(i).getValue() + "\",\"" + NGram.nGrams.get(i).getFrequency() + "\"\n");
			}

			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
