package mod.adrenix.nostalgic.listener.common;

import dev.architectury.event.events.common.PlayerEvent;
import dev.architectury.event.events.common.TickEvent;
import dev.architectury.networking.NetworkManager;
import mod.adrenix.nostalgic.NostalgicTweaks;
import mod.adrenix.nostalgic.network.packet.sync.ClientboundHandshake;
import mod.adrenix.nostalgic.tweak.config.CandyTweak;
import mod.adrenix.nostalgic.tweak.config.GameplayTweak;
import mod.adrenix.nostalgic.tweak.enums.Hotbar;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public abstract class PlayerListener
{
    /**
     * Registers common server player events.
     */
    public static void register()
    {
        PlayerEvent.PLAYER_JOIN.register(PlayerListener::onPlayerJoin);
        TickEvent.PLAYER_POST.register(PlayerListener::onTick);
    }

    /**
     * Enforces disabled sprinting and/or swimming when required by a level running the mod.
     */
    public static void onTick(Player player)
    {
        if (player.isCreative() || player.isSpectator())
            return;

        if (GameplayTweak.DISABLE_SPRINT.get() && player.isSprinting())
            player.setSprinting(false);

        if (GameplayTweak.DISABLE_SWIM.get() && player.isSwimming())
            player.setSwimming(false);
    }

    /**
     * This method provides instructions for the mod to perform after a player connects to the server level.
     *
     * @param player A {@link ServerPlayer} instance.
     */
    private static void onPlayerJoin(ServerPlayer player)
    {
        String loader = NostalgicTweaks.getLoader();
        String tiny = NostalgicTweaks.getTinyVersion();
        String beta = NostalgicTweaks.getBetaVersion();
        String version = beta.isEmpty() ? tiny : tiny + "-" + beta;
        String protocol = NostalgicTweaks.getProtocol();

        NetworkManager.sendToPlayer(player, new ClientboundHandshake(loader, version, protocol));

        setCreativeHotbar(player);
    }

    /**
     * Utility method for {@link #setCreativeHotbar(ServerPlayer)}.
     *
     * @param player The {@link ServerPlayer} to modify.
     * @param slot   The slot to place the given block in.
     * @param block  The {@link Block} to place in the given slot.
     */
    private static void setBlockInSlot(ServerPlayer player, int slot, Block block)
    {
        player.getInventory().add(slot, block.asItem().getDefaultInstance());
    }

    /**
     * Changes the player's hotbar in creative mode based on the defined hotbar version.
     *
     * @param player A {@link ServerPlayer} instance.
     */
    private static void setCreativeHotbar(ServerPlayer player)
    {
        Hotbar hotbar = CandyTweak.OLD_CREATIVE_HOTBAR.get();

        boolean isCreative = player.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
        boolean isNostalgic = hotbar != Hotbar.MODERN;

        if (player.getInventory().isEmpty() && isCreative && isNostalgic)
        {
            setBlockInSlot(player, 0, Blocks.STONE);
            setBlockInSlot(player, 1, Blocks.COBBLESTONE);
            setBlockInSlot(player, 2, Blocks.BRICKS);
            setBlockInSlot(player, 3, Blocks.DIRT);
            setBlockInSlot(player, 4, Blocks.OAK_PLANKS);
            setBlockInSlot(player, 5, Blocks.OAK_LOG);
            setBlockInSlot(player, 6, Blocks.OAK_LEAVES);
            setBlockInSlot(player, 8, Blocks.SMOOTH_STONE_SLAB);

            if (hotbar == Hotbar.BETA)
                setBlockInSlot(player, 7, Blocks.TORCH);
            else
                setBlockInSlot(player, 7, Blocks.GLASS);
        }
    }
}