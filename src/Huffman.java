import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// Huffman class , codes class and Node class [The important classes, the other classes are for interface].

// important class for huffman coding

public class Huffman {
	 private final int MAX_CHAR = 256; 
	 private Queue<codes> codeList = new LinkedList<codes>();
	 private String sentence;
	 private Node last;
	  
	    
	public Huffman(String s) {
		
		sentence = s;
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		
		// count frequency
		getOccuringChar(sentence,q);
		
		// make tree
		while(!q.isEmpty() && q.size()>1) {
			Node left = q.poll();
			Node right = q.poll();
			// put left and right in new node which's the parent.
			Node parent = new Node(left,right);
			parent.getLeft().setParent(parent);
			parent.getRight().setParent(parent);
			// add parent to queue 
			q.add(parent);
			
			
		} // end loop when the list have one node which's root
		
		// poll root 
		last = q.poll();
		//send the root to codewordsList to make list of char and the frequency for it.
		codewordsList(last);
			
	}
	
	// create and save file of encoding.
	public void saveEncodingFile()
		    throws IOException
		{
			// write tree in total (the text)
			String total = "Tree: \n";
			total = treeForFile(last, total) + "\n \n";
			// write encoding in total (the text)
			total += "Encoding:\n" + encoding(sentence) +"\n";
			// write size before huffman coding in total (the text)
			total += "The size before Huffman coding: \n" + sizeBeforeHuff() + "\n";
			// write size after huffman coding in total (the text)
			total += "The size after Huffman coding: \n" + sizeAfterHuff() + "\n\n";
			// write table in total (the text)
			total += "Table:\n" + table() + "\n";
			
			// create the path file.
			File file = new File("Encoding.txt");
			file.delete();
		     Path path = Paths.get("Encoding.txt");
		    
		    
		    try (
		         BufferedWriter writer = Files.newBufferedWriter(path,
		            StandardCharsets.UTF_8, StandardOpenOption.CREATE);
		    ) {
		    	// put total (the text) in file.
		        writer.write(total);
		        // close write after save the file.
		        writer.close();
		    }
		    
		  
		   }
	
	
	// (This and only this function was taken from google)
	// build PriorityQueue with char frequency
	// to count frequency for each  and added to priority queue.
	public void getOccuringChar(String str, PriorityQueue<Node> pq) 
   { 
       // Create an array of size 256 i.e. ASCII_SIZE 
       int count[] = new int[MAX_CHAR]; 
 
       int len = str.length(); 
 
       // Initialize count array index 
       for (int i = 0; i < len; i++) 
           count[str.charAt(i)]++; 
 
       
       // Create an array of given String size 
       char ch[] = new char[str.length()]; 
       for (int i = 0; i < len; i++) { 
           ch[i] = str.charAt(i); 
           int find = 0; 
           for (int j = 0; j <= i; j++) { 
 
               // If any matches found 
               if (str.charAt(i) == ch[j]) {  
                   find++;                 
               }
           } 
           
           if (find == 1) {
           	Node newNode = new Node(str.charAt(i),  count[str.charAt(i)]);
           	pq.add(newNode);
           }
                            
       } 
   } 
	
	
	// make codewords list (Letter to code) and added to codeList from type queue.
	public void codewordsList(Node root) {
		
		// this condition to get the leaf node.
		if(root.getLeft() == null && root.getRight() == null) {
			
			Node newNode = root;
			// take the letter of the leaf node, to added in codes
			char letter = root.getData();
			// take the letter of the leaf node, to added in codes
			int freq = root.getFrequency();
			
			String code = "";
			// here this loop to calculate the code of the letter (0 or 1) to end. 
			while(newNode.getDecode() != -1) {
				code = newNode.getDecode()+code;
				newNode = newNode.getParent();
			}
			// make new codes object that take three variables (code of the letter, letter, frequency of letter).
			codes c = new codes(code, letter, freq);
			
			// add c to codeList which's contains a list from type codes.
			codeList.add(c);
			
			
		}
		
		// this condition to go to the left node if you can
		if(root.getLeft() != null)
		codewordsList(root.getLeft());
		
		// this condition to go to the right node if you can
		if(root.getRight() != null)
		codewordsList(root.getRight());
	
}
	

	// the encoding for the sentence.
	public String encoding(String s) {
		String total = "";
		// first loop moving on every letter from s (sentence).
		for(int i = 0; i<s.length(); i++) {
			// second loop moving on codeList, to take the code for the letter.
			for(int j = 0; j<codeList.size(); j++) {
				// poll from codeList to compare.
				codes c = codeList.poll();
				// check if it's equal the letter from s (sentence) with the polling letter from codeList. 
				if(s.charAt(i) == c.getLetter())
					// print the code if it's equal
					total += c.getCode();
				// added c to codeList to make sure the codeList get back to original.
				codeList.add(c);
			}
		}
		total+="\n";
		return total;
	}
	
