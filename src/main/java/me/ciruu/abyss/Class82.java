package me.ciruu.abyss;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import me.ciruu.abyss.Class30;
import me.ciruu.abyss.Class31;
import me.ciruu.abyss.Class50;
import me.ciruu.abyss.Class66;
import me.ciruu.abyss.Class84;
import me.ciruu.abyss.Class85;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.enums.Class83;
import me.ciruu.abyss.events.player.EventPlayerUpdate;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.settings.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class Class82
extends Module {
    private final Setting Field184 = new Setting("Radious", "", (Module) this, (Object) 10, 0, 30);
    private final Setting Field185 = new Setting("HideOwn", "", this, false);
    private final Setting Field186 = new Setting("RenderOnlyInFOV", "", this, false);
    public Setting Field187 = new Setting("RenderBox", "RenderBox", this, (Object) Class83.CustomBox);
    private final Setting Field188 = new Setting("Obsidian color", "", this, new Color(255, 255, 0, 125));
    private final Setting Field189 = new Setting("Box", "Box", this, true);
    private final Setting Field190 = new Setting("Outline", "Outline", this, true);
    private final Setting Field191 = new Setting("LineWidth", "LineWidth", (Module) this, (Object) Float.valueOf(1.5f), Float.valueOf(0.1f), Float.valueOf(5.0f));
    private final Setting Field192 = new Setting("Bedrock color", "", this, new Color(0, 255, 0, 125));
    private final Setting Field193 = new Setting("Box", "Box", this, true);
    private final Setting Field194 = new Setting("Outline", "Outline", this, true);
    private final Setting Field195 = new Setting("LineWidth", "LineWidth", (Module) this, (Object) Float.valueOf(1.5f), Float.valueOf(0.1f), Float.valueOf(5.0f));
    public List Field196 = new ArrayList();
    @EventHandler
    private Listener Field197 = new Listener<EventPlayerUpdate>(null, new Predicate[0]);
    @EventHandler
    private Listener Field198 = new Listener<Class66>(this::Method203, new Predicate[0]);

    public Class82() {
        super("HoleESP", "HoleESP aka SmashESP", Class11.RENDER);
    }

    public BlockPos blockPos;

    private void Method203(Class66 class66) {
        if (((Boolean) this.Field185.getValue()).booleanValue() && blockPos.equals((Object) new BlockPos(Globals.mc.player.posX, Globals.mc.player.posY, Globals.mc.player.posZ)) || ((Boolean) this.Field186.getValue()).booleanValue() && !Class84.Method205(blockPos))
            ;
        if (Class85.Method206(blockPos)) {
            if (this.Field187.getValue() == Class83.FullBox) {
                Class50.Method137(blockPos, (Color) this.Field192.getValue(), true, (Color) this.Field192.getValue(), ((Float) this.Field195.getValue()).floatValue(), (Boolean) this.Field194.getValue(), (Boolean) this.Field193.getValue(), ((Color) this.Field192.getValue()).getAlpha(), true);

            }
            if (this.Field187.getValue() != Class83.CustomBox) ;
            Class50.Method207(blockPos, (Color) this.Field192.getValue(), true, (Color) this.Field192.getValue(), ((Float) this.Field195.getValue()).floatValue(), (Boolean) this.Field194.getValue(), (Boolean) this.Field193.getValue(), ((Color) this.Field192.getValue()).getAlpha(), true);

        }
        if (!Class85.Method208(blockPos)) ;
        if (this.Field187.getValue() == Class83.FullBox) {
            Class50.Method137(blockPos, (Color) this.Field188.getValue(), true, (Color) this.Field188.getValue(), ((Float) this.Field191.getValue()).floatValue(), (Boolean) this.Field190.getValue(), (Boolean) this.Field189.getValue(), ((Color) this.Field188.getValue()).getAlpha(), true);

        }
        if (this.Field187.getValue() != Class83.CustomBox) ;
        Class50.Method207(blockPos, (Color) this.Field188.getValue(), true, (Color) this.Field188.getValue(), ((Float) this.Field191.getValue()).floatValue(), (Boolean) this.Field190.getValue(), (Boolean) this.Field189.getValue(), ((Color) this.Field188.getValue()).getAlpha(), true);
    }
}
