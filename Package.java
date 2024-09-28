package Entity;

public class Package {
    private String packageId;
    private String packageName;
    private String packageDestination;
    private String packageType;
    private int amountOfDay;
    private double price;
    private String description;
    
    private static int packageCounter = 0;
    
    // Default constructor
    public Package() {}
    
    // Parameterized constructor, auto-generating packageId
    public Package(String packageId, String packageName, String packageDestination, 
                    String packageType, int amountOfDay, double price, String description) {
        this.packageName = packageName;
        this.packageDestination = packageDestination;
        this.packageType = packageType;
        this.amountOfDay = amountOfDay;
        this.packageId = packageId;
        this.price = price;
        this.description = description;
        packageCounter++;
    }
    
    // Setter methods
    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }
    
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    
    public void setPackageDestination(String packageDestination) {
        this.packageDestination = packageDestination;
    }
    
    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }
    
    public void setAmountOfDay(int amountOfDay) {
        this.amountOfDay = amountOfDay;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Getter methods
    public String getPackageName() {
        return packageName;
    }

    public String getPackageDestination() {
        return packageDestination;
    }

    public String getPackageId() {
        return packageId;
    }

    public int getAmountOfDay() {
        return amountOfDay;
    }

    public String getPackageType() {
        return packageType;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getDescription() {
        return description;
    }
    
    // Display package information
    public void showPackageInfo() {
        System.out.println("Package Id : " + packageId);
        System.out.println("Package Name : " + packageName);
        System.out.println("Package Destination : " + packageDestination);
        System.out.println("Package Type : " + packageType);
        System.out.println("Amount of Days : " + amountOfDay);
        System.out.println("Package Price : " + price + " BDT");
        System.out.println("Package Description : " + description);
    }
    
    // Add extra days to the package
    public void addAmountOfDay(int extraDays) {
        this.amountOfDay += extraDays;
    }
    
    // Static method to display total number of packages
    public static void totalNumberOfPackages() {
        System.out.println("Total Number Of Packages : " + packageCounter);
    }
    
    // Method to return all package details as a string
    public String getAllPackageAsString() {
        return "Package Id: " + packageId + "\n" +
               "Package Name: " + packageName + "\n" +
               "Package Destination: " + packageDestination + "\n" +
               "Package Type: " + packageType + "\n" +
               "Amount of Days: " + amountOfDay + "\n" +
               "Package Price: " + price + " BDT" + "\n" +
               "Package Description: " + description;
    }
}
