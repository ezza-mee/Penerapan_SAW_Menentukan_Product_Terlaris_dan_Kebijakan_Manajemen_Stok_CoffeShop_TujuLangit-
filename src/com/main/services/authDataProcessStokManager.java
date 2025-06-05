package com.main.services;

import com.main.models.stockManager.processStokUsage;

public class authDataProcessStokManager {

    public static void processManagerStok(int idProduct, int idTransaction) {
        processStokUsage.processStockUsage(idProduct, idTransaction);
    }
}
