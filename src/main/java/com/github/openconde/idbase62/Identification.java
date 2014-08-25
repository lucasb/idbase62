package com.github.openconde.idbase62;

import java.io.Serializable;

/**
 * 
 * An instance of this class is used to identify different data.
 * 
 * @author Boscaini, Lucas
 * 
 */
public class Identification implements Serializable {

	private static final long serialVersionUID = 1L;

	private String value;

	/**
	 * 
	 * Initialize a newly created Identification object with generation a new key to identify.
	 * 
	 */
	public Identification() {
		this.value = Character.toString(Base62.ELEMENTS[0]);
	}

	/**
	 * 
	 * Get before Identification to current object.
	 * 
	 * @param value String to start this object.
	 * @return Identification object.
	 * @throws TypeException.  
	 * 
	 */
	public Identification(String value) {
		if(Base62.isValid(value)) {
			this.value = value.trim();
		} 
		else {
			throw new InstantiationError("Cannot instance class because the value is not valid.");
		}
	}

	/**
	 * 
	 * Get next Identification to current object.
	 * 
	 * @return a Identification object.
	 * 
	 */
	public Identification before() {
		this.value = Base62.minus(this.value, Character.toString(Base62.ELEMENTS[1]));
		return this;
	}

	/**
	 * 
	 * Returns a string with the key value of the Identifier object.
	 * 
	 * @return a string with Identifier object key.
	 * 
	 */
	public Identification next() {
		this.value = Base62.plus(this.value, Character.toString(Base62.ELEMENTS[1]));
		return this;
	}
	
	/**
	 * 
	 * Compares this Identification with other Identification object. The result is true if and only if the argument 
	 * is not null and is a Identifier object that represents the same id value that this Identifier. 
	 * 
	 * @param id Identification object to compare.
	 * @return true if the given object represents a Identifier equivalent to this id, false otherwise.
	 * 
	 */
	public boolean equals(Identification id) {
		return this.value.equals(id.toString());
	}
	
	/**
	 * 
	 * Returns a string with the key value of the Identification object.
	 * 
	 * @return a string with Identification object.
	 * 
	 */
	public String toString() {
		return this.value;
	}
	
}
