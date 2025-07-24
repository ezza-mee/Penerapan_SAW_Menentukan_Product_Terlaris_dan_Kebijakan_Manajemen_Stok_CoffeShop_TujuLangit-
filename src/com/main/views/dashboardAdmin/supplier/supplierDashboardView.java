package com.main.views.dashboardAdmin.supplier;

import java.util.EnumSet;

import com.main.components.*;
import com.main.components.panelApps.contentPanel;
import com.main.controller.actionButtonTable;
import com.main.models.entity.dataSupplier;
import com.main.models.supplier.loadDataSupplier;
import com.main.routes.dashboardAdminView;
import com.main.routes.mainFrame;
import com.main.services.authDataSupplier;
import com.main.views.popUp.popUpConfrim;

public class supplierDashboardView extends contentPanel {

    private mainFrame parentApp;
    private dashboardAdminView parentView;
    private textLabel headerLabel;
    private panelRounded headerPanel, contentPanel;
    private linkLabel allSupplierLabel, pendingSupplierLabel, stockSupplierLabel, outStockSupplierLabel;
    private buttonCustom buttonAdd;
    private tableActionButton dataSupplierTable;
    private scrollTable scrollDataSupplier;
    private int quantityAllDataSupplier = loadDataSupplier.getAllQuantityDataSupplier();
    private int quantityAllPendingDataSupplier = loadDataSupplier.getAllQuantityPendingDataSupplier();
    private int quantityAllStockDataSupplier = loadDataSupplier.getAllQuantityStockDataSupplier();
    private int quantityAllOutStockDataSupplier = loadDataSupplier.getAllQuantityOutStockDataSupplier();
    private EnumSet<buttonType> buttonTypes = EnumSet.of(buttonType.EDIT,
            buttonType.DELETE, buttonType.DETAIL);

    private void setColor() {
        headerLabel.setForeground(color.BLACK);
        headerPanel.setBackground(color.WHITE);
        contentPanel.setBackground(color.WHITE);

    }

