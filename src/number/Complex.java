package number;

public class Complex extends Number{
	//real point.x
	//img  point.y
	private Point cartisian;
	private Polar euclidian;
	public Complex(double real, double img){
		cartisian = new Point(real,img);
		euclidian = cartisian.toPolar();
	}
	public String toString(){
		return cartisian.getDoubleX()+" "+cartisian.getDoubleY()+"i";
	}
	public String toStringPolar(){
		return euclidian.getDoubleRadius()+"e^"+euclidian.getDoubleDegree()+"θ";
	}
	public String toStringTrig(){
		return euclidian.getDoubleRadius()+"*(cos("+euclidian.getDoubleDegree()+"t)+isin("+euclidian.getDoubleDegree()+"t))";
	}
	public double doubleValue() {
		return cartisian.getDoubleX();
	}
	public float floatValue() {
		return new Double(cartisian.getDoubleX()).floatValue();
	}
	public int intValue() {
		return new Double(cartisian.getDoubleX()).intValue();
	}
	public long longValue() {
		return new Double(cartisian.getDoubleX()).longValue();
	}
}
