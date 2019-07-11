package net.minecraft.item.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCloning;
import net.minecraft.item.crafting.RecipeFireworks;
import net.minecraft.item.crafting.RecipesArmor;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.item.crafting.RecipesCrafting;
import net.minecraft.item.crafting.RecipesDyes;
import net.minecraft.item.crafting.RecipesFood;
import net.minecraft.item.crafting.RecipesIngots;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.RecipesMapExtending;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraft.item.crafting.RecipesWeapons;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class CraftingManager {

   private static final CraftingManager field_77598_a = new CraftingManager();
   private List field_77597_b = new ArrayList();
   private static final String __OBFID = "CL_00000090";


   public static final CraftingManager func_77594_a() {
      return field_77598_a;
   }

   private CraftingManager() {
      (new RecipesTools()).func_77586_a(this);
      (new RecipesWeapons()).func_77583_a(this);
      (new RecipesIngots()).func_77590_a(this);
      (new RecipesFood()).func_77608_a(this);
      (new RecipesCrafting()).func_77589_a(this);
      (new RecipesArmor()).func_77609_a(this);
      (new RecipesDyes()).func_77607_a(this);
      this.field_77597_b.add(new RecipesArmorDyes());
      this.field_77597_b.add(new RecipeBookCloning());
      this.field_77597_b.add(new RecipesMapCloning());
      this.field_77597_b.add(new RecipesMapExtending());
      this.field_77597_b.add(new RecipeFireworks());
      this.func_92103_a(new ItemStack(Items.field_151121_aF, 3), new Object[]{"###", Character.valueOf('#'), Items.field_151120_aE});
      this.func_77596_b(new ItemStack(Items.field_151122_aG, 1), new Object[]{Items.field_151121_aF, Items.field_151121_aF, Items.field_151121_aF, Items.field_151116_aA});
      this.func_77596_b(new ItemStack(Items.field_151099_bA, 1), new Object[]{Items.field_151122_aG, new ItemStack(Items.field_151100_aR, 1, 0), Items.field_151008_G});
      this.func_92103_a(new ItemStack(Blocks.field_150422_aJ, 2), new Object[]{"###", "###", Character.valueOf('#'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Blocks.field_150463_bK, 6, 0), new Object[]{"###", "###", Character.valueOf('#'), Blocks.field_150347_e});
      this.func_92103_a(new ItemStack(Blocks.field_150463_bK, 6, 1), new Object[]{"###", "###", Character.valueOf('#'), Blocks.field_150341_Y});
      this.func_92103_a(new ItemStack(Blocks.field_150386_bk, 6), new Object[]{"###", "###", Character.valueOf('#'), Blocks.field_150385_bj});
      this.func_92103_a(new ItemStack(Blocks.field_150396_be, 1), new Object[]{"#W#", "#W#", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('W'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Blocks.field_150421_aI, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151045_i});
      this.func_92103_a(new ItemStack(Items.field_151058_ca, 2), new Object[]{"~~ ", "~O ", "  ~", Character.valueOf('~'), Items.field_151007_F, Character.valueOf('O'), Items.field_151123_aH});
      this.func_92103_a(new ItemStack(Blocks.field_150323_B, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151137_ax});
      this.func_92103_a(new ItemStack(Blocks.field_150342_X, 1), new Object[]{"###", "XXX", "###", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151122_aG});
      this.func_92103_a(new ItemStack(Blocks.field_150433_aE, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.field_151126_ay});
      this.func_92103_a(new ItemStack(Blocks.field_150431_aC, 6), new Object[]{"###", Character.valueOf('#'), Blocks.field_150433_aE});
      this.func_92103_a(new ItemStack(Blocks.field_150435_aG, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.field_151119_aD});
      this.func_92103_a(new ItemStack(Blocks.field_150336_V, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.field_151118_aC});
      this.func_92103_a(new ItemStack(Blocks.field_150426_aN, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.field_151114_aO});
      this.func_92103_a(new ItemStack(Blocks.field_150371_ca, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.field_151128_bU});
      this.func_92103_a(new ItemStack(Blocks.field_150325_L, 1), new Object[]{"##", "##", Character.valueOf('#'), Items.field_151007_F});
      this.func_92103_a(new ItemStack(Blocks.field_150335_W, 1), new Object[]{"X#X", "#X#", "X#X", Character.valueOf('X'), Items.field_151016_H, Character.valueOf('#'), Blocks.field_150354_m});
      this.func_92103_a(new ItemStack(Blocks.field_150333_U, 6, 3), new Object[]{"###", Character.valueOf('#'), Blocks.field_150347_e});
      this.func_92103_a(new ItemStack(Blocks.field_150333_U, 6, 0), new Object[]{"###", Character.valueOf('#'), Blocks.field_150348_b});
      this.func_92103_a(new ItemStack(Blocks.field_150333_U, 6, 1), new Object[]{"###", Character.valueOf('#'), Blocks.field_150322_A});
      this.func_92103_a(new ItemStack(Blocks.field_150333_U, 6, 4), new Object[]{"###", Character.valueOf('#'), Blocks.field_150336_V});
      this.func_92103_a(new ItemStack(Blocks.field_150333_U, 6, 5), new Object[]{"###", Character.valueOf('#'), Blocks.field_150417_aV});
      this.func_92103_a(new ItemStack(Blocks.field_150333_U, 6, 6), new Object[]{"###", Character.valueOf('#'), Blocks.field_150385_bj});
      this.func_92103_a(new ItemStack(Blocks.field_150333_U, 6, 7), new Object[]{"###", Character.valueOf('#'), Blocks.field_150371_ca});
      this.func_92103_a(new ItemStack(Blocks.field_150376_bx, 6, 0), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 0)});
      this.func_92103_a(new ItemStack(Blocks.field_150376_bx, 6, 2), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 2)});
      this.func_92103_a(new ItemStack(Blocks.field_150376_bx, 6, 1), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 1)});
      this.func_92103_a(new ItemStack(Blocks.field_150376_bx, 6, 3), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 3)});
      this.func_92103_a(new ItemStack(Blocks.field_150376_bx, 6, 4), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 4)});
      this.func_92103_a(new ItemStack(Blocks.field_150376_bx, 6, 5), new Object[]{"###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 5)});
      this.func_92103_a(new ItemStack(Blocks.field_150468_ap, 3), new Object[]{"# #", "###", "# #", Character.valueOf('#'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Items.field_151135_aq, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Blocks.field_150415_aT, 2), new Object[]{"###", "###", Character.valueOf('#'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Items.field_151139_aw, 1), new Object[]{"##", "##", "##", Character.valueOf('#'), Items.field_151042_j});
      this.func_92103_a(new ItemStack(Items.field_151155_ap, 3), new Object[]{"###", "###", " X ", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('X'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Items.field_151105_aU, 1), new Object[]{"AAA", "BEB", "CCC", Character.valueOf('A'), Items.field_151117_aB, Character.valueOf('B'), Items.field_151102_aT, Character.valueOf('C'), Items.field_151015_O, Character.valueOf('E'), Items.field_151110_aK});
      this.func_92103_a(new ItemStack(Items.field_151102_aT, 1), new Object[]{"#", Character.valueOf('#'), Items.field_151120_aE});
      this.func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 0), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 0)});
      this.func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 1), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 1)});
      this.func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 2), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 2)});
      this.func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 3), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.field_150364_r, 1, 3)});
      this.func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 4), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.field_150363_s, 1, 0)});
      this.func_92103_a(new ItemStack(Blocks.field_150344_f, 4, 5), new Object[]{"#", Character.valueOf('#'), new ItemStack(Blocks.field_150363_s, 1, 1)});
      this.func_92103_a(new ItemStack(Items.field_151055_y, 4), new Object[]{"#", "#", Character.valueOf('#'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Blocks.field_150478_aa, 4), new Object[]{"X", "#", Character.valueOf('X'), Items.field_151044_h, Character.valueOf('#'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Blocks.field_150478_aa, 4), new Object[]{"X", "#", Character.valueOf('X'), new ItemStack(Items.field_151044_h, 1, 1), Character.valueOf('#'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Items.field_151054_z, 4), new Object[]{"# #", " # ", Character.valueOf('#'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Items.field_151069_bo, 3), new Object[]{"# #", " # ", Character.valueOf('#'), Blocks.field_150359_w});
      this.func_92103_a(new ItemStack(Blocks.field_150448_aq, 16), new Object[]{"X X", "X#X", "X X", Character.valueOf('X'), Items.field_151042_j, Character.valueOf('#'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Blocks.field_150318_D, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.field_151043_k, Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('#'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Blocks.field_150408_cc, 6), new Object[]{"XSX", "X#X", "XSX", Character.valueOf('X'), Items.field_151042_j, Character.valueOf('#'), Blocks.field_150429_aA, Character.valueOf('S'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Blocks.field_150319_E, 6), new Object[]{"X X", "X#X", "XRX", Character.valueOf('X'), Items.field_151042_j, Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('#'), Blocks.field_150456_au});
      this.func_92103_a(new ItemStack(Items.field_151143_au, 1), new Object[]{"# #", "###", Character.valueOf('#'), Items.field_151042_j});
      this.func_92103_a(new ItemStack(Items.field_151066_bu, 1), new Object[]{"# #", "# #", "###", Character.valueOf('#'), Items.field_151042_j});
      this.func_92103_a(new ItemStack(Items.field_151067_bt, 1), new Object[]{" B ", "###", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('B'), Items.field_151072_bj});
      this.func_92103_a(new ItemStack(Blocks.field_150428_aP, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.field_150423_aK, Character.valueOf('B'), Blocks.field_150478_aa});
      this.func_92103_a(new ItemStack(Items.field_151108_aI, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.field_150486_ae, Character.valueOf('B'), Items.field_151143_au});
      this.func_92103_a(new ItemStack(Items.field_151109_aJ, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.field_150460_al, Character.valueOf('B'), Items.field_151143_au});
      this.func_92103_a(new ItemStack(Items.field_151142_bV, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.field_150335_W, Character.valueOf('B'), Items.field_151143_au});
      this.func_92103_a(new ItemStack(Items.field_151140_bW, 1), new Object[]{"A", "B", Character.valueOf('A'), Blocks.field_150438_bZ, Character.valueOf('B'), Items.field_151143_au});
      this.func_92103_a(new ItemStack(Items.field_151124_az, 1), new Object[]{"# #", "###", Character.valueOf('#'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Items.field_151133_ar, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.field_151042_j});
      this.func_92103_a(new ItemStack(Items.field_151162_bE, 1), new Object[]{"# #", " # ", Character.valueOf('#'), Items.field_151118_aC});
      this.func_77596_b(new ItemStack(Items.field_151033_d, 1), new Object[]{new ItemStack(Items.field_151042_j, 1), new ItemStack(Items.field_151145_ak, 1)});
      this.func_92103_a(new ItemStack(Items.field_151025_P, 1), new Object[]{"###", Character.valueOf('#'), Items.field_151015_O});
      this.func_92103_a(new ItemStack(Blocks.field_150476_ad, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 0)});
      this.func_92103_a(new ItemStack(Blocks.field_150487_bG, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 2)});
      this.func_92103_a(new ItemStack(Blocks.field_150485_bF, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 1)});
      this.func_92103_a(new ItemStack(Blocks.field_150481_bH, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 3)});
      this.func_92103_a(new ItemStack(Blocks.field_150400_ck, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 4)});
      this.func_92103_a(new ItemStack(Blocks.field_150401_cl, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), new ItemStack(Blocks.field_150344_f, 1, 5)});
      this.func_92103_a(new ItemStack(Items.field_151112_aM, 1), new Object[]{"  #", " #X", "# X", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Items.field_151007_F});
      this.func_92103_a(new ItemStack(Items.field_151146_bM, 1), new Object[]{"# ", " X", Character.valueOf('#'), Items.field_151112_aM, Character.valueOf('X'), Items.field_151172_bF}).func_92100_c();
      this.func_92103_a(new ItemStack(Blocks.field_150446_ar, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150347_e});
      this.func_92103_a(new ItemStack(Blocks.field_150389_bf, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150336_V});
      this.func_92103_a(new ItemStack(Blocks.field_150390_bg, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150417_aV});
      this.func_92103_a(new ItemStack(Blocks.field_150387_bl, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150385_bj});
      this.func_92103_a(new ItemStack(Blocks.field_150372_bz, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150322_A});
      this.func_92103_a(new ItemStack(Blocks.field_150370_cb, 4), new Object[]{"#  ", "## ", "###", Character.valueOf('#'), Blocks.field_150371_ca});
      this.func_92103_a(new ItemStack(Items.field_151159_an, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Blocks.field_150325_L});
      this.func_92103_a(new ItemStack(Items.field_151160_bD, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Items.field_151116_aA});
      this.func_92103_a(new ItemStack(Items.field_151153_ao, 1, 0), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.field_151043_k, Character.valueOf('X'), Items.field_151034_e});
      this.func_92103_a(new ItemStack(Items.field_151153_ao, 1, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Blocks.field_150340_R, Character.valueOf('X'), Items.field_151034_e});
      this.func_92103_a(new ItemStack(Items.field_151150_bK, 1, 0), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.field_151074_bl, Character.valueOf('X'), Items.field_151172_bF});
      this.func_92103_a(new ItemStack(Items.field_151060_bw, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.field_151074_bl, Character.valueOf('X'), Items.field_151127_ba});
      this.func_92103_a(new ItemStack(Blocks.field_150442_at, 1), new Object[]{"X", "#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('X'), Items.field_151055_y});
      this.func_92103_a(new ItemStack(Blocks.field_150479_bC, 2), new Object[]{"I", "S", "#", Character.valueOf('#'), Blocks.field_150344_f, Character.valueOf('S'), Items.field_151055_y, Character.valueOf('I'), Items.field_151042_j});
      this.func_92103_a(new ItemStack(Blocks.field_150429_aA, 1), new Object[]{"X", "#", Character.valueOf('#'), Items.field_151055_y, Character.valueOf('X'), Items.field_151137_ax});
      this.func_92103_a(new ItemStack(Items.field_151107_aW, 1), new Object[]{"#X#", "III", Character.valueOf('#'), Blocks.field_150429_aA, Character.valueOf('X'), Items.field_151137_ax, Character.valueOf('I'), Blocks.field_150348_b});
      this.func_92103_a(new ItemStack(Items.field_151132_bS, 1), new Object[]{" # ", "#X#", "III", Character.valueOf('#'), Blocks.field_150429_aA, Character.valueOf('X'), Items.field_151128_bU, Character.valueOf('I'), Blocks.field_150348_b});
      this.func_92103_a(new ItemStack(Items.field_151113_aN, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.field_151043_k, Character.valueOf('X'), Items.field_151137_ax});
      this.func_92103_a(new ItemStack(Items.field_151111_aL, 1), new Object[]{" # ", "#X#", " # ", Character.valueOf('#'), Items.field_151042_j, Character.valueOf('X'), Items.field_151137_ax});
      this.func_92103_a(new ItemStack(Items.field_151148_bJ, 1), new Object[]{"###", "#X#", "###", Character.valueOf('#'), Items.field_151121_aF, Character.valueOf('X'), Items.field_151111_aL});
      this.func_92103_a(new ItemStack(Blocks.field_150430_aB, 1), new Object[]{"#", Character.valueOf('#'), Blocks.field_150348_b});
      this.func_92103_a(new ItemStack(Blocks.field_150471_bO, 1), new Object[]{"#", Character.valueOf('#'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Blocks.field_150456_au, 1), new Object[]{"##", Character.valueOf('#'), Blocks.field_150348_b});
      this.func_92103_a(new ItemStack(Blocks.field_150452_aw, 1), new Object[]{"##", Character.valueOf('#'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Blocks.field_150443_bT, 1), new Object[]{"##", Character.valueOf('#'), Items.field_151042_j});
      this.func_92103_a(new ItemStack(Blocks.field_150445_bS, 1), new Object[]{"##", Character.valueOf('#'), Items.field_151043_k});
      this.func_92103_a(new ItemStack(Blocks.field_150367_z, 1), new Object[]{"###", "#X#", "#R#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('X'), Items.field_151031_f, Character.valueOf('R'), Items.field_151137_ax});
      this.func_92103_a(new ItemStack(Blocks.field_150409_cd, 1), new Object[]{"###", "# #", "#R#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('R'), Items.field_151137_ax});
      this.func_92103_a(new ItemStack(Blocks.field_150331_J, 1), new Object[]{"TTT", "#X#", "#R#", Character.valueOf('#'), Blocks.field_150347_e, Character.valueOf('X'), Items.field_151042_j, Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('T'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Blocks.field_150320_F, 1), new Object[]{"S", "P", Character.valueOf('S'), Items.field_151123_aH, Character.valueOf('P'), Blocks.field_150331_J});
      this.func_92103_a(new ItemStack(Items.field_151104_aV, 1), new Object[]{"###", "XXX", Character.valueOf('#'), Blocks.field_150325_L, Character.valueOf('X'), Blocks.field_150344_f});
      this.func_92103_a(new ItemStack(Blocks.field_150381_bn, 1), new Object[]{" B ", "D#D", "###", Character.valueOf('#'), Blocks.field_150343_Z, Character.valueOf('B'), Items.field_151122_aG, Character.valueOf('D'), Items.field_151045_i});
      this.func_92103_a(new ItemStack(Blocks.field_150467_bQ, 1), new Object[]{"III", " i ", "iii", Character.valueOf('I'), Blocks.field_150339_S, Character.valueOf('i'), Items.field_151042_j});
      this.func_77596_b(new ItemStack(Items.field_151061_bv, 1), new Object[]{Items.field_151079_bi, Items.field_151065_br});
      this.func_77596_b(new ItemStack(Items.field_151059_bz, 3), new Object[]{Items.field_151016_H, Items.field_151065_br, Items.field_151044_h});
      this.func_77596_b(new ItemStack(Items.field_151059_bz, 3), new Object[]{Items.field_151016_H, Items.field_151065_br, new ItemStack(Items.field_151044_h, 1, 1)});
      this.func_92103_a(new ItemStack(Blocks.field_150453_bW), new Object[]{"GGG", "QQQ", "WWW", Character.valueOf('G'), Blocks.field_150359_w, Character.valueOf('Q'), Items.field_151128_bU, Character.valueOf('W'), Blocks.field_150376_bx});
      this.func_92103_a(new ItemStack(Blocks.field_150438_bZ), new Object[]{"I I", "ICI", " I ", Character.valueOf('I'), Items.field_151042_j, Character.valueOf('C'), Blocks.field_150486_ae});
      Collections.sort(this.field_77597_b, new Comparator() {

         private static final String __OBFID = "CL_00000091";

         public int compare(IRecipe p_compare_1_, IRecipe p_compare_2_) {
            return p_compare_1_ instanceof ShapelessRecipes && p_compare_2_ instanceof ShapedRecipes?1:(p_compare_2_ instanceof ShapelessRecipes && p_compare_1_ instanceof ShapedRecipes?-1:(p_compare_2_.func_77570_a() < p_compare_1_.func_77570_a()?-1:(p_compare_2_.func_77570_a() > p_compare_1_.func_77570_a()?1:0)));
         }
         // $FF: synthetic method
         public int compare(Object p_compare_1_, Object p_compare_2_) {
            return this.compare((IRecipe)p_compare_1_, (IRecipe)p_compare_2_);
         }
      });
   }

   ShapedRecipes func_92103_a(ItemStack p_92103_1_, Object ... p_92103_2_) {
      String var3 = "";
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      if(p_92103_2_[var4] instanceof String[]) {
         String[] var7 = (String[])((String[])p_92103_2_[var4++]);

         for(int var8 = 0; var8 < var7.length; ++var8) {
            String var9 = var7[var8];
            ++var6;
            var5 = var9.length();
            var3 = var3 + var9;
         }
      } else {
         while(p_92103_2_[var4] instanceof String) {
            String var11 = (String)p_92103_2_[var4++];
            ++var6;
            var5 = var11.length();
            var3 = var3 + var11;
         }
      }

      HashMap var12;
      for(var12 = new HashMap(); var4 < p_92103_2_.length; var4 += 2) {
         Character var13 = (Character)p_92103_2_[var4];
         ItemStack var15 = null;
         if(p_92103_2_[var4 + 1] instanceof Item) {
            var15 = new ItemStack((Item)p_92103_2_[var4 + 1]);
         } else if(p_92103_2_[var4 + 1] instanceof Block) {
            var15 = new ItemStack((Block)p_92103_2_[var4 + 1], 1, 32767);
         } else if(p_92103_2_[var4 + 1] instanceof ItemStack) {
            var15 = (ItemStack)p_92103_2_[var4 + 1];
         }

         var12.put(var13, var15);
      }

      ItemStack[] var14 = new ItemStack[var5 * var6];

      for(int var16 = 0; var16 < var5 * var6; ++var16) {
         char var10 = var3.charAt(var16);
         if(var12.containsKey(Character.valueOf(var10))) {
            var14[var16] = ((ItemStack)var12.get(Character.valueOf(var10))).func_77946_l();
         } else {
            var14[var16] = null;
         }
      }

      ShapedRecipes var17 = new ShapedRecipes(var5, var6, var14, p_92103_1_);
      this.field_77597_b.add(var17);
      return var17;
   }

   void func_77596_b(ItemStack p_77596_1_, Object ... p_77596_2_) {
      ArrayList var3 = new ArrayList();
      Object[] var4 = p_77596_2_;
      int var5 = p_77596_2_.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         Object var7 = var4[var6];
         if(var7 instanceof ItemStack) {
            var3.add(((ItemStack)var7).func_77946_l());
         } else if(var7 instanceof Item) {
            var3.add(new ItemStack((Item)var7));
         } else {
            if(!(var7 instanceof Block)) {
               throw new RuntimeException("Invalid shapeless recipy!");
            }

            var3.add(new ItemStack((Block)var7));
         }
      }

      this.field_77597_b.add(new ShapelessRecipes(p_77596_1_, var3));
   }

   public ItemStack func_82787_a(InventoryCrafting p_82787_1_, World p_82787_2_) {
      int var3 = 0;
      ItemStack var4 = null;
      ItemStack var5 = null;

      int var6;
      for(var6 = 0; var6 < p_82787_1_.func_70302_i_(); ++var6) {
         ItemStack var7 = p_82787_1_.func_70301_a(var6);
         if(var7 != null) {
            if(var3 == 0) {
               var4 = var7;
            }

            if(var3 == 1) {
               var5 = var7;
            }

            ++var3;
         }
      }

      if(var3 == 2 && var4.func_77973_b() == var5.func_77973_b() && var4.field_77994_a == 1 && var5.field_77994_a == 1 && var4.func_77973_b().func_77645_m()) {
         Item var11 = var4.func_77973_b();
         int var13 = var11.func_77612_l() - var4.func_77952_i();
         int var8 = var11.func_77612_l() - var5.func_77952_i();
         int var9 = var13 + var8 + var11.func_77612_l() * 5 / 100;
         int var10 = var11.func_77612_l() - var9;
         if(var10 < 0) {
            var10 = 0;
         }

         return new ItemStack(var4.func_77973_b(), 1, var10);
      } else {
         for(var6 = 0; var6 < this.field_77597_b.size(); ++var6) {
            IRecipe var12 = (IRecipe)this.field_77597_b.get(var6);
            if(var12.func_77569_a(p_82787_1_, p_82787_2_)) {
               return var12.func_77572_b(p_82787_1_);
            }
         }

         return null;
      }
   }

   public List func_77592_b() {
      return this.field_77597_b;
   }

}
