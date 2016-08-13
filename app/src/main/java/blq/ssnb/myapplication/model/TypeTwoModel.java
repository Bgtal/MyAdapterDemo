package blq.ssnb.myapplication.model;

/**
 * ================================================
 * 作者: SSNB
 * 日期: 2016/8/13
 * 描述:
 * 添加描述
 * ================================================
 */
public class TypeTwoModel extends BaseModel{

    public TypeTwoModel(){
        setType(ModelType.TYPE_TWO);
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
