
public class ControlVariable{
	
	// ================================= INSTANCE VARIABLES =================================
	private double waterLevel;
	private double waterTemp;
	private double ph;
	private double nitrate;
	private double oxygen;
	private double ammonia;
	private double light;
	private double airTemp;
	
	// ================================= CONSTRUCTORS =================================
	
	/**
	 * Default ControlVariable Constructor
	 */
	public ControlVariable() {
		this.waterLevel = 0.0;
		this.waterTemp = 0.0;
		this.ph = 0.0;
		this.nitrate = 0.0;
		this.oxygen = 0.0;
		this.ammonia = 0.0;
		this.light = 0.0;
		this.airTemp = 0.0;
	}
	
	/**
	 * ControlVariable Constructor
	 * Initializes variables according to input parameters
	 */
	public ControlVariable(double waterLevel, double waterTemp, double ph, double nitrate, double oxygen, double ammonia, double light, double airTemp) {
		this.waterLevel = waterLevel;
		this.waterTemp = waterTemp;
		this.ph = ph;
		this.nitrate = nitrate;
		this.oxygen = oxygen;
		this.ammonia = ammonia;
		this.light = light;
		this.airTemp = airTemp;
	}
	
	// ================================= METHODS =================================
	// ------------- Accessor Methods -------------
	public double getWaterLevel(){
		return this.waterLevel;
	}
	public double getWaterTemp(){
		return this.waterTemp;
	}
	public double getPH(){
		return this.ph;
	}
	public double getNitrate(){
		return this.nitrate;
	}
	public double getOxygen(){
		return this.oxygen;
	}
	public double getAmmonia(){
		return this.ammonia;
	}
	public double getLight(){
		return this.light;
	}
	public double getAirTemp(){
		return this.airTemp;
	}
	
	// ------------- Mutator Methods -------------
	public void setWaterLevel(double waterLevel){
		this.waterLevel = waterLevel;
	}
	public void setWaterTemp(double waterTemp){
		this.waterTemp = waterTemp;
	}
	public void setPH(double ph){
		this.ph = ph;
	}
	public void setNitrate(double nitrate){
		this.nitrate = nitrate;
	}
	public void setOxygen(double oxygen){
		this.oxygen = oxygen;
	}
	public void setAmmonia(double ammonia){
		this.ammonia = ammonia;
	}
	public void setLight(double light){
		this.light = light;
	}
	public void setAirTemp(double airTemp){
		this.airTemp = airTemp;
	}
}
