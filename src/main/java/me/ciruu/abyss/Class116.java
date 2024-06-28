package me.ciruu.abyss;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.ciruu.abyss.enums.Class11;
import me.ciruu.abyss.modules.Module;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Class116 {
    private final String var2_2;
    private float Field2880;
    private float Field2881;
    private final float Field2882 = 20.0f;
    private boolean Field2883;
    @Nullable
    private ResourceLocation Field2884;
    private boolean Field2885;
    @NotNull
    private ArrayList Field2886;
    @NotNull
    private Class11 Field2887;

    public float Method3553() {
        return this.Field2880;
    }

    public void Method278(float f) {
        this.Field2880 = f;
    }

    public float Method283() {
        return this.Field2881;
    }

    public void Method268(float f) {
        this.Field2881 = f;
    }

    public float Method3554() {
        return this.Field2882;
    }

    public boolean Method286() {
        return this.Field2883;
    }

    public void Method285(boolean bl) {
        this.Field2883 = bl;
    }

    @Nullable
    public final ResourceLocation Method3555() {
        return this.Field2884;
    }

    public final void Method3556(@Nullable ResourceLocation resourceLocation) {
        this.Field2884 = resourceLocation;
    }

    public final boolean Method3557() {
        return this.Field2885;
    }

    public final void Method3558(boolean bl) {
        this.Field2885 = bl;
    }

    @NotNull
    public final ArrayList Method271() {
        return this.Field2886;
    }

    public final void Method3559(@NotNull ArrayList arrayList) {
        this.Field2886 = arrayList;
    }

    public void Method269(int n, int n2) {
        this.Field2885 = this.Method3560(n, n2);
        this.Method3561();
        Iterable iterable = this.Field2886;
        boolean bl = false;
        for (Object t : iterable) {
            Class117 class117 = (Class117)t;
            boolean bl2 = false;
            class117.Method3565();
        }
    }

    public void Method275(int n, int n2, int n3) {
        if (n3 == 0 && this.Method3560(n, n2)) {
            Manager.Field280.hideButtons(this);
            Manager.Field280.setAnim(new Class113(200L, Manager.Field280.getFirstY(), Manager.Field280.getMiddleY()));
        }
        Iterable iterable = this.Field2886;
        boolean bl = false;
        for (Object t : iterable) {
            Class117 class117 = (Class117)t;
            boolean bl2 = false;
            class117.Method3566(n, n2, n3);
        }
    }

    private final void Method3561() {
        Class423.Method2778((int)this.Method3553(), (int)this.Method283(), this.Method3554(), this.Method286() ? Class232.Field570.Method721().getRGB() : Class232.Field570.Method720().getRGB(), 90);
        this.Method3568();
        Class423.Method2800((int)this.Method3553(), (int)this.Method283(), (int)(this.Method3554() + (float)3), !this.Method286() || this.Field2885 ? Class232.Field570.Method720().getRGB() : Class232.Field570.Method721().getRGB(), 2.0f);
    }

    private final void Method3568() {
        if (this.Field2884 != null) {
            Class118.Field282.Method304();
            TextureManager textureManager = Globals.mc.renderEngine;
            ResourceLocation resourceLocation = this.Field2884;
            if (resourceLocation == null) {
                Intrinsics.throwNpe();
            }
            textureManager.bindTexture(resourceLocation);
            Class118.Field282.Method320(this.Method3553() - this.Method3554() + (float)2, this.Method283() - this.Method3554() + (float)2, 0.0f, 0.0f, 64, 64, (this.Method3554() - (float)2) * (float)2, (this.Method3554() - (float)2) * (float)2, 64.0f, 64.0f, this.Method286() ? Class232.Field570.Method723() : Color.WHITE);
            Class118.Field282.Method313();
        }
    }

    @NotNull
    public final Class11 Method3571() {
        return this.Field2887;
    }

    public final void Method3572(@NotNull Class11 class11) {
        this.Field2887 = class11;
    }

    /*
     * Unable to fully structure code
     */
    public Class116(@NotNull Class11 var1_1) {
        String var221;
        ResourceLocation v0;
        block17: {
            block16: {
                block15: {
                    block14: {
                        block12: {
                            block13: {
                                this.Field2887 = var1_1;
                                this.Field2883 = true;
                                this.Field2886 = new ArrayList<Enum>();
                                var221 = this.Field2887.name();
                                switch (var1_1.hashCode()) {
                                    case 1993470708: {
                                        if (!var1_1.equals("COMBAT"));
                                        break;
                                    }
                                    case 71895: {
                                        if (!var1_1.equals("HUD"));
                                        break block12;
                                    }
                                    case -591166101: {
                                        if (!var1_1.equals("EXPLOIT"));
                                        break block13;
                                    }
                                    case 2366700: {
                                        if (!var1_1.equals("MISC"));
                                        break block14;
                                    }
                                    case 678949039: {
                                        if (!var1_1.equals("MOVEMENT"));
                                        break block15;
                                    }
                                    case -1881262698: {
                                        if (!var1_1.equals("RENDER"));
                                        break block16;
                                    }
                                    case 1990584267: {
                                        if (!var1_1.equals("CLIENT"));
                                        v0 = Class234.Field1810;
                                        break block17;
                                    }
                                }
                                v0 = Class234.Field1811;
                                break block17;
                            }
                            v0 = Class234.Field1812;
                            break block17;
                        }
                        v0 = Class234.Field1813;
                        break block17;
                    }
                    v0 = Class234.Field1814;
                    break block17;
                }
                v0 = Class234.Field1815;
                break block17;
            }
            v0 = Class234.Field1816;
            break block17;
        }
        this.Field2884 = v0;
        Collection var3_3 = Manager.moduleManager.getModules().values();
        boolean var4_5 = false;
        Collection var5_7 = var3_3;
        ArrayList<Object> var6_8 = new ArrayList<>();
        boolean var7_11 = false;
        Iterator var8_13 = var5_7.iterator();
        while (var8_13.hasNext()) {
            Object var9_14 = var8_13.next();
            if (!(var9_14 instanceof Module)) continue;
            var6_8.add(var9_14);
        }
        var3_3 = (List)var6_8;
        var4_5 = false;
        var5_7 = var3_3;
        boolean var6_9 = false;
        Class622 var7_12 = new Class622();
        var221 = CollectionsKt.sortedWith(var5_7, var7_12).toString();
        this.var2_2 = var221;
        boolean var3_4 = true;
        while (var5_7.add(new AbyssDecoder())) {
            Module var4_6 = (Module) var5_7.iterator();
            Class117 var6_10 = new Class117(var4_6, this);
            if (var3_4) {
                var3_4 = false;
                var6_10.Method288(true);
            }
            this.Field2886.add(var6_10);
        }
    }

    public void Method3579(int n, int n2) {
        Class102.Method1979(null, n, n2);
    }

    public void Method276(int n, int n2, int n3) {
        Class102.Method1981(null, n, n2, n3);
    }

    public void Method277(int n, int n2, int n3, long l) {
        Class102.Method1982(null, n, n2, n3, l);
    }

    public void Method273(char c, int n) {
        Class102.Method1983(null, c, n);
    }

    public void Method3580(int n) {
        Class102.Method1984(null, n);
    }

    public boolean Method3560(int n, int n2) {
        return Class102.Method1985(null, n, n2);
    }
}
