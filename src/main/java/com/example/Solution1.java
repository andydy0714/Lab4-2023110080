import java.util.HashMap;
import java.util.Map;

class Solution1 {
    public String fractionToDecimal(int numerator, int denominator) {
        // Bug修复：添加除数为0的检查
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        
        // Bug修复：处理被除数为0的情况
        if (numerator == 0) {
            return "0";
        }
        
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }

        StringBuffer sb = new StringBuffer();
        
        // 处理符号
        if ((numeratorLong < 0) ^ (denominatorLong < 0)) {
            sb.append('-');
        }

        // Bug修复：整数部分应该是除法，不是加法
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long integerPart = numeratorLong / denominatorLong;  // 修复这里
        sb.append(integerPart);
        sb.append('.');  // Bug修复：应该是小数点，不是减号

        // 小数部分
        StringBuffer fractionPart = new StringBuffer();
        Map<Long, Integer> remainderIndexMap = new HashMap<Long, Integer>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        
        // Bug修复：去掉 index != 0 的错误条件
        while (remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }
        
        if (remainder != 0) { // 有循环节
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');  // Bug修复：添加缺失的右括号
        }
        
        sb.append(fractionPart.toString());
        return sb.toString();
    }
}

