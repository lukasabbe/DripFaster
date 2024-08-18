package me.lukasabbe.dripfaster.mixin;

import com.mojang.brigadier.context.CommandContext;
import me.lukasabbe.dripfaster.Dripfaster;
import net.minecraft.server.command.ReloadCommand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ReloadCommand.class)
public class ReloadCommandMixin {
    @Inject(method = "method_13530", at=@At("HEAD"))
    private static void injectNewReloadPart(CommandContext context, CallbackInfoReturnable<Integer> cir){
        Dripfaster.CONFIG.reloadConfig();
    }
}