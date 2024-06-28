/*    */ package com.cout970.rocketdrm;
/*    */ 
/*    */ import com.sun.jna.Native;
/*    */ import java.io.File;
/*    */ import java.lang.invoke.CallSite;
/*    */ import java.lang.invoke.MethodHandles;
/*    */ import java.lang.invoke.MethodType;
/*    */ import java.lang.reflect.Field;
import java.util.Map;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JniUtil
/*    */ {
/*    */   static {
/*    */     try {
/* 21 */       File file = Native.extractFromResourcePath("jna_rocket_drm");
/* 22 */       System.load(file.getAbsolutePath());
/* 23 */     } catch (Exception e) {
/* 24 */       e.printStackTrace();
/* 25 */       hardCrash();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void hardCrash() {
/*    */     try {
/* 62 */       Class<?> clazz = Class.forName("sun.misc.Unsafe");
/* 63 */       Field theUnsafe = clazz.getDeclaredField("theUnsafe");
/* 64 */       theUnsafe.setAccessible(true);
/* 65 */       Object unsafe = theUnsafe.get(null);
/* 66 */       clazz.getDeclaredMethod("putAddress", new Class[] { long.class, long.class }).invoke(unsafe, new Object[] { Long.valueOf(0L), Long.valueOf(0L) });
/* 67 */     } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException|NoSuchFieldException e) {
/* 68 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static native CallSite decodeInvoke(MethodHandles.Lookup paramLookup, String paramString, MethodType paramMethodType);
/*    */   
/*    */   public static native long decodeLong(String paramString, long paramLong1, long paramLong2);
/*    */   
/*    */   public static native int decodeInt(String paramString, int paramInt1, int paramInt2);
/*    */   
/*    */   public static native String decodeString(String paramString);
/*    */   
/*    */   public static native byte[] onMixinLoad(String paramString);
/*    */   
/*    */   public static native void onClassLoad(String paramString);
/*    */   
/*    */   public static native void onGameInit();
/*    */   
/*    */   public static native void onPostInit(String paramString);
/*    */   
/*    */   public static native void onInit();

    public static Map decodeInvoke(String s, Iterable iterable) {
        return null;
    }

    public static Object decodeInvoke(String s, Iterable iterable, int n) {
        return null;
    }

    public static Object decodeInvoke(String s, String string, String string2, boolean bl, int n, Object object) {
        return null;
    }
    /*    */
}
