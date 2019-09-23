package com.database;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class DataBaseUtil {
	private static BlockingQueue<Connection> pool = new ArrayBlockingQueue<Connection>(10);
	private static AtomicInteger connCount = new AtomicInteger();
	  
	public static Connection getConnection() throws InterruptedException {
	    Connection conn = pool.poll(5, TimeUnit.SECONDS);
	    if (conn == null) {
	 
	    	synchronized (connCount) {
	 
	    		if (connCount.get() < 10) {
	 
					DbConnection dbConnection=new DbConnection();
				    conn =dbConnection.getConnObject();
	 
				    pool.offer(conn);
	 
				    connCount.incrementAndGet();
	    		}
	 
	    	}
	    }
		return conn;
	}
}
