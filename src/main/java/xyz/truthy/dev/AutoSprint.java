package xyz.truthy.dev;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = AutoSprint.MODID, version = AutoSprint.VERSION)
public class AutoSprint {
  public static final String MODID = "autosprint";
  public static final String VERSION = "1.0.0";

  @Mod.EventHandler
  public void init(FMLInitializationEvent event) {
    MinecraftForge.EVENT_BUS.register(this);
  }

  @SubscribeEvent
  public void onTick(TickEvent.ClientTickEvent e) {
    Minecraft mc = Minecraft.getMinecraft();
    if (mc.gameSettings.keyBindForward.isKeyDown() && !mc.thePlayer.isCollidedHorizontally) {
      mc.thePlayer.setSprinting(true);
    }
  }
}
