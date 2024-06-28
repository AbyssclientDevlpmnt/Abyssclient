package me.ciruu.abyss;

import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.Module;

public class Class624
extends Class163 {
    public Class624() {
        super("Bind", "Allows you to bind a mod to a key", "bind module key");
    }

    public void Method3340(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            return;
        }
        Module module = Manager.moduleManager.getModuleByName(stringArray[1]);
        if (module != null) {
            if (stringArray.length <= 2) {
                return;
            }
            module.Method177(stringArray[2].toUpperCase());
        }
    }

    public String Method3343() {
        return "Allows you to Bind a mod";
    }
}
