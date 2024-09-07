package mod.adrenix.nostalgic.mixin.tweak.candy.biome_color_overrides;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import mod.adrenix.nostalgic.helper.candy.block.BiomeColorHelper;
import mod.adrenix.nostalgic.tweak.config.CandyTweak;
import net.minecraft.client.renderer.BiomeColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BiomeColors.class)
public abstract class BiomeColorMixin {
    @ModifyReturnValue(
            method = "getAverageWaterColor",
            at = @At("RETURN")
    )
    private static int nt_biome_color_overrides$water_override(int original) {
        if (CandyTweak.WATER_COLOR_OVERRIDE.get()) {
            return BiomeColorHelper.waterColor;
        }
        return original;
    }

    @ModifyReturnValue(
            method = "getAverageGrassColor",
            at = @At("RETURN")
    )
    private static int nt_biome_color_overrides$grass_override(int original) {
        if (CandyTweak.GRASS_COLOR_OVERRIDE.get()) {
            return BiomeColorHelper.grassColor;
        }
        return original;
    }

    @ModifyReturnValue(
            method = "getAverageFoliageColor",
            at = @At("RETURN")
    )
    private static int nt_biome_color_overrides$foliage_override(int original) {
        if (CandyTweak.FOLIAGE_COLOR_OVERRIDE.get()) {
            return BiomeColorHelper.foliageColor;
        }
        return original;
    }
}
