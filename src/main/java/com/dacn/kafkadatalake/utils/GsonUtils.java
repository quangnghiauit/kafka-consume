package com.dacn.kafkadatalake.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;

public class GsonUtils {

  private static final Gson builder;
  private static final Gson gson = new Gson();

  static {
    GsonBuilder gsonBuilder = new GsonBuilder();
    gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    builder = gsonBuilder.disableHtmlEscaping().create();

  }

  public static String toJsonString(Object obj) {
    return builder.toJson(obj);
  }

  public static <T> T fromJsonString(String sJson, Class<T> t) {
    return builder.fromJson(sJson, t);
  }

  public static <T> T json2Collection(String sJson, Type t) {
    return builder.fromJson(sJson, t);
  }

  public static Gson useGson() {
    return gson;
  }

}
