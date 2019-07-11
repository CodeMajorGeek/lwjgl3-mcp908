package net.minecraft.network.play;

import net.minecraft.network.INetHandler;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.network.play.client.C11PacketEnchantItem;
import net.minecraft.network.play.client.C12PacketUpdateSign;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C14PacketTabComplete;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C17PacketCustomPayload;

public interface INetHandlerPlayServer extends INetHandler
{
    void func_147350_a(C0APacketAnimation p_147350_1_);

    void func_147354_a(C01PacketChatMessage p_147354_1_);

    void func_147341_a(C14PacketTabComplete p_147341_1_);

    void func_147342_a(C16PacketClientStatus p_147342_1_);

    void func_147352_a(C15PacketClientSettings p_147352_1_);

    void func_147339_a(C0FPacketConfirmTransaction p_147339_1_);

    void func_147338_a(C11PacketEnchantItem p_147338_1_);

    void func_147351_a(C0EPacketClickWindow p_147351_1_);

    void func_147356_a(C0DPacketCloseWindow p_147356_1_);

    void func_147349_a(C17PacketCustomPayload p_147349_1_);

    void func_147340_a(C02PacketUseEntity p_147340_1_);

    void func_147353_a(C00PacketKeepAlive p_147353_1_);

    void func_147347_a(C03PacketPlayer p_147347_1_);

    void func_147348_a(C13PacketPlayerAbilities p_147348_1_);

    void func_147345_a(C07PacketPlayerDigging p_147345_1_);

    void func_147357_a(C0BPacketEntityAction p_147357_1_);

    void func_147358_a(C0CPacketInput p_147358_1_);

    void func_147355_a(C09PacketHeldItemChange p_147355_1_);

    void func_147344_a(C10PacketCreativeInventoryAction p_147344_1_);

    void func_147343_a(C12PacketUpdateSign p_147343_1_);

    void func_147346_a(C08PacketPlayerBlockPlacement p_147346_1_);
}
