package com.gzmd.readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.sort.BubbleSort;

/**
 * 
 * ���裺
 * 1���ӱ��ض�ȡcsv�ļ� 
 * 2�����ļ���ʽ���й淶�������粻�ó��ֻ��з��ĵط������˻��з�
 * 3���Ѷ�ȡ���ڴ�����ݷ�װ�������棬Ȼ��ӵ�List����ȥ 
 * 4�����㷨�Լ��Ͻ������� 
 * 5��������ļ���д���µ�csv�ļ�����
 * 
 * @author Meran
 *
 */
public class ReadCSV {

	FileReader fr;
	BufferedReader br;
	List<EnterpriseInfo> list;
	public List<EnterpriseInfo> readFile() {
		 list= new LinkedList<EnterpriseInfo>(); 
		try {
			fr = new FileReader("E:\\A_QYZT.csv");
			br = new BufferedReader(fr);
			EnterpriseInfo ei;
			String line = null;
			int lineNum = 0;
			String[] newLine = null;
			br.readLine();// �������ͷ
//			String[] arrayCombine;
			while ((line = br.readLine().replace("\"", "")) != null) {
				newLine = line.split(",");
				if (newLine.length < 44) {
					br.readLine();
					continue;
				}
//				for (int i = 0; i < newLine.length; i++) {					
//					System.out.print(newLine[i]);
//				}
				ei = new EnterpriseInfo();
				ei.setNBXH(newLine[0]);
				ei.setZCH(newLine[1]);
				ei.setQYMC(newLine[2]);
				ei.setZS(newLine[3]);
				ei.setFDDBR(newLine[4]);
				ei.setZCZB(Double.parseDouble(newLine[5]));//double����
				ei.setBZ(newLine[6]);
				ei.setQYLX(newLine[7]);
				ei.setLXDH(newLine[8]);
				ei.setJYFW(newLine[9]);
				
				ei.setCLRQ(newLine[10]);
				ei.setNJJG(newLine[11]);
				ei.setNJND(newLine[12]);
				ei.setDJJG(newLine[13]);
				ei.setJYFS(newLine[14]);
				ei.setYYRQ1(newLine[15]);
				ei.setYYRQ2(newLine[16]);
				ei.setXYDJ(newLine[17]);
				ei.setDJRQ(newLine[18]);
				ei.setSFHMD(newLine[19]);
				
				ei.setQYBZ(newLine[20]);
				ei.setBY1(newLine[21]);
				ei.setBY2(newLine[22]);
				ei.setBY3(newLine[23]);
				ei.setMCLX(newLine[24]);
				ei.setHYDM(newLine[25]);
				ei.setGXDW(newLine[26]);
				ei.setQZJYFW(newLine[27]);
				ei.setYBJYFW(newLine[28]);
				ei.setDZYX(newLine[29]);
				
				ei.setLCBZ(newLine[30]);
				ei.setFXD(newLine[31]);
				ei.setOPTYPE(newLine[32]);
				ei.setHZRQ(newLine[33]);
				ei.setZXRQ(newLine[34]);
				ei.setDXRQ(newLine[35]);
				ei.setVALI(newLine[36]);
				ei.setHYML(newLine[37]);
				ei.setUNISCID(newLine[38]);
				ei.setYIEDISTRICT(newLine[39]);
				
				ei.setPROLOC(newLine[40]);
				ei.setINSERT_TIME(newLine[41]);
				ei.setUPDATE_TIME(newLine[42]);
				ei.setZSXZQH(newLine[43]);
				
				list.add(ei);
				
				lineNum++;
				if (lineNum == 10)
					break;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
//		BubbleSort bs = new BubbleSort();
//		bs.bubbleSort(list);
	}




//	/**
//	 * ������ϳ�һ������
//	 * @param a
//	 * @param b
//	 * @return
//	 */
//	public String[] combine(String[] a, String[] b) {
//		String[] c = new String[a.length + b.length];
//		System.arraycopy(a, 0, c, 0, a.length);
//		System.arraycopy(b, 0, c, a.length, b.length);
//		return c;
//	}
}
