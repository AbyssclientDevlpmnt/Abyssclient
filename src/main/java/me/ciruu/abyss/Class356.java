package me.ciruu.abyss;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.ciruu.abyss.Class163;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class128;
import me.ciruu.abyss.modules.hud.Notifications;

public class Class356
extends Class163 {
    public Class356() {
        super("Friend", "Allows you to add or remove friends", "friend <add/del> name");
    }

    public void Method1538(String string) {
        String[] stringArray = string.split("");
        if (stringArray == null || stringArray.length <= 1) {
            return;
        }
        if (stringArray[1].toLowerCase().startsWith("a")) {
            if (stringArray.length > 1) {
                try {
                    if (Manager.Field223.Method1540(stringArray[2])) {
                        this.Method1541(Class128.Info, String.format("Added %s as a friend.", stringArray[2]));
                    } else {
                        this.Method1541(Class128.Error, String.format("%s is already a friend.", stringArray[2]));
                    }
                }
                catch (Exception exception) {
                }
                return;
            }
            return;
        }
        if (stringArray[1].toLowerCase().startsWith("d")) {
            if (stringArray.length > 1) {
                if (Manager.Field223.Method1542(stringArray[2])) {
                    this.Method1541(Class128.Warning, String.format("Removed %s as a friend.", stringArray[2]));
                } else {
                    this.Method1541(Class128.Error, String.format("%s is not a friend.", stringArray[2]));
                }
                return;
            }
            return;
        }
    }

    private void Method1541(Class128 class128, String string) {
        if (((Boolean)((Notifications)Manager.moduleManager.getModuleByClass(Notifications.class)).friends.getValue()).booleanValue()) {
            Manager.Field424.Method342(class128, string);
        }
    }
}
