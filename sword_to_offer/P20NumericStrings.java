package sword_to_offer;

/**
 * P20NumericStrings
 */
public class P20NumericStrings {
    
    int idx = 0;

    boolean scanSingedInteger(String s){
        if(idx < s.length() && (s.charAt(idx) == '-' || s.charAt(idx) == '+')){
            idx ++;
        }
        return scanUnsignedInteger(s);
    }

    boolean scanUnsignedInteger(String s){
        int start = idx;
        for(; idx < s.length(); idx ++){
            if(!Character.isDigit(s.charAt(idx))){
                break;
            }
        }
        return idx > start;
    }

    public boolean isNumber(String s) {
        idx = 0;
        if(s == null || s.length() == 0){
            return false;
        }
        s = s.trim();
        boolean A = scanSingedInteger(s), B = false, C = false;
        if(idx < s.length() && s.charAt(idx) == '.'){
            idx ++;
            B = scanUnsignedInteger(s);
        }
        if(idx < s.length() && (s.charAt(idx) == 'e' || s.charAt(idx) == 'E')){
            idx ++;
            C = scanSingedInteger(s);
            if(!C){
                return false;
            }
        }
        return idx == s.length() && (A || B);
    }

    public static void main(String[] args) {
        P20NumericStrings sol = new P20NumericStrings();
        assert sol.isNumber("+100");
        assert sol.isNumber("5e2");
        assert sol.isNumber("-123");
        assert sol.isNumber("3.1416");
        assert sol.isNumber("0123");
        assert sol.isNumber("-1E-16");
        assert !sol.isNumber("12e");
        assert !sol.isNumber("1a3.14");
        assert !sol.isNumber("1.2.3");
        assert !sol.isNumber("+-5");
        assert !sol.isNumber("12e+5.4");
    }
}