package org.geo.changemachine.log;

public interface ILogToFile {
	public void write(String username, int price, String currency, long time);
}
