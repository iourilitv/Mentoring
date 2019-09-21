package logging.log4j;

public class App {

    public static void main(String[] args) {
        Reader reader = new FileReader();
        String message = reader.read();
        System.out.println(message);
    }
}
