package com.pickrecalled.util;

import java.net.InetAddress;

public class PingUtil {

	public static void main(String[] args) {
		PingDomain domain = ping("www.baidu.com");
		System.out.println(domain);
	}

	public static PingDomain ping(String domian) {
		long start = System.currentTimeMillis();
		PingDomain result = new PingDomain();
		try {
			InetAddress address = InetAddress.getByName(domian);
			result.ip = address.getHostAddress();
			result.host = address.getHostName();
			long end = System.currentTimeMillis();
			result.time = (end - start);
		} catch (Exception e) {
			result.ip = "0.0.0.0";
			result.host = "UNKONW";
		}
		return result;
	}

	public static class PingDomain {
		String ip;
		String host;
		long time;

		@Override
		public String toString() {
			return String.format("host=%s, ip=%s, time=%s", host, ip, time);
		}
	}
}
