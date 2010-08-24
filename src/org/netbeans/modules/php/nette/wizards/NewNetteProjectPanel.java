
/*
 * NewNetteProjectPanel.java
 *
 * Created on 23.8.2010, 21:39:50
 */

package org.netbeans.modules.php.nette.wizards;

import javax.swing.event.ChangeListener;
import org.netbeans.api.options.OptionsDisplayer;
import org.netbeans.modules.php.nette.options.NetteOptions;
import org.netbeans.modules.php.nette.validators.NetteEmptyPathValidator;
import org.netbeans.modules.php.nette.validators.NetteLoaderPathValidator;
import org.netbeans.modules.php.nette.validators.Validable;
import org.openide.util.ChangeSupport;

/**
 *
 * @author Ondřej Brejla
 */
public class NewNetteProjectPanel extends javax.swing.JPanel {

	private ChangeSupport changeSupport = new ChangeSupport(this);

    /** Creates new form NewNetteProjectPanel */
    public NewNetteProjectPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        copyNetteCheckbox = new javax.swing.JCheckBox();
        optionsLabel = new javax.swing.JLabel();

        copyNetteCheckbox.setText(org.openide.util.NbBundle.getMessage(NewNetteProjectPanel.class, "NewNetteProjectPanel.copyNetteCheckbox.text")); // NOI18N
        copyNetteCheckbox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                copyNetteCheckboxStateChanged(evt);
            }
        });

        optionsLabel.setForeground(java.awt.Color.blue);
        optionsLabel.setText(org.openide.util.NbBundle.getMessage(NewNetteProjectPanel.class, "NewNetteProjectPanel.optionsLabel.text")); // NOI18N
        optionsLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        optionsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                optionsLabelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(copyNetteCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(optionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(optionsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(copyNetteCheckbox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void copyNetteCheckboxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_copyNetteCheckboxStateChanged
		changeSupport.fireChange();
	}//GEN-LAST:event_copyNetteCheckboxStateChanged

	private void optionsLabelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_optionsLabelMouseReleased
		OptionsDisplayer.getDefault().open(NetteOptions.getInstance().getOptionsPath());
	}//GEN-LAST:event_optionsLabelMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox copyNetteCheckbox;
    private javax.swing.JLabel optionsLabel;
    // End of variables declaration//GEN-END:variables

	public void addChangeListener(ChangeListener cl) {
		changeSupport.addChangeListener(cl);
	}

	public void removeChangeListener(ChangeListener cl) {
		changeSupport.removeChangeListener(cl);
	}

	public String getErrorMessage() {
		if (copyNetteCheckbox.isSelected()) {
			Validable emptyPathValidator = new NetteEmptyPathValidator();

			if (emptyPathValidator.validate(NetteOptions.getInstance().getNettePath())) {
				return "Nette directory is not set. Use Options to set a valid Nette directory.";
			}

			Validable loaderPathValidator = new NetteLoaderPathValidator();

			if (!loaderPathValidator.validate(NetteOptions.getInstance().getNettePath())) {
				return "Nette files were not found in the specified folder. Use Options to set a valid Nette folder.";
			}
		}

		return null;
	}

	public boolean isCopyNetteCheckboxSelected() {
		return copyNetteCheckbox.isSelected();
	}

}
