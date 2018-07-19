package com.gzmd.writesortedfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.sort.BubbleSort;

public class WriteCSV {
	public void writeFile(Object[] obj) {
//		StringBuilder sb = new StringBuilder();
		System.out.println("**********************");
		for (int i = 0; i < obj.length; i++) {
			System.out.println(((EnterpriseInfo)obj[i]).getZCZB());
		}
		try {
			FileWriter fw = new FileWriter("E:\\info.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
