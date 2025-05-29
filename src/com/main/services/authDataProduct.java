package com.main.services;

import java.util.List;
import com.main.models.dataProduct.insertDataProduct;
import com.main.models.dataProduct.listCompositionData;
import com.main.models.dataProduct.insertDataCompositionProduct;

public class authDataProduct {

    public static boolean insertDataProductWithComposition(
            String imageProduct,
            String nameProduct,
            int price,
            String category,
            String description,
            int idSupplier,
            String nameSupplier,
            int quantity,
            String unit,
            List<listCompositionData> compositions) {

        int idProduct = insertDataProduct.insertProduct(imageProduct, nameProduct, price, category, description);

        if (idProduct == -1) {
            System.out.println("Gagal insert data produk.");
            return false;
        }

        for (listCompositionData listComp : compositions) {
            boolean compositionInserted = insertDataCompositionProduct.insertCompositionProduct(
                    idProduct,
                    listComp.idSupplier,
                    nameProduct,
                    listComp.nameSupplier,
                    listComp.quantity,
                    listComp.unit);

            if (!compositionInserted) {
                System.out.println("Produk berhasil disimpan, tapi gagal insert komposisi produk.");
                return false;
            }
        }

        return true;
    }

    public String validateProductInput(String imageProduct, String nameProduct, String category, String price,
            String description) {
        if ((imageProduct == null || imageProduct.isEmpty()) &&
                (nameProduct == null || nameProduct.isEmpty()) &&
                (category == null || category.isEmpty()) &&
                (price == null || price.isEmpty()) &&
                (description == null || description.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (imageProduct == null || imageProduct.isEmpty()) {
            return "IMAGE_PRODUCT_EMPTY";
        } else if (nameProduct == null || nameProduct.isEmpty()) {
            return "NAME_PRODUCT_EMPTY";
        } else if (price == null || price.isEmpty()) {
            return "PRICE_PRODUCT_EMPTY";
        } else if (category == null || category.isEmpty()) {
            return "CATEGORY_PRODUCT_EMPTY";
        } else if (description == null || description.isEmpty()) {
            return "DESCRIPTION_PRODUCT_EMPTY";
        } else {
            return "VALID";
        }
    }

    public String validateCompositionProductInput(String nameSupplier, String quantity, String unit) {
        if ((nameSupplier == null || nameSupplier.isEmpty()) &&
                (quantity == null || quantity.isEmpty()) &&
                (unit == null || unit.isEmpty())) {
            return "ALL_FIELDS_EMPTY";
        } else if (nameSupplier == null || nameSupplier.isEmpty()) {
            return "NAME_SUPPLIER_EMPTY";
        } else if (quantity == null || quantity.isEmpty()) {
            return "QUANTITY_EMPTY";
        } else if (unit == null || unit.isEmpty()) {
            return "UNIT_EMPTY";
        } else {
            return "VALID";
        }

    }

}
