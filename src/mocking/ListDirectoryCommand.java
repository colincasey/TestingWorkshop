package mocking;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ListDirectoryCommand {
    public static void main(String[] args) throws Exception {
        String listing = new ListDirectoryCommand().execute();
        System.out.println(listing);
    }

    private String execute() throws Exception {
        String command = "ls";
        Process process = Runtime.getRuntime().exec(command);

        InputStream stdin = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdin));

        String line = null;
        StringBuilder output = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitStatus = process.waitFor();
        if(exitStatus != 0) {
            throw new Exception("ls command did not execute successfully");
        }

        return output.toString();
    }
}
