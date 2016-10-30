package br.com.vs.strategy;

public class IntSortHandler implements SortHandler {
    private int[] array = null;

    @Override
    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    @Override
    public boolean isOutOfOrder(int index) {
        return array[index] > array[index + 1];
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public void setArray(int[] array) {
        this.array = array;
    }
}
