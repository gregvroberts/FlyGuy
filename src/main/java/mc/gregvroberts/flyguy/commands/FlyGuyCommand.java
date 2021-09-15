package mc.gregvroberts.flyguy.commands;

import mc.gregvroberts.flyguy.FlyGuy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyGuyCommand implements CommandExecutor {

    private FlyGuy plugin;
    // Used to track which players are currently allowed to fly.
    private ArrayList<Player> listOfFlyingPlayers = new ArrayList<>();

    public FlyGuyCommand(FlyGuy plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                FlyMethod(player);

            } else if (args.length == 1){

                if (player.hasPermission("flyguy.others")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    FlyMethod(target);
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to make other players fly");
                }
            }
        }
        return true;
    }


    private void FlyMethod(Player player) {
        if (player.hasPermission("flyguy.fly")) {
            if (!listOfFlyingPlayers.contains(player)) {
                listOfFlyingPlayers.add(player);
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("on-message")));
            } else if (listOfFlyingPlayers.contains(player)) {
                listOfFlyingPlayers.remove(player);
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("off-message")));
            }
        }
    }
}


