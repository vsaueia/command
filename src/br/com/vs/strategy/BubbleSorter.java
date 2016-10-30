package br.com.vs.strategy;

public class BubbleSorter {
    private int operations = 0;
    private int length = 0;
    private SortHandler itsSortHandler = null;

    public BubbleSorter(SortHandler sortHandler) {
        itsSortHandler = sortHandler;
    }

    public int sort(int[] array) {
        itsSortHandler.setArray(array);
        length = itsSortHandler.length();
        operations = 0;
        if (length <= 1) {
            return operations;
        }

        for(int nextToLast = length -2; nextToLast >= 0; nextToLast--) {
            for(int index = 0; index <= nextToLast; index++) {
                if (itsSortHandler.isOutOfOrder(index)) {
                    itsSortHandler.swap(index);
                }
                operations++;
            }
        }
        return operations;
    }
}
