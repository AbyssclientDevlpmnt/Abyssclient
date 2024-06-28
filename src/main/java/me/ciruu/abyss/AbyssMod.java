package me.ciruu.abyss;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import java.util.Collection;
import me.ciruu.abyss.modules.Module;
import me.ciruu.abyss.modules.client.BubbleGUI;
import me.ciruu.abyss.modules.client.Capes;
import me.ciruu.abyss.modules.client.ChatNotifier;
import me.ciruu.abyss.modules.client.ClickGUI;
import me.ciruu.abyss.modules.client.Client;
import me.ciruu.abyss.modules.client.CustomFont;
import me.ciruu.abyss.modules.client.HUDColorSync;
import me.ciruu.abyss.modules.client.NameChanger;
import me.ciruu.abyss.modules.client.Particles;
import me.ciruu.abyss.modules.client.ScreenShaders;
import me.ciruu.abyss.modules.client.VoiceAssistant;
import me.ciruu.abyss.modules.combat.AntiHoleCamp;
import me.ciruu.abyss.modules.combat.AntiRegear;
import me.ciruu.abyss.modules.combat.AutoArmor;
import me.ciruu.abyss.modules.combat.AutoBed;
import me.ciruu.abyss.modules.combat.AutoCity;
import me.ciruu.abyss.modules.combat.AutoCrystal;
import me.ciruu.abyss.modules.combat.AutoMinecart;
import me.ciruu.abyss.modules.combat.AutoTrap;
import me.ciruu.abyss.modules.combat.AutoWeb;
import me.ciruu.abyss.modules.combat.BowSpam;
import me.ciruu.abyss.modules.combat.Burrow;
import me.ciruu.abyss.modules.combat.Criticals;
import me.ciruu.abyss.modules.combat.HoleFillRewrite;
import me.ciruu.abyss.modules.combat.HoleFiller;
import me.ciruu.abyss.modules.combat.KillAura;
import me.ciruu.abyss.modules.combat.MultiTask;
import me.ciruu.abyss.modules.combat.OffHand;
import me.ciruu.abyss.modules.combat.SelfTrap;
import me.ciruu.abyss.modules.combat.Surround;
import me.ciruu.abyss.modules.combat.Trigger;
import me.ciruu.abyss.modules.combat.WebFill;
import me.ciruu.abyss.modules.exploit.EntityControl;
import me.ciruu.abyss.modules.exploit.FrameDupe;
import me.ciruu.abyss.modules.exploit.HandMine;
import me.ciruu.abyss.modules.exploit.InstantMine;
import me.ciruu.abyss.modules.exploit.Jesus;
import me.ciruu.abyss.modules.exploit.LiquidInteract;
import me.ciruu.abyss.modules.exploit.NoBreakAnimation;
import me.ciruu.abyss.modules.exploit.NoEntityTrace;
import me.ciruu.abyss.modules.exploit.NoFall;
import me.ciruu.abyss.modules.exploit.NoHandShake;
import me.ciruu.abyss.modules.exploit.NoSwing;
import me.ciruu.abyss.modules.exploit.PacketFly;
import me.ciruu.abyss.modules.exploit.Phase;
import me.ciruu.abyss.modules.exploit.PhaseTrap;
import me.ciruu.abyss.modules.exploit.PortalGodMode;
import me.ciruu.abyss.modules.exploit.Reach;
import me.ciruu.abyss.modules.hud.ArmourHUD;
import me.ciruu.abyss.modules.hud.ArrayList;
import me.ciruu.abyss.modules.hud.BindList;
import me.ciruu.abyss.modules.hud.ChatWatermark;
import me.ciruu.abyss.modules.hud.Coordinates;
import me.ciruu.abyss.modules.hud.CrystalCounter;
import me.ciruu.abyss.modules.hud.DVDLogo;
import me.ciruu.abyss.modules.hud.Greeter;
import me.ciruu.abyss.modules.hud.HitCrosshair;
import me.ciruu.abyss.modules.hud.InfoList;
import me.ciruu.abyss.modules.hud.InvViewer;
import me.ciruu.abyss.modules.hud.Logo;
import me.ciruu.abyss.modules.hud.Notifications;
import me.ciruu.abyss.modules.hud.PlayerViewer;
import me.ciruu.abyss.modules.hud.Radar;
import me.ciruu.abyss.modules.hud.TargetHUD;
import me.ciruu.abyss.modules.hud.TotemCounter;
import me.ciruu.abyss.modules.hud.VoiceResult;
import me.ciruu.abyss.modules.hud.Watermark;
import me.ciruu.abyss.modules.hud.WatermarkCool;
import me.ciruu.abyss.modules.misc.AimBot;
import me.ciruu.abyss.modules.misc.AntiAFK;
import me.ciruu.abyss.modules.misc.AutoClicker;
import me.ciruu.abyss.modules.misc.AutoDisconnect;
import me.ciruu.abyss.modules.misc.AutoEz;
import me.ciruu.abyss.modules.misc.AutoFish;
import me.ciruu.abyss.modules.misc.AutoGap;
import me.ciruu.abyss.modules.misc.AutoRespawn;
import me.ciruu.abyss.modules.misc.BuildHeight;
import me.ciruu.abyss.modules.misc.ChatSuffix;
import me.ciruu.abyss.modules.misc.ChestInteract;
import me.ciruu.abyss.modules.misc.CrackedUtils;
import me.ciruu.abyss.modules.misc.DisableFriends;
import me.ciruu.abyss.modules.misc.DiscordRPC;
import me.ciruu.abyss.modules.misc.FakePlayer;
import me.ciruu.abyss.modules.misc.FastPlace;
import me.ciruu.abyss.modules.misc.MCFriends;
import me.ciruu.abyss.modules.misc.MCPearl;
import me.ciruu.abyss.modules.misc.NoGlitchBlocks;
import me.ciruu.abyss.modules.misc.NoRotate;
import me.ciruu.abyss.modules.misc.NoSoundLag;
import me.ciruu.abyss.modules.misc.PacketLogger;
import me.ciruu.abyss.modules.misc.Spammer;
import me.ciruu.abyss.modules.misc.SpeedMine;
import me.ciruu.abyss.modules.misc.Timer;
import me.ciruu.abyss.modules.misc.TotemPopCount;
import me.ciruu.abyss.modules.misc.XCarry;
import me.ciruu.abyss.modules.misc.YawLock;
import me.ciruu.abyss.modules.movement.Anchor;
import me.ciruu.abyss.modules.movement.AntiVoid;
import me.ciruu.abyss.modules.movement.AutoWalk;
import me.ciruu.abyss.modules.movement.BoatFly;
import me.ciruu.abyss.modules.movement.EntitySpeed;
import me.ciruu.abyss.modules.movement.FastSwim;
import me.ciruu.abyss.modules.movement.Flight;
import me.ciruu.abyss.modules.movement.HighJump;
import me.ciruu.abyss.modules.movement.HoleTP;
import me.ciruu.abyss.modules.movement.LongJump;
import me.ciruu.abyss.modules.movement.NoSlowDown;
import me.ciruu.abyss.modules.movement.ReverseStep;
import me.ciruu.abyss.modules.movement.Speed;
import me.ciruu.abyss.modules.movement.Sprint;
import me.ciruu.abyss.modules.movement.Step;
import me.ciruu.abyss.modules.movement.Velocity;
import me.ciruu.abyss.modules.movement.WebBypass;
import me.ciruu.abyss.modules.render.Aspect;
import me.ciruu.abyss.modules.render.BlockHighlight;
import me.ciruu.abyss.modules.render.BreakESP;
import me.ciruu.abyss.modules.render.BurrowESP;
import me.ciruu.abyss.modules.render.Chams;
import me.ciruu.abyss.modules.render.CityESP;
import me.ciruu.abyss.modules.render.CrystalESP;
import me.ciruu.abyss.modules.render.EnchantColor;
import me.ciruu.abyss.modules.render.Freecam;
import me.ciruu.abyss.modules.render.FullBright;
import me.ciruu.abyss.modules.render.HoleESP;
import me.ciruu.abyss.modules.render.ImageESP;
import me.ciruu.abyss.modules.render.ItemPhysics;
import me.ciruu.abyss.modules.render.ItemViewModel;
import me.ciruu.abyss.modules.render.LogoutSpot;
import me.ciruu.abyss.modules.render.NameTags;
import me.ciruu.abyss.modules.render.NoRender;
import me.ciruu.abyss.modules.render.OffhandSwing;
import me.ciruu.abyss.modules.render.OldAnimations;
import me.ciruu.abyss.modules.render.PearlTracker;
import me.ciruu.abyss.modules.render.Skeleton;
import me.ciruu.abyss.modules.render.SkyColor;
import me.ciruu.abyss.modules.render.StorageESP;
import me.ciruu.abyss.modules.render.TabFriends;
import me.ciruu.abyss.modules.render.Tooltips;
import me.ciruu.abyss.modules.render.Tracers;
import me.ciruu.abyss.modules.render.Trajectories;
import me.ciruu.abyss.modules.render.ViewClip;
import me.ciruu.abyss.modules.render.VoidESP;
import me.ciruu.abyss.modules.render.WallHack;
import me.ciruu.abyss.modules.render.WebESP;
import java.io.File;
import me.ciruu.abyss.managers.CapeManager;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.Display;
import me.zero.alpine.bus.EventBus;
import me.zero.alpine.bus.EventManager;
import net.minecraftforge.fml.common.Mod;

