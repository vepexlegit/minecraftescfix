package de.vepexlegit.minecraftescfix;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import cpw.mods.fml.common.Mod;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

@Mod(modid = MinecraftESCFix.MODID, version = MinecraftESCFix.VERSION)
public class MinecraftESCFix {

    public static Minecraft mc = Minecraft.getMinecraft();

    public MinecraftESCFix() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static final String MODID = "minecraftescfix";
    public static final String VERSION = "1.2";

    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent event) {
        if (event.gui instanceof GuiScreenServerList && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        } else if (event.gui instanceof GuiScreenAddServer && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        } else if (event.gui instanceof GuiCreateWorld && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiSelectWorld(null));
        } else if (event.gui instanceof GuiScreenRealmsProxy && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMainMenu());
        } else if (event.gui instanceof GuiConnecting && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        }
    }
}
