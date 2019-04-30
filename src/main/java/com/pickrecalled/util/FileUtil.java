package com.pickrecalled.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.File;

/**
 * 文件工具类
 */
public class FileUtil {

	/**
	 * 资源路径
	 */
	private static String PATH;

	/**
	 * 获取外部资源文件
	 * @param fileName
	 *        文件名
	 * @return
	 */
	public static String getFilePath(String fileName) {
		if (StringUtils.isBlank(PATH)) {
			String path = FileUtil.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			PATH = new File(path).getParent() + File.separator;
		}
		return new StringBuilder(PATH).append(fileName).toString();
	}

	@Test
	public void getFilePathTest() {
		String filePath = getFilePath("晚风.flac");
		System.out.println(filePath);
	}
}
