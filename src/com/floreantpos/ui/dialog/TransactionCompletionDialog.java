package com.floreantpos.ui.dialog;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JSeparator;

import net.miginfocom.swing.MigLayout;

import com.floreantpos.main.Application;
import com.floreantpos.model.Ticket;
import com.floreantpos.print.PosPrintService;
import com.floreantpos.swing.PosButton;
import com.floreantpos.util.NumberUtil;

public class TransactionCompletionDialog extends POSDialog {
	private List<Ticket> tickets;
	private double tenderedAmount;
	private double totalAmount;
	private double paidAmount;
	private double dueAmount;
	private double dueAmountBeforePaid;
	private double gratuityAmount;
	
	private JLabel lblTenderedAmount;
	private JLabel lblTotalAmount;
	private JLabel lblPaidAmount;
	private JLabel lblDueAmount;
	private JLabel lblChangeDue;
	private JLabel lblGratuityAmount;
	
	private TransactionCompletionDialog(Frame parent) {
		super(parent, true);
		
		setTitle(com.floreantpos.POSConstants.TRANSACTION_COMPLETED);
		
		setLayout(new MigLayout("align 50% 0%, ins 20","[]20[]",""));
		
		add(createLabel("TOTAL AMOUNT" + ":",JLabel.LEFT), "grow");
		lblTotalAmount = createLabel("0.0",JLabel.RIGHT);
		add(lblTotalAmount, "span, grow");
		
		add(createLabel("TENDERED AMOUNT" + ":",JLabel.LEFT), "newline,grow");
		lblTenderedAmount = createLabel("0.0",JLabel.RIGHT);
		add(lblTenderedAmount, "span, grow");
		
		add(new JSeparator(), "newline,span, grow");
		
		add(createLabel("PAID AMOUNT" + ":",JLabel.LEFT), "newline,grow");
		lblPaidAmount = createLabel("0.0",JLabel.RIGHT);
		add(lblPaidAmount, "span, grow");

		add(createLabel("DUE AMOUNT" + ":",JLabel.LEFT), "newline,grow");
		lblDueAmount = createLabel("0.0",JLabel.RIGHT);
		add(lblDueAmount, "span, grow");
		
		add(new JSeparator(), "newline,span, grow");
		
		add(createLabel("GRATUITY AMOUNT" + ":",JLabel.LEFT), "newline,grow");
		lblGratuityAmount = createLabel("0.0",JLabel.RIGHT);
		add(lblGratuityAmount, "span, grow");
		
		add(new JSeparator(), "newline,span, grow");
		
		add(createLabel("CHANGE DUE" + ":",JLabel.LEFT), "grow");
		lblChangeDue = createLabel("0.0", JLabel.RIGHT);
		add(lblChangeDue, "span, grow");
		
		add(new JSeparator(), "sg mygroup,newline,span,grow");
		PosButton btnClose = new PosButton("CLOSE");
		btnClose.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});

		PosButton btnPrintClose = new PosButton("PRINT & CLOSE");
		btnPrintClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for (Ticket ticket : tickets) {
//						PosPrintService.printMoneyReceipt(ticket);
						PosPrintService.printTicket(ticket, getTenderedAmount());
					}
				}catch(Exception ee) {
					POSMessageDialog.showError(Application.getPosWindow(), "There was an error while printing money receipt", ee);
				}
				dispose();
			}
		});
		
		add(btnPrintClose, "newline,skip, align 100%,h 50, w 120");
		add(btnClose, "skip, align 100%,h 50, w 120");
		//setResizable(false);
	}
	
	protected JLabel createLabel(String text, int alignment) {
		JLabel label = new JLabel(text);
		label.setFont(new java.awt.Font("Tahoma", 1, 24));
		//label.setForeground(new java.awt.Color(255, 102, 0));
		label.setHorizontalAlignment(alignment);
		label.setText(text);
		return label;
	}

	public double getTenderedAmount() {
		return tenderedAmount;
	}

	public void setTenderedAmount(double amountTendered) {
		this.tenderedAmount = amountTendered;
	}

	public void updateView() {
		lblTotalAmount.setText(NumberUtil.formatNumber(totalAmount));
		lblTenderedAmount.setText(NumberUtil.formatNumber(tenderedAmount));
		lblPaidAmount.setText(NumberUtil.formatNumber(paidAmount));
		lblDueAmount.setText(NumberUtil.formatNumber(dueAmount));
		lblGratuityAmount.setText(NumberUtil.formatNumber(gratuityAmount));
		
		double changeDueAmount = tenderedAmount - gratuityAmount - dueAmountBeforePaid;
		if(changeDueAmount < 0) {
			changeDueAmount = 0;
		}
		lblChangeDue.setText(NumberUtil.formatNumber(changeDueAmount));
	}
	
	private static TransactionCompletionDialog instance;
	
	public static TransactionCompletionDialog getInstance() {
		if(instance == null) {
			instance = new TransactionCompletionDialog(Application.getPosWindow());
		}
		return instance;
	}

	public double getDueAmountBeforePaid() {
		return dueAmountBeforePaid;
	}

	public void setDueAmountBeforePaid(double dueAmountBeforePaid) {
		this.dueAmountBeforePaid = dueAmountBeforePaid;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

	public double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getGratuityAmount() {
		return gratuityAmount;
	}

	public void setGratuityAmount(double gratuityAmount) {
		this.gratuityAmount = gratuityAmount;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}
