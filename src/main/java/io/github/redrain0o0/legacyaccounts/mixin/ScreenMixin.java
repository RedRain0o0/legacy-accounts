package io.github.redrain0o0.legacyaccounts.mixin;

import com.mojang.blaze3d.platform.InputConstants;
import me.axieum.mcmod.authme.api.gui.AuthScreen;
import me.axieum.mcmod.authme.impl.gui.AuthMethodScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.sounds.SoundEvents;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import wily.legacy.client.screen.ControlTooltip;
import wily.legacy.util.ScreenUtil;

@Mixin(Screen.class)
public class ScreenMixin implements ControlTooltip.Event{

    @Shadow @Nullable protected Minecraft minecraft;

    @Inject(method = "keyPressed", at = @At("HEAD"), cancellable = true)
    private void keyPressed(int i, int j, int k, CallbackInfoReturnable<Boolean> cir) {
        if (((Object) this) instanceof TitleScreen) {
            if (i == InputConstants.KEY_X) {
                ScreenUtil.playSimpleUISound(SoundEvents.UI_BUTTON_CLICK.value(), 1.0f);
                this.minecraft.setScreen(new AuthMethodScreen((Screen) (Object) this));
            }
        }
    }
}
