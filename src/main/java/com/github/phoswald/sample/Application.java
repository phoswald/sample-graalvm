package com.github.phoswald.sample;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class Application {
    
    public static void main(String[] args) {
        if (args.length >= 1) {
            dispatch(args[0], args).run();
        } else {
            System.out.println("Hello, GraalVM world!");
        }
    }

    private static Runnable dispatch(String command, String[] args) {
        return switch(command) {
            case "about" -> () -> {
                System.out.println(Application.class.getPackage().getName() + " "
                    + Application.class.getPackage().getImplementationVersion());
            };
            case "now" -> () -> System.out.println(ZonedDateTime.now());
            case "locnow" -> () -> System.out.println(LocalDateTime.now());
            case "locale" -> () -> System.out.println(Locale.getDefault());
            case "timezone" -> () -> System.out.println(TimeZone.getDefault().getID());
            case "charset" -> () -> System.out.println(Charset.defaultCharset().name());
            case "args" -> () -> System.out.println(Arrays.asList(args).toString());
            case "env" -> () -> printMap(System.getenv());
            case "prop" -> () -> printMap(System.getProperties());
            case "class" -> () -> System.out.println(Application.class.getName());
            default -> () -> System.out.println("Invalid command: " + command);
        };
    }

    private static void printMap(Map<?, ?> map) {
        StringBuilder sb = new StringBuilder();
        map.entrySet().stream() //
                .sorted(Comparator.comparing(e -> (String) e.getKey()))
                .forEach(e -> sb.append(e.getKey() + "=" + e.getValue().toString().replace('\n', '|') + "\n"));
        if (sb.length() == 0) {
            sb.append("<empty>\n");
        }
        System.out.println(sb.toString());
    }
}
