import java.io.File;

public class WDB {
	public static void main(String[] args) {
		String name = "c:\\Windows";
		
		File file = new File(name);
		
		//디렉토리인지 검사
		if(file.isDirectory()) {
			System.out.println(name + "는 디렉토리입니다.");
			//디렉토리내의 파일정보를 읽어오는 메소드 list
			String[] list = file.list();
			
			for(String s:list) {
				File f = new File(name + "\\" + s);
				System.out.println("----------------------------");
				System.out.println("이름 : " + f.getName());
				System.out.println("경로 : " + f.getPath());
				System.out.println("부모: " + f.getParent());
				System.out.println("디렉토리 여부 : " + f.isDirectory());
				System.out.println("파일 여부 : " + f.isFile());
			}
		}else {
			System.out.println(name + "는 파일 입니다.");
		}
	}
}