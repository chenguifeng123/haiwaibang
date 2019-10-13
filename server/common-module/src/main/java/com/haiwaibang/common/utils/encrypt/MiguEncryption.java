package com.haiwaibang.common.utils.encrypt; /**
 * Created by msg on 2017/11/2.
 */
import java.math.BigDecimal;

public class MiguEncryption
{

    private static final byte[] keys = {0x23, 0x24, 0x20, 0x25, 0x20, 0x5f, (byte)0xa1, (byte)0xbe, 0x2e, 0x3f,
            (byte)0xe9, (byte)0xb0, 0x2d, 0x2b, 0x3d, 0x20, 0x40, 0x3b, 0x2a, 0x26, 0x21, 0x7e, (byte)0xc0, 0x50, 0x20,
            0x3f, 0x3e, 0x3c, 0x20, (byte)0xe8, (byte)0xb7, (byte)0x00};

    private static class AESSTAT
    {
        private int _Nb;

        private int _Nk;

        private int _Nr;

        private byte[] _key = new byte[32];

        private byte[] _w = new byte[256];

        private byte[] _state = new byte[16];
    }

    private static final byte[] __AES_SBox = // Substitution box
            {
            /* 0     1     2     3     4     5     6     7     8     9     a     b     c     d     e     f */
            /*0*/(byte)0x63, (byte)0x7c, (byte)0x77, (byte)0x7b, (byte)0xf2, (byte)0x6b, (byte)0x6f, (byte)0xc5,
                    (byte)0x30, (byte)0x01, (byte)0x67, (byte)0x2b, (byte)0xfe, (byte)0xd7, (byte)0xab, (byte)0x76,
            /*1*/(byte)0xca, (byte)0x82, (byte)0xc9, (byte)0x7d, (byte)0xfa, (byte)0x59, (byte)0x47, (byte)0xf0,
                    (byte)0xad, (byte)0xd4, (byte)0xa2, (byte)0xaf, (byte)0x9c, (byte)0xa4, (byte)0x72, (byte)0xc0,
            /*2*/(byte)0xb7, (byte)0xfd, (byte)0x93, (byte)0x26, (byte)0x36, (byte)0x3f, (byte)0xf7, (byte)0xcc,
                    (byte)0x34, (byte)0xa5, (byte)0xe5, (byte)0xf1, (byte)0x71, (byte)0xd8, (byte)0x31, (byte)0x15,
            /*3*/(byte)0x04, (byte)0xc7, (byte)0x23, (byte)0xc3, (byte)0x18, (byte)0x96, (byte)0x05, (byte)0x9a,
                    (byte)0x07, (byte)0x12, (byte)0x80, (byte)0xe2, (byte)0xeb, (byte)0x27, (byte)0xb2, (byte)0x75,
            /*4*/(byte)0x09, (byte)0x83, (byte)0x2c, (byte)0x1a, (byte)0x1b, (byte)0x6e, (byte)0x5a, (byte)0xa0,
                    (byte)0x52, (byte)0x3b, (byte)0xd6, (byte)0xb3, (byte)0x29, (byte)0xe3, (byte)0x2f, (byte)0x84,
            /*5*/(byte)0x53, (byte)0xd1, (byte)0x00, (byte)0xed, (byte)0x20, (byte)0xfc, (byte)0xb1, (byte)0x5b,
                    (byte)0x6a, (byte)0xcb, (byte)0xbe, (byte)0x39, (byte)0x4a, (byte)0x4c, (byte)0x58, (byte)0xcf,
            /*6*/(byte)0xd0, (byte)0xef, (byte)0xaa, (byte)0xfb, (byte)0x43, (byte)0x4d, (byte)0x33, (byte)0x85,
                    (byte)0x45, (byte)0xf9, (byte)0x02, (byte)0x7f, (byte)0x50, (byte)0x3c, (byte)0x9f, (byte)0xa8,
            /*7*/(byte)0x51, (byte)0xa3, (byte)0x40, (byte)0x8f, (byte)0x92, (byte)0x9d, (byte)0x38, (byte)0xf5,
                    (byte)0xbc, (byte)0xb6, (byte)0xda, (byte)0x21, (byte)0x10, (byte)0xff, (byte)0xf3, (byte)0xd2,
            /*8*/(byte)0xcd, (byte)0x0c, (byte)0x13, (byte)0xec, (byte)0x5f, (byte)0x97, (byte)0x44, (byte)0x17,
                    (byte)0xc4, (byte)0xa7, (byte)0x7e, (byte)0x3d, (byte)0x64, (byte)0x5d, (byte)0x19, (byte)0x73,
            /*9*/(byte)0x60, (byte)0x81, (byte)0x4f, (byte)0xdc, (byte)0x22, (byte)0x2a, (byte)0x90, (byte)0x88,
                    (byte)0x46, (byte)0xee, (byte)0xb8, (byte)0x14, (byte)0xde, (byte)0x5e, (byte)0x0b, (byte)0xdb,
            /*a*/(byte)0xe0, (byte)0x32, (byte)0x3a, (byte)0x0a, (byte)0x49, (byte)0x06, (byte)0x24, (byte)0x5c,
                    (byte)0xc2, (byte)0xd3, (byte)0xac, (byte)0x62, (byte)0x91, (byte)0x95, (byte)0xe4, (byte)0x79,
            /*b*/(byte)0xe7, (byte)0xc8, (byte)0x37, (byte)0x6d, (byte)0x8d, (byte)0xd5, (byte)0x4e, (byte)0xa9,
                    (byte)0x6c, (byte)0x56, (byte)0xf4, (byte)0xea, (byte)0x65, (byte)0x7a, (byte)0xae, (byte)0x08,
            /*c*/(byte)0xba, (byte)0x78, (byte)0x25, (byte)0x2e, (byte)0x1c, (byte)0xa6, (byte)0xb4, (byte)0xc6,
                    (byte)0xe8, (byte)0xdd, (byte)0x74, (byte)0x1f, (byte)0x4b, (byte)0xbd, (byte)0x8b, (byte)0x8a,
            /*d*/(byte)0x70, (byte)0x3e, (byte)0xb5, (byte)0x66, (byte)0x48, (byte)0x03, (byte)0xf6, (byte)0x0e,
                    (byte)0x61, (byte)0x35, (byte)0x57, (byte)0xb9, (byte)0x86, (byte)0xc1, (byte)0x1d, (byte)0x9e,
            /*e*/(byte)0xe1, (byte)0xf8, (byte)0x98, (byte)0x11, (byte)0x69, (byte)0xd9, (byte)0x8e, (byte)0x94,
                    (byte)0x9b, (byte)0x1e, (byte)0x87, (byte)0xe9, (byte)0xce, (byte)0x55, (byte)0x28, (byte)0xdf,
            /*f*/(byte)0x8c, (byte)0xa1, (byte)0x89, (byte)0x0d, (byte)0xbf, (byte)0xe6, (byte)0x42, (byte)0x68,
                    (byte)0x41, (byte)0x99, (byte)0x2d, (byte)0x0f, (byte)0xb0, (byte)0x54, (byte)0xbb, (byte)0x16};

