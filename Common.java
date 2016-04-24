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
import java.util.List;
import java.util.StringTokenizer;

import szoftProj.Game;

public class Common {
	private static Game game;

	public static void main(String[] args) {
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
					System.out.println(
							"Ha t�bb tesztesetet szeretn�l futtatni, akkor azt �gy tudod pl megadni: 10-15 (teh�t t�l-ig)");
					System.out.println("A testesetek list�z�s�hoz add ki ezt: list");
					while (true) {
						System.out.print(">");
						inputLine = instream.readLine();
						tokenizer = new StringTokenizer(inputLine, "-");
						command = tokenizer.nextToken();
						if ("exit".startsWith(command))
							break;
						if ("list".startsWith(command)) {
							System.out.println("\nA tesztesetek:");
							// itt k�s�bb nagyon sok teszteset lesz.
							System.out.println("1: J�t�kos �res mez�re l�p");
							System.out.println("2: J�t�kos nem �res mez�re l�p");
							System.out.println("3: J�t�kos �res �s nyitott kapura l�p");
							System.out.println("4: J�t�kos nem �res �s nyitott kapura l�p");
							System.out.println("5: J�t�kos z�rt kapura l�p");
							System.out.println("6: J�t�kos abyssre l�p");
							System.out.println("7: J�t�kos scale-re l�p");
							System.out.println("8: J�t�kos karakter nem �res (doboz) scalre l�p");
							System.out.println("9: J�t�kos karakter falnak megy");
							System.out.println("10: J�t�kos karakter port�l-falnak megy");
							System.out.println("11: J�t�kos karakter m�k�d� port�lnak megy");
							System.out.println("12: J�t�kos karakter �res �s nyitott kapub�l l�p ki");
							System.out.println("13: J�t�kos karakter �res �s nyitott kapub�l l�p ki dobozzal elz�rt �tra");
							System.out.println("14: J�t�kos karakter port�lb�l l�p ki �res �tra");
							System.out.println("15: J�t�kos fordul egy �ton");
							System.out.println("16: J�t�kos karakter scale-r�l l�p le, �res �tra");
						} else {
							try {
								int testCase = Integer.parseInt(command);
								String lastCaseStr = readString(tokenizer);
								int lastCase = testCase + 1;
								if (lastCaseStr != null)
									lastCase = Integer.parseInt(lastCaseStr) + 1;
								for (int i = testCase; i < lastCase; i++) {
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
									case 2:
										commandFile = new File("lep_nu.txt");
										expectedFile = new File("lep_nu_elvart.txt");
										break;
									case 3:
										commandFile = new File("lep_rg.txt");
										expectedFile = new File("lep_rg_elvart.txt");
										break;
									case 4:
										commandFile = new File("lep_rgb.txt");
										expectedFile = new File("lep_rgb_elvart.txt");
										break;
									case 5:
										commandFile = new File("lep_rgo.txt");
										expectedFile = new File("lep_rgo_elvart.txt");
										break;
									case 6:
										commandFile = new File("lep_ra.txt");
										expectedFile = new File("lep_ra_elvart.txt");
										break;
									case 7:
										commandFile = new File("lep_rs.txt");
										expectedFile = new File("lep_rs_elvart.txt");
										break;
									case 8:
										commandFile = new File("lep_rsb.txt");
										expectedFile = new File("lep_rsb_elvart.txt");
										break;
									case 9:
										commandFile = new File("lep_rw.txt");
										expectedFile = new File("lep_rw_elvart.txt");
										break;
									case 10:
										commandFile = new File("lep_rp.txt");
										expectedFile = new File("lep_rp_elvart.txt");
										break;
									case 11:
										commandFile = new File("lep_rpo.txt");
										expectedFile = new File("lep_rpo_elvart.txt");
										break;
									case 12:
										commandFile = new File("lep_gr.txt");
										expectedFile = new File("lep_gr_elvart.txt");
										break;
									case 13:
										commandFile = new File("lep_grb.txt");
										expectedFile = new File("lep_grb_elvart.txt");
										break;
									case 14:
										commandFile = new File("lep_pr.txt");
										expectedFile = new File("lep_pr_elvart.txt");
										break;
									case 15:
										commandFile = new File("fordul_r.txt");
										expectedFile = new File("fordul_r_elvart.txt");
										break;
									case 16:
										commandFile = new File("lep_sr.txt");
										expectedFile = new File("lep_sr_elvart.txt");
										break;
									default:
										System.out.println("Nincs ilyen teszteset!");
										continue;
									// break;
									}
									commands = loadFromFile(commandFile);
									expected = loadFromFile(expectedFile);

									List<String> result = new ArrayList<String>();

									StringBuilder inputText = new StringBuilder();
									StringBuilder expectedText = new StringBuilder();
									for (String comm : commands) {
										inputText.append(comm + "\n");
									}
									for (String expect : expected) {
										expectedText.append(expect + "\n");
									}
									System.out.println(inputText.toString());
									runCommand(inputText.toString(), expectedText.toString(), game);
								}
							} catch (Exception ex) {
								ex.printStackTrace();
								throw new Exception("Nem sz�mot adt�l meg vagy valami baj van.");
							}
						}
					}
				} else if ("console".startsWith(command)) {
					game = new Game();

					while (true) {
						System.out.println("parancsok list�z�s�hoz �rd be ezt: list");
						System.out.println("j�t�k parancs kiad�s�hoz �rd be ezt: start");
						System.out.print(">");
						inputLine = instream.readLine();

						if ("exit".startsWith(inputLine))
							break;
						else
						// TODO ,ezt l�cci valaki szedje majd �ssze
						if ("list".startsWith(inputLine)) {
							System.out.println("update: friss�ti a j�t�k �llapot�t.");
							System.out.println("sat�bbi");
						} else {
							game.console();
							System.out.println("Hib�s parancs miatt vagy egy�b okb�l kil�pt�l (starttal kezdd �jra)");
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

	static List<String> loadFromFile(File file) {
		List<String> strList = new ArrayList<String>();
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	static void runCommand(String inputText, String expectedOutputText, Game game) throws Exception {

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

		if (expectedOutputText != null) {
			boolean equals = true;
			String[] expectedOutputTextArray = expectedOutputText.split("\n");
			System.out.println("\n");
			System.out.println("az elv�rt kimenet: \n");
			for (String str : expectedOutputTextArray) {
				System.out.println(str);
			}
			for (int i = 0; i < expectedOutputTextArray.length; i++) {
				// enterek, tabul�torok kisz�r�se
				if (expectedOutputTextArray[i].length() <= 1)
					break;
				if (i < outputTextArray.length) {
					if (!outputTextArray[i].equals(expectedOutputTextArray[i] + "\r")) {
						System.out.println();
						System.out.println("A k�l�nb�z� sorok:");
						System.out.println(outputTextArray[i]);
						System.out.println(expectedOutputTextArray[i]);
						equals = false;
					}
				} else
					equals = false;
			}
			if (equals)
				System.out.println("\n A teszt sikeres");
			else
				System.out.println("\n A teszt sikertelen");
		}

	}

}
