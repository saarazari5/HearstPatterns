package com.company.IO;
import com.company.HypernymComparator;
import com.company.HypernymRepository;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;

/**
 * LineWriter class.
 */
public class LineWriter {
    /**
     * @param outputDir the directory to write the lines to.
     */
    public void writeLines(String outputDir) {
        File file = new File(outputDir.concat("\\hypernym_db.txt"));
        BufferedWriter out;
        HypernymRepository repository = HypernymRepository.getInstance();
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            repository.getDatabase().forEach((hyper,  hypernym) -> {
                if (repository.numOfHypernyms(hyper) > 2) {
                    try {
                        out.write(hyper + ":");
                        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
                         hypernym.entrySet()
                                .stream()
                                .sorted(new HypernymComparator())
                                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

                        StringBuilder builder = new StringBuilder();
                        sortedMap.forEach((key, value) -> append(builder, key, value));
                        builder.deleteCharAt(builder.length() -1);
                        builder.append(System.lineSeparator());

                        out.write(builder.toString());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void append(StringBuilder builder, String key, Integer value) {
        builder.append(" ")
                .append(key)
                .append(" (")
                .append(value)
                .append("),");
    }

    void print(BufferedWriter out, String key, Integer value ) {
        try {
            out.write(" " + key + " (" + value + "),");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


