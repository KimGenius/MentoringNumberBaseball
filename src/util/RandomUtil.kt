package util

import java.util.*
import kotlin.collections.ArrayList
import java.util.HashSet


object RandomUtil {
    private var rand = Random()
    fun getNumbers(len: Int): ArrayList<Int> {
        val result = ArrayList<Int>()
        do {
            result.clear()
            for (i in 0..len - 1) {
                val ran = rand.nextInt(10) + 0
                result.add(ran)
            }
        } while (checkOverlap(result))
//        println(result)
        return result
    }

    fun checkOverlap(arrayList: ArrayList<Int>): Boolean {
        return arrayList.size != HashSet(arrayList).size
    }
}
