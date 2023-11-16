@haveArea
public class Table {
    int a, b;
    Table(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @returnArea
    public double countArea() {
        return a * b;
    }

    public double countArea1() {
        return a + b;
    }
}