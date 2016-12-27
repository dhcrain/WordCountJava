import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        if(args.length > 0) {
            File inFile = new File(args[0]);
            TxtToList wordList = new TxtToList(inFile);

//            System.out.printf("Word counts: %s, %n", wordList.getWordCount());
//            System.out.printf("Sorted Word counts: %s, %n", wordList.sortByValue(wordList.getWordCount()));
            wordList.getTopWords();

        }

//        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();
//
//        try {
//            BufferedReader in = new BufferedReader(new FileReader("book.txt"));
//
//            String str;
//            while ((str = in.readLine()) != null) {
//                str = str.toLowerCase().replaceAll("[^a-zA-Z ]", ""); // convert to lower case
//                String[] words = str.split("\\s+"); //split the line on whitespace, would return an array of words
//
//                for(String word : words ) {
//                    if( word.length() == 0 ) {
//                        continue;
//                    }
//
//                    Integer occurrences = wordCount.get(word);
//                    if(occurrences == null) {
//                        occurrences = 1;
//                    } else {
//                        occurrences++;
//                    }
//                    wordCount.put(word, occurrences);
//                }
//            }
//        } catch(Exception e){
//            System.out.println(e);
//        }
//

//        ArrayList<Integer> values = new ArrayList<>();
//        values.addAll(wordCount.values());
//
//        Collections.sort(values, Collections.reverseOrder());
//
//        int last_i = -1;
//
//        for (Integer i : values.subList(0, 19)) {
//            if (last_i == i) // without duplicates
//                continue;
//            last_i = i;
//
//            for (String s : wordCount.keySet()) {
//
//                if (wordCount.get(s) == i) // which have this value
//                    System.out.println(s+ " " + i);
//            }
//        }
    }

    }

