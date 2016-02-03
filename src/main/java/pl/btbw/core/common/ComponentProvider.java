package pl.btbw.core.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ComponentProvider {

	public List<Component> components = new ArrayList<>();
	public Map<String, Component> componentMap = new HashMap<>();

	public void add(Component component) {
		components.add(component);
		componentMap.put(component._nameComponent, component);
	}

	public Component buildOne() {
		return components.get(0);
	}

	public List<Component> buildList() {
		return components;
	}

	public Map<String, Component> buildMap() {
		return componentMap;
	}
}
