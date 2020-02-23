package Coding_Exam_B;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CodingExamB {
	/*
	 * This is a logging program for collecting TODO comments in a program. The program will scan
	 * Through all the files in the Coding_Exam_B/classes package, and collect all the comments that start
	 * with //TODO: and write them to their own file. See the TODO_Log_example.txt file for an idea of what 
	 * the final file output will look like.
	 */
	
	
	public static String getLoggingInfo(String fileName) {
		/*
		 * 1. Complete the getLoggingInfoMethod.
		 *    The method takes in a String for a file and returns a String. 
		 *    The method will open the file a read through it. It will then 
		 *    take all the comments that begin with //TODO: and combine them 
		 *    into one large String. The string will also state the file name and
		 *    the line number for where each TODO was found. 
		*/
		File file = new File(fileName);
		String out = "File: "+fileName+"\n";
		int lineNumber = 1;
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line != null) {
				
				if(line.length()>6) {
					if(line.contains("//TODO:")) {
						
						int cutoff = 0;
						//System.out.println(line.length());
						for(int i= 0;i<line.length();i++) {
							//System.out.println(line.charAt(i));
							if(line.charAt(i)=='	') {
								cutoff++;
							}else {
								break;
							}
						}
						//System.out.println(cutoff);
						out+=lineNumber+": "+line.substring(cutoff)+"\n\n";
					}
				}
				line = br.readLine();
				lineNumber++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(out);
		return out;
	}
	
	public static void main(String[] args) {
		String finalLogString = getLoggingInfo("src/Coding_Exam_B/classes/Camera.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracedImageViewer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/RayTracer.java");
		finalLogString += getLoggingInfo("src/Coding_Exam_B/classes/Vector3.java");
		//System.out.println(finalLogString);
		/*
		 * 2. Write the finalLogString to a file called TODO_Log.txt. The file should match TODO_Log_example.txt. 
		 */
		
		try {
			File logout = new File("src/Coding_Exam_B/TODO_LOG.txt");
			FileWriter fw = new FileWriter(logout);
			
			fw.write(finalLogString);
		
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
			
		

	}
}
