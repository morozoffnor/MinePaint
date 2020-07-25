package ml.govnoed.MinePaint;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class PlayerInterract implements Listener {
	
	// canvas cords
	public int woolX1 = 41;
	public int woolX2 = 5;
	public int woolY1 = 6;
	public int woolY2 = 21;
	
	public int colorsY1 = 11;
	public int colorsY2 = 10;
	public int colorsZ1 = 66;
	public int colorsZ2 = 73;
	
	
    private Paint plugin;
    public PlayerInterract(Paint plugin) {
        this.plugin = plugin;
    }
    
    
    // canvas
    @EventHandler
    public void onPaint(PlayerInteractEvent event) {
        if (!event.hasItem())
            return;
        if (!event.getItem().getType().isBlock())
            return;
        if (!plugin.hasPainters())
            return;
        if (!plugin.getPainters().contains(event.getPlayer()))
            return;
        if (event.getPlayer().rayTraceBlocks(45) == null)
            return;
        if (!(plugin.getWool().contains(event.getItem().getType())))
        	return;

        event.setCancelled(true);
        Block block = event.getPlayer().rayTraceBlocks(45).getHitBlock();
        if (!(block.getX() <= woolX1 && block.getX() >= woolX2)) {
        	return;
        }
        if (!(block.getY() >= woolY1 && block.getY() <= woolY2)) {
        	return;
        }
        if (!(block.getZ() == 94)) {
        	return;
        }
        if (plugin.getWool().contains(block.getType())) {
        	block.setType(event.getItem().getType());
            return;
        }
    }
    
    
    // add/remove painter via pressure plates
    @EventHandler
    public void onPressurePlate(PlayerInteractEvent event) {
    	if (event.getAction() == Action.PHYSICAL) {
    		Location loc = event.getPlayer().getLocation();
    		Block block = loc.getBlock();
    		if (block.getType() == Material.BIRCH_PRESSURE_PLATE) {
    			if (plugin.getPainters().contains(event.getPlayer())) {
    				return;
    			}
    			plugin.addPainter(event.getPlayer());
    			
    			ItemStack item = new ItemStack(Material.PAINTING);
    			ItemMeta meta = item.getItemMeta();
    			meta.setDisplayName(ChatColor.BOLD + "Color Picker");
    			List<String> lore = new ArrayList<String>();
    			lore.add("");
    			lore.add(ChatColor.ITALIC + "Now you're like Bob Ross!");
    			meta.setLore(lore);
    			meta.addEnchant(Enchantment.PROTECTION_FALL, 1, true);
    			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    			meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
    			meta.setUnbreakable(true);
    			item.setItemMeta(meta);
    			
    			event.getPlayer().getInventory().setItem(0, item);
    			event.getPlayer().sendMessage("You are painter!");
    		}
    		if (block.getType() == Material.JUNGLE_PRESSURE_PLATE) {
    			event.getPlayer().getInventory().clear();
    			if (plugin.getPainters().contains(event.getPlayer())) {
    				plugin.removePainter(event.getPlayer());
    				event.getPlayer().sendMessage("You are no longer painter!");
    				event.getPlayer().getInventory().clear();
    				return;
    			}
    			return;
    		}
    	}
    }
    

}
