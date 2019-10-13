package com.haiwaibang.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.Collection;

public class CommUtils {
    /**
     * 日志对象
     */
    private static final Logger logger = LoggerFactory.getLogger(CommUtils.class);

    /**
     *
     * <默认构造函数>
     */
    private CommUtils()
    {

    }

    /**
     *
     * String转换成Int类型
     * @param intValue
     * @param defaultValue
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int parseInt(String intValue, int defaultValue)
    {
        try
        {
            return Integer.parseInt(intValue);
        }
        catch (Exception e)
        {
            logger.warn("Parsing string:{}|default:{} to int occured exception", intValue, defaultValue, e);
            return defaultValue;
        }

    }

    /**
     *
     * String转换成Int类型
     * @param intValue 要转换的值
     * @param defaultValue 转换失败的默认值
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int parseInt(Object intValue, int defaultValue)
    {
        try
        {
            return Integer.parseInt(CommUtils.valueof(intValue));
        }
        catch (Exception e)
        {
            logger.warn("Parsing string:{}|default:{} to int occured exception", intValue, defaultValue, e);
            return defaultValue;
        }

    }

    /**
     *
     * String转换成Int类型
     * @param intValue 要转换的值
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int parseInt(Object intValue)
    {
        try
        {
            return Integer.parseInt(CommUtils.valueof(intValue));
        }
        catch (Exception e)
        {
            logger.warn("Parsing string:{}|default:{} to int occured exception", intValue, -1, e);
            return -1;
        }

    }

    /**
     *
     * String转换成long类型
     * @param intValue
     * @param defaultValue
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static long parseLong(String intValue, long defaultValue)
    {
        try
        {
            return Long.parseLong(intValue);
        }
        catch (Exception e)
        {
            logger.warn("Parsing string:{}|default:{} to long occured exception:", intValue, defaultValue, e);
            return defaultValue;
        }

    }

    /**
     *
     * 字符串转成bigInteger
     *
     * @param bigInteger
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static BigInteger toBigInteger(String bigInteger)
    {
        try
        {
            return new BigInteger(bigInteger);
        }
        catch (Exception e)
        {
            logger.warn("Parsing string:{} to BigInteger occured exception:", bigInteger, e);

            return new BigInteger("-1");
        }

    }

    /**
     *
     * 文件转换成字符串并且替换参数
     *
     * @param fileName 文件名
     * @param params 参数
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String formatSoapReq(String fileName, Object... params)
    {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringWriter writer = new StringWriter();
        String line = null;
        try
        {
            while (null != (line = reader.readLine()))
            {
                writer.write(line);
            }

            String xml = writer.toString();
            return MessageFormat.format(xml, params);
        }
        catch (IOException e)
        {
            logger.warn("Convert file:{} to string with params:{} occured exception:{}", fileName, params, e);
            return null;
        }
        finally
        {
            closeStreamQuietly(reader);
            closeStreamQuietly(in);
            closeStreamQuietly(writer);
        }
    }

    /**
     *
     * 流关闭
     *
     * @param stream 数据流
     * @see [类、类#方法、类#成员]
     */
    public static void closeStreamQuietly(Closeable stream)
    {
        if (null != stream)
        {
            try
            {
                stream.close();
            }
            catch (IOException e)
            {
                logger.warn("Close stream:{} occured exception:{}", stream, e);
            }
        }
    }

    /**
     *
     * 转成字符串
     *
     * @param obj 对象
     * @return 字符串
     * @see [类、类#方法、类#成员]
     */
    public static String valueof(Object obj)
    {
        return null == obj ? "" : String.valueOf(obj);
    }

    /**
     *
     * 转成字符串Trim前后空格
     *
     * @param obj 对象信息
     * @return 字符串
     * @see [类、类#方法、类#成员]
     */
    public static String trimValueof(Object obj)
    {
        return valueof(obj).trim();
    }

    /**
     * 统计给定字符串的字节数(汉字包括汉语标点-2个字节,英文包括英文标点-1字节)
     * 如果大于最大长度则返回空字符串,不大于则通过校验返回原字符串
     *
     * @param str
     * @param maxCount
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String checkCharacterCount(String str, int maxCount)
    {
        str = str.trim();
        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars)
        {
            if ((c >= 0x0391 && c <= 0xFFE5)) //中文字符
            {
                count += 2;
            }
            else if ((c >= 0x0000 && c <= 0x00FF)) //英文字符
            {
                count += 1;
            }
        }
        if (count <= maxCount)
        {
            return str;
        }
        return "";
    }

    public static boolean collectionIsEmpty(Collection collection){
        return (collection == null || collection.size() == 0);
    }
}
