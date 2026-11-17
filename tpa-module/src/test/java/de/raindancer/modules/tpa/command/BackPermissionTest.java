package de.raindancer.modules.tpa.command;

import de.raindancer.modules.api.ModuleCommand;
import de.raindancer.modules.tpa.TpaCommands;
import de.raindancer.modules.tpa.util.PermissionNodes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BackPermissionTest {

    @Test
    @DisplayName("/back is registered with the node the plugin declares and checks, so players who have it can use it")
    void backNeedsTheDeclaredNode() {
        ModuleCommand back = TpaCommands.declared().stream().filter(command -> command.name().equals("back"))
                .findFirst().orElseThrow();
        assertThat(back.permission()).isEqualTo(PermissionNodes.BACK);
    }
}
