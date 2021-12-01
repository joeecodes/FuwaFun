package me.joehosten.fuwafun;

import dev.negativekb.api.plugin.BasePlugin;
import lombok.Getter;
import lombok.Setter;

public final class FuwaFun extends BasePlugin {

    @Getter
    @Setter
    private static FuwaFun instance;

    @Override
    public void onEnable() {
        setInstance(this);

        registerListeners(new JoinListener());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
