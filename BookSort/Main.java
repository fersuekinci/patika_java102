import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        TreeSet<Book> set = new TreeSet<>();

        set.add(new Book("küçük prens",200,"Antoine de Saint-Exupéry",2000));
        set.add(new Book("simyacı",300,"Paulo Coelho",2001));
        set.add(new Book("suç ve ceza",400,"Dostoyevski",2002));
        set.add(new Book("hayvan çiftliği",500,"George Orwell",2003));
        set.add(new Book("dönüşüm",600,"Franz Kafka",2004));

        System.out.println("isme göre sıralama");
        System.out.println("---------------------------------------");
        for(Book book : set) {
            System.out.println(book.bookName);
        }

        System.out.println("#########################################");

        TreeSet<Book> pageSet = new TreeSet<>(new OrderByPageNumberComparator());

        pageSet.addAll(set);

        System.out.println("sayfa sayısına göre sıralama");
        for (Book book : pageSet) {
            System.out.println(book.pageNumber);
        }
    }
}
