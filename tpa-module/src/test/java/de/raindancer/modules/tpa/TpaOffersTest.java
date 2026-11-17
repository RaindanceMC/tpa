package de.raindancer.modules.tpa;

import de.raindancer.core.ui.menu.Menu;
import de.raindancer.core.ui.preference.Preference;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

class TpaOffersTest {

    @Test
    @DisplayName("the blocked list is a page that opens with /preferences as its parent")
    void blockedPage() {
        Player player = mock(Player.class);
        Menu parent = mock(Menu.class);
        List<Object> opened = new ArrayList<>();
        Preference preference = TpaOffers.blocked((who, back) -> {
            opened.add(who);
            opened.add(back);
        });

        assertThat(preference.id()).isEqualTo("tpa:blocked");
        assertThat(preference.title()).isEqualTo("Blocked from teleport requests");
        assertThat(preference.group()).isEqualTo("Teleport requests");
        assertThat(preference.isPage()).isTrue();
        assertThat(preference.shown().test(player)).isTrue();

        preference.page().accept(player, parent);
        assertThat(opened).containsExactly(player, parent);
    }
}
