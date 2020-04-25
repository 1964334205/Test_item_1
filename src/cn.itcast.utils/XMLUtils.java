package cn.itcast.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
//工具类，用于读取xml文件和对xml文件进行写入操作
public class XMLUtils {
    private static String filapath;
    static {
        filapath = String.valueOf(XMLUtils.class.getClassLoader().getResource("user.xml"));
        filapath = filapath.substring(6,filapath.length());
    }
    public static Document getDocument() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(filapath));
        return document;
    }
    public static void write2Xml(Document document) throws IOException {
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream(filapath));
        writer.write(document);
        writer.close();
    }
}
