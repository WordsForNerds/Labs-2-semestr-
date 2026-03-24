package Examples;

public class Example8 {

    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } catch (RuntimeException e) {

            System.out.println("0.5" + e);
        } finally {
            System.out.println("1");
        }
        return 52;
    }

    public static void main(String[] args) {

        System.out.println(m());
    }
}
