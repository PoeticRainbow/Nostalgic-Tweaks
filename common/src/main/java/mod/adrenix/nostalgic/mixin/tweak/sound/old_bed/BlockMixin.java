package mod.adrenix.nostalgic.mixin.tweak.sound.old_bed;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import mod.adrenix.nostalgic.tweak.config.SoundTweak;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Block.class)
public abstract class BlockMixin
{
    /**
     * Changes the sound type of bed blocks back to stone.
     */
    @ModifyReturnValue(
        method = "getSoundType",
        at = @At("RETURN")
    )
    private SoundType nt_old_bed$modifyBedSoundType(SoundType soundType, BlockState state)
    {
        if (state == null)
            return soundType;

        if (SoundTweak.OLD_BED.get() && state.getBlock() instanceof BedBlock)
            return SoundType.STONE;

        return soundType;
    }
}
