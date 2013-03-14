// iDSLAddon_start_fold desc="Začnite písať výraz definujúci obmedzenia tu (pre pomoc použite kombináciu Ctrl+Space):"

import sk.tuke.magsa.tools.builder.ConstraintBuilder;

public class Personalistika2Obmedzenia extends ConstraintBuilder {
    
    @Override
    protected void define() {
// iDSLAddon_end_fold
        entity_ref("name");
// iDSLAddon_start_fold desc="Výraz končí tu."
    }    
}
// iDSLAddon_end_fold