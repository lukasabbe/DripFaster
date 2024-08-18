package me.lukasabbe.dripfaster.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.lukasabbe.dripfaster.Dripfaster;
import net.minecraft.block.PointedDripstoneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PointedDripstoneBlock.class)
public class DripStoneMixin {
    @ModifyExpressionValue(method = "dripTick", at= @At(value = "CONSTANT", args = "floatValue=0.17578125F"))
    private static float changeWaterConstant(float original){
        return Dripfaster.CONFIG.waterDrip;
    }
    @ModifyExpressionValue(method = "dripTick", at= @At(value = "CONSTANT", args = "floatValue=0.05859375F"))
    private static float changeLavaConstant(float original){
        return Dripfaster.CONFIG.lavaDrip;
    }
}
