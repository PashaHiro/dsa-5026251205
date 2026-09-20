public class ColourPrint extends PrintJob {

    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    public int calculateCharge() {
        int pages = getPages();
        int printCost = 0;

        if (pages <= 10) {
            printCost = pages * 1500;
        } else {
            printCost = (10 * 1500) + ((pages - 10) * 1000);
        }

        return printCost + 2000; 
    }

    public String label() {
        return "Colour";
    }
}