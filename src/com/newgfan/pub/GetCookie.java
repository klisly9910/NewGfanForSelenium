package com.newgfan.pub;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class GetCookie {

	public static void getCookies(WebDriver driver) {
		// 登录用例

		// 获得cookies
		File cookieFile = new File("path");// cookie存储路径

		try {
			cookieFile.delete();
			cookieFile.createNewFile();
			FileWriter fileWrite = new FileWriter(cookieFile);
			BufferedWriter buffWriter = new BufferedWriter(fileWrite);
			
			for (Cookie cookie : driver.manage().getCookies()) {
				buffWriter.write(cookie.getName() + ";" + cookie.getValue()
						+ ";" + cookie.getDomain() + ";" + cookie.getPath()
						+ ";" + cookie.getExpiry() + ";" + cookie.isSecure());
				buffWriter.newLine();

			}
			buffWriter.flush();
			buffWriter.close();
			fileWrite.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
