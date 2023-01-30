# NGramProject
Project that breaks down files into "nGrams" of specified number, then output to a CSV file

My NGram Project consists of the following features. 
 
The project is created VIA an menu driven UI which gives the user options to create the specified nGram.

A JDK Frame/labels/file explorer is used to allow for the selection of a file from anywhere on your pc that is saved to the 
program memory.
Saving the file location selected from the above mentioned JDK via an actionListener. 
Variable Ngram size input via the second option this allows generally for a selection between 1 and 4for nGram size.
A system that processes the file into string format and is then trimmed and cleaned before being sorted into the selected NGram sizes.
This is done by removing all the capitals and replacing as lower case, also removing any symbols or uncessessary punctuation.
The file is then broken down into the nGrams and stored to the system before it can be output
A file outputter to CSV format which outputs the results of the Ngram operation - created by an output handler. 
CSV file outputted to the project directory- File name "output.csv" - showing the name of the ngram and the amount 
of times it appeared within the document. - will overwrite the file in the directory if output.csv is already present.
Use of Scanner, ActionEvent, BufferedReader, ActionListener, ArrayLists and File systems. 
 
 
Instruction for use. 
 
1. Run the project using Runner.java 
2. Use the menu to select the file first before selecting any other options (file selection is option 1). 
3. Keep the JDK window open after file has been selected to run - Please minimize but do not close till application is
complete 
4. Select and nGram size between 1-4 for most optimal results 
5. File will be output to project directory - if the file already exists in the directory it will overwrite the file and save t
he new output. 
6. Use option 3 quit to kill the project- will need to re run again using Runner.java if further usage required if chosing option 3. 
