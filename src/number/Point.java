package number;

public class Point {
	private double x;
	private double y;
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	public double getDoubleX(){
		return x;
	}
	public double getDoubleY(){
		return y;
	}
	public Polar toPolar(){
		double rad = Math.atan(y/x);
		if(y>=0 && x>=0){//first quadrant
			
		}
		else if(y>=-1 && x<=0){//second
			
		}
		else if(y<=0 && x<=0){//third
			
		}
		else{//forth
			
		}
		return new Polar(Math.sqrt(x*x+y*y),Math.atan(y/x));
	}
}
