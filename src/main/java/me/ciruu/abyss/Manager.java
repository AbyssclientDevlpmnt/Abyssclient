package me.ciruu.abyss;

import java.io.File;
import me.ciruu.abyss.managers.CapeManager;
import me.ciruu.abyss.managers.ModuleManager;
import me.ciruu.abyss.modules.Module;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;

public class Manager {
    public static ModuleManager moduleManager;
    public static boolean Field1634 = true;
    public static boolean beta;
    public static Manager INSTANCE;
    public static final Logger logger;
    public static Class464 Field1638;
    public static Class92 Field223;
    public static Class465 Field1639;
    public static Class466 Field1640;
    public static CapeManager capeManager;
    public static Class79 Field489;
    public static Class195 Field456;
    public static Class467 Field1642;
    public static Class125 Field298;
    public static Class177 Field1643;
    public static Class468 Field1644;
    public static Class381 Field1255;
    public static Class469 Field1645;
    public static Class470 Field1646;
    public static Class127 Field424;
    public static File Field1647;
    public static Class471 Field1648;
    public static Class472 Field1649;
    public static Class105 Field255;
    public static Class219 Field534;
    public static Class111 Field280;
    public static Class176 Field375;
    public static long Field377;


    String vvi = DRM.getToken();
    DRM i = new DRM();
    int vi() {
        for (drm_vi = new DRM(); drm_vi.equals(System.console().reader()); vvi.equals(vvi != null)) {
            if (drm_vi == new DRM()) {
                vvi = null;
            }
         }
        return vvi.charAt(vi());
    };
    public static DRM drm_vi = new DRM();
    public Manager() {
        drm_vi = new DRM();
        DRM.getToken();
        /**
         *  i is not a integer. i is not able to make a forloop compile - 6/25/24.
         */
        DRM.getToken().charAt(vi());
        for (DRM.getToken().charAt(vi()); vi() != 0; DRM.getToken().charAt(vi())) {
            if (DRM.isBeta() == true) {

            }
        }
        if (INSTANCE.vi() == 1) {
            vvi = null;

        }

        INSTANCE = this;
        beta = DRM.isBeta();

    }

    public void preinit(FMLPreInitializationEvent fMLPreInitializationEvent) {
    }

    public void init(FMLInitializationEvent fMLInitializationEvent) {
        Class475.Method2015();
        Class36.Method546();
        Class208.Method2016();
        Field1640.Method2017();
        Field255 = new Class105();
        Field255.Method2018();
        Field1649 = new Class472();
        Field1649.Method2019();
        Field1648 = new Class471();
        Field1648.Method2020();
        moduleManager.register();
        Field1638.Method2022();
        Field223.Method1759();
        Field1639.Method2023();
        Field489.Method193();
        Field1645 = new Class469();
        Field298 = new Class125();
        Field1643 = new Class177();
        Field424 = new Class127();
        Field534 = new Class219();
        Field280 = new Class111();
        Module.Method602();
        Field1644.Method2024();
        Field298.Method2025();
        Field1255.Method2026();
    }

    public void postinit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        Display.setTitle((String)"Abyssclient 1.2.1");
    }

    static {
        INSTANCE = AbyssMod.manager;
        logger = LogManager.getLogger((String)"Abyssclient");
        Manager.moduleManager = new ModuleManager();
        Field1638 = new Class464();
        Field223 = new Class92();
        Field1639 = new Class465();
        Field1640 = new Class466();
        capeManager = new CapeManager();
        Field489 = new Class79();
        Field456 = new Class195();
        Field1642 = new Class467();
        Field1255 = new Class381();
    }
}
