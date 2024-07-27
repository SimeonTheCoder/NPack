package npack;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PackageManager {
    public static void get(String[] args) throws IOException {
        File theDir = new File(System.getProperty("user.dir") + "/build");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        String repo = String.format(
                "https://raw.githubusercontent.com/%s/%s/main/package.nlb",
                args[1],
                args[2]
        );

        System.out.println("Downloading package.nlb from: " + repo);

        Runtime.getRuntime().exec("curl -o build/package.nlb " + repo);

        Scanner scanner = new Scanner(new File("build/package.nlb"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String fileLocation = String.format(
                    "https://raw.githubusercontent.com/%s/%s/main/%s.class",
                    args[1],
                    args[2],
                    line
            );

            System.out.println("Downloading file from: " + fileLocation);

            Runtime.getRuntime().exec(
                    String.format("curl -o build/%s.class %s", line, fileLocation)
            );
        }
    }
}
