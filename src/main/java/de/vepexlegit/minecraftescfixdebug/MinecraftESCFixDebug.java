package de.vepexlegit.minecraftescfixdebug;

import de.vepexlegit.minecraftescfixdebug.commands.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.multiplayer.*;
import net.minecraftforge.client.*;
import net.minecraftforge.client.event.*;
import net.minecraftforge.common.*;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.Mod.*;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.eventhandler.*;
import org.lwjgl.input.*;

@Mod(modid = "minecraftescfixdebug", version = "1.0")
public class MinecraftESCFixDebug {
    private static final Minecraft mc = Minecraft.getMinecraft();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ClientCommandHandler.instance.registerCommand(new MinecraftESCFixCommand());
    }

    @SubscribeEvent
    public void onGuiOpen(GuiScreenEvent.KeyboardInputEvent.Pre event) {
        if (MinecraftESCFix.INSTANCE.isEnabled()) {
            if (Keyboard.getEventKeyState() && Keyboard.getEventKey() == Keyboard.KEY_ESCAPE) {
                if (mc.currentScreen instanceof GuiScreenServerList || mc.currentScreen instanceof GuiScreenAddServer || mc.currentScreen instanceof GuiConnecting) {
                    mc.displayGuiScreen(new GuiMultiplayer(null));
                } else if (mc.currentScreen instanceof GuiCreateWorld) {
                    mc.displayGuiScreen(new GuiSelectWorld(null));
                } else if (mc.currentScreen instanceof GuiScreenRealmsProxy) {
                    mc.displayGuiScreen(new GuiMainMenu());
                }
            }
        }
    }
}
