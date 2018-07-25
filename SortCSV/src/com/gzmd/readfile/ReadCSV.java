package com.gzmd.readfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gzmd.domain.EnterpriseInfo;
import com.gzmd.sort.BubbleSort;

/**
 * 
 * 步骤： 1、从本地读取csv文件 2、对文件格式进行规范化，比如不该出现换行符的地方出现了换行符
 * 3、把读取到内存的数据封装到类里面，然后加到List集合去 4、用算法对集合进行排序 5、把有序的集合写到新的csv文件里面
 * 
 * @author Meran
 *
 */
public class ReadCSV {

	FileReader fr;
	BufferedReader br;
	LinkedList<EnterpriseInfo> list;
	EnterpriseInfo ei;

	public LinkedList<EnterpriseInfo> readFile() {
		try {

			list = new LinkedList<EnterpriseInfo>();
			fr = new FileReader("D:\\A_QYZT.csv");
			br = new BufferedReader(fr);
			br.readLine();// 读取行头
			int lineNum = 0;
			int count = 0;
			String line = null;
			String[] newLine = null;
			StringBuilder sb = null;
			Pattern p = null;
			Matcher m = null;

			while ((line = br.readLine()) != null) {
				sb = new StringBuilder(line.trim());

				do {
					p = Pattern.compile("\",\"");// 创建一个字符串匹配模式
					m = p.matcher(sb);
					count = 0;
					while (m.find()) {// 统计模式匹配命中的次数
						count++;
					}
					if (count == 43) {
						break;
					} else {// 没有达到指定的记录数，则再读取下一行，然后将其拼接到上一行中
						sb.append(br.readLine().trim());
					}
				} while (true);

				newLine = sb.toString().split("\",\"");// 以 "," 为分隔符

				// 这种方法是直接将不完整的两行忽略掉
				// newLine = line.split(",");
				// if (newLine.length < 44) {
				// br.readLine();
				// continue;
				// }

				ei = new EnterpriseInfo();

				if (!(newLine[0] == null || newLine[0] == "" || "".equals(newLine[0])))
					ei.setNBXH(newLine[0].substring(1));									/**************内部序号***************/
				if (!(newLine[1] == null || newLine[1] == "" || "".equals(newLine[1])))
					ei.setZCH(newLine[1]);
				if (!(newLine[2] == null || newLine[2] == "" || "".equals(newLine[2])))
					ei.setQYMC(newLine[2]);													/**************企业名称***************/
				if (!(newLine[3] == null || newLine[3] == "" || "".equals(newLine[3])))
					ei.setZS(newLine[3]);
				if (!(newLine[4] == null || newLine[4] == "" || "".equals(newLine[4])))
					ei.setFDDBR(newLine[4]);
				if (!(newLine[5] == null || newLine[5] == "" || "".equals(newLine[5])))
					ei.setZCZB(Double.parseDouble(newLine[5]));// double类型					/**************注册资本***************/
				if (!(newLine[6] == null || newLine[6] == "" || "".equals(newLine[6])))
					ei.setBZ(newLine[6]);
				if (!(newLine[7] == null || newLine[7] == "" || "".equals(newLine[7])))
					ei.setQYLX(newLine[7]);
				if (!(newLine[8] == null || newLine[8] == "" || "".equals(newLine[8])))
					ei.setLXDH(newLine[8]);
				if (!(newLine[9] == null || newLine[9] == "" || "".equals(newLine[9])))
					ei.setJYFW(newLine[9]);

				if (!(newLine[10] == null || newLine[10] == "" || "".equals(newLine[10])))
					ei.setCLRQ(newLine[10]);
				if (!(newLine[11] == null || newLine[11] == "" || "".equals(newLine[11])))
					ei.setNJJG(newLine[11]);
				if (!(newLine[12] == null || newLine[12] == "" || "".equals(newLine[12])))
					ei.setNJND(newLine[12]);
				if (!(newLine[13] == null || newLine[13] == "" || "".equals(newLine[13])))
					ei.setDJJG(newLine[13]);
				if (!(newLine[14] == null || newLine[14] == "" || "".equals(newLine[14])))
					ei.setJYFS(newLine[14]);
				if (!(newLine[15] == null || newLine[15] == "" || "".equals(newLine[15])))
					ei.setYYRQ1(newLine[15]);
				if (!(newLine[16] == null || newLine[16] == "" || "".equals(newLine[16])))
					ei.setYYRQ2(newLine[16]);
				if (!(newLine[17] == null || newLine[17] == "" || "".equals(newLine[17])))
					ei.setXYDJ(newLine[17]);
				if (!(newLine[18] == null || newLine[18] == "" || "".equals(newLine[18])))
					ei.setDJRQ(newLine[18]);
				if (!(newLine[19] == null || newLine[19] == "" || "".equals(newLine[19])))
					ei.setSFHMD(newLine[19]);

				if (!(newLine[20] == null || newLine[20] == "" || "".equals(newLine[20])))
					ei.setQYBZ(newLine[20]);
				if (!(newLine[21] == null || newLine[21] == "" || "".equals(newLine[21])))
					ei.setBY1(newLine[21]);
				if (!(newLine[22] == null || newLine[22] == "" || "".equals(newLine[22])))
					ei.setBY2(newLine[22]);
				if (!(newLine[23] == null || newLine[23] == "" || "".equals(newLine[23])))
					ei.setBY3(newLine[23]);
				if (!(newLine[24] == null || newLine[24] == "" || "".equals(newLine[24])))
					ei.setMCLX(newLine[24]);
				if (!(newLine[25] == null || newLine[25] == "" || "".equals(newLine[25])))
					ei.setHYDM(newLine[25]);
				if (!(newLine[26] == null || newLine[26] == "" || "".equals(newLine[26])))
					ei.setGXDW(newLine[26]);
				if (!(newLine[27] == null || newLine[27] == "" || "".equals(newLine[27])))
					ei.setQZJYFW(newLine[27]);
				if (!(newLine[28] == null || newLine[28] == "" || "".equals(newLine[28])))
					ei.setYBJYFW(newLine[28]);
				if (!(newLine[29] == null || newLine[29] == "" || "".equals(newLine[29])))
					ei.setDZYX(newLine[29]);

				if (!(newLine[30] == null || newLine[30] == "" || "".equals(newLine[30])))
					ei.setLCBZ(newLine[30]);
				if (!(newLine[31] == null || newLine[31] == "" || "".equals(newLine[31])))
					ei.setFXD(newLine[31]);
				if (!(newLine[32] == null || newLine[32] == "" || "".equals(newLine[32])))
					ei.setOPTYPE(newLine[32]);
				if (!(newLine[33] == null || newLine[33] == "" || "".equals(newLine[33]))) {
					ei.setHZRQ(newLine[33]);												/**************核准日期***************/
				} else {
					ei.setHZRQ("9999/99/99");
				}
				if (!(newLine[34] == null || newLine[34] == "" || "".equals(newLine[34])))
					ei.setZXRQ(newLine[34]);
				if (!(newLine[35] == null || newLine[35] == "" || "".equals(newLine[35])))
					ei.setDXRQ(newLine[35]);
				if (!(newLine[36] == null || newLine[36] == "" || "".equals(newLine[36])))
					ei.setVALI(newLine[36]);
				if (!(newLine[37] == null || newLine[37] == "" || "".equals(newLine[37])))
					ei.setHYML(newLine[37]);
				if (!(newLine[38] == null || newLine[38] == "" || "".equals(newLine[38])))
					ei.setUNISCID(newLine[38]);
				if (!(newLine[39] == null || newLine[39] == "" || "".equals(newLine[39])))
					ei.setYIEDISTRICT(newLine[39]);

				if (!(newLine[40] == null || newLine[40] == "" || "".equals(newLine[40])))
					ei.setPROLOC(newLine[40]);
				if (!(newLine[41] == null || newLine[41] == "" || "".equals(newLine[41])))
					ei.setINSERT_TIME(newLine[41]);
				if (!(newLine[42] == null || newLine[42] == "" || "".equals(newLine[42])))
					ei.setUPDATE_TIME(newLine[42]);
				if (!(newLine[43] == null || newLine[43] == "" || "".equals(newLine[43])))
					ei.setZSXZQH(newLine[43]);

				list.add(ei);

				lineNum++;
				if (lineNum % 1000 == 0) {
					System.out.println("这是第" + lineNum + "行");
				}
				if (lineNum == 10)
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
}
