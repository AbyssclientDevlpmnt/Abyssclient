package me.ciruu.abyss.enums;

import net.minecraft.util.math.BlockPos;

/*
 * Exception performing whole class analysis ignored.
 */
public enum Class107 {
    DOWN(0, -1, 0),
    UP(0, 1, 0),
    NORTH(0, 0, -1),
    EAST(1, 0, 0),
    SOUTH(0, 0, 1),
    WEST(-1, 0, 0);

    public static int Field262;
    public static int Field263;
    public static int Field264;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Class107(int n3) {
    }

    Class107(int i, int i1, int i2) {
    }

    public BlockPos offset(BlockPos blockPos) {
        return blockPos.add(this.Field262, this.Field263, this.Field264);
    }

    public BlockPos forward(BlockPos blockPos, int n) {
        return blockPos.add(this.Field262 * n, 0, this.Field264 * n);
    }

    public BlockPos backward(BlockPos blockPos, int n) {
        return blockPos.add(-this.Field262 * n, 0, -this.Field264 * n);
    }

    public BlockPos left(BlockPos blockPos, int n) {
        return blockPos.add(this.Field264 * n, 0, -this.Field262 * n);
    }

    public BlockPos right(BlockPos blockPos, int n) {
        return blockPos.add(-this.Field264 * n, 0, this.Field262 * n);
    }
}
