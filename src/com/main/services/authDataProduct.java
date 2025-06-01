package com.main.services;

import java.util.List;
import com.main.models.dataProduct.insertDataProduct;
import com.main.models.dataProduct.listCompositionData;
import com.main.models.dataProduct.loadDataCompositionProduct;
import com.main.models.dataProduct.loadDataProduct;
import com.main.models.dataProduct.deleteDataCompositionProduct;
import com.main.models.dataProduct.deleteDataProduct;
import com.main.models.dataProduct.insertDataCompositionProduct;
import com.main.models.dataProduct.updateDataProduct;
import com.main.models.dataProduct.updateDataCompositionProduct;

public class authDataProduct {

    public static boolean updateDataProduct(int idProduct, String imageProduct, String nameProduct, int price,
            String category,
            String description) {
        return updateDataProduct.updateProduct(idProduct, imageProduct, nameProduct, price, category, description);
    }

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
                    idSupplier,
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

    public static boolean insertCompositionProduct(int idSupplier, int idProduct, String nameProduct,
            String nameSupplier, int quantity, String unit) {
        return insertDataCompositionProduct.insertCompositionProduct(idSupplier, idProduct, nameProduct, nameSupplier,
                quantity, unit);
    }

    public static boolean updateCompositionProduct(int idSupplier, int idProduct, String nameProduct,
            String nameSupplier, int quantity, String unit) {
        return updateDataCompositionProduct.updateCompositionProduct(idSupplier, idProduct, nameProduct, nameSupplier,
                quantity, unit);
    }

    public static boolean updateDataProductWithComposition(
            int idSupplier,
            int idProduct,
            String imageProduct,
            String nameProduct,
            int price,
            String category,
            String description,
            List<listCompositionData> compositions) {

        boolean productUpdated = updateDataProduct.updateProduct(
                idProduct,
                imageProduct,
                nameProduct,
                price,
                category,
                description);

        if (!productUpdated) {
            System.out.println("Gagal update data produk.");
            return false;
        }

        for (listCompositionData listComp : compositions) {
            boolean compositionUpdated = updateDataCompositionProduct.updateCompositionProduct(
                    listComp.idSupplier,
                    idProduct,
                    nameProduct,
                    listComp.nameSupplier,
                    listComp.quantity,
                    listComp.unit);

            if (!compositionUpdated) {
                System.out.println("Produk berhasil diupdate, tapi gagal update komposisi: " + listComp.nameSupplier);
                return false;
            }
        }

        return true;
    }

    public static boolean checkCompositionExists(int idSupplier, int idProduct) {
        return loadDataCompositionProduct.checkCompositionExists(idSupplier, idProduct);
    }

    public static boolean deleteDataProduct(int idProduct) {
        return deleteDataProduct.deleteProduct(idProduct);
    }

    public static int getProductIdByName(String nameProduct) {
        return loadDataProduct.getProductIdByName(nameProduct);
    }

    public static boolean deleteDataCompositionProduct(int idProduct) {
        return deleteDataCompositionProduct.deleteCompositionByProductAndSupplier(idProduct);
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
