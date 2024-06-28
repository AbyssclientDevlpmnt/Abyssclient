/*    */ package com.cout970.rocketdrm;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
/*    */ import java.net.URLClassLoader;
/*    */ import java.util.Map;
/*    */ import net.minecraft.launchwrapper.Launch;
/*    */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReplaceClassLoader
/*    */   extends URLClassLoader
/*    */ {
/*    */   private final Map<String, Class<?>> cachedClasses;
/*    */   
/*    */   private ReplaceClassLoader(URLClassLoader original, Map<String, Class<?>> cachedClasses) {
/* 18 */     super(original.getURLs(), original);
/* 19 */     this.cachedClasses = cachedClasses;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> loadClass(String name) throws ClassNotFoundException {
/* 25 */     if (name.startsWith("com.cout970.rocketdrm.")) {
/* 26 */       return super.loadClass(name);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 32 */     JniUtil.onClassLoad(name);
/*    */     
/* 34 */     if (this.cachedClasses.containsKey(name)) {
/* 35 */       return this.cachedClasses.get(name);
/*    */     }
/*    */ 
/*    */     
/* 39 */     return super.loadClass(name);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static byte[] onMixinLoad(String name) {
/*    */     try {
/* 47 */       Class<?> clazz = Class.forName("com.cout970.rocketdrm.JniUtil", true, (ClassLoader)Launch.classLoader);
/* 48 */       Method onMixinLoad = clazz.getDeclaredMethod("onMixinLoad", new Class[] { String.class });
/* 49 */       onMixinLoad.setAccessible(true);
/* 50 */       Object result = onMixinLoad.invoke(null, new Object[] { name });
/* 51 */       return (byte[])result;
/* 52 */     } catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException e) {
/* 53 */       e.printStackTrace();
/* 54 */       throw new IllegalStateException(e);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void inject(LaunchClassLoader loader) {
/*    */     try {
/* 60 */       Field parent = LaunchClassLoader.class.getDeclaredField("parent");
/* 61 */       parent.setAccessible(true);
/* 62 */       URLClassLoader original = (URLClassLoader)parent.get(loader);
/*    */       
/* 64 */       Field cache = LaunchClassLoader.class.getDeclaredField("cachedClasses");
/* 65 */       cache.setAccessible(true);
/*    */       
/* 67 */       Map<String, Class<?>> cachedClasses = (Map<String, Class<?>>)cache.get(loader);
/*    */       
/* 69 */       ReplaceClassLoader newLoader = new ReplaceClassLoader(original, cachedClasses);
/* 70 */       parent.set(loader, newLoader);
/* 71 */     } catch (NoSuchFieldException|IllegalAccessException e) {
/* 72 */       e.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }
