package dailyprogrammer;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class E207Bioinformatics {

    public static List<String> findSecondDNAStrand(String input) {
        List<String> fullStrand = new LinkedList<>();
        fullStrand.add(input);

        String[] inputArr = input.split(" ");
        String[] secondArr = Arrays.asList(inputArr).stream()
            .map(base -> (base.equals("A")) ? "T" :
                (base.equals("T")) ? "A" :
                (base.equals("C")) ? "G" :
                (base.equals("G")) ? "C" : "?")
            .toArray(String[]::new);
        fullStrand.add(String.join(" ", secondArr));

        return fullStrand;
    }


    public static List<String> findProteinSequence(String input) {
        StringBuilder codonBuilder = new StringBuilder();
        List<String> proteinStrand = new LinkedList<>();
        Map<String, String> codonMap = generateCodonMap();
        proteinStrand.add(input);

        String[] inputArr = input.split(" ");
        if (inputArr.length % 3 != 0) {
            System.out.println("The input is not a multiple of three");
            return proteinStrand;
        }

        List<String> proteins = new LinkedList<>();
        for (int i = 0; i < inputArr.length; i++) {
            if (codonBuilder.length() != 3) {
                codonBuilder.append(inputArr[i]);
            } else {
                proteins.add(codonMap.get(codonBuilder.toString()));
                codonBuilder = new StringBuilder();
                codonBuilder.append(inputArr[i]);
            }
        }
        if (codonBuilder.length() == 3) {
            proteins.add(codonMap.get(codonBuilder.toString()));
        }

        String[] proteinArr = proteins.stream().toArray(String[]::new);
        proteinStrand.add(String.join(" ", proteinArr));

        return proteinStrand;
    }


    public static Map<String, String> generateCodonMap() {
        Map<String, String> codonMap = new HashMap<>();

        try {
            Path codonInputPath = Paths.get("dna-codons.txt");
            List<String> allCodons = Files.readAllLines(codonInputPath);
            for (String line : allCodons) {
                String[] splitLine = line.split("=>");
                codonMap.put(splitLine[0].trim(), splitLine[1].trim());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return codonMap;
    }
}