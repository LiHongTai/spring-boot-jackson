package com.springboot.jackson.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JacksonUtil {

	private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
	private static ObjectMapper objectMapper = new ObjectMapper();

	static {
		// 反序列化时，忽略 json 字符串中不能识别的属性
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, Boolean.FALSE);
		// 序列化时，忽略无法转换的对象
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, Boolean.FALSE);
		// 设置成true时，属性名称不带双引号
		objectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
		// 反序列化时，是否允许属性名称不带双引号
		objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		// 按字母排序属性，默认false
		objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
		// 是否以类名作为根元素，可以通过@JsonRootName来自定义根元素名称,默认false
		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		// 序列化枚举是否以toString()来输出，默认false，即默认以name()来输出
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, false);
		// 序列化单元素数组时不以数组来输出，默认false
		objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		
		// 通过该方法对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
		// Include.Include.ALWAYS 默认
		// Include.NON_DEFAULT 属性为默认值不序列化
		// Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
		// Include.NON_NULL 属性为NULL 不序列化
		objectMapper.setSerializationInclusion(Include.NON_EMPTY);
	}

	public static String serialize(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			logger.error("对象 序列化成json字符串出错:", e);
		}
		return null;
	}

	public static <T> T deserialize(String jsonValue, Class<T> classType) {
		try {
			return objectMapper.readValue(jsonValue, classType);
		} catch (Exception e) {
			logger.error("json字符串 反序列成对象化出错:", e);
		}
		return null;
	}

	public static <T> T deserialize(String jsonArrayValue, TypeReference<T> typeReference) {
		try {
			return objectMapper.readValue(jsonArrayValue, typeReference);
		} catch (Exception e) {
			logger.error("json字符串 反序列成对象化出错:", e);
		}
		return null;
	}
}
