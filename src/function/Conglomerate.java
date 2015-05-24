package function;
/**
 * Combination of multiple functions that can be combined using 
 * addition,multiplication,division,composistion,expotentation,logirthmic ect
 * **/
public class Conglomerate implements Function{
	private Function base=null;
	private enum CombinationTypes {add,sub,mult,div,comp,exp,pow,log,sqrt,ln,log10,log2,abs};
	
	public Conglomerate(Function baseFunction){
		base = baseFunction;
	}
	private static class Combined implements Function{
		private CombinationTypes CombinationType;
		Function A;
		Function B;
		public Combined(CombinationTypes combinationType, Function a, Function b) {
			CombinationType = combinationType;
			A = a;
			B = b;
		}
		public Combined(CombinationTypes combinationType, Function a) {
			CombinationType = combinationType;
			A = a;
		}
		public double eval(double x){
			switch(CombinationType){
			case add:
				return A.eval(x)+B.eval(x);
			case mult:
				return A.eval(x)*B.eval(x);
			case comp:
				return A.eval(B.eval(x));
			case div:
				return A.eval(x)/B.eval(x);
			case pow:
				return Math.pow(A.eval(x),B.eval(x));
			case log:
				return Math.log(A.eval(x))/Math.log(B.eval(x));//utilizes change of base formula
			case sqrt:
				return Math.sqrt(A.eval(x));
			case sub:
				return A.eval(x)-B.eval(x);
			default:
				return 0.0;
			}
		}
		
	}
	public void add(Function f){
		base = new Combined(CombinationTypes.add,base,f);
	}
	public void sub(Function f){
		base = new Combined(CombinationTypes.sub,base,f);
	}
	public void mult(Function f){
		base = new Combined(CombinationTypes.mult,base,f);
	}
	public void mult2(Function f){
		base = new Combined(CombinationTypes.mult,f,base);
	}
	public void div(Function f){
		base = new Combined(CombinationTypes.div,base,f);
	}
	public void div2(Function f){
		base = new Combined(CombinationTypes.div,f,base);
	}
	public void pow(Function f){
		base = new Combined(CombinationTypes.pow,base,f);
	}
	public void pow2(Function f){
		base = new Combined(CombinationTypes.pow,base,f);
	}
	public void log(Function f){
		base = new Combined(CombinationTypes.log,base,f);
	}
	public void logBase2(){
		base = new Combined(CombinationTypes.log2,base);
	}
	public void logBase10(){
		base = new Combined(CombinationTypes.log10,base);
	}
	public void ln(){
		base = new Combined(CombinationTypes.ln,base);
	}
	public double eval(double x) {
		return base.eval(x);
	}
}
