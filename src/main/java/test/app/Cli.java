package test.app;


import lombok.Getter;
import org.springframework.stereotype.Component;
import test.exception.CliException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Getter
@Component
public class Cli {
    private File inputFile;
    private File outputFile;
    private Endpoint endpoint;

    public void parseArg(String[] args) throws IOException {

        if (args.length != 3) {
            showUsage();
            throw new CliException("Invalid arguments");
        }

        checkArg(args[0], "endpoint");
        endpoint = Arrays.stream(Endpoint.values())
                .filter(e -> e.name().equalsIgnoreCase(args[0])).findAny().orElse(null);
        if (endpoint == null) {
            throw new CliException("Invalid endpoint type " + args[0]);
        }
        checkArg(args[1], "input-file");
        inputFile = validateFileForRead(args[1]);
        checkArg(args[2], "output-file");
        outputFile = validateFileForWrite(args[2]);
    }

    private void checkArg(String arg, String parameter) {
        if (arg == null || arg.length() == 0) {
            showUsage();
            throw new CliException("Missing parameter " + parameter + " for arg " + arg);
        }
    }

    private File validateFileForRead(String path) {
        if (path == null) {
            showUsage();
            throw new CliException("input file not set");
        }
        File file = new File(path);
        if (!file.exists() || !file.canRead()) {
            throw new CliException("File " + file.getPath() + " not exist or not readable");
        }
        return file;
    }

    private File validateFileForWrite(String path) {
        if (path == null) {
            showUsage();
            throw new CliException("output file not set");
        }
        File file = new File(path);
        if (file.exists()) {
            throw new CliException("File " + file.getAbsolutePath() + " exist");
        }
        return file;
    }

    private void showUsage() {
        System.out.println(System.getProperty("line.separator") + "program.jar search|stat input.json output.json" + System.getProperty("line.separator"));
    }
}
