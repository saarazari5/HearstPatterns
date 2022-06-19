package com.company.IO;
import com.company.LineHandler.LineHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Line reader class.
 */
public class LineReader {

    /**
     * @param file file to read the lines from
     * @param handler the callbacks.
     * @throws IOException if there was an IO exception.
     */
    public void readLines(File file, List<LineHandler> handler) throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while ((line = bufferedReader.readLine()) != null) {
            if (!(line.isEmpty() || line.isBlank())) {
                for (LineHandler lineHandler : handler) {
                    lineHandler.process(line);
                }
            }
        }
        System.out.println("Done with ".concat(file.getAbsolutePath()));
    }

}

