package me.ciruu.abyss;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.Module;

public class Class464 {
    private final Map Field2550 = new HashMap();
    public static Module module;
    public void Method2022() {
            this.Method3059(Manager.moduleManager.getModuleByClass(module.getClass()));

    }

    public void Method3059(Module module) {
    }

    public List Method2580(Module module) {
        return Collections.singletonList(Manager.moduleManager.getModuleByClass(module.getClass()).toString());
    }
}
