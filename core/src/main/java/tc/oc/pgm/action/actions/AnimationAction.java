package tc.oc.pgm.action.actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import tc.oc.pgm.api.match.Match;
import tc.oc.pgm.api.match.MatchScope;
import tc.oc.pgm.entity.MobAnimation;
import tc.oc.pgm.entity.MobAnimations;
import tc.oc.pgm.entity.TaggedMobMatchModule;

public class AnimationAction extends AbstractAction<Match> {

  private static final Duration DEFAULT_DANCE_DURATION = Duration.ofSeconds(5);

  private final String entityId;
  private final MobAnimation animation;

  public AnimationAction(String entityId, MobAnimation animation) {
    super(Match.class);
    this.entityId = entityId;
    this.animation = animation;
  }

  @Override
  public void trigger(Match match) {
    match.needModule(TaggedMobMatchModule.class).forEach(entityId, le -> {
      MobAnimations.MOB_ANIMATIONS.play(le, animation);

      if (animation == MobAnimation.START_DANCING) {
        match
            .getExecutor(MatchScope.RUNNING)
            .schedule(
                () -> MobAnimations.MOB_ANIMATIONS.play(le, MobAnimation.STOP_DANCING),
                DEFAULT_DANCE_DURATION.toMillis(),
                TimeUnit.MILLISECONDS);
      }
    });
  }
}
