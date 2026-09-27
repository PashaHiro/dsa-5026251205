import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transaksi = new LinkedList<>();

        Scanner buktitransaksi = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        while (buktitransaksi.hasNextLine()) {
            String baris = buktitransaksi.nextLine();
            String[] data = baris.split(" ");
            transaksi.add(data);
        }
        buktitransaksi.close();

        LinkedList<String[]> customer = new LinkedList<>();

        for (int i = 0; i < transaksi.size(); i++) {
            String nama = transaksi.get(i)[0];

            boolean sudahAda = false;
            for (int j = 0; j < customer.size(); j++) {
                if (customer.get(j)[0].equals(nama)) {
                    sudahAda = true;
                }
            }

            if (!sudahAda) {
                String[] dataCustomer = {nama, "0"};
                customer.add(dataCustomer);
            }
        }

        Queue<String[]> antrian = new LinkedList<>();
        for (int i = 0; i < transaksi.size(); i++) {
            antrian.add(transaksi.get(i));
        }

        Stack<String[]> gagal = new Stack<>();

        while (!antrian.isEmpty()) {
            String[] t = antrian.poll();
            String nama = t[0];
            String jenis = t[1];
            int jumlah = Integer.parseInt(t[2]);
            int index = -1;
            for (int j = 0; j < customer.size(); j++) {
                if (customer.get(j)[0].equals(nama)) {
                    index = j;
                }
            }

            int saldo = Integer.parseInt(customer.get(index)[1]);

            if (jenis.equals("DEPOSIT")) {
                saldo = saldo + jumlah;
                customer.get(index)[1] = String.valueOf(saldo);
            } else {
                if (jumlah > saldo) {
                    gagal.push(t);
                } else {
                    saldo = saldo - jumlah;
                    customer.get(index)[1] = String.valueOf(saldo);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (int i = 0; i < customer.size(); i++) {
            System.out.println(customer.get(i)[0] + " : " + customer.get(i)[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!gagal.isEmpty()) {
            String[] t = gagal.pop();
            System.out.println(t[0] + " " + t[1] + " " + t[2]);
        }
    }
}