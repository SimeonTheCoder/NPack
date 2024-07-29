package npack;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class PackageManager {
    public static void get(String[] args) throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/SimeonTheCoder/NDepo/main/libs.nlb");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        Scanner libScanner = new Scanner(connection.getInputStream());

        String user = "", repoName = "";

        while(libScanner.hasNextLine()) {
            String line = libScanner.nextLine();

            String[] tokens = line.split(" ");

            if(tokens[0].equals(args[1])) {
                repoName = tokens[1];
                user = tokens[2];

                break;
            }
        }

//        if(args[2].equals("--nodir")) {
            File theDir = new File(System.getProperty("user.dir") + "/build");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }
//        }

        String repo = String.format(
                "https://raw.githubusercontent.com/%s/%s/main/package.nlb",
                user,
                repoName
        );

        System.out.println("Downloading package.nlb from: " + repo);

        Runtime.getRuntime().exec("curl -o build/package.nlb " + repo);

        Scanner scanner = new Scanner(new File("build/package.nlb"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            String fileLocation = String.format(
                    "https://raw.githubusercontent.com/%s/%s/main/%s.class",
                    user,
                    repoName,
                    line
            );

            System.out.println("Downloading file from: " + fileLocation);

            Runtime.getRuntime().exec(
                    String.format("curl -o build/%s.class %s", line, fileLocation)
            );
        }
    }

    public static void get() throws IOException {
        URL url = new URL("https://raw.githubusercontent.com/SimeonTheCoder/NDepo/main/libs.nlb");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        Scanner libScanner = new Scanner(connection.getInputStream());

        String user = "", repoName = "";

        while(libScanner.hasNextLine()) {
            String line = libScanner.nextLine();

            String[] tokens = line.split(" ");

            repoName = tokens[1];
            user = tokens[2];

            File theDir = new File(System.getProperty("user.dir") + "/build");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }

            String repo = String.format(
                    "https://raw.githubusercontent.com/%s/%s/main/package.nlb",
                    user,
                    repoName
            );

            System.out.println("Downloading package.nlb from: " + repo);

            Runtime.getRuntime().exec("curl -o build/package.nlb " + repo);

            Scanner scanner = new Scanner(new File("build/package.nlb"));

            while (scanner.hasNextLine()) {
                String line2 = scanner.nextLine();

                String fileLocation = String.format(
                        "https://raw.githubusercontent.com/%s/%s/main/%s.class",
                        user,
                        repoName,
                        line2
                );

                System.out.println("Downloading file from: " + fileLocation);

                Runtime.getRuntime().exec(
                        String.format("curl -o build/%s.class %s", line2, fileLocation)
                );
            }
        }
    }
}
