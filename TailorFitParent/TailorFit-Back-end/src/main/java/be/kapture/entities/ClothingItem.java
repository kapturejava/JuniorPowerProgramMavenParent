package be.kapture.entities;

import java.awt.Color;

import be.kapture.util.InputUtil;

public class ClothingItem {
	
	private int id;
	private int size;
	private String color;

	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public ClothingItem(int size, String color) throws IllegalArgumentException{
		setSize(size);
		setColor(color);
	}

	public void setSize(int size) {
		this.size = InputUtil.isIntStricltyPositive(size);
	}
	
	public void setColor(String color){
		this.color = InputUtil.isStringEmpty(color);
	}
	
	public int getSize(){
		return size;
	}
	
	public String getColor(){
		return color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + size;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClothingItem other = (ClothingItem) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (size != other.size)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClothingItem [size=" + size + ", color=" + color + "]";
	}
	
}
