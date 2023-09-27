package de.vepexlegit.minecraftescfix;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = MinecraftESCFix.MODID, name = MinecraftESCFix.NAME, version = MinecraftESCFix.VERSION)
public class MinecraftESCFix {

    public static Minecraft mc = Minecraft.getMinecraft();

    public static final String MODID = "minecraftescfix";
    public static final String NAME = "MinecraftESCFix";
    public static final String VERSION = "1.2";

    public MinecraftESCFix() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent.KeyboardInputEvent.Pre event) {
        if (event.getGui() instanceof GuiScreenServerList && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        } else if (event.getGui() instanceof GuiScreenAddServer && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        } else if (event.getGui() instanceof GuiCreateWorld && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiWorldSelection(null));
        } else if (event.getGui() instanceof GuiScreenRealmsProxy && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMainMenu());
        } else if (event.getGui() instanceof GuiConnecting && Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
            mc.displayGuiScreen(new GuiMultiplayer(null));
        }
    }
}
