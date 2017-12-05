package lab;

public class Vocalist extends Performer{
	private String key;
	private Integer volume;
	
	public Vocalist(Audition audition, String key){		
		super(audition);
		this.key = key;
		this.volume = null;
	}
	
	public Vocalist(Audition audition, String key, int vol){		
		super(audition);
		this.key = key;
		this.volume = vol;
	}
	
	@Override
	public void perform() {
		if(volume == null)
			System.out.println("I sing in the key of - " + key + " - " + super.id);
		else
			System.out.println("I sing in the key of - " + key + "- at the volume - " + this.volume + " - " + super.id);
	}
	
	public void perform(int vol) {
		System.out.println("I sing in the key of - " + key + "- at the volume - " + this.volume + " - " + super.id);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	
	

}
