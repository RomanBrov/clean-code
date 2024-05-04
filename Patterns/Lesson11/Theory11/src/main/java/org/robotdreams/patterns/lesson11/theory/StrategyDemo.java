package org.robotdreams.patterns.lesson11.theory;

import java.util.Arrays;
import java.util.Collection;

public class StrategyDemo {
    public void start() {
        Integer arrayToSort[] = { 1, 6, 3, 2, 5 };

        // ideally we should get it from factory
        QuickSorter<Integer> quickSorter = new QuickSorter<Integer>();
        quickSorter.Sort(Arrays.asList(arrayToSort));

        InsertionSorter<Integer> insertionSorter = new InsertionSorter<Integer>();
        insertionSorter.Sort(Arrays.asList(arrayToSort));

    }
}

interface Sorter<T>{
    void Sort(Collection<T> collection);
}

class QuickSorter<T> implements Sorter<T>{

    @Override
    public void Sort(Collection<T> collection) {

    }
}

class InsertionSorter<T> implements Sorter<T>{

    @Override
    public void Sort(Collection<T> collection) {

    }
}
