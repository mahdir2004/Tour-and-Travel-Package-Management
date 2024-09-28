package EntityList;
import Entity.Package;

public class PackageList {
    private Package[] packages;
    private int count; // To track the number of actual packages

    public PackageList() {
        packages = new Package[10];
        count = 0;
    }

    public PackageList(int size) {
        packages = new Package[size];
        count = 0;
    }

    public void insert(Package p) {
        if (count < packages.length) {
            packages[count] = p;
            count++;
            System.out.println("Successfully Inserted.");
        } else {
            System.out.println("Insertion Failed! Array is full.");
        }
    }

    public Package getById(String id) {
        for (int i = 0; i < count; i++) {
            if (packages[i] != null && packages[i].getPackageId().equals(id)) {
                System.out.println("Package Found.");
                return packages[i];
            }
        }
        System.out.println("No Package with This Id!");
        return null;
    }

    public boolean deletePackage(String id) {
        for (int i = 0; i < count; i++) {
            if (packages[i] != null && packages[i].getPackageId().equals(id)) {
                // Shift the elements to the left to maintain order
                for (int j = i; j < count - 1; j++) {
                    packages[j] = packages[j + 1];
                }
                packages[count - 1] = null; // Clear the last element
                count--;
                System.out.println("Package Removed.");
                return true;
            }
        }
        System.out.println("No Package with This Id!");
        return false;
    }

    public void showAll() {
        for (int i = 0; i < count; i++) {
            if (packages[i] != null) {
                System.out.println("--------------");
                packages[i].showPackageInfo();
                System.out.println("--------------");
            }
        }
    }
    
    public String getAllPackageAsString() {
        StringBuilder allPackage = new StringBuilder();
        for (int i = 0; i < count; i++) {
            if (packages[i] != null) {
                allPackage.append("---------------\n")
                          .append(packages[i].getAllPackageAsString())
                          .append("\n-------------\n");
            }
        }
        return allPackage.toString();
    }

    public void showByType(String type) {
        for (int i = 0; i < count; i++) {
            if (packages[i] != null && packages[i].getPackageType().equals(type)) {
                System.out.println("--------------");
                packages[i].showPackageInfo();
                System.out.println("--------------");
            }
        }
    }

    public Package searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (packages[i] != null && packages[i].getPackageDestination().equalsIgnoreCase(id)) {
                return packages[i];
            }
        }
        return null;
    }

    public int getSize() {
        return count; // Returns the actual number of packages in the list
    }

    public Package getPackageAt(int index) {
        if (index >= 0 && index < count) {
            return packages[index];
        }
        return null;
    }
}
