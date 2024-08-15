package com.plusls.ommc;

import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import top.hendrixshen.magiclib.api.compat.minecraft.resources.ResourceLocationCompat;
import top.hendrixshen.magiclib.api.i18n.I18n;
import top.hendrixshen.magiclib.api.malilib.config.MagicConfigManager;
import top.hendrixshen.magiclib.impl.malilib.config.GlobalConfigManager;
import top.hendrixshen.magiclib.impl.malilib.config.MagicConfigHandler;
import top.hendrixshen.magiclib.util.VersionUtil;

public class SharedConstants {
    @Getter
    private static final String modIdentifier = "@MOD_IDENTIFIER@";
    @Getter
    private static final String modName = "@MOD_NAME@";
    @Getter
    private static final String modVersion = "@MOD_VERSION@";
    @Getter
    private static final String modVersionType = VersionUtil.getVersionType(SharedConstants.modVersion);
    @Getter
    private static final MagicConfigManager configManager = GlobalConfigManager
            .getConfigManager(SharedConstants.getModIdentifier());
    @Getter
    private static final MagicConfigHandler configHandler = new MagicConfigHandler(configManager, 1);
    @Getter
    private static final Logger logger = LogManager.getLogger(SharedConstants.modIdentifier);

    public static @NotNull String getTranslatedModVersionType() {
        return VersionUtil.translateVersionType(SharedConstants.modVersion);
    }

    public static @NotNull ResourceLocation identifier(String path) {
        return ResourceLocationCompat.fromNamespaceAndPath(SharedConstants.getModIdentifier(), path);
    }

    public static String getTranslation(String path) {
        return I18n.tr(SharedConstants.modIdentifier + "." + path);
    }
}
