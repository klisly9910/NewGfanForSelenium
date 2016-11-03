package com.newgfan.pub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class ReadCookie {

	private static BufferedReader reader;

	@SuppressWarnings("deprecation")
	public static void readCookies(WebDriver driver) throws IOException {

		try {
			File fileCookie = new File("path");
			FileReader fs = new FileReader(fileCookie);
			reader = new BufferedReader(fs);
			String line;
			while ((line = reader.readLine()) != null) {
				StringTokenizer stringTokenizer = new StringTokenizer(line, ";");
				while (stringTokenizer.hasMoreTokens()) {
					String name = stringTokenizer.nextToken();
					String value = stringTokenizer.nextToken();
					String domain = stringTokenizer.nextToken();
					String path = stringTokenizer.nextToken();
					// String expiry = stringTokenizer.nextToken();
					// String isSecure = stringTokenizer.nextToken();
					Date expiry = null;
					String date;
					if (!(date = stringTokenizer.nextToken()).equals("null")) {
						expiry = new Date(date);
					}
					boolean isSecure = new Boolean(stringTokenizer.nextToken())
							.booleanValue();
					Cookie cookie = new Cookie(name, value, domain, path,
							expiry, isSecure);
					driver.manage().addCookie(cookie);

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
