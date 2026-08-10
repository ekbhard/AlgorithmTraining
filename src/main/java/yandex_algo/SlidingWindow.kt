package yandex_algo

import kotlin.math.max

fun main() {

    println(findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4))
    println(findMaxAverage(intArrayOf(0, 4, 0, 3, 2), 1))

    println("---maxVowels--")
    println(maxVowels("i", 0)) //0
    println(maxVowels("j", 0)) //0
    println(maxVowels("i", 1)) //1
    println("---")
    println(maxVowels("b", 1)) //0
    println(maxVowels("ba", 2)) //1
    println(maxVowels("bj", 2)) //0
    println("---")
    println(maxVowels("bji", 3)) //1
    println(maxVowels("bjj", 3)) //0
    println("---")
    println(maxVowels("abchhhkauekaur", 3)) // 3
    println(maxVowels("aueklfgakeeejkajiiikld", 5)) //4


    println("---lengthOfLongestSubstring--")
    println(lengthOfLongestSubstring("abc")) // 3
    println(lengthOfLongestSubstring("abac")) //3
    println(lengthOfLongestSubstring("aaa")) //1
    println(lengthOfLongestSubstring("abceedfkttynl")) //5
    println(lengthOfLongestSubstring("aaa"))//1
    println(lengthOfLongestSubstring("bbba"))//2
    println(lengthOfLongestSubstring("bbbab"))//2
    println(lengthOfLongestSubstring("bbbab"))//2
    println(lengthOfLongestSubstring("pwwkew"))//3

    println("---minSubArrayLen--")
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))//2
    println(minSubArrayLen(4, intArrayOf(1, 4, 4))) //1
    println(minSubArrayLen(10, intArrayOf(1, 4, 4))) //0
    println(minSubArrayLen(3, intArrayOf(1, 1, 1))) // 3
    println(minSubArrayLen(3, intArrayOf(1, 1, 3))) // 1
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))) //2
    println(minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1))) //0
    println(minSubArrayLen(4, intArrayOf(1, 4, 4))) //1


    println("---findMaxConsecutiveOnes----")
    println(findMaxConsecutiveOnes(intArrayOf(1, 1)))
    println(findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))

    println("--findAnagrams--")
    println(findAnagrams("abc", "abc"))//[0]
    println(findAnagrams("abcbcacab", "abc"))//[0,3,6]
    println(findAnagrams("abcbdsfcacab", "abc"))//[0,9]
    println(findAnagrams("cbaebabacd", "abc"))//[0,6]
    println(findAnagrams("abab", "ab"))//[0,1,2]
    println(findAnagrams("ababababab", "aab"))//[0,2,4,6]

    println("---characterReplacement---")
    println(characterReplacement("ABA", 1))//3
    println(characterReplacement("ABAB", 1))//3
    println(characterReplacement("AAAA", 1))//4
    println(characterReplacement("ABAB", 2))//4
    println(characterReplacement("AABABBA", 1))//4
    println(characterReplacement("AABHGLBBBAGHV", 1))//4


    println("-----numberOfSubarrays----")
    numberOfSubarrays(intArrayOf(1, 1), 1)//2
    numberOfSubarrays(intArrayOf(2, 2), 1)//0
    numberOfSubarrays(intArrayOf(2, 2, 4, 6), 3)//0
    numberOfSubarrays(intArrayOf(1, 1, 2, 1, 1), 3)//2
    numberOfSubarrays(intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2), 2)//2

    println("----shiftingLetters--")
    println(shiftingLetters("aaa", intArrayOf(1, 2, 3)))//gfd
    println(shiftingLetters("abc", intArrayOf(3, 5, 9)))//rpl
    println(shiftingLetters("a", intArrayOf(52)))//a
    println(shiftingLetters("a", intArrayOf(51)))//z
    println(shiftingLetters("mkgfzkkuxownxvfvxasy", intArrayOf(505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513)))//wqqwlcjnkphhsyvrkdod
}


/**
 * 643. Maximum Average Subarray I
 */

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var left = 0
    var current = 0
    var max = Int.MIN_VALUE

    for ((right, n) in nums.withIndex()) {
        current += n

        if (right - left + 1 == k) {
            max = maxOf(current, max)
            current -= nums[left]
            left++
        }

    }
    return max.toDouble() / k
}

