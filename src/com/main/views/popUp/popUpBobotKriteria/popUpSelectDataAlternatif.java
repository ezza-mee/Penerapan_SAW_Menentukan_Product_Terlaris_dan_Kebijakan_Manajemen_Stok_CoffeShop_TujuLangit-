package com.main.views.popUp.popUpBobotKriteria;

import com.main.components.panelApps.popUpPanel;
import com.main.components.*;

public class popUpSelectDataAlternatif extends popUpPanel {

    private void setLayout() {
        headerLabel = new textLabel("Select Data Alternatif", 40, 40, 300, 40);

        String[] alternatifItems = { null, "Data Product", "Data Transaction", "Data Table", "Data Supplier" };
        dataAlternatifField = new comboBox<>(alternatifItems, 40, 80, 300, 30, 10);
        dataAlternatifField.setPlaceholder("Select Data Alternatif");

        tableDataAlternatif = new tableNoActionButton(null);
        scrollTable = new scrollTable(tableDataAlternatif, 40, 140, 1050, 300);

        buttonBack = new buttonCustom("Back", 40, 490, 100, 40, 10);
        buttonSave = new buttonCustom("Save", 1040, 490, 100, 40, 10);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 20f));

    }

    private void setColor() {
        headerLabel.setForeground(color.DARKGREEN);

    }

    public popUpSelectDataAlternatif() {
        super();

        setSize(1200, 600);
        initComponent();
    }

    private void initComponent() {
        setLayout();
        setFont();
        setColor();
        setAction();

        add(headerLabel);
        add(dataAlternatifField);
        add(scrollTable);
        add(buttonBack);
        add(buttonSave);

        setVisible(true);
    }

    private void setAction() {

    }

    private textLabel headerLabel;
    private comboBox<String> dataAlternatifField;
    private tableNoActionButton tableDataAlternatif;
    private scrollTable scrollTable;
    private buttonCustom buttonSave, buttonBack;

}
