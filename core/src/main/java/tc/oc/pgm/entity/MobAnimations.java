package tc.oc.pgm.entity;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import tc.oc.pgm.util.platform.Platform;

public class MobAnimations {
  public static final MobAnimations MOB_ANIMATIONS = Platform.get(MobAnimations.class);

  private final Map<Class<? extends Entity>, Set<MobAnimation>> supported = new HashMap<>();
  private final Map<MobAnimation, Consumer<LivingEntity>> handlers =
      new EnumMap<>(MobAnimation.class);

  protected final void handler(MobAnimation animation, Consumer<LivingEntity> handler) {
    handlers.put(animation, handler);
  }

  protected final void register(Class<? extends Entity> type, MobAnimation animation) {
    supported.computeIfAbsent(type, k -> EnumSet.noneOf(MobAnimation.class)).add(animation);
  }

  public boolean supports(Class<? extends Entity> type, MobAnimation animation) {
    for (var entry : supported.entrySet()) {
      if (entry.getKey().isAssignableFrom(type) && entry.getValue().contains(animation))
        return true;
    }
    return false;
  }

  public void play(LivingEntity le, MobAnimation animation) {
    if (!supports(le.getClass(), animation)) return;

    var handler = handlers.get(animation);
    if (handler != null) handler.accept(le);
  }
}
