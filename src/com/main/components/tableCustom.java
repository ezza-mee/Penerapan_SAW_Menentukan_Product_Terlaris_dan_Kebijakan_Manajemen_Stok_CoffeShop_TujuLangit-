package com.main.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.EnumSet;

import com.main.controller.tableActionButton;

public class tableCustom extends JTable {

    public tableCustom(TableModel model, tableActionButton actionListener) {
        super(model);
        setFont(fontStyle.getFont(fontStyle.FontStyle.REGULAR, 14f));
        setRowHeight(60);
        setShowGrid(false);
        setIntercellSpacing(new Dimension(0, 0));
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setSelectionBackground(color.LIGHTGREEN);
        setSelectionForeground(color.BLACK);
        setOpaque(true);

        JTableHeader header = getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                JLabel label = new JLabel(value.toString(), SwingConstants.CENTER);
                label.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 14f));
                label.setForeground(Color.BLACK);
                label.setBackground(color.LIGHTGREY);
                label.setOpaque(true);
                label.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, color.DARKGREY));
                label.setPreferredSize(new Dimension(0, 40));
                return label;
            }
        });

        TableCellRenderer stripedRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    c.setBackground((row % 2 == 0) ? color.WHITE : color.LIGHTGREY);
                    c.setForeground(color.BLACK);
                }

                c.setFont(fontStyle.getFont(fontStyle.FontStyle.REGULAR, 14f));
                ((JLabel) c).setHorizontalAlignment(SwingConstants.CENTER);
                return c;
            }
        };

        int actionColumnIndex = getColumnCount() - 1;

        for (int i = 0; i < getColumnCount(); i++) {
            if (i != actionColumnIndex) {
                getColumnModel().getColumn(i).setCellRenderer(stripedRenderer);
            }
        }

        EnumSet<buttonType> buttons = EnumSet.of(buttonType.EDIT, buttonType.DELETE, buttonType.DETAIL,
                buttonType.APPROVE);

        getColumnModel().getColumn(actionColumnIndex).setCellRenderer(new buttonTableRenderer(buttons));
        getColumnModel().getColumn(actionColumnIndex).setCellEditor(new buttonTableEditor(actionListener, buttons));

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent e) {
                int row = rowAtPoint(e.getPoint());
                int column = columnAtPoint(e.getPoint());
                if (isCellEditable(row, column)) {
                    editCellAt(row, column);
                    Component editor = getEditorComponent();
                    if (editor != null) {
                        editor.requestFocus();
                    }
                }
            }
        });
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == getColumnCount() - 1;
    }
}
