/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package libSBOLjUseExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author mgaldzic
 */
public class FileUtil {

    static String readfile(String infilename) {
        String out = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(infilename));
            String str;
            while ((str = in.readLine()) != null) {
                out += str;
            }
            in.close();
        } catch (IOException e) {
        } finally {
            return out;
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
