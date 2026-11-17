package de.raindancer.modules.tpa.service;

import de.raindancer.core.ui.messages.Messages;
import de.raindancer.core.world.teleport.Returns;
import de.raindancer.core.world.teleport.Travel;
import de.raindancer.core.world.teleport.Waypoint;
import de.raindancer.modules.tpa.TpaSettings;
import de.raindancer.modules.tpa.util.PermissionNodes;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/** Why the Back door on /travel is shut, in the words the player reads. */
class BackLockTest {

    private final UUID id = UUID.randomUUID();
    private final Player player = mock(Player.class);
    private final Travel travel = mock(Travel.class);
    private final Returns returns = new Returns();

    BackLockTest() {
        when(player.getUniqueId()).thenReturn(id);
        when(player.hasPermission(PermissionNodes.BACK)).thenReturn(true);
        when(travel.cameFrom()).thenReturn(returns);
    }

    private BackService back(TpaSettings settings) {
        return new BackService(travel, mock(Messages.class), settings, (java.util.function.LongSupplier) null);
    }

    private void somewhereToGo() {
        returns.restore(id, new Returns.Elsewhere("", new Waypoint("world", 1, 64, 2, 0, 0, Waypoint.Cause.DEATH, 0)));
    }

    @Test
    @DisplayName("open when there is somewhere to go back to")
    void open() {
        somewhereToGo();
        assertThat(back(TpaSettings.DEFAULTS).whyNotBack(player)).isEmpty();
    }

    @Test
    @DisplayName("shut with a reason when there is nowhere to go back to")
    void nowhere() {
        assertThat(back(TpaSettings.DEFAULTS).whyNotBack(player)).contains("Nowhere to go back to");
    }

    @Test
    @DisplayName("shut when the server has no /back")
    void switchedOff() {
        somewhereToGo();
        assertThat(back(TpaSettings.DEFAULTS.withBackEnabled(false)).whyNotBack(player)).isPresent();
    }

    @Test
    @DisplayName("shut for somebody who may not use /back")
    void noPermission() {
        somewhereToGo();
        when(player.hasPermission(PermissionNodes.BACK)).thenReturn(false);
        assertThat(back(TpaSettings.DEFAULTS).whyNotBack(player)).isPresent();
    }
}
