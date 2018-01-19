package com.sk.TestJavaSyntax;
import java.io.*;
//import java.lang.*;
import java.util.*;
//For File writing
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;    // socket client



import java.net.Socket;

import javax.swing.JOptionPane;

import java.sql.Connection;
import skhelperpkg.*;

public class TestJavaSyntax {

	/**
	 * @param args
	 */
	
		
	public static String[][] serviceList = {{"CID1", "Office365", "LiveVault","PCBackup","Storegate"},
		{"CID2","PCBackup","Storegate"},
		{"CID3","Office365", "Storegate"}};
	
	
	public static void main(String[] args) {
			
		String[] temp, response;

		// TODO Auto-generated method stub
		
		//iterationConstructs();
		
		//inputOutput("C:\\Users\\sk\\dropbox\\SE\\javaapps\\TestJavaSyntax\\filename.txt");
		
		//testMethod(); 
		
		//datatypeConstructs ();
		
		//temp = getServices ("CID3");
		
		//System.out.println ("1" + temp[0] + "2" + temp[1] + "3" + temp[2]);
		
		//	readXML ("C:\\Users\\kunver\\HP Projects\\MTN XDR PoC\\file-format.xml");
		
		//databaseAccess();
		
	    DBHelper dbhelp = new DBHelper();
	    if (dbhelp.dbConnectionSetup ("postgres", "postgres", "yeboyes"))
	    	System.out.println ("Go ahead with DB Operations");

		 //socketClientTester();
		
		
		
	} // main
	
	public static void iterationConstructs (){
		
		// For Loop Construct
		System.out.println ("Foor Loop Construct Test");
		for (int i=0; i<10; i++)
			System.out.print("  i="+i+";  ");
		
		System.out.println (" ");
		
	} // iterationConstructs
	
	public static void datatypeConstructs (){
		
		short i=0, j=0, k=0; 
		// String Array Data Type
		
		System.out.println ("1 dimensional string array");
		String[] testStrArray = {"element1", "element2"}; 		
		
		while (j < testStrArray.length) 
			System.out.println(testStrArray[j++]);
		
		
		System.out.println ("2 dimensional string array");
		String[][] testStr2Array = {{"a","b","c"},{"d","e","f"},{"g","h","i"}};
		j=0;
		while (j < testStr2Array.length){
			k=0;
			while (k < testStr2Array[j].length)
				System.out.println (testStr2Array[j][k++]);
			j++;
		}		    
			
		//List<Entry<String, Integer>> li = new ArrayList<Entry<String, Integer>>(); 
		
		// 2 dimensional array construct
		int[][] testintTwoDimArray = {{0,1,2},{0,1,2},{9,8,7}};
		
		for (i=0; i<3; i++)
			for (k=0; k<3; k++)
				System.out.println (testintTwoDimArray[i][k]);
		//public String[]int[] = {"C1",{0,1}, "C2", {1}, "C3", {0,1,2}};
	} //datatypeConstructs
	
	public static void inputOutput(String filename){
		
		System.out.println ("Screen Input and output:");
		System.out.println ("Hello World");
		
		System.out.println ("File input and output:");
		
		try {
			 
			String content = "This is the content to write into file";
 
			File file = new File(filename);
			
 
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	} //inputOutput
	

	public static String[] getServices (String customerID){

		short j;

		j=0;
		while (j < serviceList.length){

				if (serviceList[j][0].compareTo(customerID)==0)
					return serviceList[j];
				else {
					j++; 
					continue;		
				}
		}
		return null;
	}  // getServices
	

	
	public static void socketClientTester(){
		
		
		 String serverAddress = JOptionPane.showInputDialog(
		            "Enter IP Address of a machine that is\n" +
		            "running the date service on port 9090:");
		 
		 try{
		        Socket s = new Socket(serverAddress, 9090);
		        BufferedReader input =
		            new BufferedReader(new InputStreamReader(s.getInputStream()));
		        String answer = input.readLine();
		        JOptionPane.showMessageDialog(null, answer);
		        s.close();
		       // System.exit(0);
		 } catch (Exception e){System.out.println ("Caught exception " + e);}
	}
	


	

} // TestJavaSyntax
