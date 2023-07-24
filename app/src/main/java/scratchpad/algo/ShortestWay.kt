package scratchpad.algo;

fun shortestWay(source: String, target: String): Int {
    var sp = 0;
    var tp = 0;
    var ans = 1
    val sn = source.length
    val tn = target.length
    while (tp < tn) {
        while (sp < sn && source[sp] != target[tp])
            sp += 1
        if (sp == sn) {
            sp = 0;
            ans += 1
            while (sp < sn && source[sp] != target[tp])
                sp += 1
            if (sp == sn) return -1;
        }
        sp += 1
        tp += 1
    }
    return ans
}

fun main() {
    shortestWay("abc", "abcbc")
}