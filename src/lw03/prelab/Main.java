import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        problem1();
        problem2();
        problem3();
    }
    private static void problem1() throws Exception{
        Scanner input = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        List<String> playlist = new ArrayList<>();
        while(input.hasNextLine()){
            String musik = input.nextLine().trim();

            if(musik.isEmpty()){
                continue;
            }

            if(musik.startsWith("ADD ")){
                playlist.add(musik.substring(4));
            }else if(musik.startsWith("INSERT ")){
                String[] bagian = musik.split(" ", 3);
                int nomor = Integer.parseInt(bagian[1]);
                playlist.add(nomor, bagian[2]);
            }else if(musik.startsWith("REMOVE ")){
                String[] lagu = musik.split(" ", 2);
                playlist.remove(lagu[1]);
            }
        }
        input.close();

        int y = 1;
        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for(String x : playlist){
            
            
            System.out.println(y + ": " + x);
            y++;
        }
    }
    


    private static void problem2() throws Exception{
        Scanner input = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> unik = new LinkedHashSet<>();
        int duplikat = 0;

        while(input.hasNextLine()){
            String nama = input.nextLine();

            if(nama.isEmpty()){
                continue;
            }

            if(!unik.add(nama)){
                duplikat++;
            }
        }
        input.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + unik.size());
        int hitung = 1;
        for(String x : unik){
            System.out.println(hitung + ". " + x);
            hitung++;
        }
        System.out.println("Duplicate registrations: " + duplikat);
    }
    private static void problem3() throws Exception{
        Scanner input = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int gagal = 0;


        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] bagian = line.split(" ");
            String tipe = bagian[0];
            String produk = bagian[1];
            int quantity = Integer.parseInt(bagian[2]);

            if(tipe.equals("ADD")){
                if(inventory.containsKey(produk)){
                    int stok = inventory.get(produk);
                    inventory.put(produk, stok + quantity);
                }else{
                    inventory.put(produk, quantity);
                }
            }else if(tipe.equals("SELL")){
                if(inventory.containsKey(produk) && quantity <= inventory.get(produk)){
                    inventory.put(produk, inventory.get(produk) - quantity);
                }else{
                    gagal++;
                }
            }
          
        }
        input.close();

        System.out.println("===== Problem 3 =====");
        for(Map.Entry<String, Integer> barang : inventory.entrySet()){
           System.out.println(barang.getKey() + ": " + barang.getValue());
        }
        System.out.println("Failed sales: " + gagal);
        
    }
}