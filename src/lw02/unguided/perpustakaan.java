import java.util.*;


class perpustakaan{
    public static void main(String[] args) {
        Scanner scan = new Scanner(perpustakaan.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> transaksi = new LinkedList<>();
        LinkedList<String[]> stok = new LinkedList<>();
        LinkedList<String[]> member = new LinkedList<>();
        Queue<String[]> pinjam = new LinkedList<>();
        Stack<String[]> gagal = new Stack<>();
        int max_buku = 2;


        while(scan.hasNext()){
            String nama = scan.next();
            String buku = scan.next();

            transaksi.add(new String[]{nama,buku});
        }
        scan.close();

        stok.add(new String[] {"Kalkulus","2"});
        stok.add(new String[] {"Fisika","1"});
        stok.add(new String[] {"Statistika","2"});
    }
}