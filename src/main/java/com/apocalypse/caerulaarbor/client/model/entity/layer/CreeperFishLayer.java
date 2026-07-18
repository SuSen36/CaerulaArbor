package com.apocalypse.caerulaarbor.client.model.entity.layer;

import com.apocalypse.caerulaarbor.CaerulaArborMod;
import com.apocalypse.caerulaarbor.entity.CreeperFishEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class CreeperFishLayer extends GeoRenderLayer<CreeperFishEntity> {
     private static final ResourceLocation DEFAULT_LAYER = new ResourceLocation(CaerulaArborMod.MODID, "textures/entities/creeperlit.png");
	 private static final ResourceLocation CRAWLER_LAYER = new ResourceLocation(CaerulaArborMod.MODID, "textures/entities/crawlerlit.png");

	public CreeperFishLayer(GeoRenderer<CreeperFishEntity> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(PoseStack poseStack, CreeperFishEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
		ResourceLocation layerTexture = animatable.getVariant() == CreeperFishEntity.Variant.CRAWLER ? CRAWLER_LAYER : DEFAULT_LAYER;
		RenderType glowRenderType = RenderType.eyes(layerTexture);
		getRenderer().reRender(getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
	}
}
