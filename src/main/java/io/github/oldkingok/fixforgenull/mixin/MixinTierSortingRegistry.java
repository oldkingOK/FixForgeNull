package io.github.oldkingok.fixforgenull.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraftforge.common.TierSortingRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(TierSortingRegistry.class)
public abstract class MixinTierSortingRegistry {

    @Inject(method = "registerTier", at = @At("HEAD"), remap = false)
    private static void voidOnRegisterTier(Tier tier, ResourceLocation name, List<Object> after, List<Object> before, CallbackInfoReturnable<Tier> cir)
    {
        if (tier == null)
            throw new NullPointerException("Registering a new Tier requires a nonnull tier! ResourceLocation name: " + name);
    }
}
