package ch.kevinberger.gitsync;

import ch.kevinberger.gitsync.commands.SaveCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class GitSync extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("save-to-git").setExecutor(new SaveCommand());
    }
}
