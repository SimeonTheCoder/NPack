import npack.PackageManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        args = new String[2];
        args[0] = "--get";
        args[1] = "nlwinplotlib";

        if (args[0].equals("--get")) {
            PackageManager.get(args);
        }
    }
}
