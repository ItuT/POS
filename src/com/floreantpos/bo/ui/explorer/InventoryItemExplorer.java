package com.floreantpos.bo.ui.explorer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXTable;

import com.floreantpos.Messages;
import com.floreantpos.POSConstants;
import com.floreantpos.bo.ui.BOMessageDialog;
import com.floreantpos.main.Application;
import com.floreantpos.model.InventoryItem;
import com.floreantpos.model.MenuGroup;
import com.floreantpos.model.MenuItem;
import com.floreantpos.model.dao.InventoryItemDAO;
import com.floreantpos.model.dao.MenuGroupDAO;
import com.floreantpos.model.dao.MenuItemDAO;
import com.floreantpos.swing.BeanTableModel;
import com.floreantpos.swing.TransparentPanel;
import com.floreantpos.ui.dialog.BeanEditorDialog;
import com.floreantpos.ui.dialog.ConfirmDeleteDialog;
import com.floreantpos.ui.model.MenuItemForm;

public class InventoryItemExplorer extends TransparentPanel {

	private JXTable table;
	private BeanTableModel<MenuItem> tableModel;
	private BeanTableModel<InventoryItem> tableModel2;

	public InventoryItemExplorer() {
		/*tableModel = new BeanTableModel<MenuItem>(MenuItem.class);
		//tableModel.addColumn(POSConstants.ID.toUpperCase(), "id"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.NAME.toUpperCase(), "name"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.TRANSLATED_NAME.toUpperCase(), "translatedName"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.PRICE.toUpperCase() + " (" + Application.getCurrencySymbol() + ")", "price"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		tableModel.addColumn(POSConstants.VISIBLE.toUpperCase(), "visible"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.DISCOUNT.toUpperCase() + "(%)", "discountRate"); //$NON-NLS-1$ //$NON-NLS-2$
		tableModel.addColumn(POSConstants.FOOD_GROUP.toUpperCase(), "parent"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.TAX.toUpperCase(), "tax"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.SORT_ORDER.toUpperCase(), "sortOrder"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.BUTTON_COLOR.toUpperCase(), "buttonAsColor"); //$NON-NLS-1$
		//tableModel.addColumn(POSConstants.IMAGE.toUpperCase(), "imageAsIcon");

		tableModel.addRows(MenuItemDAO.getInstance().findAll());

		//table = new JXTable(tableModel);

		//table.setRowHeight(120);*/

		
		///--------------------------
		tableModel2 = new BeanTableModel<InventoryItem>(InventoryItem.class);
		tableModel2.addColumn("Stock ID","id");
		tableModel2.addColumn("Stock Name","name");
		tableModel2.addColumn("Package Barcode","packageBarcode");
		tableModel2.addColumn("Unit Barcode","unitBarcode");
		
		tableModel2.addRows(InventoryItemDAO.getInstance().findAll());
		table = new JXTable(tableModel2);
		table.setRowHeight(30);
		
		setLayout(new BorderLayout(5, 5));
		add(new JScrollPane(table));
		
		
		
	}
}
