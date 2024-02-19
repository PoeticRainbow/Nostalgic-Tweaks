package mod.adrenix.nostalgic.config;

import mod.adrenix.nostalgic.NostalgicTweaks;
import mod.adrenix.nostalgic.config.factory.Config;
import mod.adrenix.nostalgic.config.factory.ConfigMeta;
import mod.adrenix.nostalgic.config.factory.LoaderException;
import mod.adrenix.nostalgic.tweak.TweakValidator;
import mod.adrenix.nostalgic.tweak.config.*;
import mod.adrenix.nostalgic.tweak.enums.*;
import mod.adrenix.nostalgic.tweak.listing.ItemMap;
import mod.adrenix.nostalgic.tweak.listing.ItemSet;
import mod.adrenix.nostalgic.tweak.listing.StringSet;

/**
 * <b color=red>IMPORTANT</b>
 * <p>
 * Any update to a field name in this class that is associated with a server tweak must update its counterpart field
 * name in the server config structure class as well.
 *
 * @see mod.adrenix.nostalgic.config.ServerConfig
 */

// This class only serves as a structure definition for Gson
@SuppressWarnings("unused")
@Config(filename = NostalgicTweaks.MOD_ID)
public class ClientConfig implements ConfigMeta
{
    /* Config Metadata */

    @Override
    public void validate() throws LoaderException
    {
        new TweakValidator(true).scan(ClientConfig.class);
    }

    /* Root */

    public boolean modEnabled = ModTweak.ENABLED.register("modEnabled");
    public boolean restrictedLan = ModTweak.RESTRICTED_LAN.register("restrictedLan");
    public boolean serverSideOnly = ModTweak.SERVER_SIDE_ONLY.register("serverSideOnly");
    public boolean serverLogging = ModTweak.SERVER_LOGGING.register("serverLogging");
    public boolean serverDebugMode = ModTweak.SERVER_DEBUG.register("serverDebugMode");

    /* Client Config */

    public static class Mod
    {
        // Internal

        public StringSet favoriteTweaks = ModTweak.FAVORITE_TWEAKS.register("favoriteTweaks");
        public boolean openedConfigScreen = ModTweak.OPENED_CONFIG_SCREEN.register("openedConfigScreen");
        public boolean openedSupporterScreen = ModTweak.OPENED_SUPPORTER_SCREEN.register("openedSupporterScreen");
        public boolean persistentConfigScreen = ModTweak.PERSISTENT_CONFIG_SCREEN.register("persistentConfigScreen");

        // Menu Hotkeys

        public MenuOption defaultScreen = ModTweak.DEFAULT_SCREEN.register("defaultScreen");
        public int openConfigBinding = ModTweak.OPEN_CONFIG_BINDING.register("openConfigBinding");
        public int fogBinding = ModTweak.FOG_BINDING.register("fogBinding");

        // Config Management

        public int numberOfBackups = ModTweak.NUMBER_OF_BACKUPS.register("numberOfBackups");

        // Toast Control

        public boolean showWelcomeToast = ModTweak.SHOW_WELCOME_TOAST.register("showWelcomeToast");
        public boolean showHandshakeToast = ModTweak.SHOW_HANDSHAKE_TOAST.register("showHandshakeToast");
        public boolean showLanChangeToast = ModTweak.SHOW_LAN_CHANGE_TOAST.register("showLanChangeToast");
        public boolean showServerboundToast = ModTweak.SHOW_SERVERBOUND_TOAST.register("showServerboundToast");
        public boolean showClientboundToast = ModTweak.SHOW_CLIENTBOUND_TOAST.register("showClientboundToast");

        // Menu Visuals

        public boolean smoothScroll = ModTweak.SMOOTH_SCROLL.register("smoothScroll");
        public int menuBackgroundOpacity = ModTweak.MENU_BACKGROUND_OPACITY.register("menuBackgroundOpacity");

        // Menu Tags

        public boolean displayNewTags = ModTweak.DISPLAY_NEW_TAGS.register("displayNewTags");
        public boolean displayTagTooltips = ModTweak.DISPLAY_TAG_TOOLTIPS.register("displayTagTooltips");

        // Menu Tree

        public boolean displayCategoryTree = ModTweak.DISPLAY_CATEGORY_TREE.register("displayCategoryTree");
        public int categoryTreeOpacity = ModTweak.CATEGORY_TREE_OPACITY.register("categoryTreeOpacity");

        // Menu Rows

        public boolean displayRowHighlight = ModTweak.DISPLAY_ROW_HIGHLIGHT.register("displayRowHighlight");
        public boolean displayRowHighlightFade = ModTweak.DISPLAY_ROW_HIGHLIGHT_FADE.register("displayRowHighlightFade");
        public boolean overrideRowHighlight = ModTweak.OVERRIDE_ROW_HIGHLIGHT.register("overrideRowHighlight");
        public int rowHighlightOpacity = ModTweak.ROW_HIGHLIGHT_OPACITY.register("rowHighlightOpacity");
    }

    public Mod mod = new Mod();

    public static class Sound
    {
        // Disabled

        public StringSet disabledPositionedSounds = SoundTweak.DISABLED_POSITIONED_SOUNDS.register("disabledPositionedSounds");
        public StringSet disabledGlobalSounds = SoundTweak.DISABLED_GLOBAL_SOUNDS.register("disabledGlobalSounds");

        // Ambient

        public boolean disableNetherAmbience = SoundTweak.DISABLE_NETHER_AMBIENCE.register("disableNetherAmbience");
        public boolean disableWaterAmbience = SoundTweak.DISABLE_WATER_AMBIENCE.register("disableWaterAmbience");

        // Bed Block

        public boolean oldBed = SoundTweak.OLD_BED.register("oldBed");
        public boolean disableBedPlace = SoundTweak.DISABLE_BED_PLACE.register("disableBedPlace");

        // Chest Block

        public boolean oldChest = SoundTweak.OLD_CHEST.register("oldChest");
        public boolean disableChest = SoundTweak.DISABLE_CHEST.register("disableChest");

