package com.haiwaibang.common.utils.encrypt;

import java.io.*;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 * 获取配置电脑的cpu  硬盘  板卡的序列号
 * Created by jiangshaobo on 2018/3/21.
 */
public class ComputerUtil {

    /**
     * 获取cpu的序列号
     * @return
     * @throws IOException
     */
    public static String getCpu() {
        try{
            Process process = Runtime.getRuntime().exec(
                    new String[] { "wmic", "cpu", "get", "ProcessorId" });
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            String serial = sc.next();
            return serial;

        }catch (Exception e){
            e.printStackTrace();
            return "";

        }

    }

    /**
     * 获取硬盘序列号
     * @return
     */
    public static String getDisk(){
        String result = "";
        String f = "D:\\log";
        String drive = "D";
        File tem = new File(f);
        try {
            File file = File.createTempFile("realhowto",".vbs",tem);
//            System.out.println("file.getPath():"+file.getPath());

            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    +"Set colDrives = objFSO.Drives\n"
                    +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
                    +"Wscript.Echo objDrive.SerialNumber";  // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();

            file.delete();

        }
        catch(Exception e){
            e.printStackTrace();
            return "";
        }
        return result.trim();
    }

    /**
     * 获取主板序列号
     * @return
     */
    public static String getMotherboardSN(){
        String result = "";
        String drive = "D:\\log";
        File tem = new File(drive);
        try {
            File file = File.createTempFile("realhowto", ".vbs", tem);
//            System.out.println("file.getPath():"+file.getPath());
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);

            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p
                    .getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return result.trim();

    }

    /**
     * 获取MAC地址
     */
    public static String getMac() {
        String result = "";
        try {

            Process process = Runtime.getRuntime().exec("ipconfig /all");

            InputStreamReader ir = new InputStreamReader(
                    process.getInputStream());

            LineNumberReader input = new LineNumberReader(ir);

            String line;

            while ((line = input.readLine()) != null)

                if (line.indexOf("Physical Address") > 0) {

                    String MACAddr = line.substring(line.indexOf("-") - 2);

                    result = MACAddr;

                }

        } catch (IOException e) {

            System.err.println("IOException " + e.getMessage());

        }
        return result;
    }

    public static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }

    /**
     * MD5加密
     * @param s
     * @return
     */
    public static String MD5(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            return toHex(bytes);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
