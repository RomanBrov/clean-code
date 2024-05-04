package org.robotdreams.patterns.lesson12.theory;

import java.util.ArrayList;

public class CustomArrayList<E> extends ArrayList<E> {

    public E first() {
        if (this.isEmpty()) {
            return null;
        }
        return this.get(0);
    }

    public E last() {
        if (this.isEmpty()) {
            return null;
        }
        return this.get(this.size() - 1);
    }

    public E removeLast() {
        if (this.isEmpty()) return null;
        return this.remove(this.size() - 1);
    }
}
