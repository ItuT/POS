package com.floreantpos.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.floreantpos.model.base.BaseStock;

@XmlRootElement(name="stock")
public class Stock extends BaseStock {
	private static final long serialVersionUID = 1L;
	
	/*[CONSTRUCTOR MARKER BEGIN]*/
	public Stock()
	{
		super();
	}
	/**
	 * Constructor for primary key
	 */
	public Stock (java.lang.String id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Stock (
		java.lang.String id,
		java.lang.Integer count) {

		super (
			id,
			count);
	}

	/*[CONSTRUCTOR MARKER END]*/
	
	public String getUniqueId() {
		return ("tax_" + getCount() + "_" + getId()).replaceAll("\\s+", "_"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

	@Override
	public String toString() {
		return " (" + getCount() + "%)"; //$NON-NLS-1$
	}
}
