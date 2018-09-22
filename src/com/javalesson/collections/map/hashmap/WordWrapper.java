package com.javalesson.collections.map.hashmap;

public class WordWrapper  implements Comparable<WordWrapper>{
    private final String word;
    private final Integer count;

    public WordWrapper(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public Integer getCount() {
        return count;
    }

    @Override
    public int compareTo(WordWrapper thatWord) {
        if(count < thatWord.getCount() ){
            return -1;
        }
        if (count > thatWord.getCount()){
            return 1;
        }
        return word.compareTo(thatWord.getWord());
    }

    @Override
    public String toString() {
        return word + " -> "+count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordWrapper that = (WordWrapper) o;

        if (word != null ? !word.equals(that.word) : that.word != null) return false;
        return count != null ? count.equals(that.count) : that.count == null;
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }
}
