package mod.adrenix.nostalgic.mixin.tweak.sound.disabled_sound;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import mod.adrenix.nostalgic.tweak.config.SoundTweak;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SoundEngine.class)
public abstract class SoundEngineMixin
{
    /**
     * Mutes any sound contained within the list of disabled sounds.
     */
    @ModifyExpressionValue(
        method = "play",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/resources/sounds/SoundInstance;getVolume()F"
        )
    )
    private float nt_disabled_sound$modifyPlayVolume(float volume, SoundInstance sound)
    {
        if (SoundTweak.DISABLED_GLOBAL_SOUNDS.get().contains(sound.getLocation().toString()))
            return 0.0F;

        return volume;
    }
}