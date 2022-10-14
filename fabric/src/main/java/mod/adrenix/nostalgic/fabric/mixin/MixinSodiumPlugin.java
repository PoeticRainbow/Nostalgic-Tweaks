package mod.adrenix.nostalgic.fabric.mixin;

import net.fabricmc.loader.api.FabricLoader;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

/**
 * Do <b>not</b> class load any mod related classes here. Doing so will cause "applied too early" ASM errors during the
 * mixin application process.
 *
 * For example, it may seem intuitive to remove the <code>SODIUM_PRESENT</code> flag and instead use the mod's main
 * class flag <code>NostalgicTweaks.isSodiumInstalled</code>. Doing this will work if the mod is loaded by itself;
 * however, any mod that applies transformations to the <code>ResourceLocation</code> class will throw a mixin
 * application error because the <code>ResourceLocation</code> class was class loaded by this plugin before the mixin
 * processor could apply patches.
 */

public class MixinSodiumPlugin implements IMixinConfigPlugin
{
    private final boolean SODIUM_PRESENT = FabricLoader.getInstance().getModContainer("sodium").isPresent();

    @Override public boolean shouldApplyMixin(String targetClassName, String mixinClassName) { return SODIUM_PRESENT; }
    @Override public void onLoad(String mixinPackage) { }
    @Override public List<String> getMixins() { return null; }
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) { }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { }
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) { }
}