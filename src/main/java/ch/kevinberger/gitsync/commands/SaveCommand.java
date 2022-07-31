package ch.kevinberger.gitsync.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SaveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {

            Bukkit.broadcastMessage("[GitSync] Sync the game with git (this may take a moment!)");
            executeCommand("git add .");
            executeCommand("git commit -m saved");
            executeCommand("git push");
            Bukkit.broadcastMessage("[GitSync] " + ChatColor.DARK_GREEN + "Synced the game with git");

        } catch (IOException e) {
            e.printStackTrace();
            Bukkit.broadcastMessage("[GitSync] " + ChatColor.DARK_RED + "Something failed");
        }

        return true;
    }

    private void executeCommand(String command) throws IOException {
        InputStream is = Runtime.getRuntime().exec(command).getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader buff = new BufferedReader(isr);

        String line;
        while ((line = buff.readLine()) != null) System.out.println(line);
    }
}
