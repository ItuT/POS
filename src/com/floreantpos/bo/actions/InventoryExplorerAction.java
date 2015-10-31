package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.bo.ui.explorer.InventoryItemExplorer;
import com.floreantpos.bo.ui.explorer.MenuItemExplorer;

public class InventoryExplorerAction extends AbstractAction {

	public InventoryExplorerAction() {
		super("Inventory Items");
	}

	public InventoryExplorerAction(String name) {
		super(name);
	}

	public InventoryExplorerAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		BackOfficeWindow backOfficeWindow = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		JTabbedPane tabbedPane;
		InventoryItemExplorer item;
		tabbedPane = backOfficeWindow.getTabbedPane();
		int index = tabbedPane.indexOfTab("Inventory Broswer");
		if (index == -1) {
			item = new InventoryItemExplorer();
			tabbedPane.addTab("Inventory Broswer", item);
		}
		else {
			item = (InventoryItemExplorer) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(item);
	}

}
