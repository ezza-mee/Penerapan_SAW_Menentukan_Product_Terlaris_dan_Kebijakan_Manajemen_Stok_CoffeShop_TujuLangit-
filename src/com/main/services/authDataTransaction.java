package com.main.services;

import java.util.List;

import com.main.models.entity.listTransactionProduct;
import com.main.models.transaction.insertDetailTransaction;
import com.main.models.transaction.insertTransaction;

public class authDataTransaction {

    public static boolean insertDataTransaction(int idStaff, int idTable, String staff,
            String numberTable, String customer, int qantity, int price, String description, String payment,
            List<listTransactionProduct> listProduct) {

        int idTransaction = insertTransaction.insertData(idStaff, idTable, staff, numberTable, customer, qantity, price,
                description, payment);

        if (idTransaction == -1) {
            System.out.println("gagal insert");
            return false;
        }

        for (listTransactionProduct data : listProduct) {
            boolean insertListProduct = insertDetailTransaction.insertData(
                    idTransaction,
                    data.idProduct,
                    data.nameProduct,
                    data.quantity,
                    data.price);

            if (!insertListProduct) {
                return false;
            }
        }

        return true;
    }

    public String validateDataTransactionInput(String numberTable, String customer, String description,
            String payment) {
        if ((numberTable == null || numberTable.isEmpty()) &&
                (customer == null || customer.isEmpty()) &&
                (description == null || description.isEmpty()) &&
                (payment == null || payment.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (numberTable == null || numberTable.isEmpty()) {
            return "NUMBER_TABLE_EMPTY";
        } else if (customer == null || customer.isEmpty()) {
            return "CUSTOMER_INVALID";
        } else if (description == null || description.isEmpty()) {
            return "DESCRIPTION_EMPTY";
        } else if (payment == null || payment.isEmpty()) {
            return "PAYMENT_EMPTY";
        } else {
            return "VALID";
        }
    }

}
