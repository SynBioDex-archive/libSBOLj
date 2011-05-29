/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author mgaldzic
 */
public class FileUtil {

    public static void main(String[] args) throws FileNotFoundException {
        //readGenBankRoundTrip();
        writeFile("test\\test_files\\test.txt", "test");
        String i = readFile("test\\test_files\\test.txt");
        System.out.println("i: " + i);
    }

    static String readFile(String infilename) throws FileNotFoundException {

        StringBuilder text = new StringBuilder();
        String NL = System.getProperty("line.separator");
        Scanner scanner = new Scanner(new FileInputStream(infilename), "UTF-8");
        try {
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine()).append(NL);
            }
        } finally {
            scanner.close();
        }
        return text.toString();
    }

    static void writeFile(String outfilename, String content) {
        DataOutputStream dos;
        FileOutputStream fos;
        try {
            //FileWriter fw = new FileWriter(outfilename);
            //BufferedWriter bw = new BufferedWriter(fw);
            //PrintWriter pw = new PrintWriter(bw);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfilename), "UTF8"));
            //   File file= new File(outfilename);
            //   fos = new FileOutputStream(file);
            //   dos=new DataOutputStream(fos);
            //   dos.writeUTF(content);
            //   dos.writeBytes(content);
            //   dos.writeBytes("\n");
            //   dos.close();

            //   pw.write(content);
            bw.write(content);
            bw.close();
            //pw.close();
        } catch (IOException e) {
        } finally {
        }
    }

    static void touchfile(String filename) {
        try {
            File file = new File(filename);
            //
            // Touch the file, when the file is not exist a new file will be
            // created. If the file exist change the file timestamp.
            //
            FileUtils.touch(file);
        } catch (IOException e) {
        }
    }
}
