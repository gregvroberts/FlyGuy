package mc.gregvroberts.flyguy;

import mc.gregvroberts.flyguy.commands.FlyGuyCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlyGuy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("fly").setExecutor(new FlyGuyCommand());

    }
}
