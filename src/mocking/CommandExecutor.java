package mocking;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandExecutor {
    private final Runtime runtime;
    private final String command;
    private final String[] args;

    public CommandExecutor(Runtime runtime, String command, String...args) {
        this.runtime = runtime;
        this.command = command;
        this.args = args;
    }

    public String exec() throws Exception {
        Process process = runtime.exec(command, args);

        InputStream stdin = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdin));

        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
            output.append("\n");
        }

        int exitStatus = process.waitFor();
        if(exitStatus != 0) {
            throw new Exception("ls command did not execute successfully");
        }

        return output.toString();
    }
}
