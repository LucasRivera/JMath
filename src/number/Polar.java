package number;

public class Polar {
	private double r;
	private double rad;
	private double deg;
	public Polar(double r, double rad){
		this.r = r;
		this.rad = rad;
		deg =  (180/Math.PI)*rad;
	}
	public Polar(int r, int rad){
		this.r = r;
		this.rad = rad;
		deg =  (180/Math.PI)*rad;
	}
	public Polar(int r, double rad){
		this.r = r;
		this.rad = rad;
		deg =  (180/Math.PI)*rad;
	}
	//gets the radius of the object
	public double getDoubleRadius(){
		return r;
	}
	public int getIntRadius(){
		return 0;
	}
	/**
	 * Returns the Radiant in Double form
	 * */
	public double getDoubleRadiant(){
		return rad;
	}
	public int getIntRadiant(){
		return 0;
	}
	public double getDoubleDegree(){
		return deg;
	}
	public int getIntDegree(){
		return 0;
	}
	public Point toCartisian(){
		return new Point(r*Math.cos(rad),r*Math.sin(rad));
	}
	public static Polar add(Polar p, Polar k){
		if(p.getIntDegree()!=k.getIntDegree()){
			return null;
		}
		return new Polar(p.getDoubleRadius()+k.getDoubleRadius(),p.getDoubleRadiant());
	}
	public boolean add(Polar p){
		if(p.getIntDegree()!=getIntDegree()){
			return false;
		}
		r+=p.getDoubleRadius();
		return true;
	}
	public static Polar sub(Polar p, Polar k){
		if(p.getIntDegree()!=k.getIntDegree()){
			return null;
		}
		return new Polar(p.getDoubleRadius()-k.getDoubleRadius(),p.getDoubleRadiant());
	}
	public boolean sub(Polar p){
		if(p.getIntDegree()!=getIntDegree()){
			return false;
		}
		r-=p.getDoubleRadius();
		return true;
	}
	public static Polar mult(Polar p, Polar k){
		return new Polar(p.getDoubleRadius()*p.getDoubleRadius(),p.getDoubleRadiant()+k.getDoubleRadiant());
	}
	public void mult(Polar p){
		r*=p.getDoubleRadius();
		rad+=p.getDoubleRadiant();
	}
	public static Polar div(Polar p, Polar k){
		return new Polar(p.getDoubleRadius()/p.getDoubleRadius(),p.getDoubleRadiant()-k.getDoubleRadiant());
	}
	public void div(Polar p){
		r/=p.getDoubleRadius();
		rad-=p.getDoubleRadiant();
	}
	public static Polar invrt(Polar p){
		return new Polar(1.0/p.r,-p.rad);
	}
	public void invrt(){
		r = 1.0/r;
		rad = -rad;
	}
}
