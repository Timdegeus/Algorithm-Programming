package SortingAlgorithms;

import java.util.Arrays;

public class QuickSort
{
    public static <T extends Comparable<T>> T[] sort(T[] array)
    {
        T[] sortedArray = Arrays.copyOf(array, array.length);
        quickSort(sortedArray, 0, sortedArray.length - 1);
        return sortedArray;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high)
    {
        if (low < high)
        {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex -1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high)
    {
        T pivot = array[high];
        int i = low - 1;
        for(int j = low; j < high; j++)
        {
            if (array[j].compareTo(pivot) < 0)
            {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i+1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
