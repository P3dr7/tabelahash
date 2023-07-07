package hashTableTree;

public class Pair {
	
	public int key;
	public String value;
	
	public Pair() {
		
	}
	
	public Pair(int key, String value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "<" + key + ": " + this.value + ">";
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
