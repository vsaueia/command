package br.com.vs.templatemethod;

public class IntBubbleSorter extends BubbleSorter {
    private int[] array = null;

    public int sort(int[] theArray) {
        array = theArray;
        length = array.length;
        return applySort();
    }

    @Override
    protected void swap(int index) {
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    @Override
    protected boolean outOfOrder(int index) {
        return (array[index] > array[index + 1]);
    }
}
