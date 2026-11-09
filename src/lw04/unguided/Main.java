import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(Main.class.getResourceAsStream("card.txt"));

        int n = input.nextInt();
        int[] kartu = new int[n];
        for(int i = 0; i < n; i++){
            kartu[i] = input.nextInt();
        }

        selectionSort(kartu);

        int k = input.nextInt();
        for(int i = 0; i<k; i++){
            int target = input.nextInt();
            cariTarget(kartu,target);
        }

    }

    static void selectionSort(int[] kartu){
        int temp = 0;
        for(int i = 0; i < 2; i++){
            int minIndex = i;
            for(int j = i+1; j < kartu.length; j++){
                if(kartu[j] < kartu[minIndex]){
                    minIndex = j;
                }
            }
            temp = kartu[minIndex];
            kartu[minIndex] = kartu[i];
            kartu[i] = temp;
        }

        System.out.println(Arrays.toString(kartu));

    }
    static void cariTarget(int[] data, int target){
        for(int i = 0; i < data.length; i++){
            if(data[i] == target){
                System.out.println(target + " : FOUND at index " + i);
                return;
            }
        }
        System.out.println(target + " : NOT FOUND");
    }
}