	// readTree from file.
	// this function hard to explain with comment , I will try my best.
	public static PriorityQueue<codes> readTree(String s) {

		PriorityQueue<codes> codeList = new PriorityQueue<codes>();
		// total Tree represent the frequency of the root.
		int totalTree=0;
		int parent = 0;
		int child = 0;
		// for check if the one of the child have children and the another not. 
		boolean flag = false;
		
		// this condition to check if the root have one number or two or three. 
			if(s.charAt(2) == ')')
				totalTree = Integer.parseInt(s.substring(1, 2));
			else if(s.charAt(3) == ')') 
				totalTree = Integer.parseInt(s.substring(1, 3));
			else if(s.charAt(4) == ')') 
				totalTree = Integer.parseInt(s.substring(1, 4));
				
			
			
				
				// code to sum the code from tree for each char.
				String  code = "";
				for(int i = 1; i<s.length(); i++) {
					
					//calculate the half of tree which's the frequency of right child of root. 
					int halfTree = 0;
					
					// to see the start.
					if('(' == s.charAt(i)) {
						
						// here if the right of root is parent , will take the frequency and multiply by 2 
						// if it's bigger than the root then it's for sure he's the right child of root.
						if(s.charAt(i+5) == ')') {
							halfTree = Integer.parseInt(s.substring(i+1, i+2));
							if(halfTree*2 >= totalTree) {
								// if it's the right child of root will make code start from the begin
								code = "";
							}
							
						}
						else if(s.charAt(i+6) == ')') {
							halfTree = Integer.parseInt(s.substring(i+1, i+3));
							if(halfTree*2 >= totalTree) {
								// if it's the right child of root will make code start from the begin
								code = "";
							}
						}
						else if(s.charAt(i+7) == ')') {
							halfTree = Integer.parseInt(s.substring(i+1, i+4));
							if(halfTree*2 >= totalTree) {
								// if it's the right child of root will make code start from the begin
								code = "";
							}
						}
						
						
						// check if it's leaf.
						if(')' == s.charAt(i+8)|| ')' == s.charAt(i+9) || ')' == s.charAt(i+10)) {
							// now check where's the correct location for the code for leaf.
							if(')' == s.charAt(i+8))
								// sum the code
								code+=s.charAt(i+7);
							else if(')' == s.charAt(i+9))
								// sum the code
								code+=s.charAt(i+8);
							else if(')' == s.charAt(i+10))
								// sum the code
								code+=s.charAt(i+9);
							
							if(code.length()>2 && code.charAt(2) == ' ')
								code = code.charAt(1) + code.substring(3, code.length());
							
							// increase the child means one of child ends.
							child++;
							
							// make new object of codes for the leaf node and he's code 
							codes c = new codes(code, s.charAt(i+1),-1);
							// added to the List
							codeList.add(c);
							
							//check if the child is 2
							if(child == 2) {
								// if the child reach to 2 means one of the grandfather's child ends.
								// which's parent of the two children
								parent ++;
								if(parent == 2 ||  (parent==1 && flag)) {
									
									if(parent==1 && flag) {
									flag = false;
									}
									// if parent reach to two we will have to delete two number of code
									parent = 0;
									code = code.substring(0,code.length()-1);
									
									
								}
								
								child =0;
								
								if(code.length()>=2)
									code = code.substring(0,code.length()-2);
								
							}
							else
								code = code.substring(0,code.length()-1);
							
							
						}
						
						else {
							// if one child end and the another have children will reach here.
							if(child == 1) {
								flag = true;
								parent++;
								// decrease because we will have new two children.
								child--;
							}
							
								
							// if it's not leaf node , take the code of it. (0 or 1)
							if(')' == s.charAt(i+5))
								code += s.charAt(i+4);
							else if(')' == s.charAt(i+6))
								code += s.charAt(i+5);
							else if(')' == s.charAt(i+7))
								code += s.charAt(i+6);
						     }
					}
						
				}
				
				return codeList;
}		
	
	
	
	public static String decoding(PriorityQueue<codes> code, String encoding) {
		// we will make it from PriorityQueue to array, to easy to handle.
		ArrayList<codes> arrayListOfcode = new ArrayList<codes>();
		while(!code.isEmpty()) {
			codes c = code.poll();
			arrayListOfcode.add(c);
		}
	 
		
		int firstOfsubString = 0;
		String text = "";
		// loop for encoding text.
		for(int i = 0; i<encoding.length(); i++) {
			// loop on array list
			for(int j = 0; j<arrayListOfcode.size(); j++) 
				// check if the substring equal to one of codes
			if(encoding.substring(firstOfsubString, i+1).equalsIgnoreCase(arrayListOfcode.get(j).getCode())){
				// if equal take the letter for the code
				text += arrayListOfcode.get(j).getLetter();
				// make the next substring start from the end substring.
				firstOfsubString = i+1;
				// if the last sunstring == the length then break;
				if(encoding.length() == i+1)
					break;
				
			}
			
		}
		
		return text;
	}
	
