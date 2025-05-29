package com.main.views;

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
import com.main.layouts.dashboardAdmin.transaction.transactionDashboardView;
import com.main.layouts.popUp.popUpFailed;
import com.main.layouts.popUp.popUpLogout;
import com.main.layouts.popUp.popUpSuccess;
import com.main.layouts.popUp.popUpStaff.popUpDetailDataStaff;
import com.main.layouts.popUp.popUpStaff.popUpFormInputAccountStaff;
import com.main.models.dataStaff.getterAccountStaff;
import com.main.models.dataStaff.getterDataStaff;
import com.main.models.dataSupplier.getterDataSupplier;
import com.main.services.authDataStaff;

public class dashboardAdminView extends containerPanel {

    private parentDashboardView parentDashboard;
    private mainFrame parentFrame;
    private contentPanel lastContent;

    private getterDataStaff dataStaffToEdit = null;
    private getterDataSupplier dataSupplierToEdit = null;

    private getterAccountStaff accountData = null;

    public dashboardAdminView(mainFrame parentFrame) {
        super();
        this.parentFrame = parentFrame;
        setSize(1366, 768);
        setBackground(color.GREEN);
        parentDashboard = new parentDashboardView(this);
        add(parentDashboard);

        // parentDashboard.getNavbar().showHomeView();
        parentDashboard.getNavbar().showProductView();
    }

    public void showDashboardHome() {
        homeDashboardView dashboardHome = new homeDashboardView();
        lastContent = dashboardHome;
        parentDashboard.setContent(dashboardHome);
    }

    public void showDashboardProduct() {
        productDashboardView dashboardProduct = new productDashboardView(this);
        lastContent = dashboardProduct;
        parentDashboard.setContent(dashboardProduct);
    }

    public void showFormProduct() {
        productFormView formProduct = new productFormView(this);
        lastContent = formProduct;
        parentDashboard.setContent(formProduct);
    }

    public void showFormCompositionProduct(String imageProduct, String nameProduct, int price, String category,
            String description) {
        productCompositionFormView formCompositionProduct = new productCompositionFormView(this, imageProduct,
                nameProduct, price, category, description);
        lastContent = formCompositionProduct;
        parentDashboard.setContent(formCompositionProduct);
    }

    public void showDashboardSupplier() {
        supplierDashboardView dashboardSupplier = new supplierDashboardView(this);
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

    public void showDashboardTransaction() {
        transactionDashboardView dashboardTransaction = new transactionDashboardView();
        lastContent = dashboardTransaction;
        parentDashboard.setContent(dashboardTransaction);
    }

    public void showDashboardStaff() {
        staffDashboardView dashboardStaff = new staffDashboardView(this);
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
            String name,
            String email,
            String phoneNumber,
            String gender,
            String jobdesk,
            String address, boolean isEdit, int idStaff) {

        popUpFormInputAccountStaff popupForm = new popUpFormInputAccountStaff(
                parentFrame, this, name, email, phoneNumber, gender, jobdesk, address, isEdit, idStaff);

        this.accountData = authDataStaff.getDataAccountById(idStaff);
        this.dataStaffToEdit = new getterDataStaff(idStaff, name, email, phoneNumber, gender, jobdesk, address);

        System.out.println("ID Staff: " + idStaff);

        if (this.accountData != null) {
            popupForm.setFormAccountData(this.accountData, dataStaffToEdit);
            accountData = null;
            System.out.println("[DEBUG] showFormAccountStaff: isEdit = " + isEdit + ", idStaff = " + idStaff);
        }

        parentDashboard.setContent(restoreLastContent());
        parentFrame.showGlassPanel(popupForm);
    }

    public void showDetailPopUpDataStaff(int idStaff) {
        popUpDetailDataStaff popUp = new popUpDetailDataStaff(parentFrame, this, idStaff);
        parentDashboard.setContent(restoreLastContent());
        parentFrame.showGlassPanel(popUp);
    }

    public void showDashboardReport() {
        reportDashboardView dashboardReport = new reportDashboardView();
        lastContent = dashboardReport;
        parentDashboard.setContent(dashboardReport);
    }

    public void showSuccessPopUp(String message) {
        popUpSuccess popUp = new popUpSuccess(parentFrame);
        popUp.setNotificationMessage(message);
        parentDashboard.setContent(restoreLastContent());
        parentFrame.showGlassPanel(popUp);
    }

    public void showFailedPopUp(String message) {
        popUpFailed popUp = new popUpFailed(parentFrame);
        popUp.setNotificationMessage(message);
        parentDashboard.setContent(restoreLastContent());
        parentFrame.showGlassPanel(popUp);
    }

    public void showLogoutApp() {
        parentDashboard.setContent(restoreLastContent());
        parentFrame.showGlassPanel(new popUpLogout(parentFrame));
    }

    public contentPanel restoreLastContent() {
        return lastContent != null ? lastContent : new homeDashboardView();
    }

    public void resetLastContent() {
        parentDashboard.getNavbar().showProductView();
        lastContent = null;
    }

    public void setDataStaffToEdit(getterDataStaff dataStaff) {
        this.dataStaffToEdit = dataStaff;
    }

    public void setDataSupplierToEdit(getterDataSupplier dataSupplier) {
        this.dataSupplierToEdit = dataSupplier;
    }

}
