public class Ex5_2 {	//1501205 �̻���
	
	public void E_2() {
		
		int sale[][] = new int[][] {{63,84,140,130},{157,209,251,312}};
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<4; j++) {
				System.out.printf("%d/4�б� : sale[%d][%d] = %d %n",j+1,i,j,sale[i][j]);
			}
		}
	}
}
