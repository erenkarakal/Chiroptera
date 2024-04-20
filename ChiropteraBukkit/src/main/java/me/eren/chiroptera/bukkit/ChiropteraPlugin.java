package me.eren.chiroptera.bukkit;

import me.eren.chiroptera.core.Chiroptera;
import me.eren.chiroptera.core.ChiropteraClient;
import me.eren.chiroptera.core.ChiropteraServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.net.InetSocketAddress;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public final class ChiropteraPlugin extends JavaPlugin {

    private static ChiropteraPlugin instance;
    private static boolean isServer;


    @Override
    public void onEnable() {
        instance = this;
        Logger logger = Chiroptera.getLogger();
        saveDefaultConfig();

        isServer = getConfig().getString("type", "server").equals("server");
        String secret = getConfig().getString("secret", "123abc");
        int capacity = getConfig().getInt("capacity", 1024);
        int port = getConfig().getInt("port", 53_415);

        if (secret.equals("123abc")) {
            logger.warning("");
            logger.warning("Using default secret key!");
            logger.warning("Please change your secret in the config and restart the server. This is REALLY important.");
            logger.warning("");
        }

        new Thread(() -> {
            if (isServer) {
                logger.info("Starting a listener on port " + port + "...");
                List<String> whitelistedIps = getConfig().getStringList("whitelisted-ips");
                if (!whitelistedIps.isEmpty()) ChiropteraServer.whitelistedIps.addAll(whitelistedIps);
                ChiropteraServer.listen(port, capacity, secret);
            } else {
                String host = getConfig().getString("host", "0.0.0.0");
                String clientIdentifier = getConfig().getString("client-identifier", UUID.randomUUID().toString());
                InetSocketAddress address = new InetSocketAddress(host, port);
                ChiropteraClient.connect(address, capacity, secret, clientIdentifier);
            }
        }).start();

    }

    @Override
    public void onDisable() {
        ChiropteraServer.close();
        ChiropteraClient.disconnect();
    }


    public static ChiropteraPlugin getInstance() {
        return instance;
    }

    /**
     * @return true if the current server is a ChiropteraServer
     */
    public static boolean isServer() {
        return isServer;
    }

}