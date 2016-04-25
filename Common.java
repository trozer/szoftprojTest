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
							System.out.println("14: J�t�kos fordul egy �ton");
							System.out.println("15: J�t�kos karakter scale-r�l l�p le, �res �tra");
							System.out.println("16: A j�t�kos karakter dobozt rak egy �res mez�re");
							System.out.println("17: A j�t�kos karakter dobozt rak egy m�r dobozt tartalmaz� mez�re");
							System.out.println("18: A j�t�kos karakter dobozt rak egy �res, nyitott kapura");
							System.out.println("19: A j�t�kos karakter dobozt rak egy nem �res, nyitott kapura");
							System.out.println("20: A j�t�kos karakter dobozt rak egy z�rt kapura");
							System.out.println("21: A j�t�kos karakter dobozt vesz fel �tr�l");
							System.out.println("22: A j�t�kos karakter dobozt vesz fel abbysr�l");
							System.out.println("23: A j�t�kos karakter dobozt vesz fel z�rt kapur�l");
							System.out.println("24: A j�t�kos karakter dobozt vesz fel nyitott port�lr�l");
							System.out.println("25: O�Neill l�ved�ket ind�t");
							System.out.println("26: Jaffa l�ved�ket ind�t");
							System.out.println("27: L�ved�k falba csap�dik");
							System.out.println("28: L�ved�k port�l falba csap�dik");
							System.out.println("29: L�ved�k becsap�d�s port�l falba, �gy, hogy nyitva van valahol egy port�l p�r");
							System.out.println("30: L�ved�k port�lba csap�dik");
							System.out.println("31: L�ved�k �ton halad �t");
							System.out.println("32: L�ved�k m�rlegen halad �t");
							System.out.println("33: L�ved�k abyssen halad �t");
							System.out.println("34: JL�ved�k nyitott kapun halad �t");
							System.out.println("35: J�t�kos ZPM-re l�p");
							System.out.println("36: J�t�kos ZPM-et vesz fel");
							System.out.println("37: Dobozt rak m�rlegre (0 doboz van rajta)");
							System.out.println("38: Dobozt rak m�rlegre (1 doboz van rajta)");
							System.out.println("39: Dobozt rak m�rlegre (2 doboz van rajta)");
							System.out.println("40: Dobozt rak m�rlegre (3 doboz van rajta)");
							System.out.println("41: Dobozt rak abyss-ra");
							System.out.println("42: Dobozt rak falra");
							System.out.println("43: Dobozt rak nyitott port�lra");
							System.out.println("44: Dobozt vesz fel nyitott kapur�l (kapuban van doboz");
							System.out.println("45: Dobozt vesz fel nyitott kapur�l (kapuban nincs doboz)");
							System.out.println("46: Dobozt vesz fel m�rlegr�l (nincs rajta doboz)");
							System.out.println("47: Dobozt vesz fel m�rlegr�l (1 doboz van rajta)");
							System.out.println("48: Dobozt vesz fel m�rlegr�l (3 doboz van rajta)");
							System.out.println("49: Dobozt vesz fel m�rlegr�l (4 doboz van rajta)");
							System.out.println("50: Replik�tor l�p (fal)");
							System.out.println("51: Replik�tor l�p (scale, van hozz�kapcsolt kapu)");
							System.out.println("52: Replik�tor l�p (l�ved�kkel tal�lkozik)");
							System.out.println("53: Replik�tor l�p (O'Neill-el elz�rt �t)");
							System.out.println("54: Replik�tor l�p (dobozzal elz�rt �t)");
							System.out.println("55: Replik�tor l�p (�res �t)");
							System.out.println("56: Replik�tor l�p (m�k�d� port�l)");
							System.out.println("57: Replik�tor l�p (z�rt kapu)");
							System.out.println("58: Replik�tor l�p (abyss)");
							System.out.println("59: O'Neill �s Jaffa egym�s mellett �llnak �s l�pnek mindketten");
						} else {
							try {
								int testCase = Integer.parseInt(command);
								String lastCaseStr = readString(tokenizer);
								int lastCase = testCase + 1;
								if (lastCaseStr != null)
									lastCase = Integer.parseInt(lastCaseStr) + 1;
								int success = 0;
								int all = 0;
								for (int i = testCase; i < lastCase; i++) {
									all++;
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
										commandFile = new File("fordul_r.txt");
										expectedFile = new File("fordul_r_elvart.txt");
									case 15:
										commandFile = new File("lep_sr.txt");
										expectedFile = new File("lep_sr_elvart.txt");
										break;
									case 16:
										commandFile = new File("drop_rr.txt");
										expectedFile = new File("drop_rr_elvart.txt");
										break;
									case 17:
										commandFile = new File("drop_rrb.txt");
										expectedFile = new File("drop_rrb_elvart.txt");
										break;
									case 18:
										commandFile = new File("drop_rg.txt");
										expectedFile = new File("drop_rg_elvart.txt");
										break;
									case 19:
										commandFile = new File("drop_rgb.txt");
										expectedFile = new File("drop_rgb_elvart.txt");
										break;
									case 20:
										commandFile = new File("drop_rgc.txt");
										expectedFile = new File("drop_rgc_elvart.txt");
										break;
									case 21:
										commandFile = new File("dobozfel.txt");
										expectedFile = new File("dobozfel_elvart.txt");
										break;
									case 22:
										commandFile = new File("dobozfel_abbys.txt");
										expectedFile = new File("dobozfel_abbys_elvart.txt");
										break;
									case 23:
										commandFile = new File("dobozfel_kapu.txt");
										expectedFile = new File("dobozfel_kapu_elvart.txt");
										break;
									case 24:
										commandFile = new File("dobozfel_portal.txt");
										expectedFile = new File("dobozfel_portal_elvart.txt");
										break;
									case 25:
										commandFile = new File("loves_oneill.txt");
										expectedFile = new File("loves_oneill_elvart.txt");
										break;
									case 26:
										commandFile = new File("loves_jaffa.txt");
										expectedFile = new File("loves_jaffa_elvart.txt");
										break;
									case 27:
										commandFile = new File("loves_falba.txt");
										expectedFile = new File("loves_falba_elvart.txt");
										break;
									case 28:
										commandFile = new File("loves_pfalba.txt");
										expectedFile = new File("loves_pfalba_elvart.txt");
										break;
									case 29:
										commandFile = new File("loves_pfalba2.txt");
										expectedFile = new File("loves_pfalba2_elvart.txt");
										break;
									case 31:
										commandFile = new File("bullet_uton.txt");
										expectedFile = new File("bullet_uton_elvart.txt");
										break;
									case 32:
										commandFile = new File("bullet_uton.txt");
										expectedFile = new File("bullet_uton_elvart.txt");
										break;
									case 33:
										commandFile = new File("bullet_abyss.txt");
										expectedFile = new File("bullet_abyss_elvart.txt");
										break;
									case 34:
								          commandFile = new File("bullet_ajto.txt");
								          expectedFile = new File("bullet_ajto_elvart.txt");
								          break;
									case 35:
										commandFile = new File("player_zpm_move.txt");
										expectedFile = new File("player_zpm_move_elvart.txt");
										break;
									case 36:
										commandFile = new File("player_zpm_grab.txt");
										expectedFile = new File("player_zpm_grab_elvart.txt");
										break;
									case 37:
										commandFile = new File("drop_rs0.txt");
										expectedFile = new File("drop_rs0_elvart.txt");
										break;
									case 38:
										commandFile = new File("drop_rs1.txt");
										expectedFile = new File("drop_rs1_elvart.txt");
										break;
									case 39:
										commandFile = new File("drop_rs2.txt");
										expectedFile = new File("drop_rs2_elvart.txt");
										break;
									case 40:
										commandFile = new File("drop_rs3.txt");
										expectedFile = new File("drop_rs3_elvart.txt");
										break;	
									case 41:
										commandFile = new File("drop_ra.txt");
										expectedFile = new File("drop_ra_elvart.txt");
										break;	
									case 42:
										commandFile = new File("drop_rw.txt");
										expectedFile = new File("drop_rw_elvart.txt");
										break;	
									case 43:
										commandFile = new File("drop_rpo.txt");
										expectedFile = new File("drop_rpo_elvart.txt");
										break;	
									case 44:
										commandFile = new File("grab_rg.txt");
										expectedFile = new File("grab_rg_elvart.txt");
										break;
									case 45:
										commandFile = new File("grab_rgb.txt");
										expectedFile = new File("grab_rgb_elvart.txt");
										break;
									case 46:
										commandFile = new File("grab_rs.txt");
										expectedFile = new File("grab_rs_elvart.txt");
										break;
									case 47:
										commandFile = new File("grab_rs2.txt");
										expectedFile = new File("grab_rs2_elvart.txt");
										break;
									case 48:
										commandFile = new File("grab_rs3.txt");
										expectedFile = new File("grab_rs3_elvart.txt");
										break;
									case 49:
										commandFile = new File("grab_rs4.txt");
										expectedFile = new File("grab_rs4_elvart.txt");
										break;
									case 50:
										commandFile = new File("replicator_lep_rw.txt");
										expectedFile = new File("replicator_lep_rw_elvart.txt");
										break;
									case 51:
										commandFile = new File("replicator_lep_rsrg.txt");
										expectedFile = new File("replicator_lep_rsrg_elvart.txt");
										break;
									case 52:
										commandFile = new File("replicator_lep_rrrbu.txt");
										expectedFile = new File("replicator_lep_rrrbu_elvart.txt");
										break;
									case 53:
										commandFile = new File("replicator_lep_rro.txt");
										expectedFile = new File("replicator_lep_rro_elvart.txt");
										break;
									case 54:
										commandFile = new File("replicator_lep_rrb.txt");
										expectedFile = new File("replicator_lep_rrb_elvart.txt");
										break;
									case 55:
										commandFile = new File("replicator_lep_rr.txt");
										expectedFile = new File("replicator_lep_rr_elvart.txt");
										break;
									case 56:
										commandFile = new File("replicator_lep_rpp.txt");
										expectedFile = new File("replicator_lep_rpp_elvart.txt");
										break;
									case 57:
										commandFile = new File("replicator_lep_rg.txt");
										expectedFile = new File("replicator_lep_rg_elvart.txt");
										break;
									case 58:
										commandFile = new File("replicator_lep_ra.txt");
										expectedFile = new File("replicator_lep_ra_elvart.txt");
										break;
									case 59:
										commandFile = new File("units.txt");
										expectedFile = new File("units_elvart.txt");
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
									if(runCommand(inputText.toString(), expectedText.toString(), game))
										success++;
									System.out.println("\n tesztek sz�ma: " + all + " ebb�l ennyi volt sikeres: " + success );
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
							System.out.println("newGame : �j j�t�k kezd�se az alap�rtelmezett p�ly�n");
							System.out.println("newGame p�lya.xml : �j j�t�k kezd�se p�lya.xml p�ly�n");
							System.out.println("update : friss�ti a j�t�k �llapot�t");
							System.out.println("update pause|resume : automatikus friss�t�s ki-be (egyenl�re nincs haszn�latban)");
							System.out.println("loadGame : j�t�k bet�lt�se (egyenl�re nincs haszn�latban)");
							System.out.println("saveGame : j�t�k ment�se  (egyenl�re nincs haszn�latban)");
							System.out.println("exitGame : kil�p�s a j�t�kb�l ment�s n�lk�l");
							System.out.println("move oneill|jaffa|replicator : O'neill vagy Jaffa vagy Replik�tor karaktere l�p egyet");
							System.out.println("turn oneill|jaffa|replicator north|west|east|south : egys�g fordul adott ir�nyba");
							System.out.println("grab oneill|jaffa : egys�g megpr�b�l felvenni valamit az el�tte l�v� mez�r�l");
							System.out.println("drop oneill|jaffa : egys�g megpr�b�l lerakni valamit az el�tte l�v� mez�re");
							System.out.println("shoot oneill|jaffa blue|yellow|red|green : egys�g l� adott sz�n� l�ved�ket");
							System.out.println("getUnit oneill|jaffa|replicator : adott egys�g teljes �llapot�nak ki�r�sa");
							System.out.println("getZPM oneill|jaffa : adott egys�gn�l l�v� ZPM ki�r�sa");
							System.out.println("getField x y : (x,y) koordin�t�kon l�v� mez� �llapot�nak ki�r�sa");
							System.out.println("getPortal : portal objektum �llapot�nak ki�r�sa");
							System.out.println("listBoxes : �sszes doboz ki�r�sa");
							System.out.println("listZPMs : �sszes ZPM ki�r�sa");
							System.out.println("setReplicatorDir north|west|east|south : replik�tor statikus ir�ny�nak megad�sa");
							System.out.println("setUnitPos oneill|jaffa|replicator x y : adott egys�g �thelyez�se (x,y) koordin�t�j� mez�re");
							System.out.println("setUnitPos ox oy tx ty : (ox,oy) koordin�t�n l�v� �sszes egys�g �thelyez�se (x,y) koordin�t�j� mez�re");
							System.out.println("killUnit oneill|jaffa|replicator : adott egys�g elpuszt�t�sa");
							System.out.println("killUnit x y : (x,y) koordin�t�n l�v� �sszes egys�g elpuszt�t�sa");
							System.out.println("addBox : �j doboz lerak�sa random �res �tra");
							System.out.println("addZPM : �j ZPM lerak�sa random �res �tra");
							System.out.println("addReplicator : �j replik�tor lerak�sa random �res �tra");
							System.out.println("talkativeStage on|off : az �llapot ki�r�s ki-be kapcsol�sa (alapb�l bekapcsolva)");
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

	static boolean runCommand(String inputText, String expectedOutputText, Game game) throws Exception {

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
			if (equals){
				System.out.println("\n A teszt sikeres");
				return true;
			}
			else{
				System.out.println("\n A teszt sikertelen");
				return false;
			}
			
		}
		return false;

	}

}
