package com.main.services;

import java.util.ArrayList;
import java.util.List;
import com.main.models.dataProduct.insertDataProduct;
import com.main.models.dataProduct.listCompositionData;
import com.main.models.dataProduct.loadDataCompositionProduct;
import com.main.models.dataProduct.searchDataProduct;
import com.main.models.dataProduct.deleteDataCompositionProduct;
import com.main.models.dataProduct.deleteDataProduct;
import com.main.models.dataProduct.getterDataProduct;
import com.main.models.dataProduct.insertDataCompositionProduct;
import com.main.models.dataProduct.updateDataProduct;

public class authDataProduct {

    public static ArrayList<getterDataProduct> searchProductByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return new ArrayList<>();
        }
        return searchDataProduct.searchProducts(keyword.trim());
    }

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
            List<listCompositionData> compositions) {

        // Insert product terlebih dahulu
        int idProduct = insertDataProduct.insertProduct(imageProduct, nameProduct, price, category, description);

        if (idProduct == -1) {
            System.out.println("Gagal insert data produk.");
            return false;
        }

        // Masukkan setiap komposisi
        for (listCompositionData comp : compositions) {
            System.out.printf("Memasukkan komposisi: idSupplier = %d, nameSupplier = %s, quantity = %d, unit = %s%n",
                    comp.idSupplier, comp.nameSupplier, comp.quantity, comp.unit);

            boolean compositionInserted = insertDataCompositionProduct.insertCompositionProduct(
                    comp.idSupplier,
                    idProduct,
                    nameProduct,
                    comp.nameSupplier,
                    comp.quantity,
                    comp.unit);

            if (!compositionInserted) {
                System.out.printf("Gagal memasukkan komposisi: idSupplier = %d, nameSupplier = %s%n",
                        comp.idSupplier, comp.nameSupplier);
                return false;
            }
        }

        return true;
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

        // Hapus semua komposisi lama dulu
        boolean deleted = deleteDataCompositionProduct.deleteAllCompositionByProduct(idProduct);
        if (!deleted) {
            System.out.println("Gagal menghapus komposisi lama.");
            return false;
        }

        // Tambahkan ulang semua komposisi dari list baru
        for (listCompositionData comp : compositions) {
            boolean inserted = insertDataCompositionProduct.insertCompositionProduct(
                    comp.idSupplier,
                    idProduct,
                    nameProduct,
                    comp.nameSupplier,
                    comp.quantity,
                    comp.unit);

            if (!inserted) {
                System.out.printf("Gagal menambahkan komposisi baru: %s%n", comp.nameSupplier);
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

    public static boolean deleteDataCompositionProduct(int idSupplier, int idProduct) {
        return deleteDataCompositionProduct.deleteComposition(idSupplier, idProduct);
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