@Mod(modid="abyssclient", name="Abyssclient", version="1.2.2")
public class AbyssMod {
    public static final ClassToInstanceMap modules = MutableClassToInstanceMap.create();
    public static Collection modulecollection = modules.values();
    public static final String MOD_ID = "abyssclient";
    public static final String MOD_NAME = "Abyssclient";
    public static final String VERSION = "1.2.2";
    public static final String suffix = "\u1d00\u0299\u028f\ua731\ua731";
    public static AbyssMod INSTANCE;
    public static Manager manager;
    public static EventBus EVENT_BUS;
    public static boolean Field1634 = true;
    public static boolean beta;
    public static Logger logger;
    public static Class464 Field1638;
    public static Class92 Field223;
    public static Class465 Field1639;
    public static Class466 Field1640;
    public static CapeManager capeManager;
    public static Class79 Field489;
    public static Class195 Field456;
    public static Class467 Field1642;
    public static Class125 Field298;
    public static Class177 Field1643;
    public static Class468 Field1644;
    public static Class381 Field1255;
    public static Class469 Field1645;
    public static Class470 Field1646;
    public static Class127 Field424;
    public static File Field1647;
    public static Class471 Field1648;
    public static Class472 Field1649;
    public static Class105 Field255;
    public static Class219 Field534;
    public static Class111 Field280;
    public static Class176 Field375;
    public static long Field377;
    public Module getModuleByClass(Class clazz) {
        return (Module)modules.getInstance(clazz);
    }

