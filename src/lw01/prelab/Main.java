import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        
        ArrayList<PrintJob> jobs = new ArrayList<>();
        
        File file = new File("jobs.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            // Baca tipe, ID, dan halamannya
            String type = scanner.next();
            String id = scanner.next();
            int pages = scanner.nextInt();

            if (type.equals("MONO")) {
                jobs.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                jobs.add(new ColourPrint(id, pages));
            }
        }
        
        scanner.close();

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}