package com.pickrecalled.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.io.IOException;

/**
 * 参考：
 * https://blog.csdn.net/wyyl1/article/details/45830073
 */
public class PictureMetadataExtractorUtil {

    public static void main(String[] args) {
        metadataExtractor();
    }

	public static void metadataExtractor() {
		File jpegFile = new File("/Users/shuang/Downloads/6476636FED85507DE731C19C10DC1F03.png");
		try {
			Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
			for (Directory directory : metadata.getDirectories()) {
				for (Tag tag : directory.getTags()) {
					System.out.println(tag);
				}
			}
		} catch (ImageProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
