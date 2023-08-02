public class Main {
    public static void main(String[] args) {

    }

    public class Solution {
        public int reverseBits(int n) {
            int result = 0; // new int created to be appended and returned as the reverse
            for (int i = 0; i<32; i++){ // for 32 bit unsigned int (meaning can have leading 0's) must loop 32 times
                result<<=1; // result shifted one place to left so on first iteration result becomes '00'
                result += n%2; // if last place in 'n' is a 1, then append a 1. otherwise, new zero remains. lets assumee
                // its a 1 though so '00' becomes 01.
                n>>>=1; // unsigned shift right so the least place goes off and second place becomees least such as
                // 001234 --> 000123 using a 6 bit example
                // eventually all becomes 0's aftre 32 iterations
            }
            return result;
        }
    }
}

// bitwise operators >> and << are for shift right and shift left
// suppoing numberr int n =  8, binary is 1000. n >> 1 would mean binary would equal 100 (intgeter of 4)
// ooposite it n << 1 meaning anothere place is added 1000 --> 10000, so n now = 16
// we can further specify the shift amount we want,  such as >>2, <<3, etc.
// the >>> as opposed to >> shifts a 0 into the highest place in a 32 bit unsigned int such that is the binary is
// 11....11 and we shift right, we get 01.....?1 to always have 32 bit places representeed. >> is for signed ints and
// doesn't keep the 32 spacs, instead would drop to 31 for >> or 30 for >>2, etc.

// lovely attempt but obviously no. it works with ints not starting with 0, but this obviously isn't supposed to just
// be memorizing methods
//class Solution {
//    public int reverseBits(int n) {
//        String converted = Integer.toString(n);
//        StringBuilder builder = new StringBuilder();
//        builder.append(converted);
//        builder.reverse();
//        converted = builder.toString();
//        return Integer.parseInt(converted);
//    }
//}

// idea one: int to string --> reverse string into string builder, convrt back to int and
// return. this requires essentially no binary knowledge and too many conversions. likely
// not the solution


// thoughts? & operator no good. | no good. ^ XOR flipping won't worrk either
// no recognizable patterrn when overrlapping
// no factor of two stuff since we aren't adding orr subtracting...