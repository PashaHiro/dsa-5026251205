import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> kursus = new LinkedHashMap<>();
        List<String> cek = new ArrayList<>();
        int tolak = 0;

        while(input.hasNextLine()){
            String operasi = input.nextLine().trim();
            String[] bagian = operasi.split(" ");
            String perintah = bagian[0];
            String kode = bagian[1];

            if(perintah.equals("REGISTER")){
                int jumlah = Integer.parseInt(bagian[2]);
                if(jumlah <= 0){
                    tolak++;
                }else{
                    if(kursus.containsKey(kode)){
                        int isi = kursus.get(kode);
                        kursus.put(kode, isi + jumlah);
                    }else{
                        kursus.put(kode, jumlah);
                    }

                }

            }else if(perintah.equals("WITHDRAW")){
                int jumlah = Integer.parseInt(bagian[2]);
                if(kursus.containsKey(kode) && jumlah<= kursus.get(kode)){
                    kursus.put(kode, kursus.get(kode) - jumlah);
                }else{
                    tolak++;
                    continue;
                }
            }else if(perintah.equals("CHECK")){
                if(kursus.containsKey(kode)){
                    cek.add(kode + " : " + kursus.get(kode) + " Student");
                }else{
                    cek.add(kode + " : Not Found");
                }
            }
        }
        input.close();

        System.out.println("===== Enrollment Checks =====");
        for(String x : cek){
            System.out.println(x);
        }
        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for(String hasil : kursus.keySet()){
            System.out.println(hasil + ": " + kursus.get(hasil) + " Student");
        }
        System.out.println();
        System.out.println("Rejected operations: " + tolak);
    }
}