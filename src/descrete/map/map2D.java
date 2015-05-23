package descrete.map;
import java.util.ArrayList;

public class map2D<T>{
	private class Point<T>{
		T x;
		T y;
		private Point(T x, T y){
			this.x = x;
			this.y = y;
		}
	}
	private ArrayList<Point<T>> map = new ArrayList<Point<T>>();
	public map2D(){}
	public void add(T x, T y){
		map.add(new Point<T>(x,y));
	}
	public ArrayList<T> map(T x){
		ArrayList<T> matches = new ArrayList<T>();
		for(int i=0;i<map.size();i++){
			if(map.get(i).x.equals(x)){
				matches.add(map.get(i).y);
			}
		}
		return matches;
	}
	public ArrayList<T> mapinverse(T y){
		ArrayList<T> matches = new ArrayList<T>();
		for(int i=0;i<map.size();i++){
			if(map.get(i).y.equals(y)){
				matches.add(map.get(i).x);
			}
		}
		return matches;
	}
	
}
