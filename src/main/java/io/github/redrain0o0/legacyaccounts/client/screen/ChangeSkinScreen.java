package io.github.redrain0o0.legacyaccounts.client.screen;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import wily.legacy.client.LegacyTip;
import wily.legacy.client.screen.*;

public class ChangeSkinScreen extends RenderableVListScreen {

    public ChangeSkinScreen(Screen parent) {
        super(parent,Component.translatable("legacy.menu.change_skin"), r->{});
        renderableVList.addRenderable(Button.builder(Component.translatable("legacy.menu.change_skin"),(b)-> minecraft.getToasts().addToast(new LegacyTip(Component.literal("Work in Progress!!"), 80, 40).disappearTime(960))).build());
    }
}