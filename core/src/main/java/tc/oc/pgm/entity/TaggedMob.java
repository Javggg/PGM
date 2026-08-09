package tc.oc.pgm.entity;

import org.bukkit.entity.LivingEntity;
import org.jspecify.annotations.Nullable;
import tc.oc.pgm.api.feature.FeatureDefinition;
import tc.oc.pgm.api.match.Match;
import tc.oc.pgm.api.player.MatchPlayer;

public interface TaggedMob extends FeatureDefinition {
  String getId();

  LivingEntity spawn(
      Match match,
      double x,
      double y,
      double z,
      float pitch,
      float yaw,
      @Nullable MatchPlayer trigger);
}
