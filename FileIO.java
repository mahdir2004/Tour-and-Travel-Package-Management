package Files;

import java.io.*;
import java.util.Scanner;
import Entity.Package;
import EntityList.PackageList;

public class FileIO {

    public static boolean checkUser(String userId, String userPass) {
        boolean flag = false;
        try {
            Scanner fsc = new Scanner(new File("./Files/users.txt"));
            while (fsc.hasNextLine()) {
                String line = fsc.nextLine();
                String[] data = line.split(";");
                if (userId.equals(data[3]) && userPass.equals(data[2])) {
                    flag = true;
                    break;
                }
            }
            fsc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found: users.txt");
        } catch (Exception ex) {
            System.out.println("Cannot Read File");
        }
        return flag;
    }

    public static void loadPackageFromFile(PackageList packageList) {
        try {
            Scanner fsc = new Scanner(new File("./Files/packages.txt"));
            while (fsc.hasNextLine()) {
                String line = fsc.nextLine();
                String[] data = line.split(";");
                Package tempp = new Package(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        Double.parseDouble(data[5]),
                        data[6]);
                packageList.insert(tempp);
            }
            fsc.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found: packages.txt");
        } catch (Exception ex) {
            System.out.println("Cannot Read File");
        }
    }

    public static void writePackageInFile(Package p) {
        try {
            FileWriter fw = new FileWriter(new File("./Files/packages.txt"), true);
            String line = p.getPackageId() + ";" + p.getPackageName() + ";" + p.getPackageDestination() + ";" +
                    p.getPackageType() + ";" + p.getAmountOfDay() + ";" + p.getPrice() + ";" + p.getDescription() + "\n";
            fw.write(line);
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file: packages.txt");
        }
    }

    // New method to write all packages from the list to the file
    public static void writeAllPackagesToFile(PackageList packageList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./Files/packages.txt"))) {
            for (int i = 0; i < packageList.getSize(); i++) {
                Package p = packageList.getPackageAt(i);
                String line = p.getPackageId() + ";" + p.getPackageName() + ";" + p.getPackageDestination() + ";" +
                        p.getPackageType() + ";" + p.getAmountOfDay() + ";" + p.getPrice() + ";" + p.getDescription();
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Error writing all packages to file: packages.txt");
        }
    }
}
