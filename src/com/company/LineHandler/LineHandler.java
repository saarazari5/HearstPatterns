package com.company.LineHandler;

/**
 * Line handler protocol.
 */
public interface LineHandler {
    /**
     * @param line to process.
     * @return true if process succeed.
     */
    boolean process(String line);
}

