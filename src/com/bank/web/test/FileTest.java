package com.bank.web.test;

import java.util.Scanner;

import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
public class FileTest {
	public static final String FILE_PATH =String.format("C:%sUsers%suser%seclipes-jee%sjee-bitcamp%sWebContent%sresources%stxt%s"
												,File.separator
												,File.separator
												,File.separator
												,File.separator
												,File.separator
												,File.separator
												,File.separator
												,File.separator);
			
											
//	경로를 설정 리소스 -> txt폴더에 경로를 상수형태로 fix해놓음  \\<-이거는 윈도우 전용(다른곳에서도 되기 위해 저 파일점 시파레이터를 해준다 
	public static void main(String[] args) {
		System.out.println(" >>> "+ FILE_PATH);
		try {
			File file = new File(FILE_PATH + "list.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true)); 
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String msg ="";
			StringBuffer buff = new StringBuffer();
			List<String> list = new ArrayList<>();
			while (true) {
				switch (JOptionPane.showInputDialog("0.종료 1.저장 2.읽기")) {
				case "0":
					JOptionPane.showMessageDialog(null, "시스템 종료");
					return;
				case "1":
//					저장해놓은 폴더에 메시지 저장하기 버퍼라이터와 파일라이터를 이용해서...
					msg = JOptionPane.showInputDialog("메시지를 입력해주세여. 데이터사이에, 입력");
					writer.write(msg);
					writer.newLine();
					writer.flush();
					break;
					
				case "2":
					msg = "";
					while((msg = reader.readLine())!=null) {
						list.add(msg +"/");
					}
					JOptionPane.showMessageDialog(null, list);
					reader.close();
					break;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
