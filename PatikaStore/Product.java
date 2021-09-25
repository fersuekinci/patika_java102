public class Product {
    private int id;
    private String pName;
    private double price;
    private double discount;
    private int stock;
    private int screenSize;
    private String color;
    private int ram;
    private int battary;
    private int storage;
    private int memory;
    Brand brand;

    public Product(int id, String pName, double price, double discount, int stock, int screenSize, String color, int ram, int battary, int storage, int memory, Brand brand) {
        this.id = id;
        this.pName = pName;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
        this.screenSize = screenSize;
        this.color = color;
        this.ram = ram;
        this.battary = battary;
        this.storage = storage;
        this.memory = memory;
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getBattary() {
        return battary;
    }

    public void setBattary(int battary) {
        this.battary = battary;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
