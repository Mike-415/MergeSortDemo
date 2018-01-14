import java.util.Random;

public class MergeSort
{
    static void mergeSort(int[] array)
    {
        mergeSort(array, new int[array.length], 0, array.length-1);
    }

    static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd)
    {

        if(leftStart >= rightEnd)
        {
//            System.out.println("Array: "+arrToStr(array)+"\n\t leftStart: "+leftStart+" rightEnd: "+rightEnd);
//            System.out.println("***************BASE CASE*****************\n");
            return;
        }
//        System.out.print("Array: "+arrToStr(array)+"\n\t leftStart: "+leftStart+" rightEnd: "+rightEnd);
        int middle = (leftStart + rightEnd)/2;
//        System.out.println(" middle: "+middle);
//        System.out.println("LEFT SORT");
        mergeSort(array, temp, leftStart, middle);
//        System.out.println("RIGHT SORT");
        mergeSort(array, temp, middle+1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd )
    {
        int leftEnd = (rightEnd+leftStart)/2;
        int rightStart = leftEnd + 1;
        int size = (rightEnd - leftStart)+1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while(left <= leftEnd && right <= rightEnd)
        {
            if(array[left] <= array[right])
            {
                temp[index] = array[left];
                left++;
            }
            else
            {
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        /*
        public static void arraycopy(Object source_arr, int sourcePos,
                            Object dest_arr, int destPos, int len)
        Parameters :
            -source_arr : array to be copied from
            -sourcePos : starting position in source array from where to copy
            -dest_arr : array to be copied in
            -destPos : starting position in destination array, where to copy in
            -len : total no. of components to be copied.
         */
        System.arraycopy(array, left, temp, index, (leftEnd - left)+1);
        System.arraycopy(array, right, temp, index, (rightEnd-right)+1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

    private static String arrToStr(int[] intArray)
    {
        String results = "\t[ ";
        for(int num: intArray)
        {
            results += num+" ";
        }
        results += "]";
        return results;
    }

    private static int[] getRandomArray()
    {
        int[] intArray = new int[10];
        for(int i = 0; i < 10; i++)
        {
            intArray[i] = (new Random()).nextInt(100)+1;
        }
        return intArray;
    }

    public static void main(String...args)
    {
        System.out.println("\nMerge Sort Demonstration: \n");
        int[] intArray = getRandomArray();
        System.out.println("\t-Unsorted: "+arrToStr(intArray));
        mergeSort(intArray);
        System.out.println("\n\t-Sorted: "+arrToStr(intArray));
    }
}
