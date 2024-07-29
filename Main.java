import npack.PackageManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("--get") && args.length > 1) {
            PackageManager.get(args);
        } else if(args[0].equals("--get")) {
            PackageManager.get();
        }
    }
}
