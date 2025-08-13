package mainPackage;

import java.util.Arrays;

public class SortingAlgorithms {
    public SortingAlgorithms() {}


    public int[] SelectionSort(int[] list) {
        if (list.length >= 2) {
            int last = list.length - 1;
            int maxPos; int temp;

            while (last > 0) {
                maxPos = 0;
                for (int i = 1; i <= last; i++) {
                    if (list[i] > list[maxPos]) { maxPos = i; }
                }
                temp = list[maxPos];
                list[maxPos] = list[last];
                list[last] = temp;
                last--;
            } 
        }

        return list;
    }


    public int[] InsertionSort(int[] list) {
        if (list.length >= 2) {
            int pos = list.length - 1;
            int indexNew; int valueNew;

            while (pos > 0) {
                indexNew = pos - 1;
                valueNew = list[indexNew];
                while ((indexNew < list.length - 1) && (valueNew > list[indexNew + 1])) {
                    list[indexNew] = list[indexNew + 1];
                    indexNew++;
                }
                list[indexNew] = valueNew;
                pos--;
            }
        }

        return list;
    }

    /**
     * The public quicksort method that can be called externally.
     * @param list - The list of integers to sort.
     * @return Returns the sorted version of the original list of integers.
     */
    public int[] Quicksort(int[] list) {
        int left = 0; int right = list.length - 1;
        int temp;
        if (list.length == 0 || list.length == 1) { // Quickest Sort
            return list;
        } else if (list.length == 2) { // Quicker Sort
            if (list[0] > list[1]) {
                temp = list[0]; 
                list[0] = list[1];
                list[1] = temp;
            }
            return list;
        } else { // The actual Quicksort algorithm
            int pivot = list[0];
            while (left <= right) {
                while (list[left] <= pivot && left < list.length-1) { left++; }
                if (left > right) { break; }
                while (list[right] >= pivot && right > 0) { right--; }

                temp = list[left];
                list[left] = list[right];
                list[right] = temp;

                left++;
                if (left > right) { break; } else { right--; }
            }
            list[0] = list[right];
            list[right] = pivot;

            list = Quicksort(list, 0, right-1);
            list = Quicksort(list, right+1, list.length-1);
            return list;
        }
    }

    /**
     * The private quicksort method that provides the recursion.
     * @param list 
     * @param first - The start index of the porition of the original list that should be sorted.
     * @param last - The end index of the porition of the original list that should be sorted.
     * @return Returns the list with the numbers between first and last (inclusive) sorted.
     */
    private int[] Quicksort(int[] list, int first, int last) {
        int left = first; int right = last;
        int temp;
        if (left >= right) { // Quickest Sort
            return list;
        } else if (right - left == 1) { // Quicker Sort
            if (list[left] > list[right]) {
                temp = list[left]; 
                list[left] = list[right];
                list[right] = temp;
            }
            return list;
        } else { // The actual Quicksort algorithm
            int pivot = list[first];
            while (left <= right) {
                while (list[left] <= pivot && left < last) { left++; }
                if (left > right) { break; }
                while (list[right] >= pivot && right > first) { right--; }

                temp = list[left];
                list[left] = list[right];
                list[right] = temp;

                left++; 
                if (left > right) { break; } else { right--; }
            }
            list[first] = list[right];
            list[right] = pivot;

            list = Quicksort(list, first, right-1);
            list = Quicksort(list, right+1, last);
            return list;
        }
    }

    public int[] MergeSort(int[] list) {
        int first = 0;
        int last = list.length - 1;

        if (first >= last) {
            return list;
        }

        int middle = (first+last)/2;
        int[] aux = new int[list.length];

        list = MergeSort(list, first, middle, aux);
        list = MergeSort(list, middle+1, last, aux);
        list = Merge(list, first, middle, last, aux);
        return list;
    }

    private int[] MergeSort(int[] list, int first, int last, int[] aux) {
        if (first >= last) {
            return list;
        }

        int middle = (first+last)/2;

        list = MergeSort(list, first, middle, aux);
        list = MergeSort(list, middle+1, last, aux);
        list = Merge(list, first, middle, last, aux);
        return list;
    }

    private int[] Merge(int[] list, int first, int middle, int last, int[] aux) {
        int i, j;

        for (i = middle+1; i > first; i--) {
            aux[i-1] = list[i-1];
        }
        for (j = middle; j < last; j++) {
            aux[last+middle-j] = list[j+1];
        }

        for (int k = first; k <= last; k++) {
            if (aux[j] < aux[i]) {
                list[k] = aux[j--];
            } else {
                list[k] = aux[i++];
            }
        }
        return list;
    }


}
