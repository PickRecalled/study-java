package com.pickrecalled.study_classlib;

import org.apache.pdfbox.util.StringUtil;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;

/**
 * 字符串算法题
 */
public class StringAlgorithmTopic {

    public String[] getMaxSameSubString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuffer sBuffer = new StringBuffer();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }

        return null;
    }

	/**
	 * 获取两个字符串中最大相同子串。比如:str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm" 。 <br>
	 * 提示:将短的那个串进行长度依次递减的子串与较长的串比较。
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String[] getMaxSameWord(String str1, String str2) {
		String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
		String minStr = (str1.length() < str2.length()) ? str1 : str2;
		int length = minStr.length();
		StringBuilder sbl = new StringBuilder();
		for (int i = 0; i < length; i++) {
			for (int x = 0, y = length - i; y <= length; x++, y++) {
				String subStr = minStr.substring(x, y);
				if (maxStr.contains(subStr)) {
					sbl.append(subStr + ",");
					System.out.println(subStr);
				}
			}
			if (sbl.length() != 0) {
				break;
			}
		}

		return StringUtils.isNotBlank(sbl.toString()) ? sbl.toString().split(",") : null;
	}

	@Test
	public void getMaxSameWordTest() {
		String maxSameWord[] = getMaxSameWord("abcwerthelloyuiodefabcd", "cvhellobnmabcd");
        String[] maxSameSubString1 = getMaxSameSubString1("abcwerthelloyuiodefabcd", "cvhellobnmabcd");
        System.out.println(Arrays.toString(maxSameSubString1));

        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnmiodef";
        String[] strs = getMaxSameSubString1(str1, str2);
        System.out.println(Arrays.toString(strs));
	}

	/**
	 * 获取一个字符串在另一个字符串中出现的次数。比如:获取“ab”在 “abkkcadkabkebfkabkskab” 中出现的次数。
	 * @param mainStr
	 *        数据内容
	 * @param subStr
	 *        统计的单词
	 * @return
	 */
	public static int wordCount(String mainStr, String subStr) {
		int mainLength = mainStr.length();
		int subLength = subStr.length();
		// 主数据长度小于统计单词数据长度业务直接返回0
		if (mainLength < subLength) return 0;
		int count = 0, index = 0;
		// 效率低,因为字符串拼接
		// while ((index = mainStr.indexOf(subStr)) != -1) {
		// count++;
		// mainStr = mainStr.substring(index + subStr.length());
		// }
		// 效率高
		while ((index = mainStr.indexOf(subStr, index)) != -1) {
			count++;
			index += subLength;
		}
		return count;
	}

	@Test
	public void wordCountTest() {
		int wordCount = wordCount("abkkcadkabkebfkabkskab", "ab");
		System.out.println(wordCount);
	}

	/**
	 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg” 。
	 * @param reversalStr
	 *        反转数据
	 * @param startIndex
	 *        反转数据开始下标
	 * @param endIndex
	 *        反转数据结束下标
	 * @return
	 */

	public static String reversalByCharArray(String reversalStr, int startIndex, int endIndex) {
		char[] chars = reversalStr.toCharArray();
		for (int x = startIndex, y = endIndex; x < y; x++, y--) {
			char temp = chars[x];
			chars[x] = chars[y];
			chars[y] = temp;
		}
		return new String(chars);
	}

	/**
	 * 将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg” 。
	 * @param reversalStr
	 *        反转数据
	 * @param startIndex
	 *        反转数据开始下标
	 * @param endIndex
	 *        反转数据结束下标
	 * @return
	 */
	public static String reversalByStringBuilder(String reversalStr, int startIndex, int endIndex) {
		StringBuilder bur = new StringBuilder();
		bur.append(reversalStr.substring(0, startIndex));
		bur.append(new StringBuilder(reversalStr.substring(startIndex, endIndex + 1)).reverse());
		bur.append(reversalStr.substring(endIndex + 1));
		return bur.toString();
	}

	@Test
	public void reversalTest() {
		String reversal = reversalByStringBuilder("abcdefg", 2, 5);
		System.out.println(reversal);

		Long l = null;
		System.out.println(l.equals(0));
	}
}
