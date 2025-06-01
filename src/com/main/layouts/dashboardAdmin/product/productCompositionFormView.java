package com.main.layouts.dashboardAdmin.product;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JScrollBar;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import com.main.components.panelApps.contentPanel;
import com.main.models.dataProduct.listCompositionData;
import com.main.models.dataSupplier.getterDataSupplier;
import com.main.services.authDataProduct;
import com.main.services.authDataSupplier;
import com.main.views.dashboardAdminView;

import com.main.components.*;

public class productCompositionFormView extends contentPanel {

    private dashboardAdminView parentView;

    private panelRounded contentPanel, listIngredientPanel, parentListIngredientPanel;

    private textLabel headerLabel, nameIngredientLabel, quantityIngredientLabel, unitIngredientLabel,
            listIngredientLabel;

    private textLabel ingredientEmptyLabel, quantityEmptyLabel, unitEmptyLabel;

    private textField quantityIngredientField;

    private comboBox<String> unitIngredientField;
    private comboBox<getterDataSupplier> ingredientField;

    private buttonCustom buttonBack, buttonReset, buttonAdd, buttonSave;

    private scrollPane scrollPane;

    private appIcons appIcons = new appIcons();

    private imageIcon iconDelete = appIcons.getDeleteIconWhite(20, 20);
    private imageIcon iconEdit = appIcons.getEditIconWhite(20, 20);

    private authDataProduct authData = new authDataProduct();

    private List<listCompositionData> listComposition = new ArrayList<>();

    private String imageProduct, nameProduct, category, description;
    private int idProduct, price;

    private boolean isUpdateMode = false;
    private boolean isEditMode = false;
    private listCompositionData currentEditData = null;

    public productCompositionFormView(dashboardAdminView parentView, int idProduct, String imageProduct,
            String nameProduct, int price,
            String category, String description) {
        super();
        this.idProduct = idProduct;
        this.parentView = parentView;
        this.imageProduct = imageProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.category = category;
        this.description = description;
        initContent();
    }

    @Override
    public void initContent() {
        setPosition();
        setColor();
        setFont();
        handleButton();

        contentPanel.add(nameIngredientLabel);
        contentPanel.add(quantityIngredientLabel);
        contentPanel.add(unitIngredientLabel);

        contentPanel.add(ingredientField);
        contentPanel.add(quantityIngredientField);
        contentPanel.add(unitIngredientField);

        contentPanel.add(buttonBack);
        contentPanel.add(buttonReset);
        contentPanel.add(buttonAdd);

        listIngredientPanel.add(listIngredientLabel);
        listIngredientPanel.add(scrollPane);
        listIngredientPanel.add(buttonSave);

        add(headerLabel);
        add(contentPanel);
        add(listIngredientPanel);

        setVisible(true);
    }