        // Lava Block

        public boolean disableLavaAmbience = SoundTweak.DISABLE_LAVA_AMBIENCE.register("disableLavaAmbience");
        public boolean disableLavaPop = SoundTweak.DISABLE_LAVA_POP.register("disableLavaPop");

        // Furnace Block

        public boolean disableFurnace = SoundTweak.DISABLE_FURNACE.register("disableFurnace");
        public boolean disableBlastFurnace = SoundTweak.DISABLE_BLAST_FURNACE.register("disableBlastFurnace");

        // Blocks

        public boolean disableGrowth = SoundTweak.DISABLE_GROWTH.register("disableGrowth");
        public boolean disableDoorPlace = SoundTweak.DISABLE_DOOR_PLACE.register("disableDoorPlace");

        // Damage

        public boolean oldAttack = SoundTweak.OLD_ATTACK.register("oldAttack");
        public boolean oldHurt = SoundTweak.OLD_HURT.register("oldHurt");
        public boolean oldFall = SoundTweak.OLD_FALL.register("oldFall");

        // Experience

        public boolean oldXp = SoundTweak.OLD_XP.register("oldXp");
        public boolean disableXpPickup = SoundTweak.DISABLE_XP_PICKUP.register("disableXpPickup");
        public boolean disableXpLevel = SoundTweak.DISABLE_XP_LEVEL.register("disableXpLevel");

        // Mobs

        public boolean disableGenericSwim = SoundTweak.DISABLE_GENERIC_SWIM.register("disableGenericSwim");
        public boolean disableFishSwim = SoundTweak.DISABLE_FISH_SWIM.register("disableFishSwim");
        public boolean disableFishHurt = SoundTweak.DISABLE_FISH_HURT.register("disableFishHurt");
        public boolean disableFishDeath = SoundTweak.DISABLE_FISH_DEATH.register("disableFishDeath");
        public boolean disableSquid = SoundTweak.DISABLE_SQUID.register("disableSquid");
        public boolean disableGlowSquidOther = SoundTweak.DISABLE_GLOW_SQUID_OTHER.register("disableGlowSquidOther");
        public boolean disableGlowSquidAmbience = SoundTweak.DISABLE_GLOW_SQUID_AMBIENCE.register("disableGlowSquidAmbience");
        public boolean oldStep = SoundTweak.OLD_STEP.register("oldStep");
        public boolean ignoreModdedStep = SoundTweak.IGNORE_MODDED_STEP.register("ignoreModdedStep");
    }

    public Sound sound = new Sound();

    public static class EyeCandy
    {
        // Block

        public ItemSet ambientOcclusionBlocks = CandyTweak.AMBIENT_OCCLUSION_BLOCKS.register("ambientOcclusionBlocks");
        public ItemSet disableBlockOffsets = CandyTweak.DISABLE_BLOCK_OFFSETS.register("disableBlockOffsets");
        public boolean disableAllOffset = CandyTweak.DISABLE_ALL_OFFSET.register("disableAllOffset");
        public MissingTexture oldMissingTexture = CandyTweak.OLD_MISSING_TEXTURE.register("oldMissingTexture");

        // Hitbox Outline

        public ItemSet oldBlockOutlines = CandyTweak.OLD_BLOCK_OUTLINES.register("oldBlockOutlines");
        public String oldBlockOutlineColor = CandyTweak.BLOCK_OUTLINE_COLOR.register("oldBlockOutlineColor");
        public float oldBlockOutlineThickness = CandyTweak.BLOCK_OUTLINE_THICKNESS.register("oldBlockOutlineThickness");

        // Hitbox Overlay

        public boolean oldBlockOverlay = CandyTweak.OLD_BLOCK_OVERLAY.register("oldBlockOverlay");
        public RenderOrder overlayRenderOrder = CandyTweak.BLOCK_OVERLAY_RENDER_ORDER.register("overlayRenderOrder");
        public String oldBlockOverlayColor = CandyTweak.BLOCK_OVERLAY_COLOR.register("oldBlockOverlayColor");
        public boolean pulsateBlockOverlay = CandyTweak.PULSATE_BLOCK_OVERLAY.register("pulsateBlockOverlay");
        public boolean customBlockOverlayGradient = CandyTweak.BLOCK_OVERLAY_GRADIENT.register("customBlockOverlayGradient");
        public String customBlockOverlayGradientTop = CandyTweak.CUSTOM_OVERLAY_GRADIENT_TOP.register("customBlockOverlayGradientTop");
        public String customBlockOverlayGradientBottom = CandyTweak.CUSTOM_OVERLAY_GRADIENT_BOTTOM.register("customBlockOverlayGradientBottom");
        public AnimationType pulsateOverlayAnimation = CandyTweak.PULSATE_OVERLAY_ANIMATION.register("pulsateOverlayAnimation");
        public float oldBlockOverlaySpeed = CandyTweak.BLOCK_OVERLAY_SPEED.register("oldBlockOverlaySpeed");
        public float minimumBlockPulsationTransparency = CandyTweak.MINIMUM_PULSATION_TRANSPARENCY.register("minimumBlockPulsationTransparency");
        public float maximumBlockPulsationTransparency = CandyTweak.MAXIMUM_PULSATION_TRANSPARENCY.register("maximumBlockPulsationTransparency");

        // Chests

        public boolean oldChest = CandyTweak.OLD_CHEST.register("oldChest");
        public boolean oldEnderChest = CandyTweak.OLD_ENDER_CHEST.register("oldEnderChest");
        public boolean oldTrappedChest = CandyTweak.OLD_TRAPPED_CHEST.register("oldTrappedChest");
        public boolean applyChestVoxel = CandyTweak.APPLY_CHEST_VOXEL.register("applyChestVoxel");
        public ItemSet oldModChests = CandyTweak.OLD_MOD_CHESTS.register("oldModChests");

        // Torch

