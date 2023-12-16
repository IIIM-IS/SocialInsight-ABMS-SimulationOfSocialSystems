//import java.lang.reflect.Method;
//import java.lang.reflect.Field;
//import java.lang.reflect.Type;
//import java.lang.reflect.InvocationTargetException;
//import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.stream.*;
//
//public class DataField<T, I> {
//  private T target;
//  private String fieldName;
//  private Field field;
//  private Method method;
//  private ArrayList<I> history;
//  private Type type;
//
//  public T getTarget() {
//    return target;
//  }
//
//  public Method getMethod() {
//    return method;
//  }
//
//  public String getFieldName() {
//    return fieldName;
//  }
//
//  public ArrayList<I> getHistory() {
//    return history;
//  }
//
//  public Field getField() {
//    return field;
//  }
//
//  public Type getType() {
//    return type;
//  }
//
//  public boolean returnsArray() {
//    return field.getType().isArray();
//  }
//
//  public DataField(T target, String targetMethod, String fieldName) {
//    this.target = target;
//    this.fieldName = fieldName;
//    try {
//      this.field = target.getClass().getDeclaredField(fieldName);
//    } catch (NoSuchFieldException e) {
//      throw new RuntimeException(e);
//    }
//    try {
//      this.method = target.getClass().getDeclaredMethod(targetMethod);
//    } catch (NoSuchMethodException e) {
//      throw new RuntimeException(e);
//    }
//    this.history = new ArrayList<>();
//    this.type = field.getType();
//    System.out.println(type);
//  }
//
//  public I pullData() {
//    I result = null;
//    try {
//      result = (I) method.invoke(target);
//    } catch (IllegalAccessException e) {
//      throw new RuntimeException(e);
//    } catch (InvocationTargetException e) {
//      throw new RuntimeException(e);
//    }
//    history.add(result);
//    return result;
//  }
//
//  @Override
//  public String toString() {
//    return "DataField{" +
//            "target='" + target.toString() + "', " +
//            "fieldName='" + fieldName + "', " +
//            "method='" + method + "', " +
//            "history='" + history.toString() + "'}";
//  }
//
//  public static void main(String[] args) {
//    TestTarget<Double> test = new TestTarget<Double>(2.55551);
//    DataField<TestTarget, Double> poll = new DataField<TestTarget, Double>(test, "getTest", "testField");
//    System.out.println(poll.pullData());
//
//    TestTarget<Integer[]> testArray = new TestTarget<Integer[]>(new Integer[] { 1, 2, 3, 4 });
//    DataField<TestTarget, Integer[]> data = new DataField<TestTarget, Integer[]>(testArray, "getTest", "testField");
//  }
//
//}