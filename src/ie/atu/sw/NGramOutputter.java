package ie.atu.sw;

import java.io.File;
import java.io.PrintWriter;

public class NGramOutputter {

	public void save(Object[][] table, String file) throws Exception {
		PrintWriter pw = new PrintWriter(new File(file));

		for (int row = 0; row < table.length; row++) {
			pw.write(table[row][0] + "," + table[row][1]);
		}

		pw.close();

	}
}
