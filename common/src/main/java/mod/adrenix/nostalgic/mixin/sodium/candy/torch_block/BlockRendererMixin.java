package mod.adrenix.nostalgic.mixin.sodium.candy.torch_block;

import net.caffeinemc.mods.sodium.client.model.light.data.QuadLightData;
import net.caffeinemc.mods.sodium.client.model.quad.BakedQuadView;
import net.caffeinemc.mods.sodium.client.model.quad.properties.ModelQuadOrientation;
import net.caffeinemc.mods.sodium.client.render.chunk.compile.buffers.ChunkModelBuilder;
import net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderContext;
import net.caffeinemc.mods.sodium.client.render.chunk.compile.pipeline.BlockRenderer;
import net.caffeinemc.mods.sodium.client.render.chunk.terrain.material.Material;
import net.caffeinemc.mods.sodium.client.render.chunk.vertex.format.ChunkVertexEncoder;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockRenderer.class)
public abstract class BlockRendererMixin
{
//    /**
//     * Removes the bottom face quads for a wall torch model.
//     */
//    @ModifyReturnValue(
//        method = "getGeometry",
//        at = @At("RETURN")
//    )
//    private List<BakedQuad> nt_sodium_torch_block$hideBottom(List<BakedQuad> quads, BlockRenderContext context)
//    {
//        if (!CandyTweak.OLD_TORCH_BOTTOM.get() || !TorchHelper.isSheared(context.state()))
//            return quads;
//
//        if (CollectionUtil.isModifiable(quads))
//        {
//            try
//            {
//                List<BakedQuad> downQuads = new ArrayList<>();
//
//                for (BakedQuad quad : quads)
//                {
//                    if (quad.getDirection() == Direction.DOWN)
//                        downQuads.add(quad);
//                }
//
//                quads.removeAll(downQuads);
//            }
//            catch (ConcurrentModificationException ignored)
//            {
//                // No need to capture this exception - the torch will still have a bottom texture
//            }
//        }
//
//        return quads;
//    }
//
//    /**
//     * Changes the torch model used when retrieving quads.
//     */
//    @ModifyExpressionValue(
//        method = "getGeometry",
//        at = @At(
//            value = "INVOKE",
//            target = "Lme/jellysquid/mods/sodium/client/render/chunk/compile/pipeline/BlockRenderContext;model()Lnet/minecraft/client/resources/model/BakedModel;"
//        )
//    )
//    private BakedModel nt_sodium_torch_block$modifyTorchModel(BakedModel original, BlockRenderContext context)
//    {
//        if (TorchHelper.isSheared(context.state()))
//            return TorchHelper.getModel(context.state());
//
//        return original;
//    }
//
//    /**
//     * Changes the quad vertices data of wall torch blocks.
//     */
//    @Inject(
//        method = "writeGeometry",
//        at = @At(
//            shift = At.Shift.BEFORE,
//            value = "INVOKE",
//            target = "Lme/jellysquid/mods/sodium/client/render/chunk/vertex/builder/ChunkMeshBufferBuilder;push([Lme/jellysquid/mods/sodium/client/render/chunk/vertex/format/ChunkVertexEncoder$Vertex;Lme/jellysquid/mods/sodium/client/render/chunk/terrain/material/Material;)V"
//        )
//    )
//    private void nt_sodium_torch_block$rewriteVertexGeometry(BlockRenderContext context, ChunkModelBuilder builder, Vec3 offset, Material material, BakedQuadView quad, int[] colors, QuadLightData light, CallbackInfo callback, @Local ModelQuadOrientation orientation, @Local ChunkVertexEncoder.Vertex[] vertices)
//    {
//        if (TorchHelper.isNotLikeTorch(context.state()))
//            return;
//
//        PoseStack poseStack = new PoseStack();
//        boolean isSheared = TorchHelper.isSheared(context.state());
//        boolean isBright = TorchHelper.isBright(context.state());
//
//        if (isSheared)
//        {
//            poseStack.translate(context.origin().x(), context.origin().y(), context.origin().z());
//            TorchHelper.applyShear(poseStack, context.state());
//        }
//
//        for (int i = 0; i < vertices.length; i++)
//        {
//            ChunkVertexEncoder.Vertex vertex = vertices[i];
//
//            if (isSheared)
//            {
//                int srcIndex = orientation.getVertexIndex(i);
//                float x = quad.getX(srcIndex);
//                float y = quad.getY(srcIndex);
//                float z = quad.getZ(srcIndex);
//
//                Vector4f shear = poseStack.last().pose().transform(new Vector4f(x, y, z, 1.0F));
//
//                vertex.x = shear.x();
//                vertex.y = shear.y();
//                vertex.z = shear.z();
//            }
//
//            vertex.light = isBright ? LightTexture.FULL_BRIGHT : vertex.light;
//        }
//    }
}