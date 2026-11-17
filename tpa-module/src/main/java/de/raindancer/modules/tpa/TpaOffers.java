package de.raindancer.modules.tpa;

import de.raindancer.core.ui.menu.Menu;
import de.raindancer.core.ui.preference.Preference;
import org.bukkit.entity.Player;

import java.util.function.BiConsumer;

/** What Teleport requests offers to Core's {@code /preferences} as a page of its own. */
final class TpaOffers {

    private TpaOffers() {
    }

    static Preference blocked(BiConsumer<Player, Menu> open) {
        return Preference.page("tpa:blocked", "Teleport requests", "Blocked from teleport requests",
                "See who cannot ask to teleport to you, and let them ask again.", open);
    }
}
