import util.RandomUtil
import java.util.*
import kotlin.collections.ArrayList

var level = 0
var inputList = ArrayList<Int>()
val scan = Scanner(System.`in`)

fun main(args: Array<String>) {
    val result = setNumbers()
    startGame()
}

fun setNumbers(): ArrayList<Int> {
    do {
        print("1~10 정수형으로 난이도를 선택하세요 (높은 숫자일수록 난이도가 높아집니다) : ")
        level = scan.nextInt()
    } while (level > 10 || level < 0)
    return RandomUtil.getNumbers(level)
}

fun startGame() {
    do {
        inputList.clear()
        println("중복되지 않는 숫자(0~9) " + level + "개를 입력하세요")
        (1..level).forEach {
            inputList.add(scan.nextInt())
        }
        var bool = false
        inputList.forEach { i ->
            if (i < 0 || i > 9 && !bool) {
                bool = true
            }
        }
    } while (RandomUtil.checkOverlap(inputList) || bool)
}
