/**
 * Created by daviscrain on 12/30/16.
 */


public class WordCount implements Comparable<WordCount> {
    private String mWord;
    private Integer mCount;

    public WordCount(String word, Integer count) {
        this.mWord = word;
        this.mCount = count;
    }

    public void addToCount(Integer number) {
        this.mCount += number;
    }


    @Override
    public String toString() {
        return String.format("%s - %d", mWord, mCount);
    }


    public int compareTo(WordCount otherWord) {
        return this.mCount.compareTo(otherWord.mCount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WordCount)) return false;

        WordCount wordCount = (WordCount) o;

        return mWord.equals(wordCount.mWord);
    }

    @Override
    public int hashCode() {
        return mWord.hashCode();
    }


    public Integer getCount() {
        return mCount;
    }

    public String getWord() {
        return mWord;
    }
}
