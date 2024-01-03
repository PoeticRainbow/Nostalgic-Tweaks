package mod.adrenix.nostalgic.mixin.tweak.candy.fix_ambient_occlusion;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import mod.adrenix.nostalgic.tweak.config.CandyTweak;
import mod.adrenix.nostalgic.tweak.config.ModTweak;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin
{
    /**
     * Tricks the shade calculator into thinking that a block is full-sized so that ambient occlusion can be properly
     * applied.
     */
    @ModifyExpressionValue(
        method = "getShadeBrightness",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/level/block/state/BlockState;isCollisionShapeFullBlock(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Z"
        )
    )
    private boolean NT$isCollisionShapeFullBlock(boolean isCollisionShapeFullBlock, BlockState state)
    {
        if (!CandyTweak.AMBIENT_OCCLUSION_BLOCKS.get().containsBlock(state.getBlock()) || !ModTweak.ENABLED.get())
            return isCollisionShapeFullBlock;

        return true;
    }
}
