package de.raindancer.modules.tpa.screen;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TpaHubMenuTest {

    @Test
    void theAutoAcceptLeverShowsWhichWayItIsSet() {
        assertThat(TpaHubMenu.autoAcceptLever(true).state()).isEqualTo("<green>On");
        assertThat(TpaHubMenu.autoAcceptLever(false).state()).isEqualTo("<red>Off");
        assertThat(TpaHubMenu.autoAcceptLever(true).action()).isEqualTo("<gray>Click to turn it off.");
        assertThat(TpaHubMenu.autoAcceptLever(false).action()).isEqualTo("<gray>Click to turn it on.");
        assertThat(TpaHubMenu.autoAcceptLever(true).material())
                .isNotEqualTo(TpaHubMenu.autoAcceptLever(false).material());
    }
}
