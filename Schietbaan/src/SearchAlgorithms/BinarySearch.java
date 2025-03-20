package SearchAlgorithms;

public class BinarySearch
{
    // Implementatie van Binary Search
    public static int binarySearch(int[] sortedArray, int target)
    {
        int left = 0, right = sortedArray.length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;

            if (sortedArray[mid] == target)
            {
                return mid;
            }
            else if (sortedArray[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] sortedNumbers = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int targetBinary = 50;
        System.out.println("Binary Search Index: " + binarySearch(sortedNumbers, targetBinary));
    }
}
