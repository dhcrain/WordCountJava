
import java.io.File;


public class Main {

    public static void main(String[] args) {

        if(args.length > 0) {
            File inFile = new File(args[0]);
            TxtToList wordList = new TxtToList(inFile);

//            System.out.printf("Word counts: %s, %n", wordList.getWordCount());
//            System.out.printf("Sorted Word counts: %s, %n", wordList.sortByValue(wordList.getWordCount()));
            wordList.getTopWords();

        }

    }

}

