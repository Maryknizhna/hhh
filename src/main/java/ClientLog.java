import java.io.*;
import java.util.Scanner;

public class ClientLog {
    protected File file;

    protected void log(int productNum, int amount) {
        file = new File("log.txt");
        int correctNumber = productNum + 1;
        try (FileWriter out = new FileWriter(file, true)) {
            out.write(correctNumber + ", " + amount + "\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found!!!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportAsCSV(File csvFile) {
        try {
            FileWriter writer;
            File txtFile = new File("log.txt");
            Scanner scan = new Scanner(file);
            csvFile = new File("log.csv");
            txtFile.createNewFile();
            writer = new FileWriter(csvFile);
            writer.append("productNum, amount" + "\n");
            while (scan.hasNext()) {
                String csv = scan.nextLine().replace("|", ",");
                System.out.println(csv);
                writer.append(csv);
                writer.append("\n");
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