    private static final byte[] __AES_iSBox = // inverse Substitution box
            {
            /* 0     1     2     3     4     5     6     7     8     9     a     b     c     d     e     f */
            /*0*/(byte)0x52, (byte)0x09, (byte)0x6a, (byte)0xd5, (byte)0x30, (byte)0x36, (byte)0xa5, (byte)0x38,
                    (byte)0xbf, (byte)0x40, (byte)0xa3, (byte)0x9e, (byte)0x81, (byte)0xf3, (byte)0xd7, (byte)0xfb,
            /*1*/(byte)0x7c, (byte)0xe3, (byte)0x39, (byte)0x82, (byte)0x9b, (byte)0x2f, (byte)0xff, (byte)0x87,
                    (byte)0x34, (byte)0x8e, (byte)0x43, (byte)0x44, (byte)0xc4, (byte)0xde, (byte)0xe9, (byte)0xcb,
            /*2*/(byte)0x54, (byte)0x7b, (byte)0x94, (byte)0x32, (byte)0xa6, (byte)0xc2, (byte)0x23, (byte)0x3d,
                    (byte)0xee, (byte)0x4c, (byte)0x95, (byte)0x0b, (byte)0x42, (byte)0xfa, (byte)0xc3, (byte)0x4e,
            /*3*/(byte)0x08, (byte)0x2e, (byte)0xa1, (byte)0x66, (byte)0x28, (byte)0xd9, (byte)0x24, (byte)0xb2,
                    (byte)0x76, (byte)0x5b, (byte)0xa2, (byte)0x49, (byte)0x6d, (byte)0x8b, (byte)0xd1, (byte)0x25,
            /*4*/(byte)0x72, (byte)0xf8, (byte)0xf6, (byte)0x64, (byte)0x86, (byte)0x68, (byte)0x98, (byte)0x16,
                    (byte)0xd4, (byte)0xa4, (byte)0x5c, (byte)0xcc, (byte)0x5d, (byte)0x65, (byte)0xb6, (byte)0x92,
            /*5*/(byte)0x6c, (byte)0x70, (byte)0x48, (byte)0x50, (byte)0xfd, (byte)0xed, (byte)0xb9, (byte)0xda,
                    (byte)0x5e, (byte)0x15, (byte)0x46, (byte)0x57, (byte)0xa7, (byte)0x8d, (byte)0x9d, (byte)0x84,
            /*6*/(byte)0x90, (byte)0xd8, (byte)0xab, (byte)0x00, (byte)0x8c, (byte)0xbc, (byte)0xd3, (byte)0x0a,
                    (byte)0xf7, (byte)0xe4, (byte)0x58, (byte)0x05, (byte)0xb8, (byte)0xb3, (byte)0x45, (byte)0x06,
            /*7*/(byte)0xd0, (byte)0x2c, (byte)0x1e, (byte)0x8f, (byte)0xca, (byte)0x3f, (byte)0x0f, (byte)0x02,
                    (byte)0xc1, (byte)0xaf, (byte)0xbd, (byte)0x03, (byte)0x01, (byte)0x13, (byte)0x8a, (byte)0x6b,
            /*8*/(byte)0x3a, (byte)0x91, (byte)0x11, (byte)0x41, (byte)0x4f, (byte)0x67, (byte)0xdc, (byte)0xea,
                    (byte)0x97, (byte)0xf2, (byte)0xcf, (byte)0xce, (byte)0xf0, (byte)0xb4, (byte)0xe6, (byte)0x73,
            /*9*/(byte)0x96, (byte)0xac, (byte)0x74, (byte)0x22, (byte)0xe7, (byte)0xad, (byte)0x35, (byte)0x85,
                    (byte)0xe2, (byte)0xf9, (byte)0x37, (byte)0xe8, (byte)0x1c, (byte)0x75, (byte)0xdf, (byte)0x6e,
            /*a*/(byte)0x47, (byte)0xf1, (byte)0x1a, (byte)0x71, (byte)0x1d, (byte)0x29, (byte)0xc5, (byte)0x89,
                    (byte)0x6f, (byte)0xb7, (byte)0x62, (byte)0x0e, (byte)0xaa, (byte)0x18, (byte)0xbe, (byte)0x1b,
            /*b*/(byte)0xfc, (byte)0x56, (byte)0x3e, (byte)0x4b, (byte)0xc6, (byte)0xd2, (byte)0x79, (byte)0x20,
                    (byte)0x9a, (byte)0xdb, (byte)0xc0, (byte)0xfe, (byte)0x78, (byte)0xcd, (byte)0x5a, (byte)0xf4,
            /*c*/(byte)0x1f, (byte)0xdd, (byte)0xa8, (byte)0x33, (byte)0x88, (byte)0x07, (byte)0xc7, (byte)0x31,
                    (byte)0xb1, (byte)0x12, (byte)0x10, (byte)0x59, (byte)0x27, (byte)0x80, (byte)0xec, (byte)0x5f,
            /*d*/(byte)0x60, (byte)0x51, (byte)0x7f, (byte)0xa9, (byte)0x19, (byte)0xb5, (byte)0x4a, (byte)0x0d,
                    (byte)0x2d, (byte)0xe5, (byte)0x7a, (byte)0x9f, (byte)0x93, (byte)0xc9, (byte)0x9c, (byte)0xef,
            /*e*/(byte)0xa0, (byte)0xe0, (byte)0x3b, (byte)0x4d, (byte)0xae, (byte)0x2a, (byte)0xf5, (byte)0xb0,
                    (byte)0xc8, (byte)0xeb, (byte)0xbb, (byte)0x3c, (byte)0x83, (byte)0x53, (byte)0x99, (byte)0x61,
            /*f*/(byte)0x17, (byte)0x2b, (byte)0x04, (byte)0x7e, (byte)0xba, (byte)0x77, (byte)0xd6, (byte)0x26,
                    (byte)0xe1, (byte)0x69, (byte)0x14, (byte)0x63, (byte)0x55, (byte)0x21, (byte)0x0c, (byte)0x7d};

