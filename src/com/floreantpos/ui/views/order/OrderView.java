/*
 * OrderView.java
 *
 * Created on August 4, 2006, 6:58 PM
 */

package com.floreantpos.ui.views.order;

import java.awt.CardLayout;
import java.util.HashMap;

import javax.swing.JComponent;

import com.floreantpos.Messages;
import com.floreantpos.main.Application;
import com.floreantpos.model.Ticket;
import com.floreantpos.ui.dialog.POSMessageDialog;

/**
 *
 * @author  MShahriar
 */
public class OrderView extends ViewPanel {
	private HashMap<String, JComponent> views = new HashMap<String, JComponent>();

	public final static String VIEW_NAME = "ORDER_VIEW"; //$NON-NLS-1$
	private static OrderView instance;
	
	private Ticket currentTicket;

	/** Creates new form OrderView */
	private OrderView() {
		initComponents();
		
		init();
	}

	public void addView(final String viewName, final JComponent view) {
		JComponent oldView = views.get(viewName);
		if (oldView != null) {
			return;
		}

		midContainer.add(view, viewName);
	}

	public void init() {
		setOpaque(false);
		
		cardLayout = new CardLayout();
		midContainer.setOpaque(false);
		midContainer.setLayout(cardLayout);

		groupView = new GroupView();
		itemView = new MenuItemView();
		modifierView = new ModifierView();
		
		ticketView.getTicketViewerTable().setModifierStateChangeListener(modifierView);

		addView(GroupView.VIEW_NAME, groupView);
		addView(MenuItemView.VIEW_NAME, itemView);
		addView(ModifierView.VIEW_NAME, modifierView);
		addView("VIEW_EMPTY", new com.floreantpos.swing.TransparentPanel()); //$NON-NLS-1$

		showView("VIEW_EMPTY"); //$NON-NLS-1$

		orderController = new OrderController(this);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        categoryView = new com.floreantpos.ui.views.order.CategoryView();
        ticketView = new com.floreantpos.ui.views.order.TicketView();
        //othersView = ticketView.getExtraActionPanel();
        jPanel1 = new com.floreantpos.swing.TransparentPanel();
        midContainer = new com.floreantpos.swing.TransparentPanel();

        setLayout(new java.awt.BorderLayout(10, 10));

        add(categoryView, java.awt.BorderLayout.EAST);

        add(ticketView, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.add(midContainer, java.awt.BorderLayout.CENTER);

       // jPanel1.add(othersView, java.awt.BorderLayout.SOUTH);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.floreantpos.ui.views.order.CategoryView categoryView;
    private com.floreantpos.swing.TransparentPanel jPanel1;
    private com.floreantpos.swing.TransparentPanel midContainer;
   // private TicketView.ExtraTicketActionPanel othersView;
    private com.floreantpos.ui.views.order.TicketView ticketView;
    // End of variables declaration//GEN-END:variables
    
	private CardLayout cardLayout;
	private GroupView groupView;
	private MenuItemView itemView;
	private ModifierView modifierView;
	private OrderController orderController;

	public void showView(final String viewName) {
		cardLayout.show(midContainer, viewName);
	}

	public com.floreantpos.ui.views.order.CategoryView getCategoryView() {
		return categoryView;
	}

	public void setCategoryView(com.floreantpos.ui.views.order.CategoryView categoryView) {
		this.categoryView = categoryView;
	}

	public GroupView getGroupView() {
		return groupView;
	}

	public void setGroupView(GroupView groupView) {
		this.groupView = groupView;
	}

	public MenuItemView getItemView() {
		return itemView;
	}

	public void setItemView(MenuItemView itemView) {
		this.itemView = itemView;
	}

	public ModifierView getModifierView() {
		return modifierView;
	}

	public void setModifierView(ModifierView modifierView) {
		this.modifierView = modifierView;
	}

	public com.floreantpos.ui.views.order.TicketView getTicketView() {
		return ticketView;
	}

	public void setTicketView(com.floreantpos.ui.views.order.TicketView ticketView) {
		this.ticketView = ticketView;
	}

	public OrderController getOrderController() {
		return orderController;
	}

	public Ticket getCurrentTicket() {
		return currentTicket;
	}

	public void setCurrentTicket(Ticket currentTicket) {
		this.currentTicket = currentTicket;
		
		ticketView.setTicket(currentTicket);
		resetView();
	}
	
	public synchronized static OrderView getInstance() {
		if(instance == null) {
			instance = new OrderView();
		}
		return instance;
	}
	
	public void resetView() {
	}

	//public TicketView.ExtraTicketActionPanel getOthersView() {
		//return othersView;
	//}
	
	@Override
	public void setVisible(boolean aFlag) {
		if(aFlag) {
			try {
				categoryView.initialize();
			}catch(Throwable t) {
				POSMessageDialog.showError(Application.getPosWindow(), com.floreantpos.POSConstants.ERROR_MESSAGE, t);
			}
		}
		else {
			categoryView.cleanup();
		}
		super.setVisible(aFlag);
	}

	@Override
	public String getViewName() {
		return VIEW_NAME;
	}
}
