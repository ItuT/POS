/*
 * CashPaymentView.java
 *
 * Created on August 11, 2006, 7:30 PM
 */

package com.floreantpos.ui.views.payment;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTextField;

import com.floreantpos.model.GiftCertificateTransaction;
import com.floreantpos.swing.PosButton;
import com.floreantpos.ui.dialog.POSMessageDialog;
import com.floreantpos.ui.views.PaymentView;
import com.floreantpos.ui.views.SwitchboardView;
import com.floreantpos.ui.views.order.RootView;
import com.floreantpos.util.NumberUtil;

/**
 *
 * @author  MShahriar
 */
public class GiftCertificatePaymentView extends PaymentView {
	public final static String VIEW_NAME = "GIFTCERT_VIEW";

	/** Creates new form CashPaymentView */
	public GiftCertificatePaymentView() {
		initComponents();
		tfFaceValue.setEditable(true);
		tfAmountTendered.setEditable(true);
		tfFaceValue.setText("0");
		btnNextAmount.setEnabled(false);
		btnExactChange.setEnabled(false);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new com.floreantpos.swing.TransparentPanel();
        jLabel1 = new javax.swing.JLabel();
        tfFaceValue = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfAmountTendered = new javax.swing.JTextField();
        calcButtonPanel = new com.floreantpos.swing.TransparentPanel();
        posButton1 = new com.floreantpos.swing.PosButton();
        posButton2 = new com.floreantpos.swing.PosButton();
        posButton3 = new com.floreantpos.swing.PosButton();
        posButton4 = new com.floreantpos.swing.PosButton();
        posButton5 = new com.floreantpos.swing.PosButton();
        posButton6 = new com.floreantpos.swing.PosButton();
        posButton9 = new com.floreantpos.swing.PosButton();
        posButton8 = new com.floreantpos.swing.PosButton();
        posButton7 = new com.floreantpos.swing.PosButton();
        posButton11 = new com.floreantpos.swing.PosButton();
        posButton10 = new com.floreantpos.swing.PosButton();
        posButton12 = new com.floreantpos.swing.PosButton();
        jPanel3 = new com.floreantpos.swing.TransparentPanel();
        jPanel4 = new com.floreantpos.swing.TransparentPanel();
        btnChangePayment = new com.floreantpos.swing.PosButton();
        btnExactChange = new com.floreantpos.swing.PosButton();
        btnNextAmount = new com.floreantpos.swing.PosButton();
        jPanel5 = new com.floreantpos.swing.TransparentPanel();
        btnFinish = new com.floreantpos.swing.PosButton();
        btnCancel = new com.floreantpos.swing.PosButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, com.floreantpos.POSConstants.CASH_TRANSACTION, javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        setLayout(new java.awt.BorderLayout(5, 5));

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 5), javax.swing.BorderFactory.createTitledBorder("")));
        jPanel1.setPreferredSize(new java.awt.Dimension(98, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel1.setForeground(new java.awt.Color(204, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("GIFT CERT FACE VALUE");

        tfFaceValue.setEditable(false);
        tfFaceValue.setFont(new java.awt.Font("Tahoma", 1, 24));
        tfFaceValue.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfFaceValue.setText("0");
        tfFaceValue.setPreferredSize(new java.awt.Dimension(21, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18));
        jLabel2.setForeground(new java.awt.Color(204, 102, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("AMOUNT TENDERED");

        tfAmountTendered.setEditable(false);
        tfAmountTendered.setFont(new java.awt.Font("Tahoma", 1, 24));
        tfAmountTendered.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfAmountTendered.setText("0");
        tfAmountTendered.setPreferredSize(new java.awt.Dimension(21, 40));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 298, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tfFaceValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 298, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 298, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(tfAmountTendered, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 298, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jLabel1)
                .add(tfFaceValue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tfAmountTendered, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.NORTH);

        calcButtonPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        calcButtonPanel.setLayout(new java.awt.GridLayout(0, 3, 5, 5));

        posButton1.setAction(calAction);
        posButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/7_32.png"))); // NOI18N
        posButton1.setActionCommand("7");
        posButton1.setFocusable(false);
        calcButtonPanel.add(posButton1);

        posButton2.setAction(calAction);
        posButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/8_32.png"))); // NOI18N
        posButton2.setActionCommand("8");
        posButton2.setFocusable(false);
        calcButtonPanel.add(posButton2);

        posButton3.setAction(calAction);
        posButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/9_32.png"))); // NOI18N
        posButton3.setActionCommand("9");
        posButton3.setFocusable(false);
        calcButtonPanel.add(posButton3);

        posButton4.setAction(calAction);
        posButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4_32.png"))); // NOI18N
        posButton4.setActionCommand("4");
        posButton4.setFocusable(false);
        calcButtonPanel.add(posButton4);

        posButton5.setAction(calAction);
        posButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5_32.png"))); // NOI18N
        posButton5.setActionCommand("5");
        posButton5.setFocusable(false);
        calcButtonPanel.add(posButton5);

        posButton6.setAction(calAction);
        posButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6_32.png"))); // NOI18N
        posButton6.setActionCommand("6");
        posButton6.setFocusable(false);
        calcButtonPanel.add(posButton6);

        posButton9.setAction(calAction);
        posButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1_32.png"))); // NOI18N
        posButton9.setActionCommand("1");
        posButton9.setFocusable(false);
        calcButtonPanel.add(posButton9);

        posButton8.setAction(calAction);
        posButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2_32.png"))); // NOI18N
        posButton8.setActionCommand("2");
        posButton8.setFocusable(false);
        calcButtonPanel.add(posButton8);

        posButton7.setAction(calAction);
        posButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3_32.png"))); // NOI18N
        posButton7.setActionCommand("3");
        posButton7.setFocusable(false);
        calcButtonPanel.add(posButton7);

        posButton11.setAction(calAction);
        posButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/0_32.png"))); // NOI18N
        posButton11.setActionCommand("0");
        posButton11.setFocusable(false);
        calcButtonPanel.add(posButton11);

        posButton10.setAction(calAction);
        posButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/dot_32.png"))); // NOI18N
        posButton10.setActionCommand(".");
        posButton10.setFocusable(false);
        calcButtonPanel.add(posButton10);

        posButton12.setAction(calAction);
        posButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear_32.png"))); // NOI18N
        posButton12.setText("CLEAR");
        posButton12.setFocusable(false);
        calcButtonPanel.add(posButton12);

        add(calcButtonPanel, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 3));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 130));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0, 2, 5));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnChangePayment.setText("<html><body><p align='center'>CHANGE PAYMENT METHOD</p></body></html>");
        btnChangePayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePaymentActionPerformed(evt);
            }
        });
        jPanel4.add(btnChangePayment);

        btnExactChange.setText("EXACT CHANGE");
        btnExactChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExactChangeActionPerformed(evt);
            }
        });
        jPanel4.add(btnExactChange);

        btnNextAmount.setText("NEXT AMT");
        btnNextAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextAmountActionPerformed(evt);
            }
        });
        jPanel4.add(btnNextAmount);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnFinish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/finish_32.png"))); // NOI18N
        btnFinish.setText("FINISH");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doFinish(evt);
            }
        });
        jPanel5.add(btnFinish);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_32.png"))); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancel);

        jPanel3.add(jPanel5);

        add(jPanel3, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

	private void btnChangePaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePaymentActionPerformed
		changePaymentMethod();
	}//GEN-LAST:event_btnChangePaymentActionPerformed

	private void doFinish(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doFinish
		double faceValue = 0;
		try {
			faceValue = Double.parseDouble(tfFaceValue.getText());
		} catch(Exception e) {
			POSMessageDialog.showError("Gift certificate face value is not valid");
			return;
		}
		double tenderedAmount = 0;
		try {
			tenderedAmount = Double.parseDouble(tfAmountTendered.getText());
		} catch (Exception e) {
			POSMessageDialog.showError("Amount tendered is not valid");
			return;
		}
		
		if(faceValue < tenderedAmount) {
			POSMessageDialog.showError("Face value cannot be less than tendered amount.");
			return;
		}
		
		GiftCertificateTransaction transaction = new GiftCertificateTransaction();
		transaction.setFaceValue(faceValue);
		transaction.setPaidAmount(tenderedAmount);
		transaction.setCashBackAmount(faceValue - tenderedAmount);
		settleTickets(tenderedAmount, 0, transaction, null, null);
	}//GEN-LAST:event_doFinish

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
		RootView.getInstance().showView(SwitchboardView.VIEW_NAME);
	}//GEN-LAST:event_btnCancelActionPerformed

	private void btnExactChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExactChangeActionPerformed
	}//GEN-LAST:event_btnExactChangeActionPerformed

	private void btnNextAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextAmountActionPerformed
