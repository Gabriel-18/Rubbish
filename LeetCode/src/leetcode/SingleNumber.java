package leetcode;

public class SingleNumber {
    /**
     * 交换律：a ^ b ^ c <=> a ^ c ^ b；
     * 任何数于0异或为任何数 0 ^ n => n；
     * n ^ n = 0；
     * If we take XOR of zero and some bit, it will return that bit
     * a \oplus 0 = a a⊕0=a
     * If we take XOR of two same bits, it will return 0
     * a \oplus a = 0 a⊕a=0
     * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = b a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
