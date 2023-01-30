package ie.atu.sw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NGram {
	// ArrayList for Storing all nGrams
	static ArrayList<NGram> nGrams = new ArrayList<NGram>();
	private String value;
	private int frequency = 1;

	// constructor
	NGram(String inputValue) {
		value = inputValue;
		// add to when created
		NGram.nGrams.add(this);
	}

	// getters

	public String getValue() {
		return value;
	}

	// finds the frequency of ngram
	public int getFrequency() {
		return frequency;
	}

	// increments the frequency of the ngram
	public void incrementFrequency() {
		frequency++;
	}

	// find if NGram has been already added to list of NGrams - if yes Return Index
	// if no return -1
	public static int findNGram(String searchValue) {
		for (int i = 0; i < NGram.nGrams.size(); i++) {
			if (searchValue.equals(NGram.nGrams.get(i).getValue())) {
				return i;
			}

		}
		return -1;
	}

	public static void run(String fileLocation, int ngramSize) {
		// System.out.println(fileLocation);

		readFile(fileLocation, ngramSize);
	}

	public static void readFile(String filePath, int ngramSize) {
		try {
			// methodology - import file-> break down file into a string -> remove all
			// upper-case and replace with lower + remove symbols -> convert into n-Gram
			// size
			// reading the text file line by line
			BufferedReader myReader = new BufferedReader(new FileReader(filePath));

			String text = "";
			// reading the text in from BR to form a string before removal of symbols
			try {
				String line = myReader.readLine();
				while (line != null) {
					text += line;
					line = myReader.readLine();
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// IOException catch required
			try {
				myReader.close();
			} catch (IOException e) {

			}
			// removing all symbols and converting to lower case + Trim
			text = text.trim().replaceAll(
					"\\?|\\,|\\s+|\\'|\\@|\\$|\\£|\\%|\\^|\\&|\\*|\\(|\\)|\\!|\\.|\\:|\\;|\\/|\\|\\/|\\#|\\~|\\]|\\[|\\{|\\}|\"|\\€|\\_",
					"").toLowerCase();

			// System.out.println(text);

			String nGram = "";

			// iterate over the text to generate ngrams

			for (char character : text.toCharArray()) {

				nGram += character;
				if (nGram.length() == ngramSize) {
					// check if in list
					int index = NGram.findNGram(nGram);

					if (index == -1) {
						new NGram(nGram);
					} else {
						NGram.nGrams.get(index).incrementFrequency();
					}

					// set ngram back to empty
					nGram = "";
				}

			}

			// Sort - Testing if the ngram works to the console

			// Debug printout Loop
			// for(int i = 0; i < NGram.nGrams.size(); i++) {
			// System.out.println("value: " + NGram.nGrams.get(i).getValue() +
			// ", frequency: " + NGram.nGrams.get(i).getFrequency());
			// }

			OutputHandler outputHandler = new OutputHandler("output.csv");
			outputHandler.writeOut(NGram.nGrams);
			System.out.println("file has been saved to the project directory");

			// Prior version of ngram idea below

//			char ngram[] = new char[ngramSize];
//			int c = 0;
//			try {
//				while (c != -1){
//					int i = 0;
//					while (i < ngramSize) {
//						c = myReader.read();
//						char character = (char) c;
//						ngram[i] = character;	
//						i++;
//					}
//					//print out the n-grams to text format (currently the console)
//					System.out.println(ngram);
//				}
//				myReader.close();
//			} catch (IOException ex) {
//				System.out.println("Error occurred reading file");
//				ex.printStackTrace();
//			}
			// error if no file is selected when trying to run Ngram part of menu
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred, cannot find file: " + filePath);
			e.printStackTrace();

		}
	}
}
