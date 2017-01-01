
import java.io.File;


public class Main {

    public static void main(String[] args) {

        if(args.length > 0) {

            TxtToList wordList = new TxtToList(new File(args[0]));

            wordList.removeCommonWords();

            wordList.countWords();

//            int count = 0;
//            for (WordCount word : wordList.getWordCountList(1, 20)) {
//                count++;
//                System.out.printf("%-2d) %s  %n", count, word);
//            }

            wordList.printWordGraph();

        }

    }

}

