package br.com.vs.strategy;

public interface SortHandler {
    void swap(int index);
    boolean isOutOfOrder(int index);
    int length();
    void setArray(int[] array);
}
