package me.ciruu.abyss.mixin;

import java.util.Map;
import javax.annotation.Nullable;
import me.ciruu.abyss.Class488;
import me.ciruu.abyss.DRM;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

@IFMLLoadingPlugin.MCVersion(value="1.12.2")
@IFMLLoadingPlugin.Name(value="Abyssclient")
@Class488
public class MixinLoaderForge implements IFMLLoadingPlugin {

    private static boolean isObfuscatedEnvironment = false;

    public MixinLoaderForge() {
        MixinBootstrap.init();
        Mixins.addConfiguration("mixins.abyss.refmap.json");
        MixinEnvironment.getDefaultEnvironment().setObfuscationContext("searge");
    }

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        isObfuscatedEnvironment = (boolean) data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}