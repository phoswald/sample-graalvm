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
			if (args[0].equals("about")) {
				System.out.println(Application.class.getPackage().getName() + " "
						+ Application.class.getPackage().getImplementationVersion());
			} else if (args[0].equals("now")) {
				System.out.println(ZonedDateTime.now());
			} else if (args[0].equals("locnow")) {
				System.out.println(LocalDateTime.now());
			} else if (args[0].equals("locale")) {
				System.out.println(Locale.getDefault());
			} else if (args[0].equals("timezone")) {
				System.out.println(TimeZone.getDefault().getID());
			} else if (args[0].equals("charset")) {
				System.out.println(Charset.defaultCharset().name());
			} else if (args[0].equals("args")) {
				System.out.println(Arrays.asList(args).toString());
			} else if (args[0].equals("env")) {
				printMap(System.getenv());
			} else if (args[0].equals("prop")) {
				printMap(System.getProperties());
			} else if (args[0].equals("class")) {
				System.out.println(Application.class.getName());
			}
		} else {
			System.out.println("Hello, GraalVM world!");
		}
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
