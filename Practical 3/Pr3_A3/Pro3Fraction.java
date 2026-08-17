public class Pro3Fraction {
    private int num; 
    private int den;

    private int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public Pro3Fraction(int num, int den) {
        int g = findGCD(num, den);
        this.num = num / g;
        this.den = den / g;
    }
    
    public String toString() {
        return num + "/" + den;
    }
  
    public boolean equals(Object obj) {
        Pro3Fraction other = (Pro3Fraction) obj;
        if (this.num == other.num && this.den == other.den) {
            return true;
        } else {
            return false;
        }
    }
    public int hashCode() {
        return num + den;
    }
}

