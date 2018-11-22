public class Polynomial {	//1501205 이상혁
	private int degree;
	private float coef[] = new float[20];
	
	Polynomial(int degree,float coef[]) {
		this.degree = degree;
		this.coef = coef;
	}
	Polynomial(int degree){
		this.degree = degree;
		for(int i=0; i<=degree; i++)
			this.coef[i] = 0;
	}
	public int getDegree() {
		return this.degree;
	}
	public float getCoef(int i) {
		return this.coef[i];
	}
	public float setCoef(int i, float coef) {
		return this.coef[i] = coef;
	}
	public void printPoly() {
		int temp = this.degree;
		for(int i=0; i<=this.degree; i++) {
			System.out.printf("%3.0fx^%d",this.coef[i],temp--);
		}
		System.out.println();
	}
}
