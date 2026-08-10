/**
 * 523. Continuous Subarray Sum
 * 
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * A good subarray is:
 *  - Length at least two, and
 *  - Sum of elements is a multiple of k
 * 
 * Approach: Use prefix sum with modulo arithmetic.
 * If (prefixSum[j] % k) == (prefixSum[i] % k) where j > i + 1, then the subarray between i and j has sum divisible by k.
 * We store the first index where each remainder is seen in a HashMap.
 */

package yandex_algo

fun main() {
    // Test Case 1: Example from problem - should return true
    val nums1 = intArrayOf(23, 2, 4, 6, 7)
    val k1 = 6
    println("Input: nums = [23,2,4,6,7], k = 6")
    println("Expected: true")
    println("Result: ${hasContinuousSubarray(nums1, k1)}")
    println()

    // Test Case 2: Entire array sum is multiple of k - should return true
    val nums2 = intArrayOf(23, 2, 6, 4, 7)
    val k2 = 6
    println("Input: nums = [23,2,6,4,7], k = 6")
    println("Expected: true")
    println("Result: ${hasContinuousSubarray(nums2, k2)}")
    println()

    // Test Case 3: No subarray with sum multiple of k - should return false
    val nums3 = intArrayOf(23, 2, 6, 4, 7)
    val k3 = 13
    println("Input: nums = [23,2,6,4,7], k = 13")
    println("Expected: false")
    println("Result: ${hasContinuousSubarray(nums3, k3)}")
    println()

    // Test Case 4: Single element that is multiple of k (length < 2) - should return false
    val nums4 = intArrayOf(0)
    val k4 = 1
    println("Input: nums = [0], k = 1")
    println("Expected: false")
    println("Result: ${hasContinuousSubarray(nums4, k4)}")
    println()

    // Test Case 5: Two elements sum to multiple of k - should return true
    val nums5 = intArrayOf(0, 1)
    val k5 = 1
    println("Input: nums = [0, 1], k = 1")
    println("Expected: true")
    println("Result: ${hasContinuousSubarray(nums5, k5)}")
    println()

    // Test Case 6: All zeros - should return true (any subarray of length >= 2 works)
    val nums6 = intArrayOf(0, 0, 0)
    val k6 = 1
    println("Input: nums = [0, 0, 0], k = 1")
    println("Expected: true")
    println("Result: ${hasContinuousSubarray(nums6, k6)}")
}

/**
 * Returns true if there exists a continuous subarray of length >= 2 with sum divisible by k.
 */
fun hasContinuousSubarray(nums: IntArray, k: Int): Boolean {
    // HashMap to store remainder -> first index where it occurs
    // Remainder can be negative, so we use (remainder + k) % k to normalize
    val prefixSumMap = mutableMapOf<Int, Int>()
    
    var prefixSum = 0
    
    for (i in nums.indices) {
        prefixSum += nums[i]
        
        // Normalize remainder to handle negative numbers correctly
        val normalizedRemainder = ((prefixSum % k) + k) % k
        
        // If we've seen this remainder before, check if subarray length >= 2
        if (normalizedRemainder in prefixSumMap) {
            val firstIndex = prefixSumMap[normalizedRemainder]!!
            if (i - firstIndex >= 1) {
                return true
            }
        } else {
            // Store the first occurrence of this remainder
            prefixSumMap[normalizedRemainder] = i
        }
    }
    
    return false
}
