class Rectangle {
    double length;
    double width;

    Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    void calculateArea() {
        double area = length * width;
        System.out.println("Area: " + area);
    }

    void calculatePerimeter() {
        double perimeter = 2 * (length + width);
        System.out.println("Perimeter: " + perimeter);
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 5);

        r1.calculateArea();
        r1.calculatePerimeter();
    }
}