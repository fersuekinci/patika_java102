import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Product> noteBookList = new ArrayList<>();
        List<Product> mobilePhoneList = new ArrayList<>();
        List<Brand> brands = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

        noteBookList.add(new NoteBook(1, "huawei matebook 14", 7000, 20, 50, 15, "black", 16, 5, 256, 128, brands.get(3)));

        mobilePhoneList.add(new MobilePhone(1, "samsung galaxy a51", 7000, 20, 50, 15, "black", 16, 5, 256, 128, brands.get(3)));

        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        System.out.println("1 - notebook işlemleri");
        System.out.println("2 - cep telefonu işlemleri");
        System.out.println("3 - marka listele");
        System.out.println("0 - çıkış yap");

        System.out.print("seçiminiz : ");
        int select = input.nextInt();

        switch (select) {
            case 1:
                printNoteBooks(noteBookList);
                break;
            case 2:
                printMobilePhones(mobilePhoneList);
                break;
            case 3:
                printBrands(brands);
                break;
            default:
                System.out.println("lütfen seçim yapınız");
        }
    }

    static private void printBrands(List<Brand> brands) {
        System.out.println();
        System.out.println("markalarımız");
        System.out.println("-------------------------------------");
        for (Brand i : brands) {
            System.out.println("- " + i.getName());
        }
        System.out.println("-------------------------------------");
    }

    static private void printNoteBooks(List<Product> noteBookList) {
        System.out.println();
        System.out.println("notebook listesi");
        System.out.println("-------------------------------------");
        System.out.println("| id |      ürün adı        |   fiyat   |   marka   |");

        for (Product i : noteBookList) {
            System.out.println("  " + i.getId() + "\t\t" + i.getpName() + "\t\t" + i.getPrice() + "\t\t" + i.getBrand().getName());
        }
        System.out.println("-------------------------------------");
    }

    static private void printMobilePhones(List<Product> mobilePhoneList) {
        System.out.println();
        System.out.println("telefon listesi");
        System.out.println("-------------------------------------");
        System.out.println("| id |      ürün adı        |   fiyat   |   marka   |");

        for (Product i : mobilePhoneList) {
            System.out.println("  " + i.getId() + "\t\t" + i.getpName() + "\t\t" + i.getPrice() + "\t\t" + i.getBrand().getName());
        }
        System.out.println("-------------------------------------");
    }
}
