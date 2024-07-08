package me.ciruu.abyss.enums;

/*
 * Exception performing whole class analysis ignored.
 */
public enum Class11 {
    COMBAT("Combat", -65536),
    EXPLOIT("Exploit", -65536),
    MISC("Misc", -65536),
    MOVEMENT("Movement", -65536),
    RENDER("Render", -65536),
    HUD("Hud", -65536),
    CLIENT("Client", -65536);

    public static String Field3224;
    public static int Field3225;

    /*
     * WARNING - void declaration
     */

    public Class11(String combat, int i) {
    }

    public int getColour() {
        return this.Field3225;
    }

    public String toString() {
        return this.Field3224;
    }
}
