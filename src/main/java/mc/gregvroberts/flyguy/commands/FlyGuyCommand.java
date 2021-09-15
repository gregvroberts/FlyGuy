package mc.gregvroberts.flyguy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyGuyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("flyguy.fly")) {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.AQUA + "You can now fly. Be free!!!");
            }
        }

        return true;
    }
}
