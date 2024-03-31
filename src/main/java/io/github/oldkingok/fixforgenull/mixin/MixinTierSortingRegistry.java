package io.github.oldkingok.fixforgenull.mixin;

import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.TierSortingRegistry;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(TierSortingRegistry.class)
public abstract class MixinTierSortingRegistry {

    @Shadow(remap = false) @Final private static List<Tier> sortedTiers;

    @Inject(method = "isCorrectTierForDrops", at = @At("HEAD"), remap = false)
    private static void onIsCorrectTierForDrops(Tier tier, BlockState state, CallbackInfoReturnable<Boolean> cir)
    {
        while (sortedTiers.contains(null))
        {
            sortedTiers.remove(null);
        }
    }
}
