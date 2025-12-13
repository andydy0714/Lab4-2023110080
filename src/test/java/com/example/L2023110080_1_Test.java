import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 测试用例设计原则：
 * 1. 等价类划分：正数、负数、零
 * 2. 小数类型：有限小数、循环小数、整数
 * 3. 边界值：最大最小值、特殊值
 * 4. 异常情况：除数为零
 */
public class L2023110080_1_Test {
    
    private Solution1 solution = new Solution1();
    
    /**
     * 测试目的：验证有限小数转换
     * 测试用例：1/2 = 0.5
     */
    @Test
    public void testFiniteDecimal() {
        assertEquals("0.5", solution.fractionToDecimal(1, 2));
        assertEquals("0.25", solution.fractionToDecimal(1, 4));
    }
    
    /**
     * 测试目的：验证整数结果
     * 测试用例：2/1 = 2, 4/2 = 2
     */
    @Test
    public void testIntegerResult() {
        assertEquals("2", solution.fractionToDecimal(2, 1));
        assertEquals("2", solution.fractionToDecimal(4, 2));
    }
    
    /**
     * 测试目的：验证循环小数及括号添加
     * 测试用例：4/333 = 0.(012), 1/3 = 0.(3)
     */
    @Test
    public void testRepeatingDecimal() {
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333));
        assertEquals("0.(3)", solution.fractionToDecimal(1, 3));
    }
    
    /**
     * 测试目的：验证负数处理
     * 测试用例：-1/2 = -0.5, 1/-2 = -0.5
     */
    @Test
    public void testNegativeNumbers() {
        assertEquals("-0.5", solution.fractionToDecimal(-1, 2));
        assertEquals("-0.5", solution.fractionToDecimal(1, -2));
        assertEquals("0.5", solution.fractionToDecimal(-1, -2));
    }
    
    /**
     * 测试目的：验证零被除数
     * 测试用例：0/5 = 0
     */
    @Test
    public void testZeroNumerator() {
        assertEquals("0", solution.fractionToDecimal(0, 5));
    }
    
    /**
     * 测试目的：验证复杂循环小数
     * 测试用例：1/6 = 0.1(6)
     */
    @Test
    public void testComplexRepeating() {
        assertEquals("0.1(6)", solution.fractionToDecimal(1, 6));
    }
    
    /**
     * 测试目的：验证除数为零异常
     * 测试用例：1/0 应抛出异常
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        solution.fractionToDecimal(1, 0);
    }
}
