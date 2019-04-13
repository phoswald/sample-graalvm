package com.github.phoswald.sample;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Application {

	public static void main(String[] args) {
		System.out.println("Hello, GraalVM world!");
		System.out.println("Now: " + ZonedDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println("Class: " + Application.class.getName());
	}
}