        public boolean oldTorchBrightness = CandyTweak.OLD_TORCH_BRIGHTNESS.register("oldTorchBrightness");
        public boolean oldTorchModel = CandyTweak.OLD_TORCH_MODEL.register("oldTorchModel");
        public boolean oldRedstoneTorchModel = CandyTweak.OLD_REDSTONE_TORCH_MODEL.register("oldRedstoneTorchModel");
        public boolean oldSoulTorchModel = CandyTweak.OLD_SOUL_TORCH_MODEL.register("oldSoulTorchModel");

        // Interface

        public boolean oldButtonHover = CandyTweak.OLD_BUTTON_HOVER.register("oldButtonHover");
        public Hotbar oldCreativeHotbar = CandyTweak.OLD_CREATIVE_HOTBAR.register("oldCreativeHotbar");

        // Window Title

        public boolean enableWindowTitle = CandyTweak.ENABLE_WINDOW_TITLE.register("enableWindowTitle");
        public boolean matchVersionOverlay = CandyTweak.MATCH_VERSION_OVERLAY.register("matchVersionOverlay");
        public String windowTitleText = CandyTweak.WINDOW_TITLE_TEXT.register("windowTitleText");

        // Debug Screen

        public Generic oldDebug = CandyTweak.OLD_DEBUG.register("oldDebug");
        public boolean debugEntityId = CandyTweak.DEBUG_ENTITY_ID.register("debugEntityId");

        // Debug Chart

        public DebugChart fpsChart = CandyTweak.FPS_CHART.register("fpsChart");
        public boolean showDebugTpsChart = CandyTweak.SHOW_DEBUG_TPS_CHART.register("showDebugTpsChart");
        public boolean showDebugPieChart = CandyTweak.SHOW_DEBUG_PIE_CHART.register("showDebugPieChart");
        public boolean oldPieChartBackground = CandyTweak.OLD_PIE_CHART_BACKGROUND.register("oldPieChartBackground");

        // Debug Color

        public boolean showDebugTextShadow = CandyTweak.SHOW_DEBUG_TEXT_SHADOW.register("showDebugTextShadow");
        public boolean showDebugBackground = CandyTweak.SHOW_DEBUG_BACKGROUND.register("showDebugBackground");
        public String debugBackgroundColor = CandyTweak.DEBUG_BACKGROUND_COLOR.register("debugBackgroundColor");

        // Debug Extra

        public boolean showDebugGpuUsage = CandyTweak.SHOW_DEBUG_GPU_USAGE.register("showDebugGpuUsage");
        public boolean showDebugLightData = CandyTweak.SHOW_DEBUG_LIGHT_DATA.register("showDebugLightData");
        public boolean showDebugFacingData = CandyTweak.SHOW_DEBUG_FACING_DATA.register("showDebugFacingData");
        public boolean showDebugTargetData = CandyTweak.SHOW_DEBUG_TARGET_DATA.register("showDebugTargetData");
        public boolean showDebugBiomeData = CandyTweak.SHOW_DEBUG_BIOME_DATA.register("showDebugBiomeData");

        // Inventory Screen

        public boolean oldInventory = CandyTweak.OLD_INVENTORY.register("oldInventory");
        public RecipeBook inventoryBook = CandyTweak.INVENTORY_BOOK.register("inventoryBook");
        public InventoryShield inventoryShield = CandyTweak.INVENTORY_SHIELD.register("inventoryShield");
        public boolean disableEmptyArmorTexture = CandyTweak.DISABLE_EMPTY_ARMOR_TEXTURE.register("disableEmptyArmorTexture");
        public boolean disableEmptyShieldTexture = CandyTweak.DISABLE_EMPTY_SHIELD_TEXTURE.register("disableEmptyShieldTexture");
        public boolean invertedBlockLighting = CandyTweak.INVERTED_BLOCK_LIGHTING.register("invertedBlockLighting");
        public boolean invertedPlayerLighting = CandyTweak.INVERTED_PLAYER_LIGHTING.register("invertedPlayerLighting");

        // GUI

        public GuiBackground oldGuiBackground = CandyTweak.OLD_GUI_BACKGROUND.register("oldGuiBackground");
        public boolean customGuiBackground = CandyTweak.CUSTOM_GUI_BACKGROUND.register("customGuiBackground");
        public String customTopGradient = CandyTweak.CUSTOM_TOP_GRADIENT.register("customTopGradient");
        public String customBottomGradient = CandyTweak.CUSTOM_BOTTOM_GRADIENT.register("customBottomGradient");

        // Loading Overlay

        public Overlay oldLoadingOverlay = CandyTweak.OLD_LOADING_OVERLAY.register("oldLoadingOverlay");
        public boolean removeLoadingBar = CandyTweak.REMOVE_LOADING_BAR.register("removeLoadingBar");
        public boolean oldLoadingScreens = CandyTweak.OLD_LOADING_SCREENS.register("oldLoadingScreens");

        // Version Overlay

        public boolean oldVersionOverlay = CandyTweak.OLD_VERSION_OVERLAY.register("oldVersionOverlay");
        public Corner oldOverlayCorner = CandyTweak.OLD_OVERLAY_CORNER.register("oldOverlayCorner");
        public String oldOverlayText = CandyTweak.OLD_OVERLAY_TEXT.register("oldOverlayText");

        // Pause Screen

        public PauseLayout oldPauseMenu = CandyTweak.OLD_PAUSE_MENU.register("oldPauseMenu");
        public boolean includeModsOnPause = CandyTweak.INCLUDE_MODS_ON_PAUSE.register("includeModsOnPause");
        public boolean removeExtraPauseButtons = CandyTweak.REMOVE_EXTRA_PAUSE_BUTTONS.register("removeExtraPauseButtons");

        // Anvil Screen

        public boolean oldAnvilScreen = CandyTweak.OLD_ANVIL_SCREEN.register("oldAnvilScreen");

        // Crafting Screen

        public boolean oldCraftingScreen = CandyTweak.OLD_CRAFTING_SCREEN.register("oldCraftingScreen");
        public RecipeBook craftingBook = CandyTweak.CRAFTING_BOOK.register("craftingBook");

