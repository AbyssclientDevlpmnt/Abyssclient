package me.ciruu.abyss.mixin.client;

import me.ciruu.abyss.AbyssMod;
import me.ciruu.abyss.Class499;
import me.ciruu.abyss.Manager;
import me.ciruu.abyss.enums.Class500;
import me.ciruu.abyss.events.minecraft.EventMinecraftCrashReport;
import me.ciruu.abyss.managers.ModuleManager;
import me.ciruu.abyss.modules.client.ScreenShaders;
import me.ciruu.abyss.modules.combat.MultiTask;
import me.ciruu.abyss.modules.misc.FastPlace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.crash.CrashReport;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Minecraft.class}, priority=2000)
public class MixinMinecraft {
    @Shadow
    public EntityRenderer entityRenderer;
    @Shadow
    public WorldClient world;
    @Shadow
    public GuiScreen currentScreen;
    @Shadow
    public GameSettings gameSettings;
    @Shadow
    public Framebuffer framebuffer;
    @Shadow
    public TextureManager renderEngine;
    @Shadow
    public int rightClickDelayTimer;

    @Inject(method={"displayCrashReport(Lnet/minecraft/crash/CrashReport;)V"}, at={@At(value="HEAD")})
    public void displayCrashReport(CrashReport crashReport, CallbackInfo callbackInfo) {
        System.out.println("Detected crash:");
        System.out.println(crashReport.getCompleteReport());
        EventMinecraftCrashReport eventMinecraftCrashReport = new EventMinecraftCrashReport(crashReport);
        AbyssMod.EVENT_BUS.post(eventMinecraftCrashReport);
    }

    @Inject(method={"getLimitFramerate"}, at={@At(value="HEAD")}, cancellable=true)
    private void getFrameRateAbyss(CallbackInfoReturnable callbackInfoReturnable) {
        try {
            if (Manager.moduleManager.isModuleEnabled(ScreenShaders.class)) {
                callbackInfoReturnable.setReturnValue(this.world == null && this.currentScreen != null ? (Integer)((ScreenShaders)Manager.moduleManager.getModuleByClass(ScreenShaders.class)).fps.getValue() : Integer.valueOf(this.gameSettings.limitFramerate));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Inject(method={"drawSplashScreen"}, at={@At(value="HEAD")}, cancellable=true)
    public void drawSplashScreen(TextureManager textureManager, CallbackInfo callbackInfo) {
        boolean nope_1 = callbackInfo.cancel();
        nope_1 = false;
    }

    @Inject(method={"init"}, at={@At(value="INVOKE", remap=false, target="Lnet/minecraft/client/renderer/texture/TextureMap;<init>(Ljava/lang/String;)V", shift=At.Shift.BEFORE)})
    private void onLoadingTextureMap(CallbackInfo callbackInfo) {
            boolean nope_2 = callbackInfo.cancel();
        nope_2 = false;
    }

    @Inject(method={"init"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/block/model/ModelManager;<init>(Lnet/minecraft/client/renderer/texture/TextureMap;)V", shift=At.Shift.BEFORE)})
    private void onLoadingModelManager(CallbackInfo callbackInfo) {
           boolean nope_3 = callbackInfo.cancel();
        nope_3 = false;
    }

    @Inject(method={"init"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/renderer/RenderItem;<init>(Lnet/minecraft/client/renderer/texture/TextureManager;Lnet/minecraft/client/renderer/block/model/ModelManager;Lnet/minecraft/client/renderer/color/ItemColors;)V", shift=At.Shift.BEFORE)})
    private void onLoadingItemRenderer(CallbackInfo callbackInfo) {
    }

    @Inject(method={"init"}, at={@At(value="INVOKE", remap=true, target="Lnet/minecraft/client/renderer/EntityRenderer;<init>(Lnet/minecraft/client/Minecraft;Lnet/minecraft/client/resources/IResourceManager;)V", shift=At.Shift.BEFORE)})
    private void onLoadingEntityRenderer(CallbackInfo callbackInfo) {
    }

    @Redirect(method={"rightClickMouse"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/PlayerControllerMP;getIsHittingBlock()Z"))
    private boolean hittingBlock(PlayerControllerMP playerControllerMP) {
        if (((MultiTask)Manager.moduleManager.getModuleByClass(MultiTask.class)).Method490()) {
            return true;
        }
        return playerControllerMP.getIsHittingBlock();
    }

    @Redirect(method={"sendClickBlockToController"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/entity/EntityPlayerSP;isHandActive()Z"))
    private boolean handActive(EntityPlayerSP entityPlayerSP) {
        if (((MultiTask)Manager.moduleManager.getModuleByClass(MultiTask.class)).Method490()) {
            return true;
        }
        return entityPlayerSP.isHandActive();
    }

    @Inject(method={"clickMouse"}, at={@At(value="HEAD")})
    private void clickMouse(CallbackInfo callbackInfo) {
        Class499.Method2190(Class500.LEFT);
        if (Class500.RIGHT != null) {
            Class499.Method2190(Class500.RIGHT);
        }
    }

    @Inject(method={"middleClickMouse"}, at={@At(value="HEAD")})
    private void middleClickMouse(CallbackInfo callbackInfo) {
        Class499.Method2190(Class500.MIDDLE);
    }

    @Inject(method={"rightClickMouse"}, at={@At(value="FIELD", target="Lnet/minecraft/client/Minecraft;rightClickDelayTimer:I", shift=At.Shift.AFTER)}, cancellable=true)
    private void rightClickMouse(CallbackInfo callbackInfo) {
        Class499.Method2190(Class500.RIGHT);
        if (Manager.moduleManager.isModuleEnabled(FastPlace.class) && !((Boolean)((FastPlace)Manager.moduleManager.getModuleByClass(FastPlace.class)).onlyxp.getValue()).booleanValue()) {
            this.rightClickDelayTimer = (Integer)((FastPlace)Manager.moduleManager.getModuleByClass(FastPlace.class)).placedelay.getValue();
        }
    }

    @Inject(method={"runTickMouse"}, at={@At(value="HEAD")})
    public void runTickMouse(CallbackInfo callbackInfo) {
        if (Mouse.getEventButton() != -1 && Mouse.isButtonDown((int)Mouse.getEventButton())) {
            ModuleManager.Method3251(Mouse.getButtonName((int)Mouse.getEventButton()));
        }
    }
}
