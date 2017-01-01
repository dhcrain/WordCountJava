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
        final String[] stopWords = {"a", "able", "about", "across", "after", "all", "almost", "also", "am", "among", "an", "and", "any", "are", "as", "at", "be", "because", "been", "but", "by", "can", "cannot", "could", "dear", "did", "do", "does", "either", "else", "ever", "every", "for", "from", "get", "got", "had", "has", "have", "he", "her", "hers", "him", "his", "how", "however", "i", "if", "in", "into", "is", "it", "its", "just", "least", "let", "like", "likely", "may", "me", "might", "most", "must", "my", "neither", "no", "nor", "not", "of", "off", "often", "on", "only", "or", "other", "our", "own", "rather", "said", "say", "says", "she", "should", "since", "so", "some", "than", "that", "the", "their", "them", "then", "there", "these", "they", "this", "tis", "to", "too", "twas", "us", "wants", "was", "we", "were", "what", "when", "where", "which", "while", "who", "whom", "why", "will", "with", "would", "yet", "you", "your"};
        this.mWordList.removeAll(Arrays.asList(stopWords));
    }

    public void printWordGraph() {
        List<WordCount> wordCountList = getWordCountList(1, 20);
        double graphMax = (double) wordCountList.get(0).getCount();
        int rank = 0;
        for (WordCount wordCount : wordCountList) {
            rank++;
            String word = wordCount.getWord();
            Integer count = wordCount.getCount();
            // get 1st item, scale the graph based on that number
            Double scale = (count * (50.0 / graphMax));
//            System.out.println(scale.intValue());
            String graph = new String(new char[scale.intValue()]).replace("\0", "#");
            System.out.printf("%-2d) %-13s:\t %s (%d) %n", rank, word, graph, count);
        }
    }

    public void countWords() {

        this.mWordCountList = new ArrayList<>();
        Map<String, Integer> wordCounts = new HashMap<>();
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


}

