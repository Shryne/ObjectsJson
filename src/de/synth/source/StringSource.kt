package de.synth.source

/**
 * A string as a source of json objects.
 */
class StringSource : Source {
    override fun get(key: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun has(key: String): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun iterator(): Iterator<String> =
            object : Iterator<String> {
                override fun hasNext(): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun next(): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            }
}