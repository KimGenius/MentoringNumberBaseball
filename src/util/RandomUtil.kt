package util

import java.util.*
import kotlin.collections.ArrayList

object RandomUtil {
    private var rand = Random();
    fun getNumbers(len: Int): ArrayList<Int> {
        val result = ArrayList<Int>()
        for (i in 0..len - 1) {
            result.add(rand.nextInt(10) + 0)
            println(result[i])
        }
        println(result)
        return result
    }
}
