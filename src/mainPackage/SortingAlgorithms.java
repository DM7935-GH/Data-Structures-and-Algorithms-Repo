package mainPackage;

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
}
