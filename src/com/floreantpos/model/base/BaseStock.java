package com.floreantpos.model.base;

import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * This is an object that contains data related to the STOCK table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="STOCK"
 */

public class BaseStock implements Comparable, Serializable{

	public static String REF = "STOCK";
	public static String PROP_COUNT = "count";
	
	private int hashCode = Integer.MIN_VALUE;
	// primary key
	private java.lang.String id;
	// fields
	protected java.lang.Integer count;
	
	//Constructor
	public BaseStock()
	{
		initialize();
	}
	
	/**
	 * Constructor for primary key
	 */
	public BaseStock(java.lang.String id)
	{
		this.setId(id);
		initialize();
	}
	
	/**
	 * Constructor for required fields
	 */
	public BaseStock(java.lang.String id, java.lang.Integer count)
	{
		this.setId(id);
		this.setCount(count);
		initialize();
	}
	
	/**
	 * Set the value related to the column: NAME
	 * @param name the NAME value
	 */
	private void setCount(java.lang.Integer count) {
		this.count = count;
	}
	
	/**
	 * Return the value associated with the column: COUNT
	 */
	public java.lang.Integer getCount () {
					return count;
			}


	private void initialize() {}
	
	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	private void setId(java.lang.String id) 
	{
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}
	
	/**
	 * Return the unique identifier of this class
	 * @hibernate.id
	 * column="ID"
	 */
	public java.lang.String getId()
	{
		return id;
	}
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.floreantpos.model.Tax)) return false;
		else {
			com.floreantpos.model.Stock stock = (com.floreantpos.model.Stock) obj;
			if (null == this.getId() || null == stock.getId()) return false;
			else return (this.getId().equals(stock.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode(); //$NON-NLS-1$
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode()) return 1;
		else if (obj.hashCode() < hashCode()) return -1;
		else return 0;
	}
	
	public String toString () {
		return super.toString();
	}
	
}
