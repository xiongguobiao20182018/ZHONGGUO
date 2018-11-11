package com.sys.model;
/*
 * 单例类
 */
public class Singleton {
    //饿汉式单例
	private Singleton() {}
    private static Singleton instance=new Singleton();
    public static Singleton getInstance() {
    	return instance;
    }
    
}
