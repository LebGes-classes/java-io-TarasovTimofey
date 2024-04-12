import java.io.*;
import java.nio.charset.StandardCharsets;

public class Parser {
    private final String filename;
    private Warehouse[] warehouses;
    private Manufactory[] manufactories;
    private OtherData[] otherDates;
    private int numberLines;

    public Parser(String filename) {
        this.filename = filename;
    }

    private void getNumberLines() {
        try {
            FileInputStream file = new FileInputStream(filename);
            InputStreamReader ist = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(ist);
            int count = 0;
            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                count++;
            }
            numberLines = count;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inputData() {
        getNumberLines();
        try {
            FileInputStream file = new FileInputStream(filename);
            InputStreamReader ist = new InputStreamReader(file, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(ist);
            String line;
            String[] data;
            warehouses = new Warehouse[numberLines];
            manufactories = new Manufactory[numberLines];
            otherDates = new OtherData[numberLines];
            int count = 0;
            boolean cond = true;
            while ((line = reader.readLine()) != null) {
                if (cond || line.isEmpty()) {
                    cond = false;
                    continue;
                }
                data = line.split(";");
                warehouses[count] = new Warehouse(data[6]);
                manufactories[count] = new Manufactory(data[1]);
                otherDates[count] = new OtherData(data[0], data[2], data[3], data[4], data[5]);
                count++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Warehouse[] getWarehouses() {
        return warehouses;
    }

    public Manufactory[] getManufactories() {
        return manufactories;
    }

    public OtherData[] getOtherDates() {
        return otherDates;
    }
}