        // Furnace Screen

        public boolean oldFurnaceScreen = CandyTweak.OLD_FURNACE_SCREEN.register("oldFurnaceScreen");
        public RecipeBook furnaceBook = CandyTweak.FURNACE_BOOK.register("furnaceBook");

        // Chat Screen

        public boolean oldChatInput = CandyTweak.OLD_CHAT_INPUT.register("oldChatInput");
        public boolean oldChatBox = CandyTweak.OLD_CHAT_BOX.register("oldChatBox");
        public boolean disableSignatureBoxes = CandyTweak.DISABLE_SIGNATURE_BOXES.register("disableSignatureBoxes");
        public int chatOffset = CandyTweak.CHAT_OFFSET.register("chatOffset");

        // Tooltips

        public boolean oldTooltipBoxes = CandyTweak.OLD_TOOLTIP_BOXES.register("oldTooltipBoxes");
        public boolean oldNoItemTooltips = CandyTweak.OLD_NO_ITEM_TOOLTIPS.register("oldNoItemTooltips");

        // Tooltip Parts

        public boolean showEnchantmentTip = CandyTweak.SHOW_ENCHANTMENT_TIP.register("showEnchantmentTip");
        public boolean showModifierTip = CandyTweak.SHOW_MODIFIER_TIP.register("showModifierTip");
        public boolean showDyeTip = CandyTweak.SHOW_DYE_TIP.register("showDyeTip");

        // Items

        public boolean fixItemModelGap = CandyTweak.FIX_ITEM_MODEL_GAP.register("fixItemModelGap");
        public boolean oldDamageArmorTint = CandyTweak.OLD_DAMAGE_ARMOR_TINT.register("oldDamageArmorTint");
        public boolean oldItemHolding = CandyTweak.OLD_ITEM_HOLDING.register("oldItemHolding");
        public ItemSet ignoredHoldingItems = CandyTweak.IGNORED_HOLDING_ITEMS.register("ignoredHoldingItems");

        // Item Merging

        public int itemMergeLimit = CandyTweak.ITEM_MERGE_LIMIT.register("itemMergeLimit");
        public boolean oldItemMerging = CandyTweak.OLD_ITEM_MERGING.register("oldItemMerging");

        // 2D Items

        public boolean old2dColors = CandyTweak.OLD_2D_COLORS.register("old2dColors");
        public boolean old2dItems = CandyTweak.OLD_2D_ITEMS.register("old2dItems");
        public boolean old2dFrames = CandyTweak.OLD_2D_FRAMES.register("old2dFrames");
        public boolean old2dThrownItems = CandyTweak.OLD_2D_THROWN_ITEMS.register("old2dThrownItems");
        public boolean old2dEnchantedItems = CandyTweak.OLD_2D_ENCHANTED_ITEMS.register("old2dEnchantedItems");
        public boolean old2dRendering = CandyTweak.OLD_2D_RENDERING.register("old2dRendering");

        // Item Display

        public boolean oldDurabilityColors = CandyTweak.OLD_DURABILITY_COLORS.register("oldDurabilityColors");
        public boolean oldNoSelectedItemName = CandyTweak.OLD_NO_SELECTED_ITEM_NAME.register("oldNoSelectedItemName");
        public boolean oldPlainSelectedItemName = CandyTweak.OLD_PLAIN_SELECTED_ITEM_NAME.register("oldPlainSelectedItemName");

        // World Lighting

        public boolean fixChunkBorderLag = CandyTweak.FIX_CHUNK_BORDER_LAG.register("fixChunkBorderLag");
        public boolean disableBrightness = CandyTweak.DISABLE_BRIGHTNESS.register("disableBrightness");
        public boolean disableLightFlicker = CandyTweak.DISABLE_LIGHT_FLICKER.register("disableLightFlicker");
        public boolean oldClassicLighting = CandyTweak.OLD_CLASSIC_LIGHTING.register("oldClassicLighting");
        public boolean oldNetherLighting = CandyTweak.OLD_NETHER_LIGHTING.register("oldNetherLighting");
        public boolean oldLightRendering = CandyTweak.OLD_LIGHT_RENDERING.register("oldLightRendering");
        public boolean oldLightColor = CandyTweak.OLD_LIGHT_COLOR.register("oldLightColor");
        public boolean oldSmoothLighting = CandyTweak.OLD_SMOOTH_LIGHTING.register("oldSmoothLighting");
        public int maxBlockLight = CandyTweak.MAX_BLOCK_LIGHT.register("maxBlockLight");

        // Block Lighting

        public boolean oldLeavesLighting = CandyTweak.OLD_LEAVES_LIGHTING.register("oldLeavesLighting");
        public boolean oldWaterLighting = CandyTweak.OLD_WATER_LIGHTING.register("oldWaterLighting");

        // Particles

        public boolean oldOpaqueExperience = CandyTweak.OLD_OPAQUE_EXPERIENCE.register("oldOpaqueExperience");
        public boolean disableNetherParticles = CandyTweak.DISABLE_NETHER_PARTICLES.register("disableNetherParticles");
        public boolean disableUnderwaterParticles = CandyTweak.DISABLE_UNDERWATER_PARTICLES.register("disableUnderwaterParticles");

        // Block Particles

        public boolean disableLavaParticles = CandyTweak.DISABLE_LAVA_PARTICLES.register("disableLavaParticles");
        public boolean disableLeverParticles = CandyTweak.DISABLE_LEVER_PARTICLES.register("disableLeverParticles");
        public boolean disableModelDestructionParticles = CandyTweak.DISABLE_MODEL_DESTRUCTION_PARTICLES.register("disableModelDestructionParticles");
        public boolean disableEnderChestParticles = CandyTweak.DISABLE_ENDER_CHEST_PARTICLES.register("disableEnderChestParticles");
        public boolean disableGrowthParticles = CandyTweak.DISABLE_GROWTH_PARTICLES.register("disableGrowthParticles");

        // Player Particles

