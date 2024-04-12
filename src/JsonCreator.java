import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonCreator {
    private final Warehouse[] warehouses;
    private final Manufactory[] manufactories;
    private final OtherData[] otherDates;
    private final JSONObject file = new JSONObject();

    public JsonCreator(Warehouse[] warehouses, Manufactory[] manufactories, OtherData[] otherDates) {
        this.warehouses = warehouses;
        this.manufactories = manufactories;
        this.otherDates = otherDates;
    }

    public void creatingJson(String filepath) {
        int objectLength = manufactories.length;
        JSONArray listManufactory = new JSONArray();
        JSONArray listWarehouse = new JSONArray();
        JSONArray listOtherDate = new JSONArray();
        for (int i = 0; i < objectLength - 1; i++) {
            listManufactory.add(manufactories[i].toString());
            listWarehouse.add(warehouses[i].toString());
            listOtherDate.add(otherDates[i].toString());
        }
        file.put("Комания производитель", listManufactory);
        file.put("Место хранения", listWarehouse);
        file.put("Допонительные сведения", listOtherDate);
        try {
            File saveFile = new File(filepath);
            FileOutputStream outputStream = new FileOutputStream(saveFile);
            byte[] buffer = file.toJSONString().getBytes();
            outputStream.write(buffer);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
