package com.kouyy.training.sensors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class GZIPUtils {

    public static final String GZIP_ENCODE_UTF_8 = "UTF-8";
    public static final String GZIP_ENCODE_ISO_8859_1 = "ISO-8859-1";

    public static byte[] compress(String str, String encoding) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream(str.getBytes().length);
        GZIPOutputStream gzip;
        try {
            gzip = new GZIPOutputStream(out);

            gzip.write(str.getBytes(encoding));
            gzip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] bytes = out.toByteArray();
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
//        return new String(Base64Coder.encode(bytes));//Base64Coder 对 压缩数据 进行 编码
    }

    public static byte[] compress(String str) throws IOException {
        return compress(str, GZIP_ENCODE_UTF_8);
    }

    public static byte[] uncompress(byte[] bytes) {
        int bufferSize = 4096;
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream(bytes.length);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in, bufferSize);
            byte[] buffer = new byte[bufferSize];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            ungzip.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] bytes1 = out.toByteArray();

        try {
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes1;
    }

    public static String uncompressToString(byte[] bytes, String encoding) throws IOException {
        int bufferSize = 4096;
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream(bytes.length);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        GZIPInputStream ungzip = null;

        ungzip = new GZIPInputStream(in, bufferSize);
        byte[] buffer = new byte[bufferSize];
        int n;
        while ((n = ungzip.read(buffer)) > 0) {
            out.write(buffer, 0, n);
            out.flush();
        }

        if (ungzip != null) {
            ungzip.close();
        }
        in.close();
        String s = out.toString(encoding);
        out.close();
        return s;
    }


    public static String uncompress(String str, String outEncoding) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes(GZIP_ENCODE_ISO_8859_1));
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString(outEncoding);
    }

    public static String uncompressToString(byte[] bytes) throws IOException {
        return uncompressToString(bytes, GZIP_ENCODE_UTF_8);
    }

    public static String uncompressToString(String str) throws IOException {
        return uncompress(str, GZIP_ENCODE_UTF_8);
    }

    public static void main(String[] args) throws Exception {
//        String str = "H4sIAAAAAAAAAO2dz4%2FbuBXH%2FxftHrbFjEPy8ecAewgWRdGiuymQdi9JYMi2ZkZZW3JleSaDRYCi7aWXXnvZoueeeut%2F1GD%2FjD7K8ti0JTM7w0nMaRa7yEqiJZL68PG976OYF98n03yUnH2ffN78mfymvHh6kRV1ctKcGV5l1SIvC7xCB3LACJWUMra%2BOsvqy3KCF%2BuynC7WZydZneZTPDsuTi%2FL4uI7%2FG9AycAMyEDyU%2F76s8%2BelPP6ybS8eLLIikVZLYb89ZPrEd6f0VNCTxlJ3p4kk3xR58W4Hub2EVpzI7WQEh9T57MsObN1IYpLA8QQPHkzz2xVqnT8HZbJrmwzzpJ0Mvlq%2FnRsWzSvynlW1Xm22Grxr9OrFK%2BN58NxWdTZG%2FwNaw5T%2FM0Zp4TudQUM6IAm60LDdFYu7aNoc6bKpmmN5XZqfabxH6NpU%2F%2FP88UQW5%2BvCtXVMnvb1O51Zp%2BZ1NdYZpraSp7j4ReT7OrL8wlWJC%2FKLwXj3MDPsESZnIFiHIwyJ4mtl9uDJwk2kxvGADsKS4ydo2zrZQ%2BAJ2%2FfnsTEgqCSUak6WMCzIVngIVloa92wIIyULDQLHCTzscDINgv2KHIWFHYlo6yDBSZpSBZoSBbaWlsWBKBpCG4XuOLCywJ1WKDRs8CBCaKhgwUg%2Br4sXKSz7Ply9LvVTci%2BpbAF7NVfTeyTtd7wQinl95xHVi2zvFD7rnRoXgRl2ssLc3hhn3h5KF4IIcfOi%2BDKyws4vMBj5sV6VR%2FRvhw%2FL%2BjweHnhDi88el7wIjDTyQvnIX0TCOmbtLVGFhjhnEoemgUJ2u%2BbCIcFET0LmnJOWJefyu9vO7ZZICFZaGtt7QInWoaPX6WSfr9DOizI6Fnoj18FBNUy4opfFRXUy4JyWFCPmAVDg8avkbEggHtZ0A4LOnoWOJfEiE4W%2BPHqWm2tLQuKakohOAuG%2BmMNR%2BNk8WucjCnFhNhngRMIykJQf6GttWXBcKpFcH9Bgw11DrMAjsYJ8WuceBEtLu9ggSo4WhbaWiMLNowAYYKzIDV4WXA0Tohf4%2Bz1F5CFoHFEXP6CIX59ARz9EuLXL%2FtZAHO8%2FsLDs4DHXhYcbRLi1yaZMEJCl78g728Xfpo2ycnWPCLu71OsWnZm02QMQ77wvGjw5k3B0SbhUWiTPT6F0TICn8LGGoaG1qkFYX4NAhxtEuLXJhXhIIjZZwG7WhytTt3W%2BqxZWUOB0uAsSL8GAY42CbFrk2KkR%2BMUNB%2BZcabYaBcJwRgxrB%2BJcZ1fpXXmQSJfPJtOGsuQzuffbhpPCAOy3ylrKrCwnV8ShuXscT7HA0kH2PUDBnxAm%2Bkvn%2F%2B2ys7zN7fX8By%2B53zcTE5dLRxfpkWRTZvLp3RTvDhHEJLnX58%2BBSJ%2B%2Bc0XlGjyc4aoWUbSyXBVbNVx6%2F6hihF5qpQUTKKLCSAoSCGJTu4BIg4VrwACjjAK8QujXKFPr%2FcTJspI3j9BLeq0mPx%2B%2FlP8GdaVWu1BsJwP2wcvsuk5nqjKcmZ%2FpYlRypqL86qcDZdNG0LbIyqYN28GjiYKj0AT7cdA9OvjHwwDW6lhuaw%2FNAqG%2BKUPRxKF%2BCVRjVaVsv0QRxNB%2BtPpaN33XZT9eYd2hjmday4cd8b%2Bf%2FOcF%2B%2F%2B9Bf898d%2F%2F%2BPVj3%2F8T%2BK8%2Fu26rzFJNCGUS2h7bUOlZ%2FYDnP5s1ery9uYEQGreOE6r6my1AKk7r%2FKssCVvssXOdIdNp6tT699cX%2BYL7KjQwDLmz%2FlzR7fl8eu2kivNONkHVnPRr9veGVjqBVb0APvuh7%2B%2B%2B9c%2F3%2F3w5%2F%2F%2B%2FW%2B75G4asUWuZGiBQpCrJNBGGT5ecjV4TS13VGYev8osOdoTTTvIVax%2FhcKsLLKbb9En9sy7o3SaFuPsa1u8CQOsH%2F3MevOT%2FGI4zdKrbFino2nWz1Q5b39t10riHUbZeVmt73jantzMyFwgsyfJLK3Hlw0%2BJDQmAMabmOKOAM3jF6APYAL9UaJ9Lb94k%2FuEgypLF007%2F7DM62Hrb7%2FPFN2DTIaPHM7LvKkDumxD%2B0vXrDWYBCdD%2B1OW3JGjefxyNHBhtNknwwCw%2FujNvoqn02k59msItmj7sNvZyIGDdqFhzwwXy9FtFJfP5ofMTPuU4SwvcudRWN%2BsGi7KZTW293mNWA1t4Wbe%2Bia7vp2zgqLEqfEKAdxRqnn8SrVGJ1mxfS%2FKSAb9mY3jNTLYmyq4bs0bo%2BEhw9Gtefy6NSgt0RXeJ0MLHtpLweldbDkq7cX3cFDYrncC2oZCG99EU7C6zsY3wUYAUYYEF7QxTPbPRI6gzWMXtDHEEFwL05Ho0kL0JzfuBolhlNwJEtiFxFBNPhIknHtXZHNHbObxi81KMgmmY47RQvbPMXeDhAKxtvoOlFC5iwll2q6B%2BiicYNd4OXHUaB6%2FGm1zjZJ2cnJgJd4djYldt3EXSrTZoUSZj2RLcFT5%2FVVHpuaPQKbuZ0QfTp1iA3YB2XdF10lx1hngzKfpTVZ9tSrC25fcpii33vJt4DLJL5L1rxbP6yovLvDsi5cb7%2BplcvJy06r2qLWX7VE7xb5MXrmebgNasqsSjpdVlRXjm3UM1oyOQ1yvC1pxaHyZVhdZcE6l8mb6haNOi%2FjV6QPes%2B5fPWiRe3bVyKzvSyp0gdrlXTfReZUtllP7pGm5yJL3Jvo8y1a%2BNnLRRO3ldYG1tOri6o7DYjlrsnwfFPbJsmoWrTTTPrExVw%2FmTdun2MvTppXz8trWnu7GDsZa7ltTf8paw94OERJ4XChGvVGlcLRvEb%2F2fcB%2BH9hp6A7jQvjHReMDuMPiOi%2BCjwoaw6gQt6NCdfk3m4CbPvCg0NI%2FWThKv4hf6T8QIJl%2Bx%2FcOg6LTq%2BkMoD7AbAExjAvrCPZMF%2FgQu05kM180EeQDjg0tqHcptXByHSL%2BXMcBhenAZxh3GBudS5S6FKhPjlQ7NPo9KcP49qRxCg87MAz1R8LCydyI%2BDM3vd%2BwChr2%2B6SovmEVRlPv90nCydWI%2BHM1TAEVqiPaFNghx8vCqtbIAtdAIfj%2BJ5Jgr3lZcFIyIv6UDChKhejYF0nwI7YLba2tXSCAJix0DlcS4V8jKZzMi4g%2F89L7HRqayf%2Ffb9slMf59kYSTXRHxZ1d6v2GVVBxQzj99w8okMuj9blE4mRYRf6bFroJGs9zBCxNB99EKuvdvW%2BvmG1YJTIrgLCjlXeYhnWyGfATZDM6okl2rxBS9t%2B14sP3h21ojCxglS8ND77UoGRVeBV86Cr6MX8Hv3UdLKnO8e6Q89D5aaBTBu2JDOsK1jF%2B4ZpQITnQHCzgVH61%2F2dba7sFKrV4QemWGZMavQUhHqJXxC7VWmKTQsShd0QOrvBoWno%2FLyrd8x32l287DSnkcLpqbnHG%2Bfunt2uN5ZrsrPW%2BWlK%2FLsEMErb%2BfMlRz2Vi6Doja5p5tF5vlC3ylifVoQyMF4JcypCNxyvglzgNIqXtv33k4ZNnNlAUOWbroCcuL8i8glI4MKuOXQTUG9rJrOlKMBZU7gromba1XkjhIEtxN5VR5pS%2FpyKAyfhm096%2B0UnBga4OPHbI89F9pJbkQXulLOjKojF8GZQoU6dqCSSl2vFv5tbW24SunQCC4DMoN98pa0pFBZacM%2Bup%2F3fgjeexuAAA%3D";
//        byte[] bytes = str.getBytes("ISO-8859-1");
//        String s1 = new String(bytes, "UTF-8");
//        String urldecode = URLDecoder.decode(s1, "UTF-8");
//        byte[] decode = Base64Coder.decode(urldecode);
//        String s = GZIPUtils.uncompressToString(decode);
//        System.out.println(s);
    }
}