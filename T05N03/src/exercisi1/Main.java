package exercisi1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Scanner;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Main {
	
	public static final String rootPath = System.getProperty("user.dir") + "\\";
	private static final String appConfigPath = rootPath + "app.properties";
	
	private static SecretKey secretKey;
	private static IvParameterSpec iv;
	
	private static String dir;
	public static String savePath;
	
	private static final String[] options = {
            "1- Guarda l'arbre complet d'un directori a un fitxer TXT encriptat.",
            "2- Desencripta i llegeix el fitxer TXT encriptat amb l'opció 1 i mostra el seu contingut",
            "0- Sortir",
	};
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		// Generem SecretKey i IV per poder encriptar i desencriptar
		secretKey = AESEncrypter.generateKey(128);
		iv = AESEncrypter.generateIv();
		
		// Llegim fitxer de configuració
		Properties appProps = new Properties();
		appProps.load(new FileInputStream(appConfigPath));
		dir = appProps.getProperty("directory");
		savePath = appProps.getProperty("savePath") + ".txt";
		
        int option;
        boolean exit = false;
		while (!exit){
            printMenu(options);
            try {
            	option = Integer.parseInt(scanner.nextLine());
                switch (option){
                    case 1: option1(); break;
                    case 2: option2(); break;
                    case 0: System.out.println("Fins aviat!"); exit = true; break;
                    default: System.out.println("Només números entre 0 i 2");
                }
            }
            catch (NoSuchElementException ex){
                System.out.println("Has d'introduir un número");
                scanner.next();
            }
        }
	}
	
	private static void printMenu(String[] options) {
		System.out.println();
		System.out.println("--------------------------- MENÚ ---------------------------");
		for (String option : options){
            System.out.println(option);
        }
		System.out.println();
        System.out.print("Tria una opció: ");
	}
	
	private static void option1() {
		try {
			File inputFile = new File(rootPath + "temp.txt");
			File outputFile = new File(savePath);
			inputFile.delete();
			inputFile.createNewFile();
			outputFile.delete();
			outputFile.createNewFile();
			DirectoryUtils.saveAllSubdirectoriesAndFiles(dir);
			AESEncrypter.encryptFile("AES/CBC/PKCS5Padding", secretKey, iv, inputFile, outputFile);
			inputFile.delete();
			System.out.println("Directori a llegir: " + dir);
			System.out.println("Arbre complet guardat al fitxer i encriptat a" + savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void option2() {
		try {
			File inputFile = new File(savePath);
			File outputFile = new File(rootPath + "temp.txt");
			outputFile.delete();
			outputFile.createNewFile();
			AESEncrypter.decryptFile("AES/CBC/PKCS5Padding", secretKey, iv, inputFile, outputFile);
			System.out.println("Fitxer desencriptat " + savePath + "\nContingut: ");
			System.out.println();
			DirectoryUtils.printFile(rootPath + "temp.txt");
			outputFile.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
