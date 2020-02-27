/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_text_editor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
/**
 *
 * @author GAJERA_KISHAN
 */
public class Executer {
 /*   public static void main(String[] args) {
        try {
            //runProcess("pwd");
            System.out.println("**********");
            //runProcess("set path=\"C:\\Program Files\\Java\\jdk1.8.0_111\\bin\"");
            Runtime.getRuntime().exec("C://WINDOWS//system32//cmd.exe");
            Runtime.getRuntime().exec("C://Users//GAJERA_KISHAN//Desktop//input.cmd");
            //Runtime.getRuntime().exec("javac C:\\Users\\GAJERA_KISHAN\\Desktop\\Hello.java");
            System.out.println("**********");
            //runProcess("java C:\\Users\\GAJERA_KISHAN\\Desktop\\Hello Hi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }*/
    
    public static void main(String[] args) throws IOException {
       try {
        String ss = null;
        Runtime obj = null;
        Process p = Runtime.getRuntime().exec("cmd.exe /c start input.cmd");
        BufferedWriter writeer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        writeer.write("input.cmd");
        writeer.flush();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        System.out.println("Here is the standard output of the command:\n");
        while ((ss = stdInput.readLine()) != null) {
            System.out.println(ss);
        }
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((ss = stdError.readLine()) != null) {
            System.out.println(ss);
        }

    } catch (IOException e) {
        System.out.println("FROM CATCH" + e.toString());
    }

}

    private static void printLines(String cmd, InputStream ins) throws Exception {
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(cmd + " " + line);
        }
      }

      private static void runProcess(String command) throws Exception {
        Process pro = Runtime.getRuntime().exec(command);
        printLines(command + " stdout:", pro.getInputStream());
        printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
      }

}

