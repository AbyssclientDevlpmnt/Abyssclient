/*    */ package com.cout970.rocketdrm;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.function.Consumer;
/*    */ import javax.swing.JOptionPane;
/*    */ import net.minecraft.launchwrapper.Launch;
/*    */ import org.apache.commons.lang3.text.WordUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ErrorHandler
/*    */ {
/*    */   public static void showError(String error) {
/* 18 */     if (error == null) {
/* 19 */       error = "Internal error";
/*    */     }
/*    */     
/* 22 */     String info = WordUtils.wrap("[Error] " + error, 80);
/* 23 */     String msg = "================================================================================\nThe client has encountered and error and will be closed.\n\n" + info + "\n\nIf you believe this is a bug contact the developers.\n================================================================================\n";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 29 */     System.err.println("\n" + msg);
/* 30 */     JOptionPane.showMessageDialog(null, msg);
/*    */     
/* 32 */     Map<String, Object> drm_inject = (Map<String, Object>)Launch.blackboard.get("DRM-InjectData");
/* 33 */     List<Consumer<String>> handlers = (List<Consumer<String>>)drm_inject.get("error-handlers");
/* 34 */     if (handlers != null) {
/* 35 */       for (Consumer<String> handler : handlers) {
/*    */         try {
/* 37 */           handler.accept(error);
/* 38 */         } catch (Throwable e) {
/* 39 */           e.printStackTrace();
/*    */         } 
/*    */       } 
/*    */     }
/* 43 */     JniUtil.hardCrash();
/*    */   }
/*    */   
/*    */   public static void showCrash(Thread th, Throwable exception) {
/* 47 */     Throwable original = exception;
/* 48 */     while (original.getCause() != null) {
/* 49 */       original = original.getCause();
/*    */     }
/* 51 */     exception.printStackTrace();
/*    */     
/* 53 */     String msg = original.getMessage();
/* 54 */     if (msg == null) {
/* 55 */       ByteArrayOutputStream stream = new ByteArrayOutputStream();
/* 56 */       original.printStackTrace(new PrintStream(stream));
/* 57 */       msg = stream.toString().split("\n", 2)[0];
/*    */     } 
/*    */     
/* 60 */     showError(th + " " + msg);
/*    */   }
/*    */ }
