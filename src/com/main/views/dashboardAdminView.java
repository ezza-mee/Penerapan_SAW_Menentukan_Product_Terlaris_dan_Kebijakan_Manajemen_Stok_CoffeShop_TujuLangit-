package com.main.views;

import java.util.List;

import com.main.components.color;
import com.main.components.panelApps.containerPanel;
import com.main.components.panelApps.contentPanel;
import com.main.layouts.dashboardAdmin.homeDashboardView;
import com.main.layouts.dashboardAdmin.parentDashboardView;
import com.main.layouts.dashboardAdmin.Report.reportDashboardView;
import com.main.layouts.dashboardAdmin.product.productCompositionFormView;
import com.main.layouts.dashboardAdmin.product.productDashboardView;
import com.main.layouts.dashboardAdmin.product.productFormView;
import com.main.layouts.dashboardAdmin.staff.staffDashboardView;
import com.main.layouts.dashboardAdmin.staff.staffFormView;
import com.main.layouts.dashboardAdmin.supplier.supplierDashboardView;
import com.main.layouts.dashboardAdmin.supplier.supplierFormView;
import com.main.layouts.dashboardAdmin.table.tableDashboardView;
import com.main.layouts.dashboardAdmin.table.tableFormView;
import com.main.layouts.dashboardAdmin.transaction.transactionDashboardView;
import com.main.layouts.popUp.popUpConfrim;
import com.main.layouts.popUp.popUpFailed;
import com.main.layouts.popUp.popUpLogout;
import com.main.layouts.popUp.popUpSuccess;
import com.main.layouts.popUp.popUpStaff.popUpDetailDataStaff;
import com.main.layouts.popUp.popUpStaff.popUpFormInputAccountStaff;
import com.main.models.dataProduct.getterDataProduct;
import com.main.models.dataProduct.listCompositionData;
import com.main.models.dataStaff.getterAccountStaff;
import com.main.models.dataStaff.getterDataStaff;
import com.main.models.dataSupplier.getterDataSupplier;
import com.main.models.dataTable.getterDataTable;
import com.main.services.authDataStaff;

public class dashboardAdminView extends containerPanel {

    private parentDashboardView parentDashboard;
    private mainFrame parentApp;
    private contentPanel lastContent;

    private getterDataStaff dataStaffToEdit = null;
    private getterAccountStaff accountData = null;
    private getterDataSupplier dataSupplierToEdit = null;
    private getterDataProduct dataProductToEdit = null;
    private getterDataTable dataTableToEdit = null;

    private boolean compositionModified = false;

    public dashboardAdminView(mainFrame parentApp) {
        super();
        this.parentApp = parentApp;
        setSize(1366, 768);
        setBackground(color.GREEN);
        parentDashboard = new parentDashboardView(this);
        add(parentDashboard);

        // parentDashboard.getNavbar().showHomeView();
        parentDashboard.getNavbar().showTableView();
    }

    public void showDashboardHome() {
        homeDashboardView dashboardHome = new homeDashboardView();
        lastContent = dashboardHome;
        parentDashboard.setContent(dashboardHome);
    }

    public void showDashboardProduct() {
        productDashboardView dashboardProduct = new productDashboardView(parentApp, this);
        dashboardProduct.loadAllProductCards();
        lastContent = dashboardProduct;
        parentDashboard.setContent(dashboardProduct);
    }

    public void showFormProduct() {
        productFormView formProduct = new productFormView(parentApp, this);

        if (dataProductToEdit != null) {
            formProduct.setFormProduct(dataProductToEdit);
            dataProductToEdit = null;
        }

        lastContent = formProduct;
        parentDashboard.setContent(formProduct);
    }

    public void showFormCompositionProduct(int idProduct, String imageProduct, String nameProduct,
            int price, String category, String description, List<listCompositionData> compositionList) {
        productCompositionFormView formCompositionProduct = new productCompositionFormView(this, idProduct,
                imageProduct, nameProduct, price, category, description);

        if (compositionList != null) {
            formCompositionProduct.setFormCompositionProduct(compositionList);
        }

        lastContent = formCompositionProduct;
        parentDashboard.setContent(formCompositionProduct);
    }

    public void showDashboardSupplier() {
        supplierDashboardView dashboardSupplier = new supplierDashboardView(parentApp, this);
        lastContent = dashboardSupplier;
        parentDashboard.setContent(dashboardSupplier);
    }

    public void showFormSupplier() {
        supplierFormView formSupplier = new supplierFormView(this);

        if (dataSupplierToEdit != null) {
            formSupplier.setFormSupplier(dataSupplierToEdit);
            dataSupplierToEdit = null;
        }

        lastContent = formSupplier;
        parentDashboard.setContent(formSupplier);
    }

    public void showDashboardTable() {
        tableDashboardView dashboardTable = new tableDashboardView(parentApp, this);
        lastContent = dashboardTable;
        parentDashboard.setContent(dashboardTable);
    }

    public void showFormTable() {
        tableFormView formTable = new tableFormView(this);

        if (dataTableToEdit != null) {
            formTable.setFormTable(dataTableToEdit);
            dataTableToEdit = null;
        }

        lastContent = formTable;
        parentDashboard.setContent(formTable);
    }

    public void showDashboardTransaction() {
        transactionDashboardView dashboardTransaction = new transactionDashboardView();
        lastContent = dashboardTransaction;
        parentDashboard.setContent(dashboardTransaction);
    }

    public void showDashboardStaff() {
        staffDashboardView dashboardStaff = new staffDashboardView(parentApp, this);
        lastContent = dashboardStaff;
        parentDashboard.setContent(dashboardStaff);
    }

    public void showFormStaff() {
        staffFormView formStaff = new staffFormView(this);

        if (dataStaffToEdit != null) {
            formStaff.setFormData(dataStaffToEdit);
            dataStaffToEdit = null;
        }

        lastContent = formStaff;
        parentDashboard.setContent(formStaff);
    }

    public void showFormAccountStaff(
            String date,
            String name,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address,
            String status, boolean isEdit, int idStaff) {

        popUpFormInputAccountStaff popupForm = new popUpFormInputAccountStaff(
                parentApp, this, date, name, email, phoneNumber, gender, jobdesk, address, status, isEdit, idStaff);

        this.accountData = authDataStaff.getDataAccountById(idStaff);
        this.dataStaffToEdit = new getterDataStaff(idStaff, date, name, email, phoneNumber, gender, jobdesk, address, status);

        System.out.println("ID Staff: " + idStaff);

        if (this.accountData != null) {
            popupForm.setFormAccountData(this.accountData, dataStaffToEdit);
            accountData = null;
            System.out.println("[DEBUG] showFormAccountStaff: isEdit = " + isEdit + ", idStaff = " + idStaff);
        }

        parentDashboard.setContent(restoreLastContent());
        parentApp.showGlassPanel(popupForm);
    }

    public void showDetailPopUpDataStaff(int idStaff) {
        popUpDetailDataStaff popUp = new popUpDetailDataStaff(parentApp, this, idStaff);
        parentDashboard.setContent(restoreLastContent());
        parentApp.showGlassPanel(popUp);
    }

    public void showDashboardReport() {
        reportDashboardView dashboardReport = new reportDashboardView();
        lastContent = dashboardReport;
        parentDashboard.setContent(dashboardReport);
    }

    public void showSuccessPopUp(String message) {
        popUpSuccess popUp = new popUpSuccess(parentApp);
        popUp.setNotificationMessage(message);
        parentDashboard.setContent(restoreLastContent());
        parentApp.showGlassPanel(popUp);
    }

    public void showFailedPopUp(String message) {
        popUpFailed popUp = new popUpFailed(parentApp);
        popUp.setNotificationMessage(message);
        parentDashboard.setContent(restoreLastContent());
        parentApp.showGlassPanel(popUp);
    }

    public popUpConfrim showConfrimPopUp(String message) {
        popUpConfrim popUp = new popUpConfrim(parentApp);
        popUp.setNotificationMessage(message);
        parentApp.showGlassPanel(popUp);
        parentDashboard.setContent(restoreLastContent());
        return popUp;
    }

    public void showLogoutApp() {
        parentDashboard.setContent(restoreLastContent());
        parentApp.showGlassPanel(new popUpLogout(parentApp));
    }

    public contentPanel restoreLastContent() {
        return lastContent != null ? lastContent : new homeDashboardView();
    }

    public void resetLastContent() {
        parentDashboard.getNavbar().showTableView();
        lastContent = null;
    }

    public void setDataProductToEdit(getterDataProduct dataProduct) {
        this.dataProductToEdit = dataProduct;
    }

    public void setCompositionModified(boolean modified) {
        this.compositionModified = modified;
    }

    public boolean isCompositionModified() {
        return this.compositionModified;
    }

    public void setDataSupplierToEdit(getterDataSupplier dataSupplier) {
        this.dataSupplierToEdit = dataSupplier;
    }

    public void setDataTableToEdit(getterDataTable dataTable) {
        this.dataTableToEdit = dataTable;
    }

    public void setDataStaffToEdit(getterDataStaff dataStaff) {
        this.dataStaffToEdit = dataStaff;
    }

}
