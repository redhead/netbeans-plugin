/*
 * The MIT license
 *
 * Copyright (c) 2010 Radek Ježdík <redhead@email.cz>, Ondřej Brejla <ondrej@brejla.cz>
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

package org.netbeans.modules.php.nette.wizards.newpresenter;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.util.NbBundle;

public final class ParentPresenterVisualPanel extends JPanel implements DocumentListener {

    private ParentPresenterWizardPanel panel;

    private ImageIcon errorIcon = new ImageIcon(getClass().getResource("/org/netbeans/modules/php/nette/resources/error_icon.png"));

    /** Creates new form NewPresenterVisualPanel2 */
    public ParentPresenterVisualPanel(ParentPresenterWizardPanel panel) {
        initComponents();
        this.panel = panel;
        errorLabel.setText("");
        parentPresenterTextField.getDocument().addDocumentListener(this);
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(ParentPresenterVisualPanel.class, "TXT_parentpresenter_visual_panel_name");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        parentPresenterTextField = new javax.swing.JTextField();
        errorLabel = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(ParentPresenterVisualPanel.class, "ParentPresenterVisualPanel.jLabel1.text")); // NOI18N

        parentPresenterTextField.setText(org.openide.util.NbBundle.getMessage(ParentPresenterVisualPanel.class, "ParentPresenterVisualPanel.parentPresenterTextField.text")); // NOI18N
        parentPresenterTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                parentPresenterTextFieldCaretUpdate(evt);
            }
        });

        errorLabel.setForeground(javax.swing.UIManager.getDefaults().getColor("nb.errorForeground"));
        org.openide.awt.Mnemonics.setLocalizedText(errorLabel, org.openide.util.NbBundle.getMessage(ParentPresenterVisualPanel.class, "ParentPresenterVisualPanel.errorLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parentPresenterTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(errorLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(parentPresenterTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(errorLabel))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void parentPresenterTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_parentPresenterTextFieldCaretUpdate
        if (!validateParentPresenter()) {
            showError(NbBundle.getMessage(ParentPresenterVisualPanel.class, "ERR_invalid_presenter_class_name"));
        } else {
            hideError();
        }
    }//GEN-LAST:event_parentPresenterTextFieldCaretUpdate

    public boolean validateParentPresenter() {
        return parentPresenterTextField.getText().trim().matches("^[a-zA-Z0-9][a-zA-Z0-9_]*$")
                || parentPresenterTextField.getText().trim().isEmpty();
    }

    public String getParentPresenter() {
        return parentPresenterTextField.getText().trim();
    }

    private void showError(String error) {
        errorLabel.setIcon(errorIcon);
        errorLabel.setText(error);
    }

    private void hideError() {
        errorLabel.setIcon(null);
        errorLabel.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField parentPresenterTextField;
    // End of variables declaration//GEN-END:variables

	@Override
    public void insertUpdate(DocumentEvent e) {
        panel.fireChangeEvent();
    }

	@Override
    public void removeUpdate(DocumentEvent e) {
        panel.fireChangeEvent();
    }

	@Override
    public void changedUpdate(DocumentEvent e) {
        panel.fireChangeEvent();
    }
}
