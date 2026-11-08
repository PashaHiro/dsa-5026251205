import java.util.*;


class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = input.nextInt();
        int[] data = new int[n];

        for(int i = 0; i<n; i++){
            data[i] = input.nextInt();
        }

        urut(data);

        int k = input.nextInt();
        for(int i = 0; i<k; i++){
            int target = input.nextInt();
            cariTarget(data, target);
        }
        



    }

    static void urut(int[] data){
        for(int i=1; i<=3; i++){
            int temp = 0;
            for(int j = i-1; j>=0; j--){
                if(data[j+1] > data[j]){
                    temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(data));
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