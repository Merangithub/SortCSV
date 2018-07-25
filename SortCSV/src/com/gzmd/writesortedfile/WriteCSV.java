package com.gzmd.writesortedfile;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.sort.BubbleSort;

public class WriteCSV {
	public void writeFile(List<EnterpriseInfo> list) {
		try {
			FileWriter fw = new FileWriter("D:\\info.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < list.size(); i++) {
				String str = String.valueOf(list.get(i).getZCZB());
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			fw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeFileByArr(Object[] arr) {
		try {
			FileWriter fw = new FileWriter("D:\\info.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for (int i = 0; i < arr.length; i++) {
				String str = ((EnterpriseInfo)arr[i]).getHZRQ();
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			fw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


