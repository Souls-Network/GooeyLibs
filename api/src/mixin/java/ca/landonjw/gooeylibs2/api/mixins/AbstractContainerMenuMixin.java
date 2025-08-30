package ca.landonjw.gooeylibs2.api.mixins;

import ca.landonjw.gooeylibs2.api.container.GooeyContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerMenu.class)
public class AbstractContainerMenuMixin {

    @Inject(method = "doClick", at = @At("HEAD"), cancellable = true)
    public void clicked(int slot, int dragType, ClickType type, Player player, CallbackInfo ci) {
        if(((AbstractContainerMenu) (Object) this) instanceof GooeyContainer container) {
            container.customClicked(slot, dragType, type, player);
            ci.cancel();
        }

    }
}
