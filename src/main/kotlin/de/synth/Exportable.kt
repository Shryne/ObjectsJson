package de.synth

import de.synth.target.Target

/**
 * An exportable.
 */
interface Exportable {
    /**
     * Exports itself onto the target.
     */
    fun exportTo(target: Target)
}
