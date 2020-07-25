package ml.govnoed.MinePaint;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PaintCommand implements CommandExecutor {

    private Paint plugin;
    public PaintCommand(Paint plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only player can send this command.");
            return true;
        }
        Player player = (Player) sender;
        if (plugin.hasPainters()) {
            if (plugin.getPainters().contains(player)) {
                plugin.removePainter(player);
                player.sendMessage("You are no longer painter!");
                return true;
            }
        }
        plugin.addPainter(player);
        player.sendMessage("You can now paint!");
        return false;
    }


}