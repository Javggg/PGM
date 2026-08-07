package tc.oc.pgm.platform.modern.entity;

import static tc.oc.pgm.util.platform.Supports.Variant.PAPER;

import org.bukkit.EntityEffect;
import org.bukkit.entity.Allay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mannequin;
import org.bukkit.entity.Sheep;
import tc.oc.pgm.entity.MobAnimation;
import tc.oc.pgm.entity.MobAnimations;
import tc.oc.pgm.util.platform.Supports;

@Supports(PAPER)
public class ModernMobAnimations extends MobAnimations {

  public ModernMobAnimations() {
    handler(MobAnimation.SWING_MAIN_HAND, LivingEntity::swingMainHand);
    handler(MobAnimation.SWING_OFFHAND, LivingEntity::swingOffHand);
    handler(MobAnimation.START_DANCING, le -> ((Allay) le).startDancing());
    handler(MobAnimation.STOP_DANCING, le -> ((Allay) le).stopDancing());
    handler(MobAnimation.EAT_GRASS, le -> le.playEffect(EntityEffect.SHEEP_EAT_GRASS));

    register(Mannequin.class, MobAnimation.SWING_MAIN_HAND);
    register(Mannequin.class, MobAnimation.SWING_OFFHAND);

    register(Allay.class, MobAnimation.START_DANCING);
    register(Allay.class, MobAnimation.STOP_DANCING);

    register(Sheep.class, MobAnimation.EAT_GRASS);
  }
}
