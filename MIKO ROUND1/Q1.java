
import java.io.*;
import java.util.*;

public class SimpleDatabase {
    private static final String METADATA_FILE = "metadata.txt";
    private static final String TABLE_FILE = "table.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter SQL statement: ");
            String sql = scanner.nextLine();
            if (sql.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }
            parseSQLStatement(sql);
        }
        scanner.close();
    }

    private static void parseSQLStatement(String sql) {
        String[] tokens = sql.split("\\s+");
        if (tokens[0].equalsIgnoreCase("create") && tokens[1].equalsIgnoreCase("table")) {
            createTable(tokens);
        } else if (tokens[0].equalsIgnoreCase("insert") && tokens[1].equalsIgnoreCase("into")) {
            insertIntoTable(tokens);
        } else {
            System.out.println("Invalid SQL statement!");
        }
    }

    private static void createTable(String[] tokens) {
        try {
            FileWriter metadataWriter = new FileWriter(METADATA_FILE);
            FileWriter tableWriter = new FileWriter(TABLE_FILE);

            metadataWriter.write(Arrays.toString(Arrays.copyOfRange(tokens, 2, tokens.length - 1)));
            metadataWriter.flush();
            metadataWriter.close();

            tableWriter.write("");
            tableWriter.flush();
            tableWriter.close();

            System.out.println("Table created successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while creating the table.");
            e.printStackTrace();
        }
    }

    private static void insertIntoTable(String[] tokens) {
        try {
            String values = Arrays.toString(Arrays.copyOfRange(tokens, 3, tokens.length))
                    .replaceAll("[\\[\\]]", "");

            FileWriter tableWriter = new FileWriter(TABLE_FILE, true);
            tableWriter.write(values + "\n");
            tableWriter.flush();
            tableWriter.close();

            System.out.println("Data inserted into the table successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while inserting data into the table.");
            e.printStackTrace();
        }
    }
}