    private void setPosition() {
        contentPanel = new panelRounded(40, 80, 600, 550, 10, 10);
        listIngredientPanel = new panelRounded(685, 80, 400, 550, 10, 10);
        parentListIngredientPanel = new panelRounded(0, 80, 400, 360, 0, 0);
        parentListIngredientPanel.setLayout(new BoxLayout(parentListIngredientPanel, BoxLayout.Y_AXIS));

        scrollPane = new scrollPane(parentListIngredientPanel, 0, 0, getWidth(), getHeight());
        scrollPane.setBounds(0, 80, 400, 360);

        headerLabel = new textLabel("Input Product Ingredient Composition", 40, 0, 600, 80);
        listIngredientLabel = new textLabel("List Ingredient", 40, 30, 300, 80);
        nameIngredientLabel = new textLabel("Name Ingredient", 100, 30, 300, 80);
        quantityIngredientLabel = new textLabel("quantity Ingredient", 100, 130, 300, 80);
        unitIngredientLabel = new textLabel("unit Ingredient", 100, 230, 300, 80);

        ingredientEmptyLabel = new textLabel("Ingredient is Empty", 100, 85, 300, 80);
        quantityEmptyLabel = new textLabel("quantity is Empty", 100, 185, 300, 80);
        unitEmptyLabel = new textLabel("Ingredient is Empty", 100, 290, 300, 80);

        List<getterDataSupplier> supplierList = authDataSupplier.loadDataSupplier();

        if (supplierList.isEmpty()) {
            supplierList.add(new getterDataSupplier(0, "Tidak ada data supplier", 0, "", ""));
        }

        ingredientField = new comboBox<>(
                supplierList.toArray(new getterDataSupplier[0]),
                100, 80, 400, 30, 10);

        String ingredientPlaceholder = "Select Ingredient";

        ingredientField.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                if (index == -1 && value == null) {
                    setText(ingredientPlaceholder);
                    setForeground(color.DARKGREY);
                } else if (value instanceof getterDataSupplier supplier) {
                    setText(supplier.getNameSupplier());
                    setForeground(isSelected ? list.getSelectionForeground() : list.getForeground());
                    setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
                } else {
                    setText(value != null ? value.toString() : "");
                }
                return this;
            }
        });

        quantityIngredientField = new textField(100, 185, 400, 10);

        String[] unitItems = { null, "Gram", "Kilogram", "Ons", "Mililiter", "Liter",
                "Sendok Makan", "Sendok Teh", "Gelas", "Botol",
                "Kaleng", "Buah", "Kemasan", "Sachet", "Lembaran",
                "Batangan", "Biji-bijian", "Cangkir", "Irisan", "Kotak", "Kemasan", "Tetesan" };
        unitIngredientField = new comboBox<>(unitItems, 100, 290, 400, 30, 10);
        unitIngredientField.setPlaceholder("Select Unit Ingredient");

        buttonSave = new buttonCustom("Save", 25, 470, 350, 40, 10);
        buttonBack = new buttonCustom("Back", 50, 470, 100, 40, 10);
        buttonReset = new buttonCustom("Reset", 310, 470, 100, 40, 10);
        buttonAdd = new buttonCustom("Add", 440, 470, 100, 40, 10);
    }

    private void setColor() {
        contentPanel.setBackground(color.WHITE);
        listIngredientPanel.setBackground(color.WHITE);
        parentListIngredientPanel.setBackground(color.WHITE);
        scrollPane.setBackground(color.WHITE);

        headerLabel.setForeground(color.BLACK);

        ingredientEmptyLabel.setForeground(color.RED);
        quantityEmptyLabel.setForeground(color.RED);
        unitEmptyLabel.setForeground(color.RED);
    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 30f));

        listIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        nameIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        quantityIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));
        unitIngredientLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 18f));

        ingredientEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        quantityEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
        unitEmptyLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 10f));
    }

    public void setFormCompositionProduct(List<listCompositionData> compositionList) {
        isUpdateMode = true;

        System.out.println("setFormCompositionProduct called with compositionList size: "
                + (compositionList != null ? compositionList.size() : "null"));

        parentListIngredientPanel.removeAll();
        listComposition.clear();

        if (compositionList != null) {
            for (listCompositionData data : compositionList) {
                System.out.println("Composition item - Supplier: " + data.getNameSupplier() + ", Quantity: "
                        + data.getQuantity() + ", Unit: " + data.getUnit());

                int idSupplier = data.getIdSupplier();

                listComposition.add(data);

                panelRounded cardPanel = new panelRounded();
                Dimension cardSize = new Dimension(380, 80);
                cardPanel.setPreferredSize(cardSize);
                cardPanel.setMaximumSize(cardSize);
                cardPanel.setMinimumSize(cardSize);
                cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                cardPanel.setBackground(color.WHITE);
                cardPanel.setLayout(null);

                textLabel nameLabel = new textLabel(data.getNameSupplier(), 50, 30, 200, 30);
                textLabel quantityAndUnitLabel = new textLabel(data.getQuantity() + " " + data.getUnit(), 50, 50, 200,
                        20);
                nameLabel.setForeground(color.BLACK);
                quantityAndUnitLabel.setForeground(color.BLACK);
                nameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));
                quantityAndUnitLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 13f));

                cardPanel.add(nameLabel);
                cardPanel.add(quantityAndUnitLabel);

                buttonCustom buttonDelete = new buttonCustom("", 330, 35, 40, 40, 10);
                buttonDelete.setIcon(iconDelete);
                cardPanel.add(buttonDelete);

                buttonCustom buttonEdit = new buttonCustom("", 280, 35, 40, 40, 10);
                buttonEdit.setIcon(iconEdit);
                cardPanel.add(buttonEdit);

                Component padding = Box.createRigidArea(new Dimension(0, 10));

                buttonEdit.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        for (int i = 0; i < ingredientField.getItemCount(); i++) {
                            getterDataSupplier supplierItem = (getterDataSupplier) ingredientField.getItemAt(i);
                            if (supplierItem.getIdSupplier() == data.getIdSupplier()) {
                                ingredientField.setSelectedIndex(i);
                                break;
                            }
                        }
                        quantityIngredientField.setText(String.valueOf(data.getQuantity()));
                        unitIngredientField.setSelectedItem(data.getUnit());

                        isEditMode = true;
                        currentEditData = data;

                        boolean exists = authDataProduct.checkCompositionExists(idSupplier,
                                idProduct);

                        if (exists) {
                            boolean deleted = authDataProduct.deleteDataCompositionProduct(idSupplier, idProduct);
                            System.out.println("Deleted from DB: " + deleted);
                        }

                        buttonAdd.setText(isEditMode ? "Save" : "Add");

                        parentListIngredientPanel.remove(cardPanel);
                        parentListIngredientPanel.remove(padding);
                        parentListIngredientPanel.revalidate();
                        parentListIngredientPanel.repaint();
                    }
                });

                buttonDelete.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        boolean exists = authDataProduct.checkCompositionExists(idSupplier,
                                idProduct);

                        if (exists) {
                            boolean deleted = authDataProduct.deleteDataCompositionProduct(idSupplier, idProduct);
                            System.out.println("Deleted from DB: " + deleted);
                        }

                        parentListIngredientPanel.remove(cardPanel);
                        parentListIngredientPanel.remove(padding);
                        parentListIngredientPanel.revalidate();
                        parentListIngredientPanel.repaint();
                        listComposition.remove(data);
                    }
                });

                parentListIngredientPanel.add(padding);
                parentListIngredientPanel.add(cardPanel, parentListIngredientPanel.getComponentCount());
                cardPanel.add(Box.createVerticalGlue());
            }
        } else {
            System.out.println("compositionList is null.");
        }

        buttonAdd.setText(isEditMode ? "Save" : "Add");

        parentListIngredientPanel.revalidate();
        parentListIngredientPanel.repaint();
    }

    private void handleButton() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                try {
                    // Ambil input
                    getterDataSupplier selectedSupplier = (getterDataSupplier) ingredientField.getSelectedItem();
                    String stringQuantity = quantityIngredientField.getText().trim();
                    String unit = (String) unitIngredientField.getSelectedItem();

                    int idSupplier = selectedSupplier.getIdSupplier();
                    String nameSupplier = selectedSupplier.getNameSupplier();
                    int quantity = Integer.parseInt(stringQuantity);

                    System.out.println("=== [DEBUG] Adding new composition ===");
                    System.out.println("idSupplier: " + idSupplier);
                    System.out.println("Supplier Name: " + nameSupplier);
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Unit: " + unit);
                    System.out.println("--------------------------------------");

                    // Validasi input
                    String validation = authData.validateCompositionProductInput(nameSupplier, stringQuantity, unit);
                    if (!validation.equals("VALID")) {
                        showValidationMessages(validation);
                        return;
                    }

                    // Reset pesan error
                    clearValidationMessages();

                    // Mode Edit atau Tambah Baru
                    listCompositionData data;

                    if (isEditMode) {
                        currentEditData.setQuantity(quantity);
                        currentEditData.setUnit(unit);
                        data = currentEditData;

                        listComposition.add(data);
                        isEditMode = false;
                        currentEditData = null;
                    } else {
                        boolean isDuplicate = listComposition.stream()
                                .anyMatch(d -> d.getIdSupplier() == idSupplier);
                        if (isDuplicate) {
                            parentView.showFailedPopUp("Supplier sudah ditambahkan untuk produk ini.");
                            return;
                        }

                        data = new listCompositionData(idSupplier, idProduct, nameProduct,
                                nameSupplier, quantity, unit);
                        listComposition.add(data);
                    }

                    // Tampilkan data di panel
                    addCompositionCardToPanel(data);

                    // Scroll otomatis ke bawah
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
                        verticalBar.setValue(verticalBar.getMaximum());
                    });

                    // Reset input
                    ingredientField.setSelectedIndex(0);
                    quantityIngredientField.setText("");
                    unitIngredientField.setSelectedIndex(0);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void showValidationMessages(String validation) {
                if (validation.equals("ALL_FIELDS_EMPTY")) {
                    contentPanel.add(ingredientEmptyLabel);
                    contentPanel.add(quantityEmptyLabel);
                    contentPanel.add(unitEmptyLabel);
                } else if (validation.equals("NAME_SUPPLIER_EMPTY")) {
                    contentPanel.add(ingredientEmptyLabel);
                } else if (validation.equals("QUANTITY_EMPTY")) {
                    contentPanel.add(quantityEmptyLabel);
                } else if (validation.equals("UNIT_EMPTY")) {
                    contentPanel.add(unitEmptyLabel);
                }
                contentPanel.revalidate();
                contentPanel.repaint();
            }

            private void clearValidationMessages() {
                contentPanel.remove(ingredientEmptyLabel);
                contentPanel.remove(quantityEmptyLabel);
                contentPanel.remove(unitEmptyLabel);
            }

            private void addCompositionCardToPanel(listCompositionData data) {
                panelRounded cardPanel = new panelRounded();
                Dimension cardSize = new Dimension(380, 80);
                cardPanel.setPreferredSize(cardSize);
                cardPanel.setMaximumSize(cardSize);
                cardPanel.setMinimumSize(cardSize);
                cardPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                cardPanel.setBackground(color.WHITE);
                cardPanel.setLayout(null);

                textLabel nameLabel = new textLabel(data.getNameSupplier(), 50, 30, 200, 30);
                textLabel quantityAndUnitLabel = new textLabel(data.getQuantity() + " " + data.getUnit(), 50, 50, 200,
                        20);
                nameLabel.setForeground(color.BLACK);
                quantityAndUnitLabel.setForeground(color.BLACK);
                nameLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 15f));
                quantityAndUnitLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 13f));

                cardPanel.add(nameLabel);
                cardPanel.add(quantityAndUnitLabel);

                buttonCustom buttonEdit = new buttonCustom("", 280, 35, 40, 40, 10);
                buttonEdit.setIcon(iconEdit);
                cardPanel.add(buttonEdit);

                buttonCustom buttonDelete = new buttonCustom("", 330, 35, 40, 40, 10);
                buttonDelete.setIcon(iconDelete);
                cardPanel.add(buttonDelete);

                Component padding = Box.createRigidArea(new Dimension(0, 10));

                // Event Edit
                buttonEdit.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        for (int i = 0; i < ingredientField.getItemCount(); i++) {
                            getterDataSupplier supplierItem = (getterDataSupplier) ingredientField.getItemAt(i);
                            if (supplierItem.getIdSupplier() == data.getIdSupplier()) {
                                ingredientField.setSelectedIndex(i);
                                break;
                            }
                        }
                        quantityIngredientField.setText(String.valueOf(data.getQuantity()));
                        unitIngredientField.setSelectedItem(data.getUnit());

                        isEditMode = true;
                        currentEditData = data;

                        parentListIngredientPanel.remove(cardPanel);
                        parentListIngredientPanel.remove(padding);
                        parentListIngredientPanel.revalidate();
                        parentListIngredientPanel.repaint();
                        buttonAdd.setText(isEditMode ? "Save" : "Add");
                    }
                });

                // Event Delete
                buttonDelete.addActionListener(new java.awt.event.ActionListener() {
                    @Override
                    public void actionPerformed(java.awt.event.ActionEvent ae) {
                        parentListIngredientPanel.remove(cardPanel);
                        parentListIngredientPanel.remove(padding);
                        parentListIngredientPanel.revalidate();
                        parentListIngredientPanel.repaint();

                        listComposition.remove(data);
                    }
                });

                parentListIngredientPanel.add(padding);
                parentListIngredientPanel.add(cardPanel, parentListIngredientPanel.getComponentCount());
                cardPanel.add(Box.createVerticalGlue());

                buttonAdd.setText(isEditMode ? "Save" : "Add");

                parentListIngredientPanel.revalidate();
                parentListIngredientPanel.repaint();
            }
        });

        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentView.showFormProduct();
            }
        });

        buttonSave.addActionListener(e -> {
            try {
                if (listComposition.isEmpty()) {
                    parentView.showFailedPopUp("Silakan tambahkan komposisi terlebih dahulu");
                    return;
                }

                listCompositionData dataComp = listComposition.get(0);
                int idSupplier = dataComp.idSupplier;
                int quantity = dataComp.quantity;
                String unit = dataComp.unit;

                if (quantity <= 0 || unit == null || unit.isEmpty()) {
                    parentView.showFailedPopUp("Komposisi pertama harus memiliki quantity dan unit yang valid");
                    return;
                }

                boolean success;
                if (isUpdateMode) {
                    System.out.println("IdProduct update : " + idProduct);
                    // Update produk dan komposisinya
                    success = authDataProduct.updateDataProductWithComposition(
                            idSupplier,
                            idProduct,
                            imageProduct,
                            nameProduct,
                            price,
                            category,
                            description,
                            listComposition);
                } else {
                    System.out.println("IdProduct insert : " + idProduct);
                    // Insert produk dan komposisinya
                    success = authDataProduct.insertDataProductWithComposition(
                            imageProduct,
                            nameProduct,
                            price,
                            category,
                            description,
                            listComposition);
                }

                if (success) {
                    parentView.showSuccessPopUp("Produk berhasil disimpan");
                    parentView.showDashboardProduct();
                } else {
                    parentView.showFailedPopUp("Gagal menyimpan produk");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
                parentView.showFailedPopUp("Terjadi kesalahan saat menyimpan produk");
            }
        });

    }
}
