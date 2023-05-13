//Можно задать любую последовательность в alphabet и codingNumbs
//Важно чтобы размер alphabet был равен codingNumbs, а их значения уникальны!
val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toList()
val codingNumbs = arrayOf(1,2,20,21,5,22,23,24,8,9,10,11,32,16,17,18,19,9,30,31,12,13,14,25,26,6,7,27,28,23,4,15,33)
fun main() {
    print("Введите слово на русском, которое хотите зашифровать: ")
    val encodingMessage = encode()
    val decryptMessage = decrypt(encodingMessage)
    println("Зашифрованное сообщение: $encodingMessage\nРасшифровка закодированного сообщения: $decryptMessage")
}

fun encode(): String {
    var userInput = readln()
    userInput = userInput.uppercase()
    val chars = userInput.toList()
    var output = ""
    for (char in chars) {
        output += alphabet[(alphabet.indexOf(char) + codingNumbs[alphabet.indexOf(char)]) % 33]
    }
    return output
}

fun decrypt(message: String): String {
    var output = ""
    for (char in message) {
        for (num in codingNumbs) {
            if (char == alphabet[(codingNumbs.indexOf(num) + num) % 33]) {
             output += alphabet[codingNumbs.indexOf(num)]
                break
            }
        }
    }
    return output
}