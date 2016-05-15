package info.axbase.appprot;

import java.util.HashMap;
import java.util.Map;

public class ComponentRegister {
	private static ComponentRegister instance = new ComponentRegister();
	
	private Map<String, Protocol> map = new HashMap<String, Protocol>();

	public static ComponentRegister getInstance() {
		return instance;
	}
	
	public synchronized Protocol getComponent(String name) {
		return map.get(name);
	}

	public synchronized void setComponent(String name, Protocol p) {
		map.put(name, p);
	}
}
