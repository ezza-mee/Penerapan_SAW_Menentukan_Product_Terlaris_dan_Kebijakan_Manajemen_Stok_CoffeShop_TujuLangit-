package com.main.components;

import javax.swing.*;
import javax.swing.table.TableCellEditor;

import com.main.controller.tableActionButton;
import java.awt.*;
import java.awt.event.ActionEvent;

public class buttonTableEditor extends AbstractCellEditor implements TableCellEditor {

    private final JPanel panel;
    private final buttonCustom editButton;
    private final buttonCustom deleteButton;
    private final buttonCustom detailButton;
    private final tableActionButton actionListener;
    private int row;

    public buttonTableEditor(tableActionButton actionListener) {
        this.actionListener = actionListener;

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

        editButton.addActionListener((ActionEvent e) -> {
            actionListener.onEdit(row);
            fireEditingStopped();
        });

        deleteButton.addActionListener((ActionEvent e) -> {
            actionListener.onDelete(row);
            fireEditingStopped();
        });

        detailButton.addActionListener((ActionEvent e) -> {
            actionListener.onDetail(row);
            fireEditingStopped();
        });

        JPanel container = new JPanel(new GridLayout(1, 2, 10, 0));
        container.setOpaque(false);
        container.add(editButton);
        container.add(deleteButton);
        container.add(detailButton);

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
