package com.main.components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class tableNoActionButton extends JTable {

    public tableNoActionButton(TableModel model) {
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

        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(stripedRenderer);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public void applyCustomStyle() {
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

        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(stripedRenderer);
        }
    }
    
}
