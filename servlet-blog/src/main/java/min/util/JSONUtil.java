package min.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import exception.SystemException;
import min.model.Result;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

/**
 * @author zhaomin
 * @date 2020/3/8 11:17
 */
public class JSONUtil {

    public static final String DATA_PATTERN="yyyy-MM-dd HH:mm:ss";

    public static String serialize(Object obj) {
        //序列化操作
        ObjectMapper mapper = new ObjectMapper();
        //设置日期格式--这里要干什么
        mapper.setDateFormat(new SimpleDateFormat(DATA_PATTERN));
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw  new SystemException(Constant.JSON_ERROR_CODE,"JSON序列化失败:"+obj,e);
        }
    }

    /**
     * 将JSON字符串转为java对象
     *反序列化
     */
    public static <T> T deserialize(String json,Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        //设置日期格式类
        mapper.setDateFormat(new SimpleDateFormat(DATA_PATTERN));
        try {
            return mapper.readValue(json,clazz);
        } catch (IOException e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON字符串反序列化失败",e);
        }
    }

    public static <T> T deserialize(InputStream is, Class<T> clazz) {
        ObjectMapper mapper = new ObjectMapper();
        //设置日期格式类
        mapper.setDateFormat(new SimpleDateFormat(DATA_PATTERN));
        try {
            return mapper.readValue(is,clazz);
        } catch (Exception e) {
            throw new SystemException(Constant.JSON_ERROR_CODE,"JSON字符串反序列化失败",e);
        }
    }

    public static void main(String[] args) {
        Result result=new Result();
        result.setCode("xxx001");
        result.setMessage("发表文章出错");
        result.setData("文章数据");
        //序列化
        String json=serialize(result);
        System.out.println(json);
        //反序列化
        System.out.println(deserialize(json,Result.class));
        //System.out.println(serialize(result));
    }
}
