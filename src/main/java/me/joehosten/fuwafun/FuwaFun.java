package me.joehosten.fuwafun;

import dev.negativekb.api.plugin.BasePlugin;
import lombok.Getter;
import lombok.Setter;
import me.joehosten.fuwafun.commands.CommandPing;
import me.joehosten.fuwafun.listeners.JoinListener;

public final class FuwaFun extends BasePlugin {

    @Getter
    @Setter
    private static FuwaFun instance;

    @Override
    public void onEnable() {
        setInstance(this);

        registerListeners(new JoinListener());

        registerCommands(new CommandPing());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
