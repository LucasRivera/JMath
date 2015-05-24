package function;
/**
 * Consider the Form
 * X(t) = Amplitude*Type(2PI*frequency*t+phi)
 * example:
 * X(t) = 5cos(32.7t+23)
 * */
public class Trigonometric {
	public enum trigTypes {sin,cos,tan};
	private trigTypes trigType;
	private double Amplitude=1;
	private double frequency=1.0/(2*Math.PI);
	private double phaseshift=0;
	public Trigonometric(trigTypes type, double amplitude, double frequency, double phaseshift) {
		this.trigType = type;
		Amplitude = amplitude;
		this.frequency = frequency;
		this.phaseshift = phaseshift;
	}
	public Trigonometric(trigTypes type, double amplitude, double frequency) {
		this.trigType = type;
		Amplitude = amplitude;
		this.frequency = frequency;
	}
	public Trigonometric(trigTypes type, double amplitude) {
		this.trigType = type;
		Amplitude = amplitude;
	}
	public Trigonometric(trigTypes type){
		this.trigType = type;
	}
	public double eval(double t){
		switch(trigType){
		case cos:
			return Amplitude*Math.cos(2*Math.PI*frequency+phaseshift);
		case sin:
			return Amplitude*Math.sin(2*Math.PI*frequency+phaseshift);
		case tan:
			return Amplitude*Math.tan(2*Math.PI*frequency+phaseshift);
		default:
			return 0;
		}
	}
	public double getAmplitude() {
		return Amplitude;
	}
	public void setAmplitude(double amplitude) {
		Amplitude = amplitude;
	}
	public double getFrequency() {
		return frequency;
	}
	public double getRadiantFrequency() {
		return 2*Math.PI*frequency;
	}
	public double getPeriod() {
		return 1.0/frequency;
	}
	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}
	public void setRadiantFrequency(double Radfrequency) {
		this.frequency = Radfrequency/(2*Math.PI);
	}
	public void setPeriod(double period) {
		this.frequency = 1.0/period;
	}
	public double getPhaseshift() {
		return phaseshift;
	}
	public void setPhaseshift(double phaseshift) {
		this.phaseshift = phaseshift;
	}
	public trigTypes getTrigType() {
		return trigType;
	}
	public static Trigonometric SinCosConvertion(Trigonometric t){
		if(t.trigType==trigTypes.sin){
			return new Trigonometric(trigTypes.cos,t.Amplitude,t.frequency,t.phaseshift-(Math.PI/2.0));
		}
		return null;
	}
	public void SinCosConvertion(){
		if(trigType==trigTypes.sin){
			phaseshift-=(Math.PI/2.0);
			trigType=trigTypes.cos;
		}
		else if(trigType==trigTypes.cos){
			phaseshift+=(Math.PI/2.0);
			trigType = trigTypes.sin;
		}
		else{
			return;
		}
	}
}
