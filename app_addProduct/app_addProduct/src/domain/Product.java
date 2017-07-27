package domain;

import java.io.Serializable;

/**
 * Created by dell on 17-7-27.
 * 实现接口Serializable目的：实现序列化，让类对象长久的保存在内存中
 * 其实例可以安全地将数据保存到HttpSeion中
 */
public class Product implements Serializable {

    //序列化时为了保持版本的兼容性，即在版本升级时反序列化仍保持对象的唯一性。此为类的标识
    //根据Serializable要求，Product实现了一个serialVersionUID属性
    private static final long serialVersionUID = 748392348L;
    private String name;
    private String description;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
