package form;

/**
 * Created by dell on 17-7-27.
 * PredocuForm看上去与Product类似，但他却有必要存在，原因如下：
 * 1.表单对象会传递ServletRequest给其他组件，类似Validator,而ServletRequest
 * 是Servlet层的一个对象，不应当暴露给应用的其他层
 * 2.当数据校验失败后，表单对象将用于保存和展示用户在原始表单上的输入
 */
public class ProductForm {
    private String name;
    private String description;
    private String price;

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
