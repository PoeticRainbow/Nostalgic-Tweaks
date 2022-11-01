package mod.adrenix.nostalgic.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

/**
 * Use this API to bypass overrides made to levels.
 * This class will be kept server safe.
 */
public abstract class NostalgicLevel
{
    /**
     * Get the vanilla brightness value from the provided light layer and block position.
     *
     * Only the client-side level instance returns modified sky/block light values. If your mod is experiencing
     * client-side rendering issues due to incorrect light values, then use the helper method below to retrieve the
     * default vanilla light layer value at the given block position.
     *
     * @param level A level instance.
     * @param lightLayer The light layer to retrieve data from.
     * @param blockPos A block position to retrieve data from.
     * @return A vanilla brightness value (0-15)
     */
    public static int getVanillaBrightness(Level level, LightLayer lightLayer, BlockPos blockPos)
    {
        return level.getLightEngine().getLayerListener(lightLayer).getLightValue(blockPos);
    }
}
