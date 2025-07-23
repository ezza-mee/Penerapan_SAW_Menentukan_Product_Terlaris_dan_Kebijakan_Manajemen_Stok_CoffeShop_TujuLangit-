package com.main.services;

import java.util.List;
import com.main.models.saw.processSAW;

public class authDataSaw {
    public static void executeSAW(String periode, List<Integer> idProductList) {
        processSAW.runSAW(periode, idProductList);
    }
}
