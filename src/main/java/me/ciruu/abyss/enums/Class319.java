package me.ciruu.abyss.enums;

/*
 * Exception performing whole class analysis ignored.
 */
public enum Class319 {
    NONE(0.0f, 0.0f),
    ARROW(1.5f, 0.05f),
    POTION(0.5f, 0.05f),
    EXPERIENCE(0.7f, 0.07f),
    FISHING_ROD(1.5f, 0.04f),
    NORMAL(1.5f, 0.03f);

    public static float Field1970;
    public static float Field1971;

    /*
     * WARNING - void declaration
     */
    private Class319() {
    }

    Class319(float v, float v1) {
    }

    public float getVelocity() {
        return this.Field1970;
    }

    public float getGravity() {
        return this.Field1971;
    }
}
