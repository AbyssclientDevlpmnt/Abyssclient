package me.ciruu.abyss.modules.client;

import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import net.minecraft.client.gui.GuiScreen;

public class BubbleGUI
extends Module {
    public final Setting animation = new Setting("Animation", "", this, true);

    public BubbleGUI() {
        super("BubbleGUI", "Bubble GUI (Not SAO)", Class11.CLIENT);
    }

    public void Method3047(boolean bl) {
        this.Method3049();
    }

    public void Method3050() {
        super.Method13();
        Globals.mc.displayGuiScreen((GuiScreen)Manager.Field280);
    }

    public void Method3049() {
        super.Method15();
        Globals.mc.displayGuiScreen(null);
    }
}