        public boolean disableFallingParticles = CandyTweak.DISABLE_FALLING_PARTICLES.register("disableFallingParticles");
        public boolean disableSprintingParticles = CandyTweak.DISABLE_SPRINTING_PARTICLES.register("disableSprintingParticles");

        // Attack Particles

        public boolean oldSweepParticles = CandyTweak.OLD_SWEEP_PARTICLES.register("oldSweepParticles");
        public boolean oldNoDamageParticles = CandyTweak.OLD_NO_DAMAGE_PARTICLES.register("oldNoDamageParticles");
        public boolean oldNoCritParticles = CandyTweak.OLD_NO_CRIT_PARTICLES.register("oldNoCritParticles");
        public boolean oldNoMagicHitParticles = CandyTweak.OLD_NO_MAGIC_HIT_PARTICLES.register("oldNoMagicHitParticles");

        // Explosion Particles

        public boolean oldExplosionParticles = CandyTweak.OLD_EXPLOSION_PARTICLES.register("oldExplosionParticles");
        public boolean oldMixedExplosionParticles = CandyTweak.OLD_MIXED_EXPLOSION_PARTICLES.register("oldMixedExplosionParticles");
        public boolean unoptimizedExplosionParticles = CandyTweak.UNOPTIMIZED_EXPLOSION_PARTICLES.register("unoptimizedExplosionParticles");

        // Title Screen

        public boolean overrideTitleScreen = CandyTweak.OVERRIDE_TITLE_SCREEN.register("overrideTitleScreen");
        public boolean oldTitleBackground = CandyTweak.OLD_TITLE_BACKGROUND.register("oldTitleBackground");
        public boolean uncapTitleFPS = CandyTweak.UNCAP_TITLE_FPS.register("uncapTitleFPS");

        // Title Screen Logo

        public boolean oldAlphaLogo = CandyTweak.OLD_ALPHA_LOGO.register("oldAlphaLogo");
        public boolean oldLogoOutline = CandyTweak.OLD_LOGO_OUTLINE.register("oldLogoOutline");

        // Title Screen Buttons

        public TitleLayout oldButtonLayout = CandyTweak.OLD_BUTTON_LAYOUT.register("oldButtonLayout");
        public boolean includeModsOnTitle = CandyTweak.INCLUDE_MODS_ON_TITLE.register("includeModsOnTitle");
        public boolean removeTitleRealmsButton = CandyTweak.REMOVE_TITLE_REALMS_BUTTON.register("removeTitleRealmsButton");
        public boolean removeTitleAccessibilityButton = CandyTweak.REMOVE_TITLE_ACCESSIBILITY_BUTTON.register("removeTitleAccessibilityButton");
        public boolean removeTitleLanguageButton = CandyTweak.REMOVE_TITLE_LANGUAGE_BUTTON.register("removeTitleLanguageButton");

        // Title Screen Text

        public String titleVersionText = CandyTweak.TITLE_VERSION_TEXT.register("titleVersionText");
        public boolean titleBottomLeftText = CandyTweak.TITLE_BOTTOM_LEFT_TEXT.register("titleBottomLeftText");
        public boolean removeTitleModLoaderText = CandyTweak.REMOVE_TITLE_MOD_LOADER_TEXT.register("removeTitleModLoaderText");

        // World

        public boolean oldSquareBorder = CandyTweak.OLD_SQUARE_BORDER.register("oldSquareBorder");
        public boolean oldNameTags = CandyTweak.OLD_NAME_TAGS.register("oldNameTags");

        // World Fog

        public WorldFog oldWorldFog = CandyTweak.OLD_WORLD_FOG.register("oldWorldFog");
        public boolean disableHorizonFog = CandyTweak.DISABLE_HORIZON_FOG.register("disableHorizonFog");
        public boolean oldNetherFog = CandyTweak.OLD_NETHER_FOG.register("oldNetherFog");
        public boolean oldSunriseSunsetFog = CandyTweak.OLD_SUNRISE_SUNSET_FOG.register("oldSunriseSunsetFog");
        public boolean oldDarkFog = CandyTweak.OLD_DARK_FOG.register("oldDarkFog");
        public boolean oldDynamicFogColor = CandyTweak.OLD_DYNAMIC_FOG_COLOR.register("oldDynamicFogColor");
        public FogColor universalFogColor = CandyTweak.UNIVERSAL_FOG_COLOR.register("universalFogColor");

        // Custom World Fog

        public boolean customTerrainFog = CandyTweak.CUSTOM_TERRAIN_FOG.register("customTerrainFog");
        public String customTerrainFogColor = CandyTweak.CUSTOM_TERRAIN_FOG_COLOR.register("customTerrainFogColor");
        public boolean customNetherFog = CandyTweak.CUSTOM_NETHER_FOG.register("customNetherFog");
        public String customNetherFogColor = CandyTweak.CUSTOM_NETHER_FOG_COLOR.register("customNetherFogColor");

        // Water Fog

        public boolean oldWaterFogDensity = CandyTweak.OLD_WATER_FOG_DENSITY.register("oldWaterFogDensity");
        public boolean oldWaterFogColor = CandyTweak.OLD_WATER_FOG_COLOR.register("oldWaterFogColor");
        public boolean smoothWaterDensity = CandyTweak.SMOOTH_WATER_DENSITY.register("smoothWaterDensity");
        public boolean smoothWaterColor = CandyTweak.SMOOTH_WATER_COLOR.register("smoothWaterColor");

        // World Sky

        public boolean disableSunriseSunsetColors = CandyTweak.DISABLE_SUNRISE_SUNSET_COLORS.register("disableSunriseSunsetColors");
        public boolean oldSunriseAtNorth = CandyTweak.OLD_SUNRISE_AT_NORTH.register("oldSunriseAtNorth");
        public Generic oldStars = CandyTweak.OLD_STARS.register("oldStars");
        public boolean oldDynamicSkyColor = CandyTweak.OLD_DYNAMIC_SKY_COLOR.register("oldDynamicSkyColor");
        public SkyColor universalSkyColor = CandyTweak.UNIVERSAL_SKY_COLOR.register("universalSkyColor");
        public boolean oldNetherSky = CandyTweak.OLD_NETHER_SKY.register("oldNetherSky");
        public int oldCloudHeight = CandyTweak.OLD_CLOUD_HEIGHT.register("oldCloudHeight");

