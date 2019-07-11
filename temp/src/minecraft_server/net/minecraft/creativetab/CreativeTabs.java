package net.minecraft.creativetab;

import net.minecraft.enchantment.EnumEnchantmentType;

public abstract class CreativeTabs {

   public static final CreativeTabs[] field_78032_a = new CreativeTabs[12];
   public static final CreativeTabs field_78030_b = new CreativeTabs(0, "buildingBlocks") {

      private static final String __OBFID = "CL_00000006";

   };
   public static final CreativeTabs field_78031_c = new CreativeTabs(1, "decorations") {

      private static final String __OBFID = "CL_00000010";

   };
   public static final CreativeTabs field_78028_d = new CreativeTabs(2, "redstone") {

      private static final String __OBFID = "CL_00000011";

   };
   public static final CreativeTabs field_78029_e = new CreativeTabs(3, "transportation") {

      private static final String __OBFID = "CL_00000012";

   };
   public static final CreativeTabs field_78026_f = (new CreativeTabs(4, "misc") {

      private static final String __OBFID = "CL_00000014";

   }).func_111229_a(new EnumEnchantmentType[]{EnumEnchantmentType.all});
   public static final CreativeTabs field_78027_g = (new CreativeTabs(5, "search") {

      private static final String __OBFID = "CL_00000015";

   }).func_78025_a("item_search.png");
   public static final CreativeTabs field_78039_h = new CreativeTabs(6, "food") {

      private static final String __OBFID = "CL_00000016";

   };
   public static final CreativeTabs field_78040_i = (new CreativeTabs(7, "tools") {

      private static final String __OBFID = "CL_00000017";

   }).func_111229_a(new EnumEnchantmentType[]{EnumEnchantmentType.digger, EnumEnchantmentType.fishing_rod, EnumEnchantmentType.breakable});
   public static final CreativeTabs field_78037_j = (new CreativeTabs(8, "combat") {

      private static final String __OBFID = "CL_00000018";

   }).func_111229_a(new EnumEnchantmentType[]{EnumEnchantmentType.armor, EnumEnchantmentType.armor_feet, EnumEnchantmentType.armor_head, EnumEnchantmentType.armor_legs, EnumEnchantmentType.armor_torso, EnumEnchantmentType.bow, EnumEnchantmentType.weapon});
   public static final CreativeTabs field_78038_k = new CreativeTabs(9, "brewing") {

      private static final String __OBFID = "CL_00000007";

   };
   public static final CreativeTabs field_78035_l = new CreativeTabs(10, "materials") {

      private static final String __OBFID = "CL_00000008";

   };
   public static final CreativeTabs field_78036_m = (new CreativeTabs(11, "inventory") {

      private static final String __OBFID = "CL_00000009";

   }).func_78025_a("inventory.png").func_78022_j().func_78014_h();
   private final int field_78033_n;
   private final String field_78034_o;
   private String field_78043_p = "items.png";
   private boolean field_78042_q = true;
   private boolean field_78041_r = true;
   private EnumEnchantmentType[] field_111230_s;
   private static final String __OBFID = "CL_00000005";


   public CreativeTabs(int p_i1853_1_, String p_i1853_2_) {
      this.field_78033_n = p_i1853_1_;
      this.field_78034_o = p_i1853_2_;
      field_78032_a[p_i1853_1_] = this;
   }

   public CreativeTabs func_78025_a(String p_78025_1_) {
      this.field_78043_p = p_78025_1_;
      return this;
   }

   public CreativeTabs func_78014_h() {
      this.field_78041_r = false;
      return this;
   }

   public CreativeTabs func_78022_j() {
      this.field_78042_q = false;
      return this;
   }

   public CreativeTabs func_111229_a(EnumEnchantmentType ... p_111229_1_) {
      this.field_111230_s = p_111229_1_;
      return this;
   }

}
