import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by daviscrain on 12/23/16.
 */

public class TxtToList {
    private List<String> mWordList;
    private List<WordCount> mWordCountList;


    public TxtToList(File txtFile) {
        List<String> wordList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(txtFile))) {
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                String[] words = sCurrentLine.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("[^\\w']+");
                for (String word : Arrays.asList(words)) {
                    if (!word.equals("")) {
                        wordList.add(word);
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println("Trouble Opening File.");
            ioe.printStackTrace();
        }
        this.mWordList = wordList;
    }


    public List<WordCount> getWordCountList(int start, int stop) {
        Collections.sort(mWordCountList);
        Collections.reverse(mWordCountList);
        return mWordCountList.subList(--start, stop);
    }

    public void removeCommonWords() {

        // defining an array of stop words (you probably want that as a constant somewhere else)
        final String[] stopWords = {"a", "able", "about", "across", "after", "all", "almost", "also", "am", "among", "an", "and", "any", "are", "as", "at", "be", "because", "been", "but", "by", "can", "cannot", "could", "dear", "did", "do", "does", "either", "else", "ever", "every", "for", "from", "get", "got", "had", "has", "have", "he", "her", "hers", "him", "his", "how", "however", "i", "if", "in", "into", "is", "it", "its", "just", "least", "let", "like", "likely", "may", "me", "might", "most", "must", "my", "neither", "no", "nor", "not", "of", "off", "often", "on", "only", "or", "other", "our", "own", "rather", "said", "say", "says", "she", "should", "since", "so", "some", "than", "that", "the", "their", "them", "then", "there", "these", "they", "this", "tis", "to", "too", "twas", "us", "wants", "was", "we", "were", "what", "when", "where", "which", "while", "who", "whom", "why", "will", "with", "would", "yet", "you", "your"};

        // printing un-processed list
//        System.out.printf("Dirty: %s%n", this.mWordList);

        // invoking removeAll to remove all stop words
        this.mWordList.removeAll(Arrays.asList(stopWords));

        // printing "clean" list
//        System.out.printf("Clean: %s%n", this.mWordList);

//        commonWords =
//
//        for (String word : commonWords) {

//        }
    }


    public void countWords() {

        this.mWordCountList = new ArrayList<>();
        Map<String, Integer> wordCounts = new HashMap<>();
        WordCount newWord;
        Integer count;

        for (String word : mWordList) {
            count = wordCounts.get(word);

            if (count == null ) {
                count = 0;
            }

            count++;
            wordCounts.put(word, count);

        }
//        loadWordCount(wordCounts);
        for (Map.Entry<String, Integer> word : wordCounts.entrySet()) {
            String wordKey = word.getKey();
            Integer wordCount = word.getValue();
            this.mWordCountList.add(new WordCount(wordKey, wordCount));
        }
    }


    public List<String> getWordList() {
        return mWordList;
    }


    public List<WordCount> getWordCountList() {
        return mWordCountList;
    }

//    // from http://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values-java
//    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
//        return map.entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (e1, e2) -> e1,
//                        LinkedHashMap::new
//                ));
//    }

    //    public Map<String, Integer> getTopWords() {
//        Map<String, Integer> wordCount = this.getWordCount();
//
//        ArrayList<Integer> values = new ArrayList<>();
//        values.addAll(wordCount.values()); // Array of counts only
//
//        Collections.sort(values, Collections.reverseOrder()); // sorts counts high to low
////        System.out.print(wordCount);
//
//        int lastCount = -1;
//        int rank = 1;
//
//        for (Integer count : values.subList(0, 20)) {
//            if (lastCount == count) { // without duplicates
//                continue;
//            }
//            lastCount = count;
//
//            for (String word : wordCount.keySet()) {
//                if (wordCount.get(word) == lastCount) { // which have this value
//                    System.out.printf("%d.) %s - %s  %n", rank, word, lastCount);
//                }
//            }
//            rank++;
//        }
//        return wordCount;

}

