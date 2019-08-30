package java_20190801;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileDemo {
	public void mkdirs(String path){
		File f1 = new File(path);
		boolean isExisted = f1.isDirectory();
		if(!isExisted) {
			if(f1.mkdirs())
				System.out.println("생성");
			else
				System.out.println("생성실패");
		}
	}
	
	public String getComma(long num) {		
		return String.format("%,d", num);
	}
	
	public String getComma(double num, int precision) {		
		return String.format("%,."+precision+"f", num);
	}
	
	public void changeFile(String path) {
		File f1 = new File(path);
		String fileName = f1.getName();
		String name = fileName.substring(0,fileName.lastIndexOf("."));
		String extension = fileName.substring(fileName.lastIndexOf(".")+1);
		name = String.valueOf(System.currentTimeMillis());
		fileName = name +"."+extension;
		
		String parent = f1.getParent();
		File f2 = new File(parent, fileName);
		f1.renameTo(f2);
	}
	
	
	public static void main(String[] args) {
		FileDemo f1 = new FileDemo();
		/*
		f1.mkdirs("c:\\dev\\test\\2019\\02\\02");
		
		File f2 = new File("c:\\dev\\test","calendar1.exe");
		
		long fileSize = f2.length()/1024;
		System.out.println(f1.getComma(fileSize)+"KB");
		
		boolean isFile = f2.isFile();
		if(isFile) {
			String path = f2.getPath();
			System.out.println(path);
			if(path.endsWith(".exe")){
				System.out.println("실행파일입니다");
			}else if(path.endsWith(".txt")){
				System.out.println("문서파일입니다");			
			}
		}else {
			System.out.println("디렉토리입니다.");
		}
			
		
		File f3 = new File("c:\\dev\\test","무제.txt");
		
		*/
		FileDemo f4 = new FileDemo();
		//f4.changeFile("c:\\dev\\test\\무제.txt");
		File f5 = new File("c:\\dev\\test\\calendar.jar");
		
		long lastModi =f5.lastModified();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(lastModi);
		System.out.println(c.get(Calendar.YEAR));
		System.out.println(c.get(Calendar.MONTH)+1);
		System.out.println(c.get(Calendar.DATE));
		
		SimpleDateFormat sdf = new SimpleDateFormat();
		String date = sdf.format(c.getTime());
		System.out.println(date);
		
		File f6 = new File("c:\\dev\\test");
		String[] lists = f6.list();
		for(String list:lists){
			File f7 = new File(f6, list);
			String name = f7.getName();
			if(f7.isDirectory()){
				System.out.println(name+"-dir");
			}else {				
				long fileSize = f7.length()/1024;
				c.setTimeInMillis(f7.lastModified());
				String fm = sdf.format(c.getTime());
				System.out.println(name+"-file\t"+fileSize+"KB\t"+fm);
			}
		}
		
		
	}
}
