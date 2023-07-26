package scratchpad.algo

import java.util.*
import kotlin.math.max

fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
    val n = s.length
    if (n < 3) return n
    var left = 0
    var right = 0
    // hashmap character -> its rightmost position in the sliding window
    val hashmap = mutableMapOf<Char, Int>()
    var maxLen = 2
    while (right < n) {
        // slidewindow contains less than 3 characters
        if (hashmap.size < 3) hashmap[s[right]] = right++

        // slidewindow contains 3 characters
        if (hashmap.size == 3) {
            // delete the leftmost character
            val delIdx = Collections.min(hashmap.values)
            hashmap.remove(s[delIdx])
            // move left pointer of the slidewindow
            left = delIdx + 1
        }
        maxLen = max(maxLen, right - left)
    }
    return maxLen
}

fun main() {
    lengthOfLongestSubstringTwoDistinct("eceba")
}