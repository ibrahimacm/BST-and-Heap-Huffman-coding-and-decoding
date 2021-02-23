
// important class for huffman coding

public class codes implements Comparable<codes>{
private String code;
private char letter;
private int freq;

public codes(String code, char letter, int freq) {
	this.code = code;
	this.letter = letter;
	this.freq = freq;
}


// getters
public String getCode() {
	return code;
}
public char getLetter() {
	return letter;
}
public int getFreq() {
	return freq;
}

// setters
public void setCode(String code) {
	this.code = code;
}
public void setLetter(char letter) {
	this.letter = letter;
}
public void setFreq(int freq) {
	this.freq = freq;
}

//When to add node to PriorityQueue order it by letter.
public int compareTo(codes c) {
	return   getCode().length() - c.getCode().length();
}

}