    private static final byte[] __AES_Rcon = // Round constants.
            {(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x01, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x02,
                    (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x04, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x08, (byte)0x00,
                    (byte)0x00, (byte)0x00, (byte)0x10, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x20, (byte)0x00, (byte)0x00,
                    (byte)0x00, (byte)0x40, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x80, (byte)0x00, (byte)0x00, (byte)0x00,
                    (byte)0x1b, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x36, (byte)0x00, (byte)0x00, (byte)0x00};

    private static void __AES_AddRoundKey(AESSTAT stat, int round)
    {
        int r, c;
        for (r = 0; r < 4; ++r)
        {
            for (c = 0; c < 4; ++c)
                stat._state[(r << 2) + c] =
                        (byte)(((int)stat._state[(r << 2) + c]) ^ ((int)stat._w[(((round << 2) + c) << 2) + r]));
        }
    }

    private static class CODE62
    {
        private static byte[] ___code62 =
                {(byte)'0', (byte)'1', (byte)'2', (byte)'3', (byte)'4', (byte)'5', (byte)'6', (byte)'7', (byte)'8',
                        (byte)'9', (byte)'A', (byte)'B', (byte)'C', (byte)'D', (byte)'E', (byte)'F', (byte)'G', (byte)'H',
                        (byte)'I', (byte)'J', (byte)'K', (byte)'L', (byte)'M', (byte)'N', (byte)'O', (byte)'P', (byte)'Q',
                        (byte)'R', (byte)'S', (byte)'T', (byte)'U', (byte)'V', (byte)'W', (byte)'X', (byte)'Y', (byte)'Z',
                        (byte)'a', (byte)'b', (byte)'c', (byte)'d', (byte)'e', (byte)'f', (byte)'g', (byte)'h', (byte)'i',
                        (byte)'j', (byte)'k', (byte)'l', (byte)'m', (byte)'n', (byte)'o', (byte)'p', (byte)'q', (byte)'r',
                        (byte)'s', (byte)'t', (byte)'u', (byte)'v', (byte)'w', (byte)'x', (byte)'y', (byte)'z', 0, 0};

        private byte[] ___code62_index = new byte[256];

        private CODE62()
        {
            //___init_code62_index();
        }

        void ___init_code62_index()
        {
            int i;
            for (i = 0; i < ___code62_index.length; i++)
            {
                ___code62_index[i] = (byte)255;
            }
            for (i = 0; i < 64; i++)
            {
                ___code62_index[(byte)___code62[i]] = (byte)i;
            }
        }

        int __int_to_code62(byte[] buf, int size, long value)
        {
            int c = 0, j;
            int fmt_count = 11;
            byte[] bf = new byte[11];
            ___init_code62_index();
            BigDecimal longlongValue;
            if (value < 0)
            {
                long lowValue = value & 0x7fffffffffffffffL;
                longlongValue =
                        BigDecimal.valueOf(lowValue).add(BigDecimal.valueOf(Long.MAX_VALUE)).add(BigDecimal.valueOf(1));
            }
            else
            {
                longlongValue = new BigDecimal(value);
            }
            while (longlongValue.compareTo(BigDecimal.ZERO) > 0 && c < bf.length)
            {
                if (longlongValue.compareTo(new BigDecimal(62)) < 0)
                {
                    bf[c++] = ___code62[longlongValue.byteValue()];
                    break;
                }
                else
                {
                    BigDecimal[] divAndRema = longlongValue.divideAndRemainder(new BigDecimal(62));
                    bf[c++] = ___code62[divAndRema[1].byteValue()];
                    longlongValue = divAndRema[0];
                }
            }
            if (fmt_count <= c)
            {
                for (j = 0; j < c && j < size; j++)
                    buf[j] = bf[c - j - 1];
                if (c < size)
                    buf[c] = '\0';
            }
            else
            {
                j = 0;
                for (; j < fmt_count - c && j < size; j++)
                    buf[j] = ___code62[0];
                for (; j < fmt_count && j < size; j++)
                    buf[j] = bf[fmt_count - j - 1];
                if (fmt_count < size)
                    buf[fmt_count] = '\0';
                c = fmt_count;
            }
            return c;
        }

        long __power62(int m)
        {
            int i;
            long p = 1;
            for (i = 1; i <= m; i++)
                p = (p << 6) - (p << 1);
            return p;
        }

        long __code62_to_int(char[] code62)
        {
            ___init_code62_index();
            int i, c;
            BigDecimal v = BigDecimal.ZERO;
            int size = code62.length < 11 ? code62.length : 11;
            for (c = 0; c < size; c++)
            {
                if (___code62_index[code62[c]] >= 62)
                    return -2;
            }

            v = new BigDecimal(___code62_index[code62[c - 1]]);
            for (i = 1; i < c; i++)
            {
                v = v.add(new BigDecimal(__power62(i)).multiply(new BigDecimal(___code62_index[code62[c - i - 1]])));
            }
            return v.longValue();
        }
    }

    private static void __AES_SubBytes(AESSTAT stat)
    {
        int r, c;
        for (r = 0; r < 4; ++r)
        {
            for (c = 0; c < 4; ++c)
                stat._state[(r << 2) + c] = __AES_SBox[((ByteUtil.byteToInt(stat._state[(r << 2) + c]) >> 4) << 4)
                        + (ByteUtil.byteToInt(stat._state[(r << 2) + c]) & 0x0f)];
        }
    }

    private static void __AES_ShiftRows(AESSTAT stat)
    {
        int r, c;
        byte[] temp = new byte[16];

        for (r = 0; r < 16; r++)
            // copy State into temp[]
            temp[r] = stat._state[r];

        for (r = 1; r < 4; ++r) // shift temp into State
        {
            for (c = 0; c < 4; ++c)
                stat._state[(r << 2) + c] = temp[(r << 2) + (c + r) % stat._Nb];
        }
    }

    private static byte __AES_gfmultby02(byte b)
    {
        if (ByteUtil.byteToInt(b) < 0x80)
            return (byte)(int)(ByteUtil.byteToInt(b) << 1);
        else
            return (byte)(((int)(ByteUtil.byteToInt(b) << 1)) ^ (int)(0x1b));
    }

    private static byte __AES_gfmultby03(byte b)
    {
        return (byte)(((int)__AES_gfmultby02(b)) ^ (int)b);
    }

    private static byte __AES_gfmultby09(byte b)
    {
        return (byte)(((int)__AES_gfmultby02(__AES_gfmultby02(__AES_gfmultby02(b)))) ^ (int)b);
    }

    private static byte __AES_gfmultby0b(byte b)
    {
        return (byte)(((int)__AES_gfmultby02(__AES_gfmultby02(__AES_gfmultby02(b)))) ^ ((int)__AES_gfmultby02(b))
                ^ (int)b);
    }

    private static byte __AES_gfmultby0d(byte b)
    {
        return (byte)(((int)__AES_gfmultby02(__AES_gfmultby02(__AES_gfmultby02(b))))
                ^ ((int)__AES_gfmultby02(__AES_gfmultby02(b))) ^ ((int)(b)));
    }

    private static byte __AES_gfmultby0e(byte b)
    {
        return (byte)((int)__AES_gfmultby02(__AES_gfmultby02(__AES_gfmultby02(b)))
                ^ (int)__AES_gfmultby02(__AES_gfmultby02(b)) ^ (int)__AES_gfmultby02(b));
    }

    private static byte __AES_gfmultby01(byte b)
    {
        return b;
    }

    private static void __AES_MixColumns(AESSTAT stat)
    {
        int r, c;
        byte[] temp = new byte[16];
        for (r = 0; r < 16; r++)
            // copy State into temp[]
            temp[r] = stat._state[r];

        for (c = 0; c < 4; ++c)
        {
            stat._state[c] = (byte)(((int)__AES_gfmultby02(temp[c])) ^ ((int)__AES_gfmultby03(temp[4 + c]))
                    ^ ((int)__AES_gfmultby01(temp[8 + c])) ^ ((int)__AES_gfmultby01(temp[12 + c])));
            stat._state[4 + c] = (byte)(((int)__AES_gfmultby01(temp[c])) ^ ((int)__AES_gfmultby02(temp[4 + c]))
                    ^ ((int)__AES_gfmultby03(temp[8 + c])) ^ ((int)__AES_gfmultby01(temp[12 + c])));
            stat._state[8 + c] = (byte)(((int)__AES_gfmultby01(temp[c])) ^ ((int)__AES_gfmultby01(temp[4 + c]))
                    ^ ((int)__AES_gfmultby02(temp[8 + c])) ^ ((int)__AES_gfmultby03(temp[12 + c])));
            stat._state[12 + c] = (byte)(((int)__AES_gfmultby03(temp[c])) ^ ((int)__AES_gfmultby01(temp[4 + c]))
                    ^ ((int)__AES_gfmultby01(temp[8 + c])) ^ ((int)__AES_gfmultby02(temp[12 + c])));
        }
    }

    private static byte[] __AES_RotWord(byte[] temp)
    {
        byte t;
        t = temp[0];
        temp[0] = temp[1];
        temp[1] = temp[2];
        temp[2] = temp[3];
        temp[3] = t;
        return temp;
    }

    private static byte[] __AES_SubWord(byte[] word)
    {
        byte[] result = new byte[4];
        result[0] = __AES_SBox[((ByteUtil.byteToInt(word[0]) >> 4) << 4) + (ByteUtil.byteToInt(word[0]) & 0x0f)];
        result[1] = __AES_SBox[((ByteUtil.byteToInt(word[1]) >> 4) << 4) + (ByteUtil.byteToInt(word[1]) & 0x0f)];
        result[2] = __AES_SBox[((ByteUtil.byteToInt(word[2]) >> 4) << 4) + (ByteUtil.byteToInt(word[2]) & 0x0f)];
        result[3] = __AES_SBox[((ByteUtil.byteToInt(word[3]) >> 4) << 4) + (ByteUtil.byteToInt(word[3]) & 0x0f)];
        word[0] = result[0];
        word[1] = result[1];
        word[2] = result[2];
        word[3] = result[3];
        return word;
    }

    private static void __AES_KeyExpansionL(AESSTAT stat)
    {
        int k, kk;
        int row, wLen = stat._Nb * (stat._Nr + 1) * 4;
        byte[] t4 = new byte[4];
        byte[] temp = t4;

        for (row = 0; row < wLen; row++)
            stat._w[row] = 0; // 4 columns of bytes corresponds to a word

        for (row = 0; row < stat._Nk; ++row)
        {
            k = row << 2;
            stat._w[k] = stat._key[k];
            stat._w[k + 1] = stat._key[k + 1];
            stat._w[k + 2] = stat._key[k + 2];
            stat._w[k + 3] = stat._key[k + 3];
        }

        for (row = stat._Nk; row < stat._Nb * (stat._Nr + 1); ++row)
        {
            temp[0] = stat._w[(row - 1) << 2];
            temp[1] = stat._w[((row - 1) << 2) + 1];
            temp[2] = stat._w[((row - 1) << 2) + 2];
            temp[3] = stat._w[((row - 1) << 2) + 3];

            if (row % stat._Nk == 0)
            {
                temp = __AES_SubWord(__AES_RotWord(temp));

                k = (row / stat._Nk) << 2;
                temp[0] = (byte)(((int)temp[0]) ^ ((int)__AES_Rcon[k]));
                temp[1] = (byte)(((int)temp[1]) ^ ((int)__AES_Rcon[k + 1]));
                temp[2] = (byte)(((int)temp[2]) ^ ((int)__AES_Rcon[k + 2]));
                temp[3] = (byte)(((int)temp[3]) ^ ((int)__AES_Rcon[k + 3]));
            }
            else if (stat._Nk > 6 && (row % stat._Nk == 4))
            {
                temp = __AES_SubWord(temp);
            }

            k = (row - stat._Nk) << 2;
            kk = row << 2;
            // w[row] = w[row-Nk] xor temp
            stat._w[kk] = (byte)(((int)stat._w[k]) ^ ((int)temp[0]));
            stat._w[kk + 1] = (byte)(((int)stat._w[k + 1]) ^ ((int)temp[1]));
            stat._w[kk + 2] = (byte)(((int)stat._w[k + 2]) ^ ((int)temp[2]));
            stat._w[kk + 3] = (byte)(((int)stat._w[k + 3]) ^ ((int)temp[3]));
        } // for loop
    }

    private static void __AES_ConstructL(AESSTAT stat, byte[] aKeyBytes)
    {
        int i;
        int KeyLen = 4 * stat._Nk;

        for (i = 0; i < KeyLen; i++)
            stat._key[i] = aKeyBytes[i];

        __AES_KeyExpansionL(stat); // expand the seed key into a key schedule and store in w
    }

    private static void __AES_Init(AESSTAT stat, byte[] key, int type)
    {
        int keylen;
        byte[] key_buf = new byte[65];
        //      memset(stat._key,0,sizeof(stat._key));
        //      memset(stat._state,0,sizeof(stat._state));
        //      memset(stat._w,0,sizeof(stat._w));
        //      memset(key_buf,0,sizeof(key_buf));

        stat._Nb = 4; // block size always = 4 words = 16 bytes = 128 bits for AES
        if (type == 0)
        {
            stat._Nk = 4; // key size = 4 words = 16 bytes = 128 bits
            stat._Nr = 10; // rounds for algorithm = 10
        }
        else if (type == 1)
        {
            stat._Nk = 6; // 6 words = 24 bytes = 192 bits
            stat._Nr = 12;
        }
        else if (type == 2)
        {
            stat._Nk = 8; // 8 words = 32 bytes = 256 bits
            stat._Nr = 14;
        }

        keylen = key == null ? 0 : key.length;
        keylen = keylen < key_buf.length ? keylen : key_buf.length - 1;
        System.arraycopy(key, 0, key_buf, 0, keylen);
        __AES_ConstructL(stat, key_buf);
    }

    private static void __AES_InvSubBytes(AESSTAT stat)
    {
        int r, c;
        for (r = 0; r < 4; ++r)
        {
            for (c = 0; c < 4; ++c)
                stat._state[(r << 2) + c] = __AES_iSBox[((ByteUtil.byteToInt(stat._state[(r << 2) + c]) >> 4) << 4)
                        + (ByteUtil.byteToInt(stat._state[(r << 2) + c]) & 0x0f)];
        }
    }

    private static void __AES_InvMixColumns(AESSTAT stat)
    {
        int r, c;
        byte[] temp = new byte[16];
        for (r = 0; r < 16; r++)
            // copy State into temp[]
            temp[r] = stat._state[r];

        for (c = 0; c < 4; ++c)
        {
            stat._state[c] = (byte)(((int)__AES_gfmultby0e(temp[c])) ^ ((int)__AES_gfmultby0b(temp[4 + c]))
                    ^ ((int)__AES_gfmultby0d(temp[8 + c])) ^ ((int)__AES_gfmultby09(temp[12 + c])));
            stat._state[4 + c] = (byte)(((int)__AES_gfmultby09(temp[c])) ^ ((int)__AES_gfmultby0e(temp[4 + c]))
                    ^ ((int)__AES_gfmultby0b(temp[8 + c])) ^ ((int)__AES_gfmultby0d(temp[12 + c])));
            stat._state[8 + c] = (byte)(((int)__AES_gfmultby0d(temp[c])) ^ ((int)__AES_gfmultby09(temp[4 + c]))
                    ^ ((int)__AES_gfmultby0e(temp[8 + c])) ^ ((int)__AES_gfmultby0b(temp[12 + c])));
            stat._state[12 + c] = (byte)(((int)__AES_gfmultby0b(temp[c])) ^ ((int)__AES_gfmultby0d(temp[4 + c]))
                    ^ ((int)__AES_gfmultby09(temp[8 + c])) ^ ((int)__AES_gfmultby0e(temp[12 + c])));
        }
    }

    private static void __AES_InvShiftRows(AESSTAT stat)
    {
        int r, c;
        byte[] temp = new byte[16];
        for (r = 0; r < 16; r++)
            // copy State into temp[]
            temp[r] = stat._state[r];

        for (r = 1; r < 4; ++r) // shift temp into State
        {
            for (c = 0; c < 4; ++c)
            {
                stat._state[(r << 2) + (c + r) % stat._Nb] = temp[(r << 2) + c];
            }
        }
    }

    private static void __AES_Encode16(AESSTAT stat, byte[] aInput, byte[] aOutput)
    {
        int i, round;
        for (i = 0; i < (16); ++i)
            stat._state[((i % 4) << 2) + (i >> 2)] = aInput[i];
        __AES_AddRoundKey(stat, 0);
        for (round = 1; round <= (stat._Nr - 1); ++round) // main round loop
        {
            __AES_SubBytes(stat);
            __AES_ShiftRows(stat);
            __AES_MixColumns(stat);
            __AES_AddRoundKey(stat, round);
        } // main round loop

        __AES_SubBytes(stat);
        __AES_ShiftRows(stat);
        __AES_AddRoundKey(stat, stat._Nr);

        // output = state
        for (i = 0; i < (16); ++i)
            aOutput[i] = stat._state[((i % 4) << 2) + (i >> 2)];
    }

    private static void __AES_Decode16(AESSTAT stat, byte[] aInput, byte[] aOutput)
    {
        int i, round;
        for (i = 0; i < 16; ++i)
            stat._state[((i % 4) << 2) + (i >> 2)] = aInput[i];

        __AES_AddRoundKey(stat, stat._Nr);
        for (round = stat._Nr - 1; round >= 1; --round) // main round loop
        {
            __AES_InvShiftRows(stat);
            __AES_InvSubBytes(stat);
            __AES_AddRoundKey(stat, round);
            __AES_InvMixColumns(stat);
        } // end main round loop for InvCipher

        __AES_InvShiftRows(stat);
        __AES_InvSubBytes(stat);
        __AES_AddRoundKey(stat, 0);

        // output = state
        for (i = 0; i < (4 * stat._Nb); ++i)
            aOutput[i] = stat._state[((i % 4) << 2) + (i >> 2)];
    }

    private static int AES_Encode(byte[] szkey, int keytype, byte[] aInput, byte[] aOutput)
    {
        int nResult = 0;
        AESSTAT stat = new AESSTAT();
        byte bFix;
        int nFixlen;
        byte[] byFix16bit = new byte[16];
        int i, j;
        int i_size = aInput.length, o_size = aOutput.length;
        __AES_Init(stat, szkey, keytype);

        if (i_size <= 0)
        {
            if (aInput != null)
                i_size = aInput.length;
            if (i_size <= 0)
                return 0;
        }
        if (o_size < ((i_size + 15) / 16) * 16)
            return 0;

        nFixlen = i_size / 16;
        for (i = 0; i < (i_size % 16); i++)
            byFix16bit[i] = aInput[nFixlen * 16 + i];

        bFix = (byte)(16 - (i_size % 16));
        if (bFix > 0 && bFix < 16)
        {
            for (j = 0; j < bFix; ++j)
                byFix16bit[i + j] = bFix;
        }

        for (i = 0; i < nFixlen; i++)
        {
            byte[] ab = new byte[16];
            byte[] ob = new byte[16];
            int index = i * 16;
            System.arraycopy(aInput, index, ab, 0, 16);
            System.arraycopy(aOutput, index, ob, 0, 16);
            __AES_Encode16(stat, ab, ob);
            System.arraycopy(ab, 0, aInput, index, 16);
            System.arraycopy(ob, 0, aOutput, index, 16);
        }

        if (bFix > 0 && bFix < 16)
        {
            byte[] ab = new byte[16];
            byte[] ob = new byte[16];
            int index = i * 16;
            System.arraycopy(byFix16bit, index, ab, 0, 16);
            System.arraycopy(aOutput, index, ob, 0, 16);
            __AES_Encode16(stat, ab, ob);
            System.arraycopy(ab, 0, byFix16bit, index, 16);
            System.arraycopy(ob, 0, aOutput, index, 16);
        }

        nResult = ((i_size + 15) / 16) * 16;
        return nResult;
    }

    private static int ASE_Decode(byte[] szkey, int keytype, byte[] aInput, byte[] aOutput)
    {
        int nResult = 0;
        AESSTAT stat = new AESSTAT();
        byte bFix;
        int i, j, i_size = aInput.length, o_size = aOutput.length;

        __AES_Init(stat, szkey, keytype);

        if (i_size <= 0 || i_size % 16 != 0)
            return 0;
        if (o_size < i_size)
            return 0;

        for (i = 0; i < i_size; i += 16)
        {
            byte[] ab = new byte[16];
            byte[] ob = new byte[16];
            int index = i * 16;
            System.arraycopy(aInput, index, ab, 0, 16);
            System.arraycopy(aOutput, index, ob, 0, 16);
            __AES_Decode16(stat, ab, ob);
            System.arraycopy(ab, 0, aInput, index, 16);
            System.arraycopy(ob, 0, aOutput, index, 16);
        }
        //__AES_Decode16(stat,(unsigned char*)&aInput[i], (unsigned char*)&aOutput[i]);

        bFix = aOutput[i_size - 1];
        if (bFix > 0 && bFix < 15)
        {
            for (j = 0; j < bFix; ++j)
            {
                if (aOutput[i_size - bFix + j] != bFix)
                {
                    bFix = 0;
                    break;
                }
            }
            if (bFix != 0)
            {
                for (int m = 0; m < bFix; m++)
                {
                    aOutput[i_size - bFix + m] = 0;
                }
            }
        }
        else
        {
            bFix = 0;
        }

        nResult = i_size - bFix;
        if (o_size > nResult)
            aOutput[nResult] = '\0'; //add houjiajian 2013-08-20
        return nResult;
    }

    private static int hashPass(String szpass)
    {
        int seed = 131;
        int hash = 0;
        int str_len = 0;
        if (szpass != null && !szpass.isEmpty())
        {
            str_len = szpass.length();
        }
        for (int i = 0; i < str_len; i++)
        {
            hash = hash * seed + szpass.charAt(i);
        }
        byte[] hashPass = new byte[4];
        ByteUtil.int2BytesReverse(hashPass, hash, 0);
        hashPass[3] = 0;
        return ByteUtil.bytes2IntReverse(hashPass, 0);
    }

    public static class TokenInfo
    {
        private int passHash;

        private int code1;

        private int code2;

        private int time;

        private long userid;

        public int getPassHash()
        {
            return passHash;
        }

        public void setPassHash(int passHash)
        {
            this.passHash = passHash;
        }

        public int getCode1()
        {
            return code1;
        }

        public void setCode1(int code1)
        {
            this.code1 = code1;
        }

        public int getCode2()
        {
            return code2;
        }

        public void setCode2(int code2)
        {
            this.code2 = code2;
        }

        public int getTime()
        {
            return time;
        }

        public void setTime(int time)
        {
            this.time = time;
        }

        public long getUserid()
        {
            return userid;
        }

        public void setUserid(long userid)
        {
            this.userid = userid;
        }

        @Override
        public String toString()
        {
            // TODO Auto-generated method stub
            return "userid:" + userid + ",passHash:" + passHash + ",code1:" + code1 + ",code2:" + code2 + "time:"
                    + time;
        }
    }

    public static TokenInfo byteToTokenInfo(byte[] b)
    {
        if (b == null || b.length != 16)
        {
            return null;
        }
        byte[] init = new byte[4];
        byte[] bs = new byte[4];
        TokenInfo obj = new TokenInfo();
        System.arraycopy(b, 0, bs, 0, 3);
        obj.setPassHash(ByteUtil.bytes2IntReverse(bs, 0));
        System.arraycopy(init, 0, bs, 0, 4);
        System.arraycopy(b, 3, bs, 0, 1);
        obj.setCode1(ByteUtil.bytes2IntReverse(bs, 0));
        System.arraycopy(init, 0, bs, 0, 4);
        System.arraycopy(b, 4, bs, 0, 1);
        obj.setCode2(ByteUtil.bytes2IntReverse(bs, 0));
        System.arraycopy(init, 0, bs, 0, 4);
        System.arraycopy(b, 5, bs, 0, 3);
        obj.setTime(ByteUtil.bytes2IntReverse(bs, 0));
        bs = new byte[8];
        System.arraycopy(b, 8, bs, 0, 8);
        obj.setUserid(ByteUtil.bytes2LongReverse(bs, 0));
        return obj;
    }

    public static byte[] tokenInfoToByte(TokenInfo tokenInfo)
    {
        byte[] b = new byte[16];
        byte[] data = new byte[16];
        ByteUtil.int2BytesReverse(b, tokenInfo.getPassHash(), 0);
        System.arraycopy(b, 0, data, 0, 3);
        ByteUtil.int2BytesReverse(b, tokenInfo.getCode1(), 0);
        System.arraycopy(b, 0, data, 3, 1);
        ByteUtil.int2BytesReverse(b, tokenInfo.getCode2(), 0);
        System.arraycopy(b, 0, data, 4, 1);
        ByteUtil.int2BytesReverse(b, tokenInfo.getTime(), 0);
        System.arraycopy(b, 0, data, 5, 3);
        ByteUtil.long2BytesReverse(b, tokenInfo.getUserid(), 0);
        System.arraycopy(b, 0, data, 8, 8);
        return data;
    }

    public static long decodeToken(String token)
    {

        CODE62 code62 = new CODE62();
        char[] a = new char[11];
        System.arraycopy(token.toCharArray(), 0, a, 0, 11);
        long code1 = code62.__code62_to_int(a);
        System.arraycopy(token.toCharArray(), 11, a, 0, 11);
        long code2 = code62.__code62_to_int(a);
        byte[] data = new byte[16];
        ByteUtil.long2BytesReverse(data, code1, 0);
        ByteUtil.long2BytesReverse(data, code2, 8);
        byte[] tokenResult = new byte[16];
        ASE_Decode(keys, 2, data, tokenResult);
        TokenInfo tokenInfo = byteToTokenInfo(tokenResult);
        if (ByteUtil.byteToInt(
                (byte)(tokenInfo.getUserid() + tokenInfo.getPassHash() + tokenInfo.getTime())) == tokenInfo.getCode1()
                && ((byte)tokenInfo.getCode2()) == ByteUtil.byteToInt((byte)hashPass("keyuan")))
        {
            return tokenInfo.userid;
        }
        return -1;
    }

    public static TokenInfo decode2Token(String token)
    {

        CODE62 code62 = new CODE62();
        char[] a = new char[11];
        System.arraycopy(token.toCharArray(), 0, a, 0, 11);
        long code1 = code62.__code62_to_int(a);
        System.arraycopy(token.toCharArray(), 11, a, 0, 11);
        long code2 = code62.__code62_to_int(a);
        byte[] data = new byte[16];
        ByteUtil.long2BytesReverse(data, code1, 0);
        ByteUtil.long2BytesReverse(data, code2, 8);
        byte[] tokenResult = new byte[16];
        ASE_Decode(keys, 2, data, tokenResult);
        TokenInfo tokenInfo = byteToTokenInfo(tokenResult);
        if (ByteUtil.byteToInt(
                (byte)(tokenInfo.getUserid() + tokenInfo.getPassHash() + tokenInfo.getTime())) == tokenInfo.getCode1()
                && ((byte)tokenInfo.getCode2()) == ByteUtil.byteToInt((byte)hashPass("keyuan")))
        {
            return tokenInfo;
        }
        return null;
    }

    public static String createToken(long userid, String password)
    {
        CODE62 code62 = new CODE62();
        TokenInfo tokenInfo = new TokenInfo();
        tokenInfo.setUserid(userid);
        tokenInfo.setTime(int2_24((int)(System.currentTimeMillis()/1000)));
        tokenInfo.setCode2(ByteUtil.byteToInt((byte)hashPass("keyuan")));
        tokenInfo.setPassHash(hashPass(password));
        tokenInfo.setCode1(
                ByteUtil.byteToInt((byte)(tokenInfo.getUserid() + tokenInfo.getPassHash() + tokenInfo.getTime())));
        byte[] result = new byte[16];
        AES_Encode(keys, 2, tokenInfoToByte(tokenInfo), result);
        long code1 = ByteUtil.byteArrToLong(result, 0, 8, true);
        long code2 = ByteUtil.byteArrToLong(result, 8, 8, true);
        byte[] codeA = new byte[11];
        code62.__int_to_code62(codeA, 11, code1);
        String token = new String(codeA);
        code62.__int_to_code62(codeA, 11, code2);
        token += new String(codeA);
        return token;
    }

    private static int int2_24(int a)
    {
        byte[] hashPass = new byte[4];
        ByteUtil.int2BytesReverse(hashPass, a, 0);
        hashPass[3] = 0;
        return ByteUtil.bytes2IntReverse(hashPass, 0);
    }
/*

    public static void main(String[] args)
    {
        String token = createToken(61, "05a97a363ec3daa13b594795aa6e33e1");
        System.out.println(token);
        System.out.println(decodeToken(token));

    }
*/

}