	// calculate the size before Huff. coding
	public int sizeBeforeHuff() {
			// total frequency for letters multiply by 8.
			return last.getFrequency()*8;
		}
	
	// calculate the size after Huff. coding
	public int sizeAfterHuff() {
		
		int total = 0;
		// loop to moving on codeList.
		for(int i = 0; i<codeList.size(); i++) {
			codes c = codeList.poll();
			// calculate code multiply by frequency for each letter and sum the total.
			total += c.getCode().length() * c.getFreq();
			codeList.add(c);
		}
		
		return total;
	}
	
	// the table which's contains each letter with frequency for same letter and codewords for same letter (letter to code).
	public String table() {
		String total = "";
		// make PriorityQueue to add codeList to it to order it, then when you print in table will make it ordered.
		PriorityQueue<codes> codePQ = new PriorityQueue<codes>();
		for(int i = 0; i<codeList.size(); i++) {
			codes c = codeList.poll();
			codePQ.add(c);
			codeList.add(c);
		}
		
		// start saving the first line...
		total = "|    Letter	|	Count	|	Code	|\n";
		for(int i = 0; i<codeList.size(); i++) {
			codes c = codePQ.poll();
			// save each letter and the code for the same letter.
			total += "       " + c.getLetter() + "	   	   " + c.getFreq() + "		 " + c.getCode()+"\n";
		}
		return total;
	}

	// write tree for file.. 
	public String treeForFile(Node last, String total) {
		// check if it's leaf
		if (last.getLeft() == null && last.getRight() == null)
			return total += "(" + last.getData() + ", " +last.getFrequency() + ", " + last.getDecode() + ") " + "# # ";
		
		// check if it's not leaf
		if (last.getLeft() != null && last.getRight() != null) {
			if(last.getDecode() != -1)
			total += "(" + last.getFrequency() + ", " + last.getDecode() + ") ";
			else
			total += "(" + last.getFrequency() +  ") ";
		}
		
		// go left
		total = treeForFile(last.getLeft(), total);
		// ge right
		total = treeForFile(last.getRight(), total);
		
		return total;
	}

	public void graphTree() throws IOException {

		// Take root to add it in queue.
				Node newRoot = last;
				
				// create queue to move on tree like Breadth First Search.
		       Queue<Node> queue = new LinkedList<Node>();
		       
		      
		       int i = 0;
		       queue.add(newRoot);
		       
		       // save the first line graph.
		       String text = "Graph\n{ \n";
		       // make value for root
		       String vparent = "n"+i;
		       // save the name of parent to represent in tree
		       String parent = "n"+i+"["+"label=\""+newRoot.getFrequency()+"\"];\n";
		       text += parent;
		       int j = 0;
		       
		       // moving on queue and add the child of every parent to it.
		       while(!queue.isEmpty()) {
		    	   // this for connect parent with children
		    	   vparent = "n"+j;
		       	Node newNode = queue.poll();
		       	
		       		
		       	// check if there is children then add to text and add it to queue.
		       	if(newNode.getLeft() != null && newNode.getRight() != null ) {
		       		queue.add(newNode.getLeft());
		       		
		       	// condition inside the print, to check if it's leaf print frequency and letter , if not print frequency.
		       		String childLeft = "n"+(++i)+"["+"label=\""+(newNode.getLeft().isLeaf()? newNode.getLeft().getData() + " , " + newNode.getLeft().getFrequency()
		       				: newNode.getLeft().getFrequency())+"\"];\n";
		       		String vchildLeft = "n"+(i);
		       		text +=childLeft;
		       		text += vparent + "--" + vchildLeft +"["+"label=\"0\"];\n";
		       		
		       		
		       		queue.add(newNode.getRight());
		       		// condition inside the print, to check if it's leaf print frequency and letter , if not print frequency.
		       		String childRight = "n"+(++i)+"["+"label=\""+(newNode.getRight().isLeaf()? newNode.getRight().getData() + " , " + newNode.getRight().getFrequency()
		       				: newNode.getRight().getFrequency())+"\"];\n";
		       		String vchildRight = "n"+(i);
		       		text +=childRight;
		       		text += vparent + "--" + vchildRight +"["+"label=\"1\"];\n";
		       		
		       	}
		       	j++;
		       }
		
		text += "\n" + "}";
		
		
		// save text in file 
		File file = new File("graphTree.dot");
		file.delete();
	     Path path = Paths.get("graphTree.dot");
	    
	    
	    try (
	         BufferedWriter writer = Files.newBufferedWriter(path,
	            StandardCharsets.UTF_8, StandardOpenOption.CREATE);
	    ) {
	    	// put total (the text) in file.
	        writer.write(text);
	        writer.close();
	    }
		
	}
	
	// get for last root which's root
	public Node getLast() {
		return last;
	}
}

