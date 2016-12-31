
import java.io.File;


public class Main {

    public static void main(String[] args) {

        if(args.length > 0) {

            TxtToList wordList = new TxtToList(new File(args[0]));

//            System.out.printf("Word counts: %s, %n", wordList.getWordCount());
//            System.out.printf("Sorted Word counts: %s, %n", wordList.sortByValue(wordList.getWordCount()));

            wordList.removeCommonWords();
            
            wordList.countWords();

            int count = 0;
            for (WordCount word : wordList.getWordCountList(1, 20)) {
                count++;
                System.out.printf("%d.) %s  %n", count, word);
            }

        }

    }

}

