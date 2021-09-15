package mc.gregvroberts.flyguy.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyGuyCommand implements CommandExecutor {

    // Used to track which players are currently allowed to fly.
    private ArrayList<Player> listOfFlyingPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("flyguy.fly")) {
                if (listOfFlyingPlayers.contains(player)) {
                    listOfFlyingPlayers.remove(player);
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.AQUA + "You cannot fly anymore.");
                } else if (!listOfFlyingPlayers.contains(player)) {
                    listOfFlyingPlayers.add(player);
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.AQUA + "You can now fly. Be free!!!");
                }
            }
        }
        return true;
    }
}
