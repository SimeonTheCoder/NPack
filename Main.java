import npack.PackageManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("--get")) {
            PackageManager.get(args);
        }
    }
}
