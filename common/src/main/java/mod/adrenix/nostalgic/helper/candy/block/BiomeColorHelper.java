package mod.adrenix.nostalgic.helper.candy.block;

import mod.adrenix.nostalgic.tweak.config.CandyTweak;
import mod.adrenix.nostalgic.util.common.color.HexUtil;

public class BiomeColorHelper {
    public static int waterColor = HexUtil.parseInt(CandyTweak.WATER_COLOR.get());
    public static int grassColor = HexUtil.parseInt(CandyTweak.GRASS_COLOR.get());
    public static int foliageColor = HexUtil.parseInt(CandyTweak.FOLIAGE_COLOR.get());

    public static void reloadColors() {
        waterColor = HexUtil.parseInt(CandyTweak.WATER_COLOR.get());
        grassColor = HexUtil.parseInt(CandyTweak.GRASS_COLOR.get());
        foliageColor = HexUtil.parseInt(CandyTweak.FOLIAGE_COLOR.get());
    }
}
