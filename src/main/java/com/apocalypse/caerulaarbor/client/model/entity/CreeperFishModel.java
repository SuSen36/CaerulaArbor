package com.apocalypse.caerulaarbor.client.model.entity;

import com.apocalypse.caerulaarbor.CaerulaArborMod;
import com.apocalypse.caerulaarbor.entity.CreeperFishEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CreeperFishModel extends GeoModel<CreeperFishEntity> {
    private static final ResourceLocation DEFAULT_MODEL = new ResourceLocation(CaerulaArborMod.MODID, "geo/creeperfish.geo.json");
    private static final ResourceLocation CRAWLER_MODEL = new ResourceLocation(CaerulaArborMod.MODID, "geo/crawlerfish.geo.json");
    private static final ResourceLocation DEFAULT_TEXTURE = new ResourceLocation(CaerulaArborMod.MODID, "textures/entities/creeperfish.png");
    private static final ResourceLocation CRAWLER_TEXTURE = new ResourceLocation(CaerulaArborMod.MODID, "textures/entities/crawlerfish.png");

    @Override
    public ResourceLocation getAnimationResource(CreeperFishEntity entity) {
        return new ResourceLocation(CaerulaArborMod.MODID, "animations/creeperfish.animation.json");
    }

    @Override
    public ResourceLocation getModelResource(CreeperFishEntity entity) {
        return switch (entity.getVariant()) {
            case CRAWLER -> CRAWLER_MODEL;
            default -> DEFAULT_MODEL;
        };
    }

    @Override
    public ResourceLocation getTextureResource(CreeperFishEntity entity) {
        return switch (entity.getVariant()) {
            case CRAWLER -> CRAWLER_TEXTURE;
            default -> DEFAULT_TEXTURE;
        };
    }

    @Override
    public void setCustomAnimations(CreeperFishEntity animatable, long instanceId, AnimationState<CreeperFishEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if (head != null) {
            EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
