import java.util.Scanner;

// /Users/codeinium/programming/java/2sem/javaio/java-io-TarasovTimofey/src/IOS.txt
// /Users/codeinium/programming/java/2sem/javaio/java-io-TarasovTimofey/src/IOS.json

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите путь до файла: ");
        Scanner scanner = new Scanner(System.in);
        String filepathToOpen = scanner.nextLine();
        Parser parser = new Parser(filepathToOpen);
        parser.inputData();
        JsonCreator json = new JsonCreator(parser.getWarehouses(), parser.getManufactories(), parser.getOtherDates());
        System.out.print("Введите путь для сохранения json: ");
        String filepathToSave = scanner.nextLine();
        json.creatingJson(filepathToSave);
    }
}
