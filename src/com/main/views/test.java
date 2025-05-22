package com.main.views;

public class test {
    

    buttonSave.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent ae) {
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();
            String phoneNumber = phoneField.getText().trim();
            String gender = (String) genderField.getSelectedItem();
            String jobdesk = (String) jobdeskField.getSelectedItem();
            String address = addresField.getText().trim();

            contentPanel.remove(nameEmptyLabel);
            contentPanel.remove(emailEmptyLabel);
            contentPanel.remove(phoneEmptyLabel);
            contentPanel.remove(genderEmptyLabel);
            contentPanel.remove(jobdeskEmptyLabel);
            contentPanel.remove(addressEmptyLabel);

            String validation = insertStaff.validateStaffInput(name, email, phoneNumber, gender, jobdesk, address);

            switch (validation) {
                case "ALL_FIELDS_EMPTY":
                    contentPanel.add(nameEmptyLabel);
                    contentPanel.add(emailEmptyLabel);
                    contentPanel.add(phoneEmptyLabel);
                    contentPanel.add(genderEmptyLabel);
                    contentPanel.add(jobdeskEmptyLabel);
                    contentPanel.add(addressEmptyLabel);
                    break;
                case "NAME_EMPTY":
                    contentPanel.add(nameEmptyLabel);
                    break;
                case "EMAIL_EMPTY":
                    contentPanel.add(emailEmptyLabel);
                    break;
                case "PHONE_EMPTY":
                    contentPanel.add(phoneEmptyLabel);
                    break;
                case "GENDER_EMPTY":
                    contentPanel.add(genderEmptyLabel);
                    break;
                case "JOBDESK_EMPTY":
                    contentPanel.add(jobdeskEmptyLabel);
                    break;
                case "ADDRESS_EMPTY":
                    contentPanel.add(addressEmptyLabel);
                    break;
                case "VALID":
                    String uniquenessCheck;
                    if (staffIdToEdit == -1) {
                        // Mode Insert: cek apakah email/phone sudah ada
                        uniquenessCheck = authDataStaff.validateStaffDataExistence(email, phoneNumber);
                    } else {
                        // Mode Update: cek jika email/phone diubah, baru cek uniqueness
                        if (!email.equalsIgnoreCase(oldEmail) || !phoneNumber.equalsIgnoreCase(oldPhoneNumber)) {
                            uniquenessCheck = authDataStaff.validateStaffDataExistence(email, phoneNumber);
                        } else {
                            uniquenessCheck = "VALID"; // Tidak diubah → aman
                        }
                    }

                    if (!uniquenessCheck.equals("VALID")) {
                        switch (uniquenessCheck) {
                            case "EMAIL_ALREADY_EXISTS":
                                parentView.showFailedPopUp("Email is already used.");
                                break;
                            case "PHONE_ALREADY_EXISTS":
                                parentView.showFailedPopUp("Phone number is already used.");
                                break;
                            case "PHONE_TOO_LONG":
                                parentView.showFailedPopUp("Phone number cannot exceed 13 digits.");
                                break;
                            default:
                                parentView.showFailedPopUp("Unknown validation error.");
                                break;
                        }
                        return;
                    }

                    boolean success;
                    if (staffIdToEdit == -1) {
                        // INSERT
                        success = authDataStaff.insertDataStaff(name, email, phoneNumber, gender, jobdesk, address);
                    } else {
                        // UPDATE
                        success = authDataStaff.updateDataStaff(staffIdToEdit, name, email, phoneNumber, gender,
                                jobdesk, address);
                    }

                    if (success) {
                        if (jobdesk.equalsIgnoreCase("Cashier") || jobdesk.equalsIgnoreCase("Supplier")) {
                            parentView.showFormAccountStaff(name, email, phoneNumber, gender, jobdesk, jobdesk,
                                    (staffIdToEdit != -1), 
                                    staffIdToEdit);
                        } else {
                            parentView.showSuccessPopUp(
                                    "Data Staff Successfully " + (staffIdToEdit == -1 ? "Saved" : "Updated"));
                            parentView.showDashboardStaff();
                        }
                    } else {
                        parentView.showFailedPopUp(
                                "Failed to " + (staffIdToEdit == -1 ? "Save" : "Update") + " Data Staff");
                    }
                    break;
            }

            contentPanel.revalidate();
            contentPanel.repaint();
        }
    });}
