import util.RandomUtil
import java.util.*
import kotlin.collections.ArrayList

var level = 0
var inputList = ArrayList<Int>()
val scan = Scanner(System.`in`)

fun main(args: Array<String>) {
    val result = setNumbers()
    startGame(result)
}

fun setNumbers(): ArrayList<Int> {
    do {
        print("1~10 정수형으로 난이도를 선택하세요 (높은 숫자일수록 난이도가 높아집니다) : ")
        level = scan.nextInt()
    } while (level > 10 || level < 0)
    return RandomUtil.getNumbers(level)
}

fun startGame(result: ArrayList<Int>) {
    var strike = 0
    var ball = 0
    var count = 0
    do {
        strike = 0
        ball = 0
        getNumbers()
        for (i in 0..inputList.size - 1) {
            if (result[i] == inputList[i])
                strike++
            else {
                (0..inputList.size - 1)
                        .filter { result[(i + it) % inputList.size] == inputList[i] }
                        .forEach { println(it); ball++ }
            }
        }
        println(message = """${ball}ball ,${strike}strike""")
        count++
    } while (strike != inputList.size)
    println("정답! $count 번만에 맞추셨습니다!")
}

fun getNumbers() {
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
