package de.vepexlegit.minecraftescfixdebug;

public enum MinecraftESCFix {
    INSTANCE;

    private boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