fun maxVowels(s: String, k: Int): Int {
    val set = setOf('a', 'e', 'i', 'o', 'u')

    var temp = 0
    var result = 0

    for ((index, letter) in s.withIndex()) {
        if (index < k) {
            if (set.contains(letter)) {
                temp++
                result++
            }
        } else {
            val prevLetter = s[index - k]
            if (set.contains(prevLetter)) {
                temp--
            }
            if (set.contains(letter)) {
                temp++
            }
            result = maxOf(temp, result)
        }
    }

    return result
}


fun lengthOfLongestSubstring(s: String): Int {

    var set = mutableSetOf<Char>()
    var left = 0
    var result = 0

    for ((right, c) in s.withIndex()) {
        while (set.contains(c)) {
            set.remove(s[left])
            left++
        }
        set.add(c)
        result = maxOf(result, right - left + 1)

    }
    return result
}

/**
 * 209. Minimum Size Subarray Sum
 */

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var temp = 0
    var result = Int.MAX_VALUE

    for ((right, n) in nums.withIndex()) {
        temp += n
        while (temp >= target) {
            result = minOf(result, right - left + 1)
            temp -= nums[left]
            left++

        }
    }
    return if (result == Int.MAX_VALUE) 0 else result
}

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var right = 0
    var temp = 0
    var result = 0

    for (n in nums) {
        if (n == 1) {
            temp += 1
        } else {
            result = max(result, temp)
            temp = 0
        }
        right++
    }
    return max(result, temp)
}

/**
 * 438. Find All Anagrams in a String**
 */
fun findAnagrams(s: String, p: String): List<Int> {
    var left = 0
    val intArray = IntArray(26)
    for (char in p) {
        val index = char - 'a'
        intArray[index] = intArray[index] + 1
    }
    var result = mutableListOf<Int>()

    val tempArray = IntArray(26)

    for ((right, c) in s.withIndex()) {
        if (right < p.length - 1) {
            continue
        } else {
            val tempString = s.substring(left, right + 1)
            for (char in tempString) {
                val index = char - 'a'
                tempArray[index] = tempArray[index] + 1
            }

            if (intArray.contentEquals(tempArray)) {
                result.add(left)
            }
            left++

            tempArray.fill(0)
        }

    }
    return result
}

/**
 * 424. Longest Repeating Character Replacement
 */

fun characterReplacement(s: String, k: Int): Int {
    if (s.length < 2) return s.length // return 0 if 0 and 1 if 1

    var longestStreak = 0
    var maxCharFreq = 0
    val charFrequency = Array(26) { 0 }

    var start = 0
    for (end in s.indices) {
        val charIndex = s[end] - 'A'
        charFrequency[charIndex]++ // increase the char occurrence

        maxCharFreq = max(maxCharFreq, charFrequency[charIndex]) // update the current maxCharFreq

        if (end - start - maxCharFreq + 1 > k) {
            // Decrease the character at the start of the window before moving the start of the window to the next character
            charFrequency[s[start] - 'A']--
            start++
        }
        longestStreak = max(longestStreak, end - start + 1)
    }
    return longestStreak
}

/**
 * Given an array of integers nums and an integer k.
 * A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 */

fun numberOfSubarrays(nums: IntArray, k: Int): Int {
    var count = 0
    var currentSum = 0
    val prefixSums = mutableMapOf<Int, Int>()
    prefixSums[0] = 1

    for (num in nums) {
        if (num % 2 != 0) {
            currentSum++
        }
        if (prefixSums.containsKey(currentSum - k)) {
            count += prefixSums[currentSum - k]!!
        }
        prefixSums[currentSum] = prefixSums.getOrDefault(currentSum, 0) + 1

    }
    return count
}

/**
 * 848. Shifting Letters
 */

fun shiftingLetters(s: String, shifts: IntArray): String {
    var array = CharArray(s.length)
    var sum = 0
    for ((index, char) in s.withIndex().reversed()) {
        sum = (sum + shifts[index]) % 26  // sum всегда в -25..25
        if (sum < 0) sum += 26            // на случай отрицательных (если будут)
        val newChar = shiftChar(char, sum)
        array[index] = newChar
    }

    return array.concatToString()

}

fun shiftChar(ch: Char, shift: Int): Char {
    require(ch in 'a'..'z') { "Только строчные латинские буквы" }
    val base = 'a'.code
    var offset = ch.code - base          // 0..25
    offset = (offset + shift) % 26
    if (offset < 0) offset += 26         // приводим к 0..25
    return (base + offset).toChar()
}

