package szoftProj;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.StringTokenizer;


public class Common {
	private static Game game;
	
	public static void main(String[] args){
		System.out.println("Ez a program teszteli a ZPM-es j�t�kunkat! \n");
		BufferedReader instream = new BufferedReader(new InputStreamReader(System.in));
	    while (true) {
	        try {
	        	System.out.println("Mit szeretn�l csin�lni?");
	        	System.out.println("A program parancssoros haszn�lat�hoz ezt a parancsot add ki: console");
	        	System.out.println("Ha el�re defini�lt teszteseteket szeretn�l futtatni ezt add ki: test");
	        	System.out.println("Ha valamelyikbe bel�pt�l �s ki szeretn�l l�pni, akkor ezt add ki : exit");
	        	System.out.print(">");
	            String inputLine = instream.readLine();
	            StringTokenizer tokenizer = new StringTokenizer(inputLine, "   ");
	            String command = tokenizer.nextToken();
	            
	            if ("test".startsWith(command)) {
            		System.out.println("A teszt futtat�s�hoz a megfelel� sz�mot add ki parancsk�nt!");
            		System.out.println("Ha t�bb tesztesetet szeretn�l futtatni, akkor azt �gy tudod pl megadni: 10-15 (teh�t t�l-ig)");
            		System.out.println("A testesetek list�z�s�hoz add ki ezt: list");
	            	while(true){
	            		System.out.print(">");
	    	            inputLine = instream.readLine();
	    	            tokenizer = new StringTokenizer(inputLine, "-");
	    	            command = tokenizer.nextToken();
	    	            if("exit".startsWith(command))
	    	            	break;
	    	            if("list".startsWith(command)){
		            		System.out.println("\nA tesztesetek:");
		            		//itt k�s�bb nagyon sok teszteset lesz.
		            		System.out.println("1: J�t�kos �res mez�re l�p");
	    	            }else{
		    	            try{
		    	            	int testCase = Integer.parseInt(command);
		    	            	String lastCaseStr = readString(tokenizer);
		    	            	int lastCase = testCase + 1;
		    	            	if(lastCaseStr != null)
		    	            		lastCase = Integer.parseInt(lastCaseStr) + 1;
		    	            	for(int i = testCase; i < lastCase; i++){
		    	            		game = new Game();
		    	            		List<String> commands = new ArrayList<String>();
		    	            		List<String> expected = new ArrayList<String>();
		    	            		
		    	            		File commandFile = null;
		    	            		File expectedFile = null;
		    	            		switch (i) {
									case 1:
										commandFile = new File("lep.txt");
										expectedFile = new File("lep_elvart.txt");
										break;
									default:
										System.out.println("Nincs ilyen teszteset!");
										continue;
										//break;
									}
									commands = loadFromFile(commandFile);
									expected = loadFromFile(expectedFile);
		    	            		
		    	            		List<String> result = new ArrayList<String>();
		    	            		
		    	            		StringBuilder inputText = new StringBuilder();
		    	            		StringBuilder expectedText = new StringBuilder();
		    	            		for(String comm : commands){
		    	            			inputText.append(comm + "\n");
		    	            		}
		    	            		for(String expect : expected){
		    	            			expectedText.append(expect + "\n");
		    	            		}
		    	            		System.out.println(inputText.toString());
		    	            		runCommand(inputText.toString(),expectedText.toString(),game);
		    	            	}
		    	            }catch(Exception ex){
		    	            	ex.printStackTrace();
		    	            	throw new Exception("Nem sz�mot adt�l meg vagy valami baj van.");
		    	            }
	    	            }
	            	}
	            } else if ("console".startsWith(command)) {
	            	game = new Game();
	            	System.out.println("parancsok list�z�s�hoz �rd be ezt: list");
	            	while(true){
	            		System.out.print(">");
	    	            inputLine = instream.readLine();
	            		
	    	            if("exit".startsWith(inputLine))
	    	            	break;
	    	            else
	    	            //TODO ,ezt l�cci valaki szedje majd �ssze
	    	            if("list".startsWith(inputLine)){
	    	            	System.out.println("update: friss�ti a j�t�k �llapot�t.");
	    	            	System.out.println("sat�bbi");
	    	            }else{
	    	            	game.console();
	    	            }
	            	}
	            } else {
	                throw new Exception("Hibas parancs! (" + inputLine + ")");
	            }
	        } catch (Exception e) {
	            System.out.println("? " + e.toString());
	        }
	    }
	}
	
    static String readString(StringTokenizer tokenizer) throws Exception {
        if (tokenizer.hasMoreElements()) {
            return tokenizer.nextToken();
        } else {
            return null;
        }
    }
    
    static List<String> loadFromFile(File file){
    	List<String> strList = new ArrayList<String>();
    	try{
	    	BufferedReader br = new BufferedReader(new FileReader(file));
	    	try {
	    	    StringBuilder sb = new StringBuilder();
	    	    String line = br.readLine();
	
	    	    while (line != null) {
	    	        strList.add(line);
	    	        line = br.readLine();
	    	    }
	    	    return strList;
	    	} finally {
	    	    br.close();
	    	}
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return null;
    }
    
    static void runCommand(String inputText,String expectedOutputText, Game game) throws Exception{
    	
        ByteArrayInputStream bais = new ByteArrayInputStream(inputText.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        InputStream originalInput = System.in;
        PrintStream originalOutput = System.out;

        System.setIn(bais);
        System.setOut(new PrintStream(baos));

        game.console();

        System.setIn(originalInput);
        System.setOut(originalOutput);

        String outputText = baos.toString();
        System.out.println(outputText);

        String[] outputTextArray = outputText.split("\n");
        
        if(expectedOutputText != null){
        	boolean equals = true;
        	String[] expectedOutputTextArray = expectedOutputText.split("\n");
        	System.out.println("\n");
            for(String str : expectedOutputTextArray){
            	System.out.println(str);
            }
            for(int i = 0; i < expectedOutputTextArray.length;i++){
            	if(i < outputTextArray.length){
            		if(!outputTextArray[i].equals(expectedOutputTextArray[i]))
            			equals = false;
            	}else 
            		equals = false;
            }
            if(equals)
            	System.out.println("\n A teszt sikeres");
            else
            	System.out.println("\n A teszt sikertelen");
        }
    	
    }
    
}
