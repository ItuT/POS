
/*
 * GroupView.java
 *
 * Created on August 5, 2006, 9:29 PM
 */

package com.floreantpos.ui.views.order;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXTable;

import com.floreantpos.Messages;
import com.floreantpos.POSConstants;
import com.floreantpos.bo.ui.BOMessageDialog;
import com.floreantpos.main.Application;
import com.floreantpos.model.MenuItem;
import com.floreantpos.model.dao.MenuItemDAO;
import com.floreantpos.swing.BeanTableModel;
import com.floreantpos.swing.TransparentPanel;
import com.floreantpos.ui.views.order.actions.ItemSelectionListener;

public class MenuItemView extends TransparentPanel implements ActionListener, ListSelectionListener {
	public final static String VIEW_NAME = "ITEM_LIST_VIEW"; //$NON-NLS-1$

	private JXTable table;
	private BeanTableModel<MenuItem> tableModel;

	private Vector<ItemSelectionListener> listenerList = new Vector<ItemSelectionListener>();
	
	public MenuItemView() {
		tableModel = new BeanTableModel<MenuItem>(MenuItem.class);
		//tableModel.addColumn(POSConstants.ID.toUpperCase(), "id"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.NAME.toUpperCase(), "name"); //$NON-NLS-1$
		//tableModel.addColumn(POSConstants.TRANSLATED_NAME.toUpperCase(), "translatedName"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.PRICE.toUpperCase() + " (" + Application.getCurrencySymbol() + ")", "price"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		//tableModel.addColumn(POSConstants.VISIBLE.toUpperCase(), "visible"); //$NON-NLS-1$
		//tableModel.addColumn(POSConstants.DISCOUNT.toUpperCase() + "(%)", "discountRate"); //$NON-NLS-1$ //$NON-NLS-2$
		//tableModel.addColumn(POSConstants.FOOD_GROUP.toUpperCase(), "parent"); //$NON-NLS-1$
		//tableModel.addColumn(POSConstants.TAX.toUpperCase(), "tax"); //$NON-NLS-1$
		//tableModel.addColumn(POSConstants.SORT_ORDER.toUpperCase(), "sortOrder"); //$NON-NLS-1$
		//tableModel.addColumn(POSConstants.BUTTON_COLOR.toUpperCase(), "buttonAsColor"); //$NON-NLS-1$
		//tableModel.addColumn(POSConstants.IMAGE.toUpperCase(), "imageAsIcon");
		tableModel.addColumn("COUNT", "count");
		
		tableModel.addRows(MenuItemDAO.getInstance().findAll());

		table = new JXTable(tableModel);
		table.setCellSelectionEnabled(true);

		table.setRowHeight(30);
		
		table.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if (e.getClickCount() == 2)
				{
					JXTable target = (JXTable)e.getSource();
					int row = target.getSelectedRow();
					
					fireItemSelected(tableModel.getRow(row));
				}
			}
		});

		setLayout(new BorderLayout(5, 5));
		add(new JScrollPane(table));

		add(buildSearchForm(), BorderLayout.NORTH);
	}

	private JPanel buildSearchForm() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]30[][]30[]", "[]20[]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		JLabel nameLabel = new JLabel(Messages.getString("MenuListExplorer.2")); //$NON-NLS-1$
		//JLabel groupLabel = new JLabel(Messages.getString("MenuListExplorer.3")); //$NON-NLS-1$
		final JTextField nameField = new JTextField(15);

		try {

			/*List<MenuGroup> menuGroupList = MenuGroupDAO.getInstance().findAll();

			final JComboBox cbGroup = new JComboBox();

			cbGroup.addItem(Messages.getString("MenuListExplorer.0")); //$NON-NLS-1$
			for (MenuGroup s : menuGroupList) {
				cbGroup.addItem(s);
			}*/

			JButton searchBttn = new JButton(Messages.getString("MenuListExplorer.1")); //$NON-NLS-1$

			panel.add(nameLabel, "align label"); //$NON-NLS-1$
			panel.add(nameField);
			//panel.add(groupLabel);
			//panel.add(cbGroup);
			panel.add(searchBttn);

			Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			TitledBorder title = BorderFactory.createTitledBorder(loweredetched, Messages.getString("MenuListExplorer.21")); //$NON-NLS-1$
			title.setTitleJustification(TitledBorder.LEFT);
			panel.setBorder(title);

			searchBttn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					String txName = nameField.getText();
					//Object selectedItem = cbGroup.getSelectedItem();

					List<MenuItem> similarItem = null;
					//if (selectedItem instanceof MenuGroup) {
					//	similarItem = MenuItemDAO.getInstance().getSimilar(txName, (MenuGroup) selectedItem);
					//} else {
						similarItem = MenuItemDAO.getInstance().getSimilar(txName, null);
					//}

					tableModel.removeAll();
					tableModel.addRows(similarItem);
					//tableModel.g getRow(0).getId();
				}
			});

		} catch (Throwable x) {
			BOMessageDialog.showError(POSConstants.ERROR_MESSAGE, x);
		}

		return panel;
	}

	public void addItemSelectionListener(ItemSelectionListener listener) {
		listenerList.add(listener);
	}

	public void removeItemSelectionListener(ItemSelectionListener listener) {
		listenerList.remove(listener);
	}
	
	public void fireItemSelected(MenuItem foodItem) {
		for (ItemSelectionListener listener : listenerList) {
			listener.itemSelected(foodItem);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("act perfomed ###");
		if(e.getActionCommand().isEmpty()) {
			return;
		}

		int selectedRow = table.getSelectedRow();
		if(selectedRow < 0) {
			return;
		}
		
		selectedRow = table.convertRowIndexToModel(selectedRow);
		
		if(selectedRow < 0) return;
		
		MenuItem data = tableModel.getRow(selectedRow);
		System.out.println(data.getName());
		
		fireItemSelected(data);
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		System.out.println("listsele perfomed .....");
		if(e.getValueIsAdjusting()) {
			return;
		}

		int selectedRow = table.getSelectedRow();
		if(selectedRow < 0) {
			return;
		}
		
		selectedRow = table.convertRowIndexToModel(selectedRow);
		
		if(selectedRow < 0) return;
		
		MenuItem data = tableModel.getRow(selectedRow);
		System.out.println(data.getName());
		
		fireItemSelected(data);
	}
	
}

