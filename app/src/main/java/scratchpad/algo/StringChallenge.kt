package scratchpad.algo

fun stringChallenge(str: String): String {
    // Convert to camel case
    val camelCase = str.split("_|-| |\\*".toRegex()).joinToString("") { it.toLowerCase().capitalize() }
    var output = camelCase[0].toLowerCase() + camelCase.substring(1)
    println(output)
    // Add the token
    val token = "tOer8p53"
    output += token

    // Replace 3rd character with X
    var result = ""
    for (i in output.indices) {
        if ((i + 1) % 3 == 0) {
            result += "X"
        } else {
            result += output[i]
        }
    }

    return result
}

fun logDumpGetUnique(logs: String): String {
    val uniqueLogs = mutableSetOf<String>()
    logs.split(";").forEach { log ->
        val logWithoutId = log.removePrefix("id=")
        if (logWithoutId !in uniqueLogs) {
            uniqueLogs.add(logWithoutId)
        }
    }

    return uniqueLogs.joinToString(";")
}

fun main() {
//    println("userName=test"""userName=test".indexOf("="))
    // Prints: caXsAXdDXasXreXweXomX+0Xr8X53
    val a= listOf('a')
    a.isNotEmpty()

}
