package org.animey.skins;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public final class Skins extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // TODO: Command opens GUI that allows switching cape textures
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info("Skins plugin on.");
    }

    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent e){
        try{
            String[] textures = getTextures(e.getPlayer().getName());
            applyTextures(e.getPlayer(), textures);
        } catch (IOException err) {
            this.getLogger().info("failed to update skin for player "+ e.getPlayer().getName());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Skins plugin off.");
    }

    private String[] getTextures(String playerName) throws IOException {
        URL url_0 = new URL("https://api.mojang.com/users/profiles/minecraft/" + playerName);
        InputStreamReader reader_0 = new InputStreamReader(url_0.openStream());
        String uuid = JsonParser.parseReader(reader_0).getAsJsonObject().get("id").getAsString();

        URL url_1 = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");
        InputStreamReader reader_1 = new InputStreamReader(url_1.openStream());
        JsonObject textureProperty =JsonParser.parseReader(reader_1).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();
        String texture = textureProperty.get("value").getAsString();
        String signature = textureProperty.get("signature").getAsString();

        return new String[] {texture, signature};
    }
    private void applyTextures(Player player, String[] textures) { // Cape and skin
        PlayerProfile playerProfile = player.getPlayerProfile();
        playerProfile.setProperty(new ProfileProperty("textures", textures[0], textures[1]));
        player.setPlayerProfile(playerProfile);
    }
}
