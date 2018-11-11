package com.sys.model;

public class MaoPao {

	public static void main(String[] args) {
		int array[]= {1,3,2,6,9,8,7};
        for(int i=0;i<array.length;i++) {
        	for(int j=0;j<array.length-1-i;j++) {
        		if(array[j]<array[j+1]) {
        			int c;
        			c=array[j];
        			array[j]=array[j+1];
        			array[j+1]=c;
        		}
        	}
        	
        }
        for(int i:array) {
        	System.out.print(i+"\t");
        }
	}

}
