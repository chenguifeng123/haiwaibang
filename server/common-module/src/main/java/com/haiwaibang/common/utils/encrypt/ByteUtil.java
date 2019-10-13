package com.haiwaibang.common.utils.encrypt;

import java.util.Arrays;

public class ByteUtil
{
    
    private static final char[] hexCode = "0123456789ABCDEF".toCharArray();
    
    private ByteUtil()
    {
    }
    
    /**
     * 2进制数组转为16进制字符串
     * 
     * @param byteArr
     * @return
     */
    public static String byte2Hex(byte[] byteArr)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : byteArr)
        {
            stringBuilder.append(hexCode[(b >> 4) & 0xF]);
            stringBuilder.append(hexCode[b & 0xF]);
        }
        return stringBuilder.toString().toUpperCase();
    }
    
    /**
     * 2进制数组转为16进制字符串
     * 
     * @param hex
     * @return
     * @throws Exception
     */
    public static byte[] hex2byte(String hex)
    {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0, j = 0; i < hex.length(); i += 2, j++)
        {
            bytes[j] = (byte)Integer.parseInt(hex.substring(i, i + 2), 16);
        }
        return bytes;
    }
    
    /**
     * 追加byte数组
     * 
     * @param org
     * @param add
     * @return
     */
    public static byte[] addBytes(byte[] org, byte[] add)
    {
        byte[] retByte = new byte[org.length + add.length];
        System.arraycopy(org, 0, retByte, 0, org.length);
        System.arraycopy(add, 0, retByte, org.length, add.length);
        return retByte;
    }
    
    /**
     * 截取子byte数组
     * 
     * @param org
     * @param beginIndex
     * @param endIndex
     * @return
     */
    public static byte[] subByte(byte[] org, int beginIndex, int endIndex)
    {
        if (beginIndex > endIndex || endIndex > org.length)
        {
            return new byte[0];
        }
        
        return Arrays.copyOfRange(org, beginIndex, endIndex);
    }
    
    // long类型转成byte数组
    public static byte[] longToByte(long number)
    {
        long temp = number;
        byte[] b = new byte[8];
        for (int i = 0; i < b.length; i++)
        {
            b[i] = new Long(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }
    
    // byte数组转成long
    public static long byteToLong(byte[] b)
    {
        long s = 0;
        long s0 = b[0] & 0xff;// 最低位
        long s1 = b[1] & 0xff;
        long s2 = b[2] & 0xff;
        long s3 = b[3] & 0xff;
        long s4 = b[4] & 0xff;// 最低位
        long s5 = b[5] & 0xff;
        long s6 = b[6] & 0xff;
        long s7 = b[7] & 0xff;
        
        // s0不变
        s1 <<= 8;
        s2 <<= 16;
        s3 <<= 24;
        s4 <<= 8 * 4;
        s5 <<= 8 * 5;
        s6 <<= 8 * 6;
        s7 <<= 8 * 7;
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;
        return s;
    }
    
    /**
     * 注释：int到字节数组的转换！
     * 
     * @param number
     * @return
     */
    public static byte[] intToByte(int number)
    {
        int temp = number;
        byte[] b = new byte[4];
        for (int i = 0; i < b.length; i++)
        {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }
    
    /**
     * 注释：字节数组到int的转换！
     * 
     * @param b
     * @return
     */
    public static int byteToInt(byte[] b)
    {
        int s = 0;
        int s0 = b[0] & 0xff;// 最低位
        int s1 = b[1] & 0xff;
        int s2 = b[2] & 0xff;
        int s3 = b[3] & 0xff;
        s3 <<= 24;
        s2 <<= 16;
        s1 <<= 8;
        s = s0 | s1 | s2 | s3;
        return s;
    }
    
    /**
     * 注释：short到字节数组的转换！
     * 
     * @param s
     * @return
     */
    public static byte[] shortToByte(short number)
    {
        int temp = number;
        byte[] b = new byte[2];
        for (int i = 0; i < b.length; i++)
        {
            b[i] = new Integer(temp & 0xff).byteValue();// 将最低位保存在最低位
            temp = temp >> 8; // 向右移8位
        }
        return b;
    }
    
    /**
     * 注释：字节数组到short的转换！
     * 
     * @param b
     * @return
     */
    public static short byteToShort(byte[] b)
    {
        short s = 0;
        short s0 = (short)(b[0] & 0xff);// 最低位
        short s1 = (short)(b[1] & 0xff);
        s1 <<= 8;
        s = (short)(s0 | s1);
        return s;
    }
    
    public static void short2Bytes(byte[] b, short s, int index)
    {
        b[index] = (byte)(s >> 8);
        b[index + 1] = (byte)(s >> 0);
    }
    
    public static void short2BytesReverse(byte[] b, short s, int index)
    {
        b[index] = (byte)(s >> 0);
        b[index + 1] = (byte)(s >> 8); //右移8位
    }
    
    public static void short2CharReverse(char[] b, short s, int index)
    {
        b[index] = (char)(s >> 0);
        b[index + 1] = (char)(s >> 8);
    }
    
    public static short bytes2Short(byte[] b, int index)
    {
        return (short)((b[index] << 8) | b[index + 1] & 0xff);
    }
    
    public static short bytes2ShortReverse(byte[] b, int index)
    {
        return (short)((b[index + 1] << 8) | b[index] & 0xff);
    }
    
    public static short char2ShortReverse(char[] b, int index)
    {
        return (short)((b[index + 1] << 8) | b[index] & 0xff);
    }
    
    public static void int2Bytes(byte[] bb, int x, int index)
    {
        bb[index + 0] = (byte)(x >> 24);
        bb[index + 1] = (byte)(x >> 16);
        bb[index + 2] = (byte)(x >> 8);
        bb[index + 3] = (byte)(x >> 0);
    }
    
    public static void int2BytesReverse(byte[] bb, int x, int index)
    {
        bb[index + 3] = (byte)(x >> 24);
        bb[index + 2] = (byte)(x >> 16);
        bb[index + 1] = (byte)(x >> 8);
        bb[index + 0] = (byte)(x >> 0);
    }
    
    public static void long2BytesReverse(byte[] b, long s, int index)
    {
        b[index] = (byte)(s >> 0);
        b[index + 1] = (byte)(s >> 8);
        b[index + 2] = (byte)(s >> 16);
        b[index + 3] = (byte)(s >> 24);
        b[index + 4] = (byte)(s >> 32);
        b[index + 5] = (byte)(s >> 40);
        b[index + 6] = (byte)(s >> 48);
        b[index + 7] = (byte)(s >> 56);
    }
    
    public static void int2CharReverse(char[] bb, int x, int index)
    {
        bb[index + 3] = (char)(x >> 24);
        bb[index + 2] = (char)(x >> 16);
        bb[index + 1] = (char)(x >> 8);
        bb[index + 0] = (char)(x >> 0);
    }
    
    public static int bytes2Int(byte[] bb, int index)
    {
        return (int)((((bb[index + 0] & 0xff) << 24) | ((bb[index + 1] & 0xff) << 16) | ((bb[index + 2] & 0xff) << 8)
            | ((bb[index + 3] & 0xff) << 0)));
    }
    
    public static int bytes2IntReverse(byte[] bb, int index)
    {
        if (bb.length == 2)
        {
            return (int)((((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0)));
        }
        return (int)((((bb[index + 3] & 0xff) << 24) | ((bb[index + 2] & 0xff) << 16) | ((bb[index + 1] & 0xff) << 8)
            | ((bb[index + 0] & 0xff) << 0)));
    }
    
    public static long bytes2LongReverse(byte[] bb, int index)
    {
        if (bb.length - index == 2)
        {
            return (long)((((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0)));
        }
        if (bb.length - index == 4)
        {
            return (long)((((bb[index + 3] & 0xff) << 24) | ((bb[index + 2] & 0xff) << 16)
                | ((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0)));
        }
        return (long)(((bb[index + 7] & 0xff) << 56) | ((bb[index + 6] & 0xff) << 48) | ((bb[index + 5] & 0xff) << 40)
            | ((bb[index + 4] & 0xff) << 32) | ((bb[index + 3] & 0xff) << 24) | ((bb[index + 2] & 0xff) << 16)
            | ((bb[index + 1] & 0xff) << 8) | ((bb[index + 0] & 0xff) << 0));
    }
    
    public static int char2IntReverse(char[] bb, int index)
    {
        return (int)((((bb[index + 3] & 0xff) << 24) | ((bb[index + 2] & 0xff) << 16) | ((bb[index + 1] & 0xff) << 8)
            | ((bb[index + 0] & 0xff) << 0)));
    }
    
    public static int bytes2int(byte[] bb, int index)
    {
        return (int)((((bb[index + 0] & 0xff) << 24) | ((bb[index + 1] & 0xff) << 16) | ((bb[index + 2] & 0xff) << 8)
            | ((bb[index + 3] & 0xff) << 0)));
    }
    
    public static int bytes2intReverse(byte[] bb, int index)
    {
        return (int)((((bb[index + 3] & 0xff) << 24) | ((bb[index + 2] & 0xff) << 16) | ((bb[index + 1] & 0xff) << 8)
            | ((bb[index + 0] & 0xff) << 0)));
    }
    
    public static int char2intReverse(char[] bb, int index)
    {
        return (int)((((bb[index + 3] & 0xff) << 24) | ((bb[index + 2] & 0xff) << 16) | ((bb[index + 1] & 0xff) << 8)
            | ((bb[index + 0] & 0xff) << 0)));
    }
    
    /**
     * 从数组里，指定位置转换出一个int(包括1~4字节)
     * 
     * @param abyte
     *            byte[]
     * @param beginPos
     *            int
     * @param len
     *            int
     * @param LHorder
     *            boolean 低位在前，高位在后 －－true | 高位在前，低位在后为false
     * @return int
     */
    public static int byteArrToInt(byte[] abyte, int beginPos, int len, boolean LHorder)
    {
        if (beginPos > abyte.length - len)
        {
            return 0;
        }
        int aint = 0;
        int tmpint;
        for (int i = 0; i < len; i++)
        {
            tmpint = abyte[i + beginPos];
            if (tmpint < 0)
            {
                tmpint += 256;
            }
            if (LHorder)
            {
                tmpint = tmpint << (i * 8);
            }
            else
            {
                tmpint = tmpint << ((len - i - 1) * 8);
            }
            aint |= tmpint;
        }
        return aint;
    }
    
    /**
     * 从数组里，指定位置转换出一个long(包括1~8字节)
     * 
     * @param abyte
     *            byte[]
     * @param beginPos
     *            int
     * @param len
     *            int
     * @param LHorder
     *            boolean 低位在前，高位在后 －－true | 高位在前，低位在后为false
     * @return int
     */
    public static long byteArrToLong(byte[] abyte, int beginPos, int len, boolean LHorder)
    {
        if (beginPos >= abyte.length - 1)
        {
            return 0;
        }
        long aint = 0;
        long tmpint;
        for (int i = 0; i < len; i++)
        {
            tmpint = abyte[i + beginPos];
            if (tmpint < 0)
            {
                tmpint += 256;
            }
            if (LHorder)
            {
                tmpint = tmpint << (i * 8);
            }
            else
            {
                tmpint = tmpint << ((len - i - 1) * 8);
            }
            aint |= tmpint;
        }
        
        return aint;
    }
    
    public static int ByteArrayToint(byte[] b, int len)
    {
        int mask = 0xff;
        int temp = 0;
        int res = 0;
        for (int i = len - 1; i >= 0; i--)
        {
            res <<= 8;
            temp = b[i] & mask;
            res |= temp;
        }
        return res;
    }
    
    public static int byteToInt(byte b)
    {
        if (b < 0)
        {
            return b + 256;
        }
        else
        {
            return b;
        }
    }
    
}