        // Custom World Sky

        public boolean customWorldSky = CandyTweak.CUSTOM_WORLD_SKY.register("customWorldSky");
        public String customWorldSkyColor = CandyTweak.CUSTOM_WORLD_SKY_COLOR.register("customWorldSkyColor");
        public boolean customNetherSky = CandyTweak.CUSTOM_NETHER_SKY.register("customNetherSky");
        public String customNetherSkyColor = CandyTweak.CUSTOM_NETHER_SKY_COLOR.register("customNetherSkyColor");

        // Void Sky

        public Generic oldBlueVoid = CandyTweak.OLD_BLUE_VOID.register("oldBlueVoid");
        public boolean oldBlueVoidOverride = CandyTweak.OLD_BLUE_VOID_OVERRIDE.register("oldBlueVoidOverride");
        public boolean oldDarkVoidHeight = CandyTweak.OLD_DARK_VOID_HEIGHT.register("oldDarkVoidHeight");
        public boolean customVoidSky = CandyTweak.CUSTOM_VOID_SKY.register("customVoidSky");
        public String customVoidSkyColor = CandyTweak.CUSTOM_VOID_SKY_COLOR.register("customVoidSkyColor");

        // Void Fog

        public boolean disableVoidFog = CandyTweak.DISABLE_VOID_FOG.register("disableVoidFog");
        public boolean creativeVoidFog = CandyTweak.CREATIVE_VOID_FOG.register("creativeVoidFog");
        public boolean creativeVoidParticles = CandyTweak.CREATIVE_VOID_PARTICLES.register("creativeVoidParticles");
        public boolean lightRemovesVoidFog = CandyTweak.LIGHT_REMOVES_VOID_FOG.register("lightRemovesVoidFog");
        public String voidFogColor = CandyTweak.VOID_FOG_COLOR.register("voidFogColor");
        public int voidFogEncroach = CandyTweak.VOID_FOG_ENCROACH.register("voidFogEncroach");
        public int voidFogStart = CandyTweak.VOID_FOG_START.register("voidFogStart");
        public int voidParticleStart = CandyTweak.VOID_PARTICLE_START.register("voidParticleStart");
        public int voidParticleRadius = CandyTweak.VOID_PARTICLE_RADIUS.register("voidParticleRadius");
        public int voidParticleDensity = CandyTweak.VOID_PARTICLE_DENSITY.register("voidParticleDensity");
    }

    public EyeCandy eyeCandy = new EyeCandy();

    public static class Gameplay
    {
        // Bugs

        public boolean oldLadderGap = GameplayTweak.OLD_LADDER_GAP.register("oldLadderGap");
        public boolean oldSquidMilking = GameplayTweak.OLD_SQUID_MILKING.register("oldSquidMilking");

        // Mob AI

        public boolean disableAnimalPanic = GameplayTweak.DISABLE_ANIMAL_PANIC.register("disableAnimalPanic");

        // Mob Spawning

        public int animalSpawnCap = GameplayTweak.ANIMAL_SPAWN_CAP.register("animalSpawnCap");
        public boolean oldAnimalSpawning = GameplayTweak.OLD_ANIMAL_SPAWNING.register("oldAnimalSpawning");

        // Sheep

        public boolean disableSheepEatGrass = GameplayTweak.DISABLE_SHEEP_EAT_GRASS.register("disableSheepEatGrass");
        public boolean oldSheepPunching = GameplayTweak.OLD_SHEEP_PUNCHING.register("oldSheepPunching");
        public boolean oneWoolPunch = GameplayTweak.ONE_WOOL_PUNCH.register("oneWoolPunch");

        // Classic Mob Drops

        public boolean oldZombiePigmenDrops = GameplayTweak.OLD_ZOMBIE_PIGMEN_DROPS.register("oldZombiePigmenDrops");
        public boolean oldSkeletonDrops = GameplayTweak.OLD_SKELETON_DROPS.register("oldSkeletonDrops");
        public boolean oldChickenDrops = GameplayTweak.OLD_CHICKEN_DROPS.register("oldChickenDrops");
        public boolean oldZombieDrops = GameplayTweak.OLD_ZOMBIE_DROPS.register("oldZombieDrops");
        public boolean oldSpiderDrops = GameplayTweak.OLD_SPIDER_DROPS.register("oldSpiderDrops");
        public boolean oldSheepDrops = GameplayTweak.OLD_SHEEP_DROPS.register("oldSheepDrops");
        public boolean oldCowDrops = GameplayTweak.OLD_COW_DROPS.register("oldCowDrops");
        public boolean oldPigDrops = GameplayTweak.OLD_PIG_DROPS.register("oldPigDrops");

        // Modern Mob Drops

        public boolean oldStyleZombieVillagerDrops = GameplayTweak.OLD_STYLE_ZOMBIE_VILLAGER_DROPS.register("oldStyleZombieVillagerDrops");
        public boolean oldStyleCaveSpiderDrops = GameplayTweak.OLD_STYLE_CAVE_SPIDER_DROPS.register("oldStyleCaveSpiderDrops");
        public boolean oldStyleMooshroomDrops = GameplayTweak.OLD_STYLE_MOOSHROOM_DROPS.register("oldStyleMooshroomDrops");
        public boolean oldStyleDrownedDrops = GameplayTweak.OLD_STYLE_DROWNED_DROPS.register("oldStyleDrownedDrops");
        public boolean oldStyleRabbitDrops = GameplayTweak.OLD_STYLE_RABBIT_DROPS.register("oldStyleRabbitDrops");
        public boolean oldStyleStrayDrops = GameplayTweak.OLD_STYLE_STRAY_DROPS.register("oldStyleStrayDrops");
        public boolean oldStyleHuskDrops = GameplayTweak.OLD_STYLE_HUSK_DROPS.register("oldStyleHuskDrops");

