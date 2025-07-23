package com.main.components;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import com.main.controller.actionButtonTable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EnumSet;

public class buttonTableEditor extends AbstractCellEditor implements TableCellEditor {

    private final JPanel panel;
    private final buttonCustom editButton;
    private final buttonCustom deleteButton;
    private final buttonCustom detailButton;
    private final buttonCustom approveButton;
    private final actionButtonTable actionListener;
    private final EnumSet<buttonType> buttonTypes;
    private int row;

    public buttonTableEditor(actionButtonTable actionListener2, EnumSet<buttonType> buttonTypes) {
        this.actionListener = actionListener2;
        this.buttonTypes = buttonTypes;

        panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false);

        appIcons iconApps = new appIcons();

        editButton = new buttonCustom("", 0, 0, 0, 0, 10);
        editButton.setPreferredSize(new Dimension(40, 40));
        editButton.setIcon(iconApps.getEditIconWhite(20, 20));

        deleteButton = new buttonCustom("", 0, 0, 0, 0, 10);
        deleteButton.setPreferredSize(new Dimension(40, 40));
        deleteButton.setIcon(iconApps.getDeleteIconWhite(20, 20));

        detailButton = new buttonCustom("", 0, 0, 0, 0, 10);
        detailButton.setPreferredSize(new Dimension(40, 40));
        detailButton.setIcon(iconApps.getDetailIconWhite(20, 20));

        approveButton = new buttonCustom("", 0, 0, 0, 0, 10);
        approveButton.setPreferredSize(new Dimension(40, 40));
        approveButton.setIcon(iconApps.getApproveIconWhite(20, 20));

        editButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.onEdit(row);
                fireEditingStopped();
            }
        });

        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.onDelete(row);
                fireEditingStopped();
            }
        });

        detailButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.onDetail(row);
                fireEditingStopped();
            }
        });

        approveButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionListener.onApprove(row);
                fireEditingStopped();
            }
        });

        JPanel container = new JPanel(new GridLayout(1, 3, 10, 0));
        container.setOpaque(false);

        if (buttonTypes.contains(buttonType.EDIT))
            container.add(editButton);
        if (buttonTypes.contains(buttonType.DELETE))
            container.add(deleteButton);
        if (buttonTypes.contains(buttonType.DETAIL))
            container.add(detailButton);
        if (buttonTypes.contains(buttonType.APPROVE))
            container.add(approveButton);

        panel.add(container);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        this.row = row;
        return panel;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
