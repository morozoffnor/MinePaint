package ml.govnoed.MinePaint;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import net.md_5.bungee.api.ChatColor;

public class DeathEvent implements Listener{
	
	private Paint plugin;
	public DeathEvent(Paint plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		if(plugin.getPainters().contains(event.getEntity().getPlayer())) {
			plugin.removePainter(event.getEntity().getPlayer());
			event.getEntity().getPlayer().sendMessage(ChatColor.ITALIC + "You are dead somehow... Well, it looks like you are not a painter anymore...");
			event.getEntity().getPlayer().sendMessage("");
		}
	}
	
}
