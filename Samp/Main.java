package Samp;

public class Main {
    public static void main (String[] args)
    {
        sortedOrNotAlt(new int[]{1,2,3,3,4,5});
    }
    public static void sortedOrNot(int[] array){
        int currentValue;
        int prevValue;
        int length = array.length;
        if(length<2){
            System.out.println("Sorted");
            return;
        }
        boolean sorted = true;
        String order = "";
        for(int index = 1; index<length; index++){
            prevValue = array[index-1];
            currentValue = array[index];
            if(prevValue > currentValue){
                if(order.equals(""))
                    order = "descending";
                else if(order.equals("ascending")){
                    sorted = false;
                    break;
                }
            }else if (currentValue > prevValue){
                if(order.equals(""))
                    order = "ascending";
                else if(order.equals("descending")){
                    sorted = false;
                    break;
                }
            }
        }
        if(sorted)
            System.out.println("The order is "+ order);
        else
            System.out.println("The array is not sorted.");

    }

    public static sortedornot sortedOrNotAlt(int[] array){
        int length = array.length;
        int countAsc = 0;
        int countDesc = 0;
        for(int i=1; i<length; i++){
            if(array[i]>=array[i-1])
                countAsc++;
            if(array[i]<=array[i-1])
                countDesc++;
        }
        if(countAsc==length-1){
            return sortedornot.ASCENDING;
        }else if(countDesc==length-1){
            return sortedornot.DESCENDING;
        }else
            return sortedornot.SORTED;
    }

}
enum sortedornot{
    SORTED, ASCENDING, DESCENDING
}