    private void setFont() {
        headerLabel.setFont(fontStyle.getFont(fontStyle.FontStyle.SEMIBOLD, 30f));

        allSupplierLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        pendingSupplierLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        stockSupplierLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));
        outStockSupplierLabel.setLinkLabelFont(fontStyle.getFont(fontStyle.FontStyle.BOLD, 14f));

    }

    public supplierDashboardView(mainFrame parentApp, dashboardAdminView parentView) {
        super();
        this.parentApp = parentApp;
        this.parentView = parentView;
        initContent();
    }

    @Override
    public void initContent() {
        setLayout();
        setColor();
        setFont();
        setAction();
        showAllSupplier();

        headerPanel.add(allSupplierLabel);
        headerPanel.add(pendingSupplierLabel);
        headerPanel.add(stockSupplierLabel);
        headerPanel.add(outStockSupplierLabel);
        headerPanel.add(buttonAdd);

        contentPanel.add(scrollDataSupplier);

        add(headerLabel);
        add(headerPanel);
        add(contentPanel);

        setVisible(true);
    }

    private void setLayout() {
        headerLabel = new textLabel("Data Supplier", 40, 0, 300, 80);
        headerPanel = new panelRounded(40, 80, 1050, 110, 10, 10);
        contentPanel = new panelRounded(40, 220, 1050, 410, 10, 10);

        allSupplierLabel = new linkLabel("ALL", 40, 40, 80, 30);
        allSupplierLabel.setQuantity(quantityAllDataSupplier);
        pendingSupplierLabel = new linkLabel("Pending", 155, 40, 120, 30);
        pendingSupplierLabel.setQuantity(quantityAllPendingDataSupplier);
        stockSupplierLabel = new linkLabel("In Stock", 310, 40, 120, 30);
        stockSupplierLabel.setQuantity(quantityAllStockDataSupplier);
        outStockSupplierLabel = new linkLabel("Out Stock", 470, 40, 120, 30);
        outStockSupplierLabel.setQuantity(quantityAllOutStockDataSupplier);

        buttonAdd = new buttonCustom("Add", 900, 35, 100, 40, 10);

    }

    private void setAction() {
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                parentView.showFormSupplier();
            }
        });

        allSupplierLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showAllSupplier();
            }
        });

        pendingSupplierLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showPendingSupplier();
            }
        });

        stockSupplierLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showStockSupplier();
            }
        });

        outStockSupplierLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                showOutStockSupplier();
            }
        });

    }

    private void resetLinkLabel() {
        allSupplierLabel.setForeground(color.DARKGREY);
        allSupplierLabel.setLabelInActive();

        pendingSupplierLabel.setForeground(color.DARKGREY);
        pendingSupplierLabel.setLabelInActive();

        stockSupplierLabel.setForeground(color.DARKGREY);
        stockSupplierLabel.setLabelInActive();

        outStockSupplierLabel.setForeground(color.DARKGREEN);
        outStockSupplierLabel.setLabelInActive();
    }

    private void showAllSupplier() {
        resetLinkLabel();
        allSupplierLabel.setForeground(color.DARKGREEN);
        allSupplierLabel.setLabelActive();
        loadAllSupplier();

    }

    private void showPendingSupplier() {
        resetLinkLabel();
        pendingSupplierLabel.setForeground(color.DARKGREEN);
        pendingSupplierLabel.setLabelActive();
        loadPendingSupplier();
    }

    private void showStockSupplier() {
        resetLinkLabel();
        stockSupplierLabel.setForeground(color.DARKGREEN);
        stockSupplierLabel.setLabelActive();
        loadStockSupplier();
    }

    private void showOutStockSupplier() {
        resetLinkLabel();
        outStockSupplierLabel.setForeground(color.DARKGREEN);
        outStockSupplierLabel.setLabelActive();
        loadOutStockSupplier();
    }

    private void loadAllSupplier() {
        actionButtonTable actionButton = new actionButtonTable() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));

                                dataSupplier selectedDataSupplier = loadDataSupplier.getDataById(idSupplier);

                                if (selectedDataSupplier != null) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.setDataSupplierToEdit(selectedDataSupplier);
                                    parentView.showFormSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Data Supplier not found!");
                                }
                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDelete(int row) {
                try {

                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));
                                int quantity = 0;
                                boolean isSuccess = authDataSupplier.deleteDataSupplier(idSupplier, quantity);

                                if (isSuccess) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showSuccessPopUp("Success Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Failed Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                }

                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDetail(int row) {
                // Not implemented
                System.out.println("Detail row: " + row);
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataSupplierTable = new tableActionButton(loadDataSupplier.getAllDataSupplier(), actionButton);

        int actionColumnIndex = 6;
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollDataSupplier = new scrollTable(dataSupplierTable, 0, 0, 1050, 410);

        contentPanel.removeAll();
        contentPanel.add(scrollDataSupplier);
        contentPanel.revalidate();
        contentPanel.repaint();

        setHeaderTableAllDataSupplier();

    }

    private void loadPendingSupplier() {
        actionButtonTable actionButton = new actionButtonTable() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));

                                dataSupplier selectedDataSupplier = loadDataSupplier.getDataById(idSupplier);

                                if (selectedDataSupplier != null) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.setDataSupplierToEdit(selectedDataSupplier);
                                    parentView.showFormSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Data Supplier not found!");
                                }
                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDelete(int row) {
                try {

                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));
                                int quantity = 0;
                                boolean isSuccess = authDataSupplier.deleteDataSupplier(idSupplier, quantity);

                                if (isSuccess) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showSuccessPopUp("Success Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Failed Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                }

                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDetail(int row) {
                // Not implemented
                System.out.println("Detail row: " + row);
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataSupplierTable = new tableActionButton(loadDataSupplier.getAllPendingDataSupplier(), actionButton);

        int actionColumnIndex = 6;
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollDataSupplier = new scrollTable(dataSupplierTable, 0, 0, 1050, 410);

        contentPanel.removeAll();
        contentPanel.add(scrollDataSupplier);
        contentPanel.revalidate();
        contentPanel.repaint();

        setHeaderTableAllDataSupplier();
    }

    private void loadStockSupplier() {
        actionButtonTable actionButton = new actionButtonTable() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));

                                dataSupplier selectedDataSupplier = loadDataSupplier.getDataById(idSupplier);

                                if (selectedDataSupplier != null) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.setDataSupplierToEdit(selectedDataSupplier);
                                    parentView.showFormSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Data Supplier not found!");
                                }
                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDelete(int row) {
                try {

                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));
                                int quantity = 0;
                                boolean isSuccess = authDataSupplier.deleteDataSupplier(idSupplier, quantity);

                                if (isSuccess) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showSuccessPopUp("Success Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Failed Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                }

                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDetail(int row) {
                // Not implemented
                System.out.println("Detail row: " + row);
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataSupplierTable = new tableActionButton(loadDataSupplier.getAllStockDataSupplier(), actionButton);

        int actionColumnIndex = 6;
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollDataSupplier = new scrollTable(dataSupplierTable, 0, 0, 1050, 410);

        contentPanel.removeAll();
        contentPanel.add(scrollDataSupplier);
        contentPanel.revalidate();
        contentPanel.repaint();

        setHeaderTableAllDataSupplier();

    }

    private void loadOutStockSupplier() {
        actionButtonTable actionButton = new actionButtonTable() {
            @Override
            public void onEdit(int row) {
                try {
                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));

                                dataSupplier selectedDataSupplier = loadDataSupplier.getDataById(idSupplier);

                                if (selectedDataSupplier != null) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.setDataSupplierToEdit(selectedDataSupplier);
                                    parentView.showFormSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Data Supplier not found!");
                                }
                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDelete(int row) {
                try {

                    popUpConfrim messagePopUp = parentView.showConfrimPopUp("do you want to delete product data?");

                    messagePopUp.getButtonConfrim().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            int selectedRow = dataSupplierTable.getSelectedRow();
                            if (selectedRow != -1) {
                                String stringIdSupplier = dataSupplierTable.getValueAt(selectedRow, 0).toString();
                                int idSupplier = Integer.parseInt(stringIdSupplier.replaceAll("[^0-9]", ""));
                                int quantity = 0;
                                boolean isSuccess = authDataSupplier.deleteDataSupplier(idSupplier, quantity);

                                if (isSuccess) {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showSuccessPopUp("Success Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                } else {
                                    parentApp.hideGlassNotificationPanel();
                                    parentView.showFailedPopUp("Failed Delete Data Delete");
                                    parentView.showDashboardSupplier();
                                }

                            }
                        }
                    });

                    messagePopUp.getButtonCancel().addActionListener(new java.awt.event.ActionListener() {
                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent ae) {
                            parentApp.hideGlassNotificationPanel();
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onDetail(int row) {
                // Not implemented
                System.out.println("Detail row: " + row);
            }

            @Override
            public void onApprove(int row) {
                // Not implemented
                System.out.println("Approve row: " + row);
            }
        };

        dataSupplierTable = new tableActionButton(loadDataSupplier.getAllOutStockDataSupplier(), actionButton);

        int actionColumnIndex = 6;
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellRenderer(new buttonTableRenderer(buttonTypes));
        dataSupplierTable.getColumnModel().getColumn(actionColumnIndex)
                .setCellEditor(new buttonTableEditor(actionButton, buttonTypes));

        scrollDataSupplier = new scrollTable(dataSupplierTable, 0, 0, 1050, 410);

        contentPanel.removeAll();
        contentPanel.add(scrollDataSupplier);
        contentPanel.revalidate();
        contentPanel.repaint();

        setHeaderTableAllDataSupplier();

    }

    private void setHeaderTableAllDataSupplier() {
        dataSupplierTable.getColumnModel().getColumn(0).setMinWidth(80);
        dataSupplierTable.getColumnModel().getColumn(0).setMaxWidth(80);
        dataSupplierTable.getColumnModel().getColumn(0).setWidth(80);

        dataSupplierTable.getColumnModel().getColumn(4).setMinWidth(90);
        dataSupplierTable.getColumnModel().getColumn(4).setMaxWidth(90);
        dataSupplierTable.getColumnModel().getColumn(4).setWidth(90);
    }

}
