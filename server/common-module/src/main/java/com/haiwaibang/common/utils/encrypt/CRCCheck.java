package com.haiwaibang.common.utils.encrypt;

/**
 * Created by Administrator on 2018/3/22.
 */
public class CRCCheck {

/*    public static void main(String[] args){
        String str="43a068783575c043543f3b94bd4292206115d97dadff2488146695bcbfe803b4905d8c7381d65f6f9d7311c800fbc396fb5d1a664c044244001bc2475e3836c603a833e25e870a7550d6ed12caa2cccdc0d661e79c3aa0d2f26bd1cbfb9acb5a3b1cd3325b0bf15c29d9be112005e7c645e44adb5855cf4dcfc1f660e3943321";
        byte[] data=str.getBytes();
        System.out.println(new String(data));
        System.out.println(CRCCheck.Make_CRC(data));
    }*/
    /**
     * 计算产生校验码
     * @param data 需要校验的数据
     * @return 校验码
     */
    public static String Make_CRC(byte[] data) {
        byte[] buf = new byte[data.length];// 存储需要产生校验码的数据
        for (int i = 0; i < data.length; i++) {
            buf[i] = data[i];
        }
        int len = buf.length;
        int crc = 0xFFFF;//16位
        for (int pos = 0; pos < len; pos++) {
            if (buf[pos] < 0) {
                crc ^= (int) buf[pos] + 256; // XOR byte into least sig. byte of
                // crc
            } else {
                crc ^= (int) buf[pos]; // XOR byte into least sig. byte of crc
            }
            for (int i = 8; i != 0; i--) { // Loop over each bit
                if ((crc & 0x0001) != 0) { // If the LSB is set
                    crc >>= 1; // Shift right and XOR 0xA001
                    crc ^= 0xA001;
                } else
                    // Else LSB is not set
                    crc >>= 1; // Just shift right
            }
        }
        String c = Integer.toHexString(crc);
        if (c.length() == 4) {
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 3) {
            c = "0" + c;
            c = c.substring(2, 4) + c.substring(0, 2);
        } else if (c.length() == 2) {
            c = "0" + c.substring(1, 2) + "0" + c.substring(0, 1);
        }
        return c;
    }
}
