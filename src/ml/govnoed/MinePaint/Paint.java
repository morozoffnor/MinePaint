package ml.govnoed.MinePaint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Paint extends JavaPlugin {

    private List<Player> painters = new ArrayList<Player>();
    private Set<Material> wool = new HashSet<Material>();
    public Inventory inv;

    @Override
    public void onEnable() {
        this.getCommand("paint").setExecutor(new PaintCommand(this));
        this.getServer().getPluginManager().registerEvents(new PlayerInterract(this), this);
        this.getServer().getPluginManager().registerEvents(new ColorPicker(this), this);
        this.getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
        setWool();
        createColorPickerInv();
    }

    @Override
    public void onDisable() {

    }

    public void addPainter(Player player) {
        painters.add(player);
    }

    public void removePainter(Player player) {
        painters.remove(player);
    }

    public List<Player> getPainters() {
        return painters;
    }

    public boolean hasPainters() {
        if (painters.isEmpty())
            return false;
        return true;
    }
    
    public void setWool() {
    	wool.add(Material.WHITE_WOOL);
    	wool.add(Material.ORANGE_WOOL);
    	wool.add(Material.MAGENTA_WOOL);
    	wool.add(Material.LIGHT_BLUE_WOOL);
    	wool.add(Material.YELLOW_WOOL);
    	wool.add(Material.LIME_WOOL);
    	wool.add(Material.PINK_WOOL);
    	wool.add(Material.GRAY_WOOL);
    	wool.add(Material.LIGHT_GRAY_WOOL);
    	wool.add(Material.CYAN_WOOL);
    	wool.add(Material.PURPLE_WOOL);
    	wool.add(Material.BLUE_WOOL);
    	wool.add(Material.BROWN_WOOL);
    	wool.add(Material.GREEN_WOOL);
    	wool.add(Material.RED_WOOL);
    	wool.add(Material.BLACK_WOOL);
    }
    
    public Set<Material> getWool() {
    	return wool;
    }
    
    public void createColorPickerInv() {
    	inv = Bukkit.createInventory(null, 18, "Pick color");
    	
    	ItemStack item = new ItemStack(Material.WHITE_WOOL);
    	ItemMeta meta = item.getItemMeta();
    	
    	// white
    	meta.setDisplayName(ChatColor.BOLD + "White");
    	List<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GRAY + "Нажмите, чтобы выбрать");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(0, item);
		
		// orange
		item.setType(Material.ORANGE_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Orange");
		item.setItemMeta(meta);
		inv.setItem(1, item);
		
		// magenta
		item.setType(Material.MAGENTA_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Magenta");
		item.setItemMeta(meta);
		inv.setItem(2, item);

		// light blue
		item.setType(Material.LIGHT_BLUE_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Light Blue");
		item.setItemMeta(meta);
		inv.setItem(3, item);

		// yellow
		item.setType(Material.YELLOW_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Yellow");
		item.setItemMeta(meta);
		inv.setItem(4, item);

		// lime
		item.setType(Material.LIME_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Lime");
		item.setItemMeta(meta);
		inv.setItem(5, item);

		// pink
		item.setType(Material.PINK_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Pink");
		item.setItemMeta(meta);
		inv.setItem(6, item);

		// gray
		item.setType(Material.GRAY_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Gray");
		item.setItemMeta(meta);
		inv.setItem(7, item);

		// light gray
		item.setType(Material.LIGHT_GRAY_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Light Gray");
		item.setItemMeta(meta);
		inv.setItem(8, item);

		// cyan
		item.setType(Material.CYAN_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Cyan");
		item.setItemMeta(meta);
		inv.setItem(9, item);

		// purple
		item.setType(Material.PURPLE_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Purple");
		item.setItemMeta(meta);
		inv.setItem(10, item);

		// blue
		item.setType(Material.BLUE_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Blue");
		item.setItemMeta(meta);
		inv.setItem(11, item);

		// brown
		item.setType(Material.BROWN_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Brown");
		item.setItemMeta(meta);
		inv.setItem(12, item);

		// green
		item.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Green");
		item.setItemMeta(meta);
		inv.setItem(13, item);

		// red
		item.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Red");
		item.setItemMeta(meta);
		inv.setItem(14, item);

		// black
		item.setType(Material.BLACK_WOOL);
		meta.setDisplayName(ChatColor.BOLD + "Black");
		item.setItemMeta(meta);
		inv.setItem(15, item);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

}
