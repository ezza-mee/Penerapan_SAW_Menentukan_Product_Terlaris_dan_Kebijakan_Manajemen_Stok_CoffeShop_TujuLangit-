package com.main.components;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class buttonTableRenderer extends JPanel implements TableCellRenderer {

    private final buttonCustom editButton;
    private final buttonCustom deleteButton;
    private final buttonCustom detailButton;

    private final Color evenColor = color.LIGHTGREY;
    private final Color oddColor = color.WHITE;

    public buttonTableRenderer() {
        setLayout(new GridBagLayout());
        setOpaque(true);

        appIcons iconApps = new appIcons();
        editButton = new buttonCustom("", 0, 0, 0, 0, 10);
        editButton.setPreferredSize(new Dimension(40, 40));
        editButton.setIcon(iconApps.getEditIconWhite(20, 20));
        editButton.setEnabled(false); 

        deleteButton = new buttonCustom("", 0, 0, 0, 0, 10);
        deleteButton.setPreferredSize(new Dimension(40, 40));
        deleteButton.setIcon(iconApps.getDeleteIconWhite(20, 20));
        deleteButton.setEnabled(false);

        detailButton = new buttonCustom("", 0, 0, 0, 0, 10);
        detailButton.setPreferredSize(new Dimension(40, 40));
        detailButton.setIcon(iconApps.getDetailIconWhite(20, 20));
        detailButton.setEnabled(false);

        JPanel container = new JPanel(new GridLayout(1, 2, 10, 0));
        container.setOpaque(false);
        container.add(editButton);
        container.add(deleteButton);
        container.add(detailButton);

        add(container);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        setBackground(isSelected ? table.getSelectionBackground() : (row % 2 == 0 ? oddColor : evenColor));

        return this;
    }
}
