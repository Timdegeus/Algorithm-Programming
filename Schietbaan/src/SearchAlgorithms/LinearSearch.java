package SearchAlgorithms;

public class LinearSearch
{
    // Methode om lineair te zoeken in een array
    public static int linearSearch(String[] array, String target) {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i].equals(target))
            {
                return i; // Index van het gevonden element retourneren
            }
        }
        return -1; // Element niet gevonden
    }

    public static void main(String[] args)
    {
        String[] schutters = {"Hendrik", "Karel", "Jan"};
        String target = "Karel";

        int result = linearSearch(schutters, target);

        if (result != -1)
        {
            System.out.println("Element gevonden op index: " + result);
        }
        else
        {
            System.out.println("Element niet gevonden.");
        }
    }
}
