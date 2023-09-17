package de.vepexlegit.minecraftescfix;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;

@Mod(modid = MinecraftESCFix.MODID, name = MinecraftESCFix.NAME, version = MinecraftESCFix.VERSION)
public class MinecraftESCFix {

    public static Minecraft mc = Minecraft.getMinecraft();

    public MinecraftESCFix() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final String MODID = "minecraftescfix";
    public static final String NAME = "MinecraftESCFix";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent.KeyboardInputEvent.Pre event) {
        if (event.getGui() instanceof GuiScreenServerList && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        }
        if (event.getGui() instanceof GuiScreenAddServer && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        }
        if (event.getGui() instanceof GuiCreateWorld && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiWorldSelection(null));
        }
    }
}
