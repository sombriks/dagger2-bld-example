package example.dagger2;

public class Example {
    public String getMessage() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Example().getMessage());
    }
}