//		double totalPrice = getDueAmount();
//		double tenderedAmount = Math.ceil(totalPrice);

		//ticket.setTenderedAmount(tenderedAmount);

		//doPayTicket();
	}//GEN-LAST:event_btnNextAmountActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.floreantpos.swing.PosButton btnCancel;
    private com.floreantpos.swing.PosButton btnChangePayment;
    private com.floreantpos.swing.PosButton btnExactChange;
    private com.floreantpos.swing.PosButton btnFinish;
    private com.floreantpos.swing.PosButton btnNextAmount;
    private com.floreantpos.swing.TransparentPanel calcButtonPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private com.floreantpos.swing.TransparentPanel jPanel1;
    private com.floreantpos.swing.TransparentPanel jPanel3;
    private com.floreantpos.swing.TransparentPanel jPanel4;
    private com.floreantpos.swing.TransparentPanel jPanel5;
    private com.floreantpos.swing.PosButton posButton1;
    private com.floreantpos.swing.PosButton posButton10;
    private com.floreantpos.swing.PosButton posButton11;
    private com.floreantpos.swing.PosButton posButton12;
    private com.floreantpos.swing.PosButton posButton2;
    private com.floreantpos.swing.PosButton posButton3;
    private com.floreantpos.swing.PosButton posButton4;
    private com.floreantpos.swing.PosButton posButton5;
    private com.floreantpos.swing.PosButton posButton6;
    private com.floreantpos.swing.PosButton posButton7;
    private com.floreantpos.swing.PosButton posButton8;
    private com.floreantpos.swing.PosButton posButton9;
    private javax.swing.JTextField tfAmountTendered;
    private javax.swing.JTextField tfFaceValue;
    // End of variables declaration//GEN-END:variables

	public void resetView() {
		tfFaceValue.setText("50.0");
		tfAmountTendered.setText("0.0");
	}

	Dimension preferredSize = new Dimension(330, 100);

	public Dimension getPreferredSize() {
		return preferredSize;
	}
	
	private JTextField getFocusedTextField() {
		if (tfFaceValue.hasFocus()) {
			return tfFaceValue;
		}
		if (tfAmountTendered.hasFocus()) {
			return tfAmountTendered;
		}
		return tfAmountTendered;
	}


	Action calAction = new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			JTextField tf = getFocusedTextField();
			PosButton button = (PosButton) e.getSource();
			String s = button.getActionCommand();
			if (s.equals("CLEAR")) {
				tf.setText("0");
			}
			else if (s.equals(".")) {
				if (tf.getText().indexOf('.') < 0) {
					tf.setText(tf.getText() + ".");
				}
			}
			else {
				String string = tf.getText();
				int index = string.indexOf('.');
				if (index < 0) {
					double value = 0;
					try {
						value = Double.parseDouble(string);
					} catch (NumberFormatException x) {
						Toolkit.getDefaultToolkit().beep();
					}
					if (value == 0) {
						tf.setText(s);
					}
					else {
						tf.setText(string + s);
					}
				}
				else {
					tf.setText(string + s);
				}
			}
		}
	};

	@Override
	public void updateView() {
		tfFaceValue.setText("50.0");
		tfAmountTendered.setText(NumberUtil.formatNumber(getDueAmount()));
	}
}
