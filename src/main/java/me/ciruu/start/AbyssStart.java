package me.ciruu.start;

import me.ciruu.abyss.DRM;
import me.ciruu.abyss.AbyssMod;
import java.lang.String;
import net.minecraft.client.main.Main;
import me.ciruu.abyss.Class488;

@Class488
public class AbyssStart {
    public void AbyssStart() {
    }

    public static void main(String[] args) {
        Main main = new Main();
        if (AbyssMod.INSTANCE.equals(new AbyssMod())
                == true && DRM.getToken().equals(new Main())) {
            new AbyssMod();
            new Main();
        }
    }
}

