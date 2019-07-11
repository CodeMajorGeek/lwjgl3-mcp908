package net.minecraft.realms;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.shader.TesselatorVertexState;

public class Tezzelator {

   public static Tessellator t = Tessellator.field_78398_a;
   public static final Tezzelator instance = new Tezzelator();
   private static final String __OBFID = "CL_00001855";


   public int end() {
      return t.func_78381_a();
   }

   public void vertex(double p_vertex_1_, double p_vertex_3_, double p_vertex_5_) {
      t.func_78377_a(p_vertex_1_, p_vertex_3_, p_vertex_5_);
   }

   public void color(float p_color_1_, float p_color_2_, float p_color_3_, float p_color_4_) {
      t.func_78369_a(p_color_1_, p_color_2_, p_color_3_, p_color_4_);
   }

   public void color(int p_color_1_, int p_color_2_, int p_color_3_) {
      t.func_78376_a(p_color_1_, p_color_2_, p_color_3_);
   }

   public void tex2(int p_tex2_1_) {
      t.func_78380_c(p_tex2_1_);
   }

   public void normal(float p_normal_1_, float p_normal_2_, float p_normal_3_) {
      t.func_78375_b(p_normal_1_, p_normal_2_, p_normal_3_);
   }

   public void noColor() {
      t.func_78383_c();
   }

   public void color(int p_color_1_) {
      t.func_78378_d(p_color_1_);
   }

   public void color(float p_color_1_, float p_color_2_, float p_color_3_) {
      t.func_78386_a(p_color_1_, p_color_2_, p_color_3_);
   }

   public TesselatorVertexState sortQuads(float p_sortQuads_1_, float p_sortQuads_2_, float p_sortQuads_3_) {
      return t.func_147564_a(p_sortQuads_1_, p_sortQuads_2_, p_sortQuads_3_);
   }

   public void restoreState(TesselatorVertexState p_restoreState_1_) {
      t.func_147565_a(p_restoreState_1_);
   }

   public void begin(int p_begin_1_) {
      t.func_78371_b(p_begin_1_);
   }

   public void begin() {
      t.func_78382_b();
   }

   public void vertexUV(double p_vertexUV_1_, double p_vertexUV_3_, double p_vertexUV_5_, double p_vertexUV_7_, double p_vertexUV_9_) {
      t.func_78374_a(p_vertexUV_1_, p_vertexUV_3_, p_vertexUV_5_, p_vertexUV_7_, p_vertexUV_9_);
   }

   public void color(int p_color_1_, int p_color_2_) {
      t.func_78384_a(p_color_1_, p_color_2_);
   }

   public void offset(double p_offset_1_, double p_offset_3_, double p_offset_5_) {
      t.func_78373_b(p_offset_1_, p_offset_3_, p_offset_5_);
   }

   public void color(int p_color_1_, int p_color_2_, int p_color_3_, int p_color_4_) {
      t.func_78370_a(p_color_1_, p_color_2_, p_color_3_, p_color_4_);
   }

   public void addOffset(float p_addOffset_1_, float p_addOffset_2_, float p_addOffset_3_) {
      t.func_78372_c(p_addOffset_1_, p_addOffset_2_, p_addOffset_3_);
   }

   public void tex(double p_tex_1_, double p_tex_3_) {
      t.func_78385_a(p_tex_1_, p_tex_3_);
   }

   public void color(byte p_color_1_, byte p_color_2_, byte p_color_3_) {
      t.func_154352_a(p_color_1_, p_color_2_, p_color_3_);
   }

}
