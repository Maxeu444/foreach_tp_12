package org.example.iterator;

import java.util.Iterator;

public class StringCharacters {
    public static void main(String[] args) {
        var wrapper = new StringIterator("Hello", true);

        while(wrapper.hasNext()) {
            System.out.println(wrapper.next());
        }
    }
}

class StringIterator implements Iterator<Character> {
    private String text;
    private int position;
    private boolean reverse;

    public StringIterator(String text, boolean reverse) {
        this.text = text;
        this.reverse = reverse;
        this.position = reverse ? text.length() - 1 : 0;
    }

    @Override
    public boolean hasNext() {
        return reverse ? position >= 0 : position < text.length();
    }

    @Override
    public Character next() {
        var current = text.charAt(position);
        position += reverse ? -1 : 1;
        return current;
    }
}