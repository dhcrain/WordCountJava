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
            ioe.printStackTrace();
        }
        this.mWordList = wordList;
    }


    public Map<String, Integer> getWordCount() {
        Map<String, Integer> wordCounts = new TreeMap<>();
        for (String word : mWordList) {
            Integer count = wordCounts.get(word);
            if (count == null ) {
                count = 0;
            }
            count++;
            wordCounts.put(word, count);
        }
        return wordCounts;
    }


    public Map<String, Integer> getTopWords() {
        Map<String, Integer> wordCount = this.getWordCount();

        ArrayList<Integer> values = new ArrayList<>();
        values.addAll(wordCount.values()); // Array of counts only

        Collections.sort(values, Collections.reverseOrder()); // sorts counts high to low
//        System.out.print(values.subList(0, 20));

        int lastCount = -1;

        for (Integer count : values.subList(0, 20)) {
            if (lastCount == count) { // without duplicates
                continue;
            }
            lastCount = count;

            for (String word : wordCount.keySet()) {

                if (wordCount.get(word) == lastCount) { // which have this value
                    System.out.println(word + " " + lastCount);
                }
            }
        }
        return wordCount;
    }

// from http://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values-java
    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(/*Collections.reverseOrder()*/))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public List<String> getWordList() {
        return mWordList;
    }
}

