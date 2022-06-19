package com.company;
import com.company.HearstPatterns.As;
import com.company.HearstPatterns.Especially;
import com.company.HearstPatterns.Including;
import com.company.HearstPatterns.SuchAs;
import com.company.HearstPatterns.WhichIs;
import com.company.IO.LineReader;
import com.company.IO.LineWriter;
import com.company.LineHandler.LineHandler;
import com.company.LineHandler.HearstBasePatternLineHandler;
import java.io.File;
import java.io.IOException;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Create Hypernym Db class.
 */
public class CreateHypernymDatabase {
    /**
     * @param dirPath directory path to fetch data.
     * @param databaseDir the directory to save the data in.
     */
    public void initDataBase(String dirPath, String databaseDir) {
        LineReader reader = new LineReader();
        List<LineHandler> lineHandlers = initHandlers();
        File folder = new File(dirPath);
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        Arrays.stream(files)
                .forEach(file -> {
                    try {
                        reader.readLines(file, lineHandlers);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        if (databaseDir != null) {
            new LineWriter().writeLines(databaseDir);
        }
    }

    private List<LineHandler> initHandlers() {
        ArrayList<LineHandler> lineHandlers = new ArrayList<>();
        lineHandlers.add(new HearstBasePatternLineHandler(new SuchAs()));
        lineHandlers.add(new HearstBasePatternLineHandler(new As()));
        lineHandlers.add(new HearstBasePatternLineHandler(new Including()));
        lineHandlers.add(new HearstBasePatternLineHandler(new Especially()));
        lineHandlers.add(new HearstBasePatternLineHandler(new WhichIs()));

        return lineHandlers;
    }

    /**
     * @param args args[0] should be directory where data is in, args[1] should be the directory to save the database.
     * @throws UnexpectedException exception if args is less than 2.
     */
    public static void main(String[] args) throws UnexpectedException {
        if (args.length != 2) {
            throw new UnexpectedException("Must get two args!");
        }
        new CreateHypernymDatabase().initDataBase(args[0], args[1]);
    }
}

