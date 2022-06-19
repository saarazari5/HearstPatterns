package com.company.HearstPatterns;

public enum Np {
    Regex {
        @Override
        public String toString() {
            return "<np>[^<]+</np>";
        }
    }
}