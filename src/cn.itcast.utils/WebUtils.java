package cn.itcast.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

public class WebUtils {
    public static <T> T request2Bean(HttpServletRequest req,Class<T> beanClass){
        try {
            //1.创建要封装数据的bean
            T bean = beanClass.newInstance();
            //2.HttpServletRequest封装数据到bean中
            Enumeration enumeration = req.getParameterNames();
            while (enumeration.hasMoreElements()){
                String name = (String) enumeration.nextElement();
                String value = req.getParameter(name);
                BeanUtils.setProperty(bean,name,value);
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //注册日期转换器
    public static void copyBean(Object ser,Object dest) {
        ConvertUtils.register(new Converter() {
            @Override
            public Object convert(Class type, Object value) {
                if (value == null){
                    return null;
                }
                String str = (String) value;
                if (str.trim().equals("")){
                    return null;
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return dateFormat.parse(str);
                } catch (ParseException e) {
                   throw new RuntimeException(e);
                }
            }
        }, Date.class);
        try {
            BeanUtils.copyProperties(dest,ser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //生成全球唯一ID
    public static String generateID(){
        return UUID.randomUUID().toString();
    }
}
