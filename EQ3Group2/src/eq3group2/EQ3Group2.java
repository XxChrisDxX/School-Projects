package eq3group2;
import java.util.Random;
import java.util.Arrays;

/*@author Chris Decker*/

public class EQ3Group2 {

    public static void main(String[] args) {

        int[] array1 = new int[10];
        int[] array2 = new int[10];
        
        for(int i = 0; i < array1.length; i++){ //initializing array1 as random values and copying array1 values into array2
            Random random = new Random();
            int temporary = random.nextInt(11);
            array1[i] = temporary;
            
            array2[i] = array1[i];
        }
        
        int[] array3 = new int[10];
        int[] array4 = new int[10];
        System.arraycopy(array1, 0, array3, 0, 10); //copies array1 into array3
        System.arraycopy(array1, 0, array4, 0, 10);
        
        for(int i = 0, count = 0; i < array1.length; i++, count++){ //printing out the location of each element in array and element at that location
            System.out.println("The element at index " + count + " in the array1 is " + array1[i] + ", in the array2 is " + array2[i] + ", array3 is " + array3[i] + ".");
        }
        for(int i = 0, count = 0; i < array1.length; i++, count++){ //printing out the location of each element in array and element at that location
            Arrays.sort(array1); //public static void sort(int[] a)
            System.out.println("The element at index " + count + " in the array1 after being sorted is " + array1[i] + ".");
        }
        for(int i = 0, count = 0; i < array1.length; i++, count++){ //printing out the location of each element in array and element at that location
            Arrays.sort(array4,0,5); //public static void sort (int[] a, int fromIndex, int toIndex)
            System.out.println("The element at index " + count + " in the array4 after being sorted from index 0 to 5 exclusively is " + array4[i] + ".");
        }
        
        System.out.println("The number 4 is found at index " + Arrays.binarySearch(array1, 4) + "."); //public static int binarySearch(int[] a, int key)
        System.out.println("The array1 array is equal to array2 " + Arrays.equals(array1, array2) + "."); //public static boolean equals(int[] a, int[] a2)
        System.out.println("The array2 array is equal to array3 " + Arrays.equals(array2, array3) + ".");
        
        for(int i = 0, count = 0; i < array1.length; i++, count++){ //printing out the location of each element in array and element at that location
            Arrays.fill(array1,0); //public static void fill(int[] a, int val)
            System.out.println("The element at index " + count + " in the array1 after using the fill method with 0 as the int value is " + array1[i] + ".");
        }
        for(int i = 0, count = 0; i < array1.length; i++, count++){ //printing out the location of each element in array and element at that location
            Arrays.fill(array1,0,5,5); //public static void fill(int[] a, int fromIndex,int toIndex, int val)
            System.out.println("The element at index " + count + " in the array1 after using the fill method with 5 as the int value from index 0 to 5 exclusively is " + array1[i] + ".");
        }
    }
}