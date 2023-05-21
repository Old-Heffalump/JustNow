fun main(args: Array<String>) {

    println( agoToText(60*60+1))
    println( agoToText(59))
    println( agoToText(60*60*3))
    println( agoToText(60*60*24*2))
    println( agoToText(60*60*24*3))
    println( agoToText(60*24))
    println( agoToText(60*21))
    println( agoToText(60*11))



}


fun agoToText(second: Int):String {

    when {
        (second < 61) -> {
            return "был(а) только что"
        }
        (second in 61..(60 * 60)) -> {
            return "был(а) " + timeAgoTextMinute(second) + " назад"
        }
        (second in (60 * 60)+1 .. (60*60*24)) -> {
            return "был(а) "+ timeAgoTextHour(second) +" назад"
        }
        (second in (60*60*24)+1.. (60*60*24*2)) -> {
            return "был(а) вчера"
        }
        (second in (60*60*24*2)+1..(60*60*24*3)) ->{
            return "был(а) позавчера"
        }
        else -> return ("был(а) давно")
    }
}

fun timeAgoTextMinute(second: Int ): String{
    val minute: Int = second.div(60)

    return when{
        minute % 10 in 5..9 || minute in 11..14 -> {
            "$minute минут"
        }
        minute % 10 == 1 -> {
            "$minute минуту"
        }

        else -> {
            "$minute минуты"
        }
    }
}

fun timeAgoTextHour(second: Int ): String{
    val hour: Int = second.div(60*60)

    return when{
        hour == 1 || hour == 21 -> {
            return "$hour час"
        }
        hour in 2..4 -> {
            return "$hour часа"
        }
        else -> {
            return "$hour часов"
        }
    }
}