        // Combat

        public boolean oldDamageValues = GameplayTweak.OLD_DAMAGE_VALUES.register("oldDamageValues");
        public boolean disableCooldown = GameplayTweak.DISABLE_COOLDOWN.register("disableCooldown");
        public boolean disableMissTimer = GameplayTweak.DISABLE_MISS_TIMER.register("disableMissTimer");
        public boolean disableCriticalHit = GameplayTweak.DISABLE_CRITICAL_HIT.register("disableCriticalHit");
        public boolean disableSweep = GameplayTweak.DISABLE_SWEEP.register("disableSweep");

        // Combat Bow

        public int arrowSpeed = GameplayTweak.ARROW_SPEED.register("arrowSpeed");
        public boolean instantBow = GameplayTweak.INSTANT_BOW.register("instantBow");
        public boolean invincibleBow = GameplayTweak.INVINCIBLE_BOW.register("invincibleBow");

        // Experience Bar

        public boolean disableExperienceBar = GameplayTweak.DISABLE_EXPERIENCE_BAR.register("disableExperienceBar");

        // Alternative Experience Text

        public boolean showXpLevelText = GameplayTweak.SHOW_XP_LEVEL_TEXT.register("showXpLevelText");
        public boolean showXpLevelInCreative = GameplayTweak.SHOW_XP_LEVEL_IN_CREATIVE.register("showXpLevelInCreative");
        public Corner altXpLevelCorner = GameplayTweak.ALT_XP_LEVEL_CORNER.register("altXpLevelCorner");
        public String altXpLevelText = GameplayTweak.ALT_XP_LEVEL_TEXT.register("altXpLevelText");

        // Alternative Progress Text

        public boolean showXpProgressText = GameplayTweak.SHOW_XP_PROGRESS_TEXT.register("showXpProgressText");
        public boolean showXpProgressInCreative = GameplayTweak.SHOW_XP_PROGRESS_IN_CREATIVE.register("showXpProgressInCreative");
        public boolean useDynamicProgressColor = GameplayTweak.USE_DYNAMIC_PROGRESS_COLOR.register("useDynamicProgressColor");
        public Corner altXpProgressCorner = GameplayTweak.ALT_XP_PROGRESS_CORNER.register("altXpProgressCorner");
        public String altXpProgressText = GameplayTweak.ALT_XP_PROGRESS_TEXT.register("altXpProgressText");

        // Experience Orb

        public boolean disableOrbSpawn = GameplayTweak.DISABLE_ORB_SPAWN.register("disableOrbSpawn");
        public boolean disableOrbRendering = GameplayTweak.DISABLE_ORB_RENDERING.register("disableOrbRendering");

        // Experience Blocks

        public boolean disableAnvil = GameplayTweak.DISABLE_ANVIL.register("disableAnvil");
        public boolean disableEnchantTable = GameplayTweak.DISABLE_ENCHANT_TABLE.register("disableEnchantTable");

        // Player Mechanics

        public boolean disableSprint = GameplayTweak.DISABLE_SPRINT.register("disableSprint");
        public boolean leftClickDoor = GameplayTweak.LEFT_CLICK_DOOR.register("leftClickDoor");
        public boolean leftClickLever = GameplayTweak.LEFT_CLICK_LEVER.register("leftClickLever");
        public boolean leftClickButton = GameplayTweak.LEFT_CLICK_BUTTON.register("leftClickButton");

        // Farming Mechanics

        public boolean instantBonemeal = GameplayTweak.INSTANT_BONEMEAL.register("instantBonemeal");
        public boolean tilledGrassSeeds = GameplayTweak.TILLED_GRASS_SEEDS.register("tilledGrassSeeds");

        // Fire Mechanics

        public boolean oldFire = GameplayTweak.OLD_FIRE.register("oldFire");
        public boolean infiniteBurn = GameplayTweak.INFINITE_BURN.register("infiniteBurn");

        // Swimming Mechanics

        public boolean instantAir = GameplayTweak.INSTANT_AIR.register("instantAir");
        public boolean disableSwim = GameplayTweak.DISABLE_SWIM.register("disableSwim");

        // Minecart Mechanics

        public boolean cartBoosting = GameplayTweak.CART_BOOSTING.register("cartBoosting");

        // Block Mechanics

        public boolean disableBedBounce = GameplayTweak.DISABLE_BED_BOUNCE.register("disableBedBounce");

        // Hunger Bar

        public boolean disableHungerBar = GameplayTweak.DISABLE_HUNGER_BAR.register("disableHungerBar");

        // Alternative Food Text

        public boolean showHungerFoodText = GameplayTweak.SHOW_HUNGER_FOOD_TEXT.register("showHungerFoodText");
        public boolean useDynamicFoodColor = GameplayTweak.USE_DYNAMIC_FOOD_COLOR.register("useDynamicFoodColor");
        public Corner altHungerFoodCorner = GameplayTweak.ALT_HUNGER_FOOD_CORNER.register("altHungerFoodCorner");
        public String altHungerFoodText = GameplayTweak.ALT_HUNGER_FOOD_TEXT.register("altHungerFoodText");

        // Alternative Saturation Text

        public boolean showHungerSaturationText = GameplayTweak.SHOW_HUNGER_SATURATION_TEXT.register("showHungerSaturationText");
        public boolean useDynamicSaturationColor = GameplayTweak.USE_DYNAMIC_SATURATION_COLOR.register("useDynamicSaturationColor");
        public Corner altHungerSaturationCorner = GameplayTweak.ALT_HUNGER_SATURATION_CORNER.register("altHungerSaturationCorner");
        public String altHungerSaturationText = GameplayTweak.ALT_HUNGER_SATURATION_TEXT.register("altHungerSaturationText");

        // Food

