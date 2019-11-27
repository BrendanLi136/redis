package com.qf.j1906.util;


import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.Serializable;

/**
 * @Author: Brendan Li
 * @description 自定义序列化转换器
 * @Date: 2019/11/27/19:44
 */
public class RedisUtilsSerializer implements RedisSerializer<Object> {

    //序列化转换器
    Converter<Object,byte[]>  serializingConverter = new SerializingConverter();

    //反序列化转换器
    Converter<byte[],Object> deserializingConverter = new DeserializingConverter();

    private static final byte[] EMPTY = new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o==null){
            return EMPTY;
        }

        return  serializingConverter.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if (bytes==null){
            return null;
        }

        return deserializingConverter.convert(bytes);
    }
}
