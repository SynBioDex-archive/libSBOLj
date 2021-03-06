/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Logger.getLogger(FileUtil.class.getName()).log(Level.INFO, "File contents ", i);
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
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outfilename), "UTF8"));
           
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            Logger.getLogger(FileUtil.class.getName()).log(Level.SEVERE, null, e);
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
