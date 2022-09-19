package com.example.recyclermobil;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Mobil> mobilList = new ArrayList<Mobil>();
    private static int nextId = 10;

    public MyApplication() {
        fillMobilList();
    }

    private void fillMobilList() {
        Mobil m0 = new Mobil(0, "Lamborghini Aventador", 2011, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/2012-03-07_Motorshow_Geneva_4608.JPG/450px-2012-03-07_Motorshow_Geneva_4608.JPG");
        Mobil m1 = new Mobil(1, "Pagani Huayra", 2011, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Pagani%2C_GIMS_2019%2C_Le_Grand-Saconnex_%28GIMS0023%29.jpg/420px-Pagani%2C_GIMS_2019%2C_Le_Grand-Saconnex_%28GIMS0023%29.jpg");
        Mobil m2 = new Mobil(2, "Ferrari 488", 2015, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/2017_Ferrari_488_GTB_Automatic_3.9.jpg/420px-2017_Ferrari_488_GTB_Automatic_3.9.jpg");
        Mobil m3 = new Mobil(3, "Jeep Grand Cherokee", 1992, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/2011_Jeep_Grand_Cherokee_Laredo_--_NHTSA_2.jpg/375px-2011_Jeep_Grand_Cherokee_Laredo_--_NHTSA_2.jpg");
        Mobil m4 = new Mobil(4, "Mazda RX 7", 1978, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Mazda-RX-7-FD.jpg/375px-Mazda-RX-7-FD.jpg");
        Mobil m5 = new Mobil(5, "Bugatti Veyron", 2005, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Bugatti_Veyron_-_BCN_motorshow_2009.JPG/375px-Bugatti_Veyron_-_BCN_motorshow_2009.JPG");
        Mobil m6 = new Mobil(6, "Bugatti Chiron", 2016, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/62/Bugatti_Chiron_%2836559710091%29.jpg/420px-Bugatti_Chiron_%2836559710091%29.jpg");
        Mobil m7 = new Mobil(7, "Tesla Cybertruck", 2019, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/Tesla_Cybertruck_outside_unveil_modified_by_Smnt.jpg/420px-Tesla_Cybertruck_outside_unveil_modified_by_Smnt.jpg");
        Mobil m8 = new Mobil(8, "Ford GT", 2005, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/2005_Ford_GT.jpg/375px-2005_Ford_GT.jpg");
        Mobil m9 = new Mobil(9, "Ferrari Roma", 2020, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/2021_Ferrari_Roma_Front.jpg/420px-2021_Ferrari_Roma_Front.jpg");

        mobilList.addAll(Arrays.asList(new Mobil[]{m0, m1, m2, m3, m4, m5, m6, m7, m8, m9}));
    }

    public static List<Mobil> getMobilList() {
        return mobilList;
    }

    public static void setMobilList(List<Mobil> mobilList) {
        MyApplication.mobilList = mobilList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
