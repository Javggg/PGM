package tc.oc.pgm.platform.modern.entity;

import static tc.oc.pgm.util.platform.Supports.Variant.PAPER;

import org.bukkit.EntityEffect;
import org.bukkit.entity.Allay;
import org.bukkit.entity.Goat;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mannequin;
import org.bukkit.entity.Ravager;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Warden;
import org.bukkit.entity.Wolf;
import tc.oc.pgm.entity.MobAnimation;
import tc.oc.pgm.entity.MobAnimations;
import tc.oc.pgm.util.platform.Supports;

@Supports(PAPER)
public class ModernMobAnimations extends MobAnimations {

  public ModernMobAnimations() {
    handler(MobAnimation.SWING_MAIN_HAND, LivingEntity::swingMainHand);
    handler(MobAnimation.SWING_OFFHAND, LivingEntity::swingOffHand);
    handler(MobAnimation.ALLAY_START_DANCING, le -> ((Allay) le).startDancing());
    handler(MobAnimation.ALLAY_STOP_DANCING, le -> ((Allay) le).stopDancing());
    handler(MobAnimation.SHEEP_EAT_GRASS, le -> le.playEffect(EntityEffect.SHEEP_EAT_GRASS));
    handler(MobAnimation.IRON_GOLEM_ROSE, le -> le.playEffect(EntityEffect.IRON_GOLEM_ROSE));
    handler(MobAnimation.IRON_GOLEM_SHEATH, le -> le.playEffect(EntityEffect.IRON_GOLEM_SHEATH));
    handler(MobAnimation.WOLF_SHAKE, le -> le.playEffect(EntityEffect.WOLF_SHAKE));
    handler(MobAnimation.WOLF_SHAKE_STOP, le -> le.playEffect(EntityEffect.WOLF_SHAKE_STOP));
    handler(MobAnimation.RAVAGER_STUNNED, le -> le.playEffect(EntityEffect.RAVAGER_STUNNED));
    handler(MobAnimation.RAVAGER_ROARED, le -> le.playEffect(EntityEffect.RAVAGER_ROARED));
    handler(
        MobAnimation.WARDEN_TENDRIL_SHAKE, le -> le.playEffect(EntityEffect.WARDEN_TENDRIL_SHAKE));
    handler(
        MobAnimation.WARDEN_SONIC_ATTACK, le -> le.playEffect(EntityEffect.WARDEN_SONIC_ATTACK));
    handler(MobAnimation.GOAT_LOWER_HEAD, le -> le.playEffect(EntityEffect.GOAT_LOWER_HEAD));
    handler(MobAnimation.GOAT_RAISE_HEAD, le -> le.playEffect(EntityEffect.GOAT_RAISE_HEAD));

    register(Mannequin.class, MobAnimation.SWING_MAIN_HAND);
    register(Mannequin.class, MobAnimation.SWING_OFFHAND);

    register(Allay.class, MobAnimation.ALLAY_START_DANCING);
    register(Allay.class, MobAnimation.ALLAY_STOP_DANCING);

    register(Sheep.class, MobAnimation.SHEEP_EAT_GRASS);

    register(IronGolem.class, MobAnimation.IRON_GOLEM_ROSE);
    register(IronGolem.class, MobAnimation.IRON_GOLEM_SHEATH);

    register(Wolf.class, MobAnimation.WOLF_SHAKE);
    register(Wolf.class, MobAnimation.WOLF_SHAKE_STOP);

    register(Ravager.class, MobAnimation.RAVAGER_STUNNED);
    register(Ravager.class, MobAnimation.RAVAGER_ROARED);

    register(Warden.class, MobAnimation.WARDEN_TENDRIL_SHAKE);
    register(Warden.class, MobAnimation.WARDEN_SONIC_ATTACK);

    register(Goat.class, MobAnimation.GOAT_LOWER_HEAD);
    register(Goat.class, MobAnimation.GOAT_RAISE_HEAD);
  }
}
