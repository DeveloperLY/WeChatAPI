package net.developerly.support.wechat.utils;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * 使用Java Api 默认方法
 * 发送Post、Get 请求，SSL连接同样是使用Sun提供的默认实现方法
 *
 * @author LY
 * @create 2017/06/03
 **/
public class HTTPUtils {

    public static void inputStreamClose(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            inputStream = null;
        }
    }

    public static void outputStreamClose(OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream = null;
        }
    }

    public static byte[] post(final String url, final byte[] output_datas) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedInputStream in = null;
        try {
            URL u = new URL(url);
            URLConnection connection = u.openConnection();
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            connection.connect();
            connection.getOutputStream().write(output_datas);
            in = new BufferedInputStream(connection.getInputStream());
            byte[] data = new byte[1024];
            while (in.read(data) > -1) {
                out.write(data);
                Arrays.fill(data, (byte)0);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            outputStreamClose(out);
            inputStreamClose(in);
        }
        return out.toByteArray();
    }

    public static byte[] post(final String url, final String output_datas) {
        byte[] datas = new byte[0];
        try {
            datas = post(url, output_datas.getBytes(CharsetUtils.UTF8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return datas;
    }

    public static byte[] get(final String url) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedInputStream in = null;
        try {
            URL u = new URL(url);
            URLConnection connection = u.openConnection();
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.setUseCaches(false);
            connection.connect();
            in = new BufferedInputStream(connection.getInputStream());
            byte[] data = new byte[1024];
            while (in.read(data) > -1) {
                out.write(data);
                Arrays.fill(data, (byte)0);
            }
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            outputStreamClose(out);
            inputStreamClose(in);
        }
        return out.toByteArray();
    }

    public static byte[] postOfSSL(final String url, final byte[] output_datas) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedInputStream in = null;
        try {
            // 生成SSLFactory
            URL u = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection)u.openConnection();
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setUseCaches(false);
            // 设置SSL工厂
            connection.setSSLSocketFactory(SSLContext.getDefault().getSocketFactory());
            connection.connect();
            connection.getOutputStream().write(output_datas);
            in = new BufferedInputStream(connection.getInputStream());
            byte[] d = new byte[1024];
            while (in.read(d) > -1) {
                out.write(d);
                Arrays.fill(d, (byte)0);
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            outputStreamClose(out);
            inputStreamClose(in);
        }
        return out.toByteArray();
    }

    public static byte[] postOfSSL(final String url, final String output_datas) {
        byte[] datas = new byte[0];
        try {
            datas=postOfSSL(url, output_datas.getBytes(CharsetUtils.UTF8.name()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return datas;
    }


    public static byte[] getOfSSL(final String url) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BufferedInputStream in = null;
        try {
            URL u = new URL(url);
            HttpsURLConnection connection = (HttpsURLConnection)u.openConnection();

            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.setUseCaches(false);
            connection.connect();
            in = new BufferedInputStream(connection.getInputStream());
            byte[] tmp = new byte[1024];
            while (in.read(tmp) > -1) {
                out.write(tmp);
                Arrays.fill(tmp, (byte)0);
            }

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            outputStreamClose(out);
            inputStreamClose(in);
        }
        return out.toByteArray();
    }

    public static File getOfQRCode(final String url, String scene_str) {
        File localFile = null;
        BufferedInputStream in = null;
        try {
            URL u = new URL(url);
            URLConnection connection = u.openConnection();
            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.setUseCaches(false);
            connection.connect();
            in = new BufferedInputStream(connection.getInputStream());
            localFile = FileUtils.createTmpFile(in, scene_str, "jpg");
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            inputStreamClose(in);
        }
        return localFile;
    }
}
