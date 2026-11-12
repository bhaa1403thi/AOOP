class Book {
    String ISBN;
    String title;
    double price;

    Book(String i, String t, double p) {
        ISBN = i;
        title = t;
        price = p;
    }

    void displayDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        Book b1 = new Book("9781234567890", "Java Programming", 550);

        b1.displayDetails();
    }
}