        public boolean instantEat = GameplayTweak.INSTANT_EAT.register("instantEat");
        public boolean disableHunger = GameplayTweak.DISABLE_HUNGER.register("disableHunger");
        public ItemMap<Integer> customFoodHealth = GameplayTweak.CUSTOM_FOOD_HEALTH.register("customFoodHealth");
        public boolean oldFoodStacking = GameplayTweak.OLD_FOOD_STACKING.register("oldFoodStacking");
        public ItemMap<Integer> customFoodStacking = GameplayTweak.CUSTOM_FOOD_STACKING.register("customFoodStacking");
        public ItemMap<Integer> customItemStacking = GameplayTweak.CUSTOM_ITEM_STACKING.register("customItemStacking");
    }

    public Gameplay gameplay = new Gameplay();

    public static class Animation
    {
        // Arm

        public boolean oldArmSway = AnimationTweak.OLD_ARM_SWAY.register("oldArmSway");
        public boolean armSwayMirror = AnimationTweak.ARM_SWAY_MIRROR.register("armSwayMirror");
        public int armSwayIntensity = AnimationTweak.ARM_SWAY_INTENSITY.register("armSwayIntensity");
        public boolean oldSwing = AnimationTweak.OLD_SWING.register("oldSwing");
        public boolean oldSwingInterrupt = AnimationTweak.OLD_SWING_INTERRUPT.register("oldSwingInterrupt");
        public boolean oldSwingDropping = AnimationTweak.OLD_SWING_DROPPING.register("oldSwingDropping");
        public boolean oldClassicSwing = AnimationTweak.OLD_CLASSIC_SWING.register("oldClassicSwing");

        // Item

        public boolean oldItemCooldown = AnimationTweak.OLD_ITEM_COOLDOWN.register("oldItemCooldown");
        public boolean oldItemReequip = AnimationTweak.OLD_ITEM_REEQUIP.register("oldItemReequip");
        public boolean oldToolExplosion = AnimationTweak.OLD_TOOL_EXPLOSION.register("oldToolExplosion");

        // Mob

        public boolean oldZombieArms = AnimationTweak.OLD_ZOMBIE_ARMS.register("oldZombieArms");
        public boolean oldSkeletonArms = AnimationTweak.OLD_SKELETON_ARMS.register("oldSkeletonArms");
        public boolean oldGhastCharging = AnimationTweak.OLD_GHAST_CHARGING.register("oldGhastCharging");

        // Player

        public boolean oldBackwardWalking = AnimationTweak.OLD_BACKWARD_WALKING.register("oldBackwardWalking");
        public boolean oldCollideBobbing = AnimationTweak.OLD_COLLIDE_BOBBING.register("oldCollideBobbing");
        public boolean oldVerticalBobbing = AnimationTweak.OLD_VERTICAL_BOBBING.register("oldVerticalBobbing");
        public boolean oldCreativeCrouch = AnimationTweak.OLD_CREATIVE_CROUCH.register("oldCreativeCrouch");
        public boolean oldDirectionalDamage = AnimationTweak.OLD_DIRECTIONAL_DAMAGE.register("oldDirectionalDamage");
        public boolean oldRandomDamage = AnimationTweak.OLD_RANDOM_DAMAGE.register("oldRandomDamage");
        public boolean oldSneaking = AnimationTweak.OLD_SNEAKING.register("oldSneaking");
        public boolean disableDeathTopple = AnimationTweak.DISABLE_DEATH_TOPPLE.register("disableDeathTopple");
    }

    public Animation animation = new Animation();

    public static class Swing
    {
        // Global Speeds

        public boolean overrideSpeeds = SwingTweak.OVERRIDE_SPEEDS.register("overrideSpeeds");
        public boolean leftClickSpeedOnBlockInteract = SwingTweak.LEFT_CLICK_SPEED_ON_BLOCK_INTERACT.register("leftClickSpeedOnBlockInteract");
        public int leftGlobalSpeed = SwingTweak.LEFT_GLOBAL_SPEED.register("leftGlobalSpeed");
        public int rightGlobalSpeed = SwingTweak.RIGHT_GLOBAL_SPEED.register("rightGlobalSpeed");

        // Item Speeds

        public int leftItemSpeed = SwingTweak.LEFT_ITEM_SPEED.register("leftItemSpeed");
        public int rightItemSpeed = SwingTweak.RIGHT_ITEM_SPEED.register("rightItemSpeed");
        public int leftToolSpeed = SwingTweak.LEFT_TOOL_SPEED.register("leftToolSpeed");
        public int rightToolSpeed = SwingTweak.RIGHT_TOOL_SPEED.register("rightToolSpeed");
        public int leftBlockSpeed = SwingTweak.LEFT_BLOCK_SPEED.register("leftBlockSpeed");
        public int rightBlockSpeed = SwingTweak.RIGHT_BLOCK_SPEED.register("rightBlockSpeed");
        public int leftSwordSpeed = SwingTweak.LEFT_SWORD_SPEED.register("leftSwordSpeed");
        public int rightSwordSpeed = SwingTweak.RIGHT_SWORD_SPEED.register("rightSwordSpeed");

        // Potion Speeds

        public int leftHasteSpeed = SwingTweak.LEFT_HASTE_SPEED.register("leftHasteSpeed");
        public int rightHasteSpeed = SwingTweak.RIGHT_HASTE_SPEED.register("rightHasteSpeed");
        public int leftFatigueSpeed = SwingTweak.LEFT_FATIGUE_SPEED.register("leftFatigueSpeed");
        public int rightFatigueSpeed = SwingTweak.RIGHT_FATIGUE_SPEED.register("rightFatigueSpeed");

        // Custom Speeds

        public ItemMap<Integer> leftClickSwingSpeeds = SwingTweak.LEFT_CLICK_SWING_SPEEDS.register("leftClickSwingSpeeds");
        public ItemMap<Integer> rightClickSwingSpeeds = SwingTweak.RIGHT_CLICK_SWING_SPEEDS.register("rightClickSwingSpeeds");
    }

    public Swing swing = new Swing();
}
