package me.ciruu.abyss.mixin.client;

import java.util.Map;
import me.ciruu.abyss.Class36;
import me.ciruu.abyss.Globals;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.modules.client.Alias;
import me.ciruu.abyss.modules.client.CustomFont;
import me.ciruu.abyss.modules.client.NameChanger;
import me.ciruu.abyss.modules.hud.ChatWatermark;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.StringUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public abstract class MixinFontRenderer {

    protected abstract void renderStringAtPos(String var1, boolean var2);
    public static Map.Entry entry;
    public void renderStringAtPosHook(FontRenderer fontRenderer, String string, boolean bl) {
        if (Manager.moduleManager.getModuleByClass(NameChanger.class) != null && Manager.moduleManager.isModuleEnabled(NameChanger.class) || Manager.moduleManager.getModuleByClass(Alias.class) != null && Manager.moduleManager.isModuleEnabled(Alias.class) && !((Boolean)((Alias)Manager.moduleManager.getModuleByClass(Alias.class)).onlynametags.getValue()).booleanValue()) {
            if (Manager.moduleManager.getModuleByClass(NameChanger.class) != null && Manager.moduleManager.isModuleEnabled(NameChanger.class)) {
                this.renderStringAtPos(string.replace(Minecraft.getMinecraft().getSession().getUsername(), (CharSequence)((NameChanger)Manager.moduleManager.getModuleByClass(NameChanger.class)).newname.getValue()), bl);
            }
            if (Manager.moduleManager.getModuleByClass(Alias.class) != null && Manager.moduleManager.isModuleEnabled(Alias.class) && !((Boolean)((Alias)Manager.moduleManager.getModuleByClass(Alias.class)).onlynametags.getValue()).booleanValue()) {
                    string = string.replace((CharSequence)entry.getKey(), (CharSequence)entry.getValue());
                }
                this.renderStringAtPos(string, bl);

        } else {
            this.renderStringAtPos(string, bl);
        }
    }

    public void renderString(String string, float f, float f2, int n, boolean bl, CallbackInfoReturnable callbackInfoReturnable) {
        if (Manager.moduleManager.getModuleByClass(CustomFont.class) != null && Manager.moduleManager.isModuleEnabled(CustomFont.class) && ((Boolean)((CustomFont)Manager.moduleManager.getModuleByClass(CustomFont.class)).override.getValue()).booleanValue()) {
            if (bl) {
                Class36.Method63(string, f, f2, n);
            } else {
                Class36.Method555(string, f, f2, n);
            }
            callbackInfoReturnable.setReturnValue((int)((float)Class36.Method259(string) + f));
        }
    }

    private int getShadowString(String string, float f, float f2, int n) {
        Class36.Method555(StringUtils.stripControlCodes((String)string), f + 0.5f, f2 + 0.5f, 0);
        Class36.Method555(string, f, f2, n);
        return Class36.Method259(string);
    }

    public void getStringWidth(String string, CallbackInfoReturnable callbackInfoReturnable) {
        if (Manager.moduleManager.getModuleByClass(CustomFont.class) != null && Manager.moduleManager.isModuleEnabled(CustomFont.class) && ((Boolean)((CustomFont)Manager.moduleManager.getModuleByClass(CustomFont.class)).override.getValue()).booleanValue()) {
            callbackInfoReturnable.setReturnValue(Class36.Method259(string));
        }
    }

    public void drawString(String string, float f, float f2, int n, CallbackInfoReturnable callbackInfoReturnable) {
        try {
            if (Manager.moduleManager.getModuleByClass(ChatWatermark.class) != null && Manager.moduleManager.isModuleEnabled(ChatWatermark.class) && string.contains("?+")) {
                String string2 = string.substring(2, 9);
                String string3 = string.substring(12);
                ((ChatWatermark)Manager.moduleManager.getModuleByClass(ChatWatermark.class)).Method2975(string2, f, f2);
                Globals.mc.fontRenderer.drawStringWithShadow("" + string3, f + (float)Class36.Method259(string2), f2, n);
                callbackInfoReturnable.cancel();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
