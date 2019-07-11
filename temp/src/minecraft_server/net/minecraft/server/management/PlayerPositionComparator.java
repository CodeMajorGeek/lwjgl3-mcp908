package net.minecraft.server.management;

import java.util.Comparator;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChunkCoordinates;

public class PlayerPositionComparator implements Comparator {

   private final ChunkCoordinates field_82548_a;
   private static final String __OBFID = "CL_00001422";


   public PlayerPositionComparator(ChunkCoordinates p_i1499_1_) {
      this.field_82548_a = p_i1499_1_;
   }

   public int compare(EntityPlayerMP p_compare_1_, EntityPlayerMP p_compare_2_) {
      double var3 = p_compare_1_.func_70092_e((double)this.field_82548_a.field_71574_a, (double)this.field_82548_a.field_71572_b, (double)this.field_82548_a.field_71573_c);
      double var5 = p_compare_2_.func_70092_e((double)this.field_82548_a.field_71574_a, (double)this.field_82548_a.field_71572_b, (double)this.field_82548_a.field_71573_c);
      return var3 < var5?-1:(var3 > var5?1:0);
   }

   // $FF: synthetic method
   public int compare(Object p_compare_1_, Object p_compare_2_) {
      return this.compare((EntityPlayerMP)p_compare_1_, (EntityPlayerMP)p_compare_2_);
   }
}
