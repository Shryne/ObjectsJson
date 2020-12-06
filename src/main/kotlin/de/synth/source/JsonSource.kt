package de.synth.source

import java.util.function.Supplier

/**
 * A source for json. With this interface it's possible to work lazily.
 * Additionally, it can be used to change the value from call to call.
 */
fun interface JsonSource: Supplier<String>