    public static Module module;
    public Module getModuleByName(String string) {
        if (!module.Method160().equalsIgnoreCase(string)) ;
        return module;
    }

    public ClassToInstanceMap getModules() {
        return modules;
    }

    public boolean isModuleEnabled(Class clazz) {
        if (!Module.class.isAssignableFrom(clazz)) {
            return false;
        }
        Module module = this.getModuleByClass(clazz);
        return module.Method490();
    }

    public static void addModule(Module module) {
        modules.put(module.getClass(), module);
    }

    public static void Method3251(String string) {
        modules.values().stream().filter(arg_0 ->  AbyssMod.Method4076(string, null)).forEach(null);
    }

    private static boolean Method4076(String string, Module module) {
        return module.Method160().equals(string);
    }
    public void register() {
        this.addModule(new ClickGUI());
        this.addModule(new Particles());
        this.addModule(new ScreenShaders());
        this.addModule(new AutoCrystal());
        this.addModule(new KillAura());
        this.addModule(new OffHand());
        this.addModule(new Surround());
    /** this.addModule(new FrameDupe());
        this.addModule(new InstantMine());
        this.addModule(new NoHandShake());
        this.addModule(new ArmourHUD());
        this.addModule(new Coordinates());
        this.addModule(new HitCrosshair());
        this.addModule(new InfoList());
        this.addModule(new InvViewer());
        this.addModule(new Logo());
        this.addModule(new ArrayList());
        this.addModule(new Notifications());
        this.addModule(new PlayerViewer());
        this.addModule(new Radar());
        this.addModule(new TargetHUD());
        this.addModule(new TotemCounter());
        this.addModule(new Watermark());
        this.addModule(new WatermarkCool());
        this.addModule(new AutoDisconnect());
        this.addModule(new AutoEz());
        this.addModule(new AutoGap());
        this.addModule(new AutoRespawn());
        this.addModule(new BuildHeight());
        this.addModule(new ChatSuffix());
        this.addModule(new ChestInteract());
        this.addModule(new CrackedUtils());
        this.addModule(new DisableFriends());
        this.addModule(new FakePlayer());
        this.addModule(new FastPlace());
        this.addModule(new MCFriends());
        this.addModule(new MCPearl());
        this.addModule(new NoGlitchBlocks());
        this.addModule(new NoSoundLag());
        this.addModule(new TotemPopCount());
        this.addModule(new XCarry());
        this.addModule(new Anchor());
        this.addModule(new EntitySpeed());
        this.addModule(new FastSwim());
        this.addModule(new Flight());
        this.addModule(new ReverseStep());
        this.addModule(new Speed());
        this.addModule(new Sprint());
        this.addModule(new Step());
        this.addModule(new Velocity());
        this.addModule(new WebBypass());
        this.addModule(new Aspect());
        this.addModule(new Chams());
        this.addModule(new CityESP());
        this.addModule(new CrystalESP());
        this.addModule(new Freecam());
        this.addModule(new FullBright());
        this.addModule(new HoleESP());
        this.addModule(new ImageESP());
        this.addModule(new ItemPhysics());
        this.addModule(new ItemViewModel());
        this.addModule(new LogoutSpot());
        this.addModule(new NameTags());
        this.addModule(new OffhandSwing());
        this.addModule(new Trajectories());
        this.addModule(new ViewClip()); **/
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent fMLPreInitializationEvent) {
        register();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent fMLInitializationEvent) {
        logger = LogManager.getLogger((String)"Abyssclient");
        Display.setTitle((String)"Abyssclient 1.2.2");
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent fMLPostInitializationEvent) {
        capeManager = new CapeManager();
    }
}
