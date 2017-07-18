package edu.zju.liuz.important;

/**
 * Created by Liu.Zheng on 2017/7/18.
 */
public class BigMultiply {
    public String PTmultiply(String num1, String num2) {//普通解法，O(n^2)
        //把字符串转换成char数组
        char chars1[] = num1.toCharArray();
        char chars2[] = num2.toCharArray();

        //声明存放结果和两个乘积的容器
        int result[] = new int[chars1.length + chars2.length];
        int n1[] = new int[chars1.length];
        int n2[] = new int[chars2.length];

        //把char转换成int数组，为什么要减去一个'0'呢？因为要减去0的ascii码得到的就是实际的数字
        for(int i = 0; i < chars1.length;i++)
            n1[i] = chars1[i]-'0';
        for(int i = 0; i < chars2.length;i++)
            n2[i] = chars2[i]-'0';

        //逐个相乘，因为你会发现。AB*CD = AC(BC+AD)BD , 然后进位。
        for(int i = 0; i < chars1.length; i++){
            for(int j =0; j < chars2.length; j++){
                result[i+j]+=n1[i]*n2[j];
            }
        }

        //满10进位，从后往前满十进位
        for(int i = result.length - 1; i > 0 ;i--){
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        //转成string并返回
        String resultStr = "";
        for(int i = 0; i < result.length-1; i++){
            resultStr+=""+result[i];
        }
        return resultStr;
    }
    //规模只要在这个范围内就可以直接计算了
    private final static int SIZE = 4;

    // 此方法要保证入参len为X、Y的长度最大值
    public String bigIntMultiply(String X, String Y, int len)//分治思想
    {
        // 最终返回结果
        String str = "";
        // 补齐X、Y，使之长度相同
        X = formatNumber(X, len);
        Y = formatNumber(Y, len);

        // 少于4位数，可直接计算
        if (len <= SIZE)
        {
            return "" + (Integer.parseInt(X) * Integer.parseInt(Y));
        }

        // 将X、Y分别对半分成两部分
        int len1 = len / 2;
        int len2 = len - len1;
        String A = X.substring(0, len1);
        String B = X.substring(len1);
        String C = Y.substring(0, len1);
        String D = Y.substring(len1);

        // 乘法法则，分块处理
        int lenM = Math.max(len1, len2);
        String AC = bigIntMultiply(A, C, len1);
        String AD = bigIntMultiply(A, D, lenM);
        String BC = bigIntMultiply(B, C, lenM);
        String BD = bigIntMultiply(B, D, len2);

        // 处理BD，得到原位及进位
        String[] sBD = dealString(BD, len2);

        // 处理AD+BC的和
        String ADBC = addition(AD, BC);
        // 加上BD的进位
        if (!"0".equals(sBD[1]))
        {
            ADBC = addition(ADBC, sBD[1]);
        }

        // 得到ADBC的进位
        String[] sADBC = dealString(ADBC, lenM);

        // AC加上ADBC的进位
        AC = addition(AC, sADBC[1]);

        // 最终结果
        str = AC + sADBC[0] + sBD[0];

        return str;
    }

    // 两个数字串按位加
    private String addition(String ad, String bc)
    {
        // 返回的结果
        String str = "";

        // 两字符串长度要相同
        int lenM = Math.max(ad.length(), bc.length());
        ad = formatNumber(ad, lenM);
        bc = formatNumber(bc, lenM);

        // 按位加，进位存储在temp中
        int flag = 0;

        // 从后往前按位求和
        for (int i = lenM - 1; i >= 0; i--)
        {
            int t =
                    flag + Integer.parseInt(ad.substring(i, i + 1))
                            + Integer.parseInt(bc.substring(i, i + 1));

            // 如果结果超过9，则进位当前位只保留个位数
            if (t > 9)
            {
                flag = 1;
                t = t - 10;
            }
            else
            {
                flag = 0;
            }

            // 拼接结果字符串
            str = "" + t + str;
        }
        if (flag != 0)
        {
            str = "" + flag + str;
        }
        return str;
    }

    // 处理数字串，分离出进位；
    // String数组第一个为原位数字，第二个为进位
    private String[] dealString(String ac, int len1)
    {
        String[] str = {ac, "0"};
        if (len1 < ac.length())
        {
            int t = ac.length() - len1;
            str[0] = ac.substring(t);
            str[1] = ac.substring(0, t);
        }
        else
        {
            // 要保证结果的length与入参的len一致，少于则高位补0
            String result = str[0];
            for (int i = result.length(); i < len1; i++)
            {
                result = "0" + result;
            }
            str[0] = result;
        }
        return str;
    }

    // 乘数、被乘数位数对齐
    private String formatNumber(String x, int len)
    {
        while (len > x.length())
        {
            x = "0" + x;
        }
        return x;
    }


}
