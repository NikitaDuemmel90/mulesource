package mule.lang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IO {
	static Scanner sc = new Scanner(System.in);
	public static void writeLine() {
		System.out.println();
	}
	
	public static void writeString(Object arg) {
		System.out.print(arg);
	}
	
	public static void writeBoolean(Object arg) {
		System.out.print(arg);
	}
	
	public static void writeInteger(Object arg) {
		System.out.print(arg);
	}
	
	public static void writeRational(Object arg) {
		System.out.print(arg);
	}
	
	public static void writeFile(String path, String content) {
		try (PrintWriter out = new PrintWriter(path)) {
		    out.print(content);
		    File file = new File(path);
		    if(file.exists()) {
		    	System.out.println("File path: " + file.getAbsolutePath());
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String readString() {
		String result = sc.next();
		sc.nextLine();
		return result;
	}
	
	public static Integer readInteger() {
		int result = 0;
		String str = sc.next();
		sc.nextLine();
		try {
			result = Integer.parseInt(str);
		} catch (Exception e) {}
		return result;
	}
	
	public static Double readRational() {
		double result = 0.0;
		String str = sc.next();
		sc.nextLine();
		try {
			result = Double.parseDouble(str);
		} catch (Exception e) {}
		return result;
	}
	
	public static Boolean readBoolean() {
		boolean result = false;
		String str = sc.next();
		sc.nextLine();
		try {
			result = Boolean.parseBoolean(str);
		} catch (Exception e) {}
		return result;
	}
	
	public static String readFile(String path) {
		byte[] encoded = "file not found".getBytes();
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {}
		return new String(encoded);
	}
	
	public static ArrayList<String> readFileLines(String path) {
		try {
			ArrayList<String> result = new ArrayList<String>();
			result.addAll(Files.readAllLines(Paths.get(path)));
			return result;
		} catch (IOException e) {}
		return new ArrayList<String>(Arrays.asList(new String[]{"file not found"}));
	}
	
	public static boolean fileExists(String path) {
	    File file = new File(path);
		if (file.exists())
			return true;
		return false;
	}
}
