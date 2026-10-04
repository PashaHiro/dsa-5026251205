import java.util.*;


class perpustakaan{
    public static void main(String[] args) {
        Scanner scan = new Scanner(perpustakaan.class.getResourceAsStream("borrowing"));
        LinkedList<String[]> transaksi = new LinkedList<>();
        // LinkedList<String[]> stok = new LinkedList<>();
        // LinkedList<String[]> member = new LinkedList<>();
        // Queue<String[]> pinjam = new LinkedList<>();
        // Stack<String[]> gagal = new Stack<>();


        while(scan.hasNext()){
            String nama = scan.next();
            String buku = scan.next();

            transaksi.add(new String[]{nama,buku});
        }
        scan.close();

        for(String[] x : transaksi){
            System.out.println(x[0] + " " + x[1]);
        }
    }
}