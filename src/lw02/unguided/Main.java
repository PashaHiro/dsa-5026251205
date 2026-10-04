import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> transaksi = new LinkedList<>();
        LinkedList<String[]> stok = new LinkedList<>();
        LinkedList<String[]> member = new LinkedList<>();
        Queue<String[]> pinjam = new LinkedList<>();
        Stack<String[]> gagal = new Stack<>();
        LinkedList<String[]> sukses = new LinkedList<>();

        while (input.hasNextLine()) {
            String baris = input.nextLine().trim();
            if (baris.isEmpty()) break;
            String[] data = baris.split("\\s+");
            transaksi.add(data);
        }
        input.close();

        stok.add(new String[] {"Kalkulus", "2"});
        stok.add(new String[] {"Fisika", "1"});
        stok.add(new String[] {"Statistika", "2"});

        for (String[] x : transaksi) {
            String nama = x[0];
            boolean ada = false;
            for (String[] y : member) {
                if (nama.equals(y[0])) {
                    ada = true;
                    break;
                }
            }
            if (!ada) {
                member.add(new String[] {nama, "2"});
            }
        }

        pinjam.addAll(transaksi);
        while (!pinjam.isEmpty()) {
            String[] x = pinjam.poll();
            String nama = x[0];
            String buku = x[1];

            int index = -1;
            for (int i = 0; i < member.size(); i++) {
                if (member.get(i)[0].equals(nama)) {
                    index = i;
                    break;
                }
            }

            int sisa = Integer.parseInt(member.get(index)[1]);

            if (sisa > 0) {
                int indexBuku = -1;
                for (int i = 0; i < stok.size(); i++) {
                    if (stok.get(i)[0].equals(buku)) {
                        indexBuku = i;
                        break;
                    }
                }

                if (indexBuku != -1) {
                    int jumlahBuku = Integer.parseInt(stok.get(indexBuku)[1]);
                    if (jumlahBuku > 0) {
                        jumlahBuku--;
                        stok.get(indexBuku)[1] = String.valueOf(jumlahBuku);
                        sisa--;
                        member.get(index)[1] = String.valueOf(sisa);
                        sukses.add(x);
                    } else {
                        gagal.push(x);
                    }
                } else {
                    gagal.push(x);
                }
            } else {
                gagal.push(x);
            }
        }

        System.out.println("=== Successfully Processed Requests ===");
        for (String[] x : sukses) {
            System.out.println(x[0] + " " + x[1]);
        }

        System.out.println("=== Remaining Book Stock ===");
        for (String[] x : stok) {
            System.out.println(x[0] + " " + x[1]);
        }

        System.out.println("=== Failed Requests ===");
        while (!gagal.isEmpty()) {
            String[] x = gagal.pop();
            System.out.println(x[0] + " " + x[1]);
        }
    }
}
