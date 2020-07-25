package ml.govnoed.MinePaint;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ColorPicker implements Listener{
	
	private Paint plugin;
	public ColorPicker(Paint plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void pickColor(PlayerInteractEvent event) {
		if (!event.hasItem()) {
			return;
		}
		if (!(event.getItem().getType() == Material.PAINTING)) {
			return;
		}
		event.setCancelled(true);
		event.getPlayer().openInventory(plugin.inv);
		
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent event) {
		if (!event.getInventory().equals(plugin.inv))
			return;
		if (event.getCurrentItem() == null) return;
		if (event.getCurrentItem().getItemMeta() == null) return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
		
		event.setCancelled(true);
		
		Player player = (Player) event.getWhoClicked();
		ItemStack wool = new ItemStack(event.getCurrentItem());
		player.getInventory().addItem(wool);
	}	
}
