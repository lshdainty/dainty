import java.io.File;

public class WDB {
	public static void main(String[] args) {
		String name = "c:\\Windows";
		
		File file = new File(name);
		
		//���丮���� �˻�
		if(file.isDirectory()) {
			System.out.println(name + "�� ���丮�Դϴ�.");
			//���丮���� ���������� �о���� �޼ҵ� list
			String[] list = file.list();
			
			for(String s:list) {
				File f = new File(name + "\\" + s);
				System.out.println("----------------------------");
				System.out.println("�̸� : " + f.getName());
				System.out.println("��� : " + f.getPath());
				System.out.println("�θ�: " + f.getParent());
				System.out.println("���丮 ���� : " + f.isDirectory());
				System.out.println("���� ���� : " + f.isFile());
			}
		}else {
			System.out.println(name + "�� ���� �Դϴ�.");
		}
